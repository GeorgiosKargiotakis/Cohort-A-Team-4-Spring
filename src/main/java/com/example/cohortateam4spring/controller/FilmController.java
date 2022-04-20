package com.example.cohortateam4spring.controller;

import com.example.cohortateam4spring.domain.Film;
import com.example.cohortateam4spring.service.BaseService;
import com.example.cohortateam4spring.service.FilmService;
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
@RequestMapping("/films")
public class FilmController extends AbstractController<Film> {
    private final FilmService filmService;

    @Override
    protected BaseService<Film, Long> getBaseService() {
        return filmService;
    }

    @GetMapping
    @Override
    public ResponseEntity<ApiResponse<List<Film>>> findAll() {
        return new ResponseEntity<>(ApiResponse.<List<Film>>builder().data(filmService.findAllLazy()).build(),
                HttpStatus.OK);
    }

    @GetMapping(params = {"genre"})
    public ResponseEntity<ApiResponse<Film>> findByGenre(@RequestParam String genre) {
        return ResponseEntity.ok(ApiResponse.<Film>builder().data(filmService.findByGenre(genre)).build());
    }
}
