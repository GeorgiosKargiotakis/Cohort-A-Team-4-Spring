package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.Film;

import java.util.List;

public interface FilmService extends BaseService<Film, Long>{

    List<Film> findAllLazy();

    Film findByGenre(String genre);
}
