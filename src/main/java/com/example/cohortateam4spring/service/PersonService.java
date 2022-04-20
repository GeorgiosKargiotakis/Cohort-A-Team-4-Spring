package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.Person;
import com.example.cohortateam4spring.domain.Program;

import java.math.BigDecimal;

public interface PersonService  extends BaseService<Person, Long>{

    Person getLazy(Long id);

    void assign(Person person, Program program, BigDecimal budget);
}
