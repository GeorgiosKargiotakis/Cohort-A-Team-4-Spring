package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.TvShow;

public interface TvShowService extends BaseService<TvShow, Long>{

    TvShow findBySeasons(Integer seasons);
}
