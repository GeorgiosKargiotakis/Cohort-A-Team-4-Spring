package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.Actor;
import com.example.cohortateam4spring.domain.Director;
import com.example.cohortateam4spring.domain.Program;

import java.math.BigDecimal;

public interface DirectorService extends BaseService<Director, Long>{

    void assign(Director director, Program program, BigDecimal budget);

}
