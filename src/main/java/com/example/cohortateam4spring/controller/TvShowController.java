package com.example.cohortateam4spring.controller;

import com.example.cohortateam4spring.domain.TvShow;
import com.example.cohortateam4spring.service.BaseService;
import com.example.cohortateam4spring.service.TvShowService;
import com.example.cohortateam4spring.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tvShows")
public class TvShowController extends AbstractController<TvShow> {
    private final TvShowService tvShowService;

    @Override
    protected BaseService<TvShow, Long> getBaseService() {
        return tvShowService;
    }

    @GetMapping(params = {"seasons"})
    public ResponseEntity<ApiResponse<List<TvShow>>> findBySeasons(@RequestParam Integer seasons) {
        return ResponseEntity.ok(ApiResponse.<List<TvShow>>builder().data(tvShowService.findBySeasons(seasons)).build());
    }
}
