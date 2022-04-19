package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.Actor;
import com.example.cohortateam4spring.repository.ActorRepository;
import com.example.cohortateam4spring.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl extends BaseServiceImpl<Actor> implements ActorService{
    private final ActorRepository actorRepository;

    @Override
    public JpaRepository<Actor, Long> getRepository() {
        return actorRepository;
    }
}
