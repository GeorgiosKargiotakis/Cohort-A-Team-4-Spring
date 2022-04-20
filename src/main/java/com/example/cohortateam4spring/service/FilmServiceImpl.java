package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.Film;
import com.example.cohortateam4spring.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService{
    private final FilmRepository filmRepository;

    @Override
    public JpaRepository<Film, Long> getRepository() {
        return filmRepository;
    }

    @Override
    public List<Film> findAllLazy() {
        return filmRepository.findAllLazy();
    }

    @Override
    public Film findByGenre(final String genre) {
        return filmRepository.findByGenre(genre);
    }
}
