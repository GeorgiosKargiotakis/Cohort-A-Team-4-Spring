package com.example.cohortateam4spring.repository;

import com.example.cohortateam4spring.domain.Activity;
import com.example.cohortateam4spring.domain.ActivityKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, ActivityKey> {
}
