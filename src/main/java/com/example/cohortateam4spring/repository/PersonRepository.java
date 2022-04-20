package com.example.cohortateam4spring.repository;

import com.example.cohortateam4spring.domain.Person;
import com.example.cohortateam4spring.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select a from Person a join fetch a.activities where a.id = ?1")
    Optional<Person> getLazy(Long id);
}
