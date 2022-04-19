package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.Producer;
import com.example.cohortateam4spring.repository.FilmRepository;
import com.example.cohortateam4spring.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl extends BaseServiceImpl<Producer> implements ProducerService{
    private final ProducerRepository producerRepository;

    @Override
    public JpaRepository<Producer, Long> getRepository() {
        return producerRepository;
    }
}
