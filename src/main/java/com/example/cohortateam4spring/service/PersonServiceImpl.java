package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.*;
import com.example.cohortateam4spring.repository.ActivityRepository;
import com.example.cohortateam4spring.repository.FilmRepository;
import com.example.cohortateam4spring.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
    private final PersonRepository personRepository;
    private final ActivityRepository activityRepository;
    @Override
    public JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }

    public Person getLazy(Long id) {
        return personRepository.getLazy(id).orElseThrow(NoSuchElementException::new);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void assign(final Person person, final Program program, final BigDecimal budget) {
        Activity newActivity = new Activity(person, program, budget);
        activityRepository.save(newActivity);
        logger.debug("Saved activity {}.", newActivity);
    }
}
