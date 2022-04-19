package com.example.cohortateam4spring.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class Person extends BaseModel {

    @NotNull
    @Column(length = 200, nullable = false)
    private String name;

    private Integer age;

    @NotNull
    @OneToMany(mappedBy = "")
    private Set<Film> films;

    @NotNull
    @OneToMany(mappedBy = "")
    private Set<TvShow> tvShows;

}
