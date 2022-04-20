package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.Activity;
import com.example.cohortateam4spring.domain.Actor;
import com.example.cohortateam4spring.domain.Producer;
import com.example.cohortateam4spring.domain.Program;
import com.example.cohortateam4spring.repository.ActivityRepository;
import com.example.cohortateam4spring.repository.FilmRepository;
import com.example.cohortateam4spring.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl extends BaseServiceImpl<Producer> implements ProducerService{
    private final ProducerRepository producerRepository;
    private final ActivityRepository activityRepository;

    @Override
    public JpaRepository<Producer, Long> getRepository() {
        return producerRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void assign(final Producer producer, final Program program, final BigDecimal budget) {
        Activity newActivity = new Activity(producer, program, budget);
        activityRepository.save(newActivity);
        logger.debug("Saved activity {}.", newActivity);
    }

    @Override
    public Producer findByNumberOfCast(final Integer numberOfCast) {
        return producerRepository.findByNumberOfCast(numberOfCast);
    }
}
