package com.example.cohortateam4spring.repository;

import com.example.cohortateam4spring.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {


    List<Actor> findByAwards(String awards);
}
