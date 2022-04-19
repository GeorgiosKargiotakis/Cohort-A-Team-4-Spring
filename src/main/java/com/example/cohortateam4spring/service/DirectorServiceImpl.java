package com.example.cohortateam4spring.service;

import com.example.cohortateam4spring.domain.Director;
import com.example.cohortateam4spring.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl extends BaseServiceImpl<Director> implements DirectorService{
    private final DirectorRepository directorRepository;

    @Override
    public JpaRepository<Director, Long> getRepository() {
        return directorRepository;
    }
}
