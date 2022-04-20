package com.example.cohortateam4spring.repository;

import com.example.cohortateam4spring.domain.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long> {


    List<TvShow> findBySeasons(Integer seasons);
}
