package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.Actor;
import com.example.cohortateam4spring.domain.Program;

import java.math.BigDecimal;

public interface ActorService extends BaseService<Actor, Long>{

    void assign(Actor actor, Program program, BigDecimal budget);

    Actor findByAwards(String awards);

}
