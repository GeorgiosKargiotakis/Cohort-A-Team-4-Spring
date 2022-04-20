package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.TvShow;

import java.util.List;

public interface TvShowService extends BaseService<TvShow, Long>{

    List<TvShow>  findBySeasons(Integer seasons);
}
