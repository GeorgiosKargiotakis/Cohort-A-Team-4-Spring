package com.example.cohortateam4spring.controller;

import com.example.cohortateam4spring.domain.Actor;
import com.example.cohortateam4spring.service.ActorService;
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

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorController extends AbstractController<Actor> {
    private final ActorService actorService;

    @Override
    protected BaseService<Actor, Long> getBaseService() {
        return actorService;
    }

//    @GetMapping(params = {"name"})
//    public ResponseEntity<ApiResponse<Actor>> findByName(@RequestParam String name) {
//        return new ResponseEntity<>(ApiResponse.<Actor>builder().data(actorService.findByName(name)).build(),
//                HttpStatus.OK);
//    }

    @GetMapping(params = {"awards"})
    public ResponseEntity<ApiResponse<List<Actor>>> findByAwards(@RequestParam String awards) {
        return new ResponseEntity<>(ApiResponse.<List<Actor>>builder().data(actorService.findByAwards(awards)).build(),
                HttpStatus.OK);
    }

//    @GetMapping(value = "filtered/{id}")
//    public ResponseEntity<ApiResponse<JsonNode>> filteredActor(@PathVariable Long id) {
//        Actor Actor = actorService.get(id);
//        JsonNode ActorAsJsonNode = filterActor(Actor,  "name", "age");
//        return new ResponseEntity<>(ApiResponse.<JsonNode>builder().data(ActorAsJsonNode).build(), HttpStatus.OK);
//    }
//
//    private JsonNode filterActor(Actor Actor, String... fields) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept(fields);
//        FilterProvider filters = new SimpleFilterProvider().addFilter("ActorFilter", filter);
//        objectMapper.setFilterProvider(filters);
//        ObjectWriter objectWriter = objectMapper.writer();
//        try {
//            String ActorAsString = objectWriter.writeValueAsString(Actor);
//            return objectMapper.readTree(ActorAsString);
//        } catch (JsonProcessingException e) {
//            logger.error("Something went wrong during filtering", e);
//        }
//        return null;
//    }
}
