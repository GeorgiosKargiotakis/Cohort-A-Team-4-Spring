package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.TvShow;
import com.example.cohortateam4spring.repository.FilmRepository;
import com.example.cohortateam4spring.repository.TvShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TvShowServiceImpl extends BaseServiceImpl<TvShow> implements TvShowService{
    private final TvShowRepository tvShowRepository;

    @Override
    public JpaRepository<TvShow, Long> getRepository() {
        return tvShowRepository;
    }
}
