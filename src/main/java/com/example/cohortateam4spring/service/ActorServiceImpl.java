package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.Activity;
import com.example.cohortateam4spring.domain.Actor;
import com.example.cohortateam4spring.domain.Program;
import com.example.cohortateam4spring.repository.ActivityRepository;
import com.example.cohortateam4spring.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl extends BaseServiceImpl<Actor> implements ActorService{
    private final ActorRepository actorRepository;
    private final ActivityRepository activityRepository;

    @Override
    public JpaRepository<Actor, Long> getRepository() {
        return actorRepository;
    }

    @Override
    public List<Actor> findByAwards(final String awards) {
        return actorRepository.findByAwards(awards);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void assign(final Actor actor, final Program program, final BigDecimal budget) {
        Activity newActivity = new Activity(actor, program, budget);
        activityRepository.save(newActivity);
        logger.debug("Saved activity {}.", newActivity);
    }
}
