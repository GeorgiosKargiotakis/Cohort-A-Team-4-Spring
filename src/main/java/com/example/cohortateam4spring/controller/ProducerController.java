package com.example.cohortateam4spring.controller;

import com.example.cohortateam4spring.domain.Producer;
import com.example.cohortateam4spring.service.BaseService;
import com.example.cohortateam4spring.service.ProducerService;
import com.example.cohortateam4spring.transfer.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producers")
public class ProducerController extends AbstractController<Producer> {
    private final ProducerService producerService;

    @Override
    protected BaseService<Producer, Long> getBaseService() {
        return producerService;
    }

    @GetMapping(params = {"numberOfCast"})
    public ResponseEntity<ApiResponse<Producer>> findByNumberOfCast(@RequestParam Integer numberOfCast) {
        return new ResponseEntity<>(ApiResponse.<Producer>builder().data(producerService.findByNumberOfCast(numberOfCast)).build(),
                HttpStatus.OK);
    }

    @GetMapping(value = "filtered/{id}")
    public ResponseEntity<ApiResponse<JsonNode>> filteredProducer(@PathVariable Long id) {
        Producer Producer = producerService.get(id);
        JsonNode ProducerAsJsonNode = filterProducer(Producer,  "name", "age");
        return new ResponseEntity<>(ApiResponse.<JsonNode>builder().data(ProducerAsJsonNode).build(), HttpStatus.OK);
    }

    private JsonNode filterProducer(Producer Producer, String... fields) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept(fields);
        FilterProvider filters = new SimpleFilterProvider().addFilter("ProducerFilter", filter);
        objectMapper.setFilterProvider(filters);
        ObjectWriter objectWriter = objectMapper.writer();
        try {
            String ProducerAsString = objectWriter.writeValueAsString(Producer);
            return objectMapper.readTree(ProducerAsString);
        } catch (JsonProcessingException e) {
            logger.error("Something went wrong during filtering", e);
        }
        return null;
    }
}
