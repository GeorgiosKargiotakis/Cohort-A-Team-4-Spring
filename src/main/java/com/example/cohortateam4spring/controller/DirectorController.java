package com.example.cohortateam4spring.controller;

import com.example.cohortateam4spring.domain.Director;
import com.example.cohortateam4spring.service.DirectorService;
import com.example.cohortateam4spring.service.BaseService;
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
@RequestMapping("/directors")
public class DirectorController extends AbstractController<Director> {
        private final DirectorService directorService;

        @Override
        protected BaseService<Director, Long> getBaseService() {
            return directorService;
        }

        @GetMapping(value = "filtered/{id}")
        public ResponseEntity<ApiResponse<JsonNode>> filteredDirector(@PathVariable Long id) {
            Director Director = directorService.get(id);
            JsonNode DirectorAsJsonNode = filterDirector(Director,  "name", "age");
            return new ResponseEntity<>(ApiResponse.<JsonNode>builder().data(DirectorAsJsonNode).build(), HttpStatus.OK);
        }

        private JsonNode filterDirector(Director Director, String... fields) {
            ObjectMapper objectMapper = new ObjectMapper();
            SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept(fields);
            FilterProvider filters = new SimpleFilterProvider().addFilter("DirectorFilter", filter);
            objectMapper.setFilterProvider(filters);
            ObjectWriter objectWriter = objectMapper.writer();
            try {
                String DirectorAsString = objectWriter.writeValueAsString(Director);
                return objectMapper.readTree(DirectorAsString);
            } catch (JsonProcessingException e) {
                logger.error("Something went wrong during filtering", e);
            }
            return null;
        }
}
