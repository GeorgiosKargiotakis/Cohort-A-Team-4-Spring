package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.TvShow;
import com.example.cohortateam4spring.repository.FilmRepository;
import com.example.cohortateam4spring.repository.TvShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TvShowServiceImpl extends BaseServiceImpl<TvShow> implements TvShowService{
    private final TvShowRepository tvShowRepository;

    @Override
    public List<TvShow> findBySeasons(final Integer seasons) {
        return tvShowRepository.findBySeasons(seasons);
    }

    @Override
    public JpaRepository<TvShow, Long> getRepository() {
        return tvShowRepository;
    }
}
