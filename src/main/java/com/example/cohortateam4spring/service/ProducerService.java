package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.Actor;
import com.example.cohortateam4spring.domain.Producer;
import com.example.cohortateam4spring.domain.Program;

import java.math.BigDecimal;

public interface ProducerService extends BaseService<Producer, Long>{

    Producer findByNumberOfCast(Integer numberOfCast);

    void assign(Producer producer, Program program, BigDecimal budget);

}
