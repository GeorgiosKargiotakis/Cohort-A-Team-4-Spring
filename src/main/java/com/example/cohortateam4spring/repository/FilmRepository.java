package com.example.cohortateam4spring.repository;

import com.example.cohortateam4spring.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("select o from Film o join fetch o.activities")
    List<Film> findAllLazy();

    Film findByGenre(String genre);
}
