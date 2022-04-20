package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.Activity;
import com.example.cohortateam4spring.domain.Actor;
import com.example.cohortateam4spring.domain.Director;
import com.example.cohortateam4spring.domain.Program;
import com.example.cohortateam4spring.repository.ActivityRepository;
import com.example.cohortateam4spring.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DirectorServiceImpl extends BaseServiceImpl<Director> implements DirectorService{
    private final DirectorRepository directorRepository;
    private final ActivityRepository activityRepository;

    @Override
    public JpaRepository<Director, Long> getRepository() {
        return directorRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void assign(final Director director, final Program program, final BigDecimal budget) {
        Activity newActivity = new Activity(director, program, budget);
        activityRepository.save(newActivity);
        logger.debug("Saved activity {}.", newActivity);
    }
}
