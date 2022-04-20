package com.example.cohortateam4spring.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ACTIVITIES")
public class Activity {
    @EmbeddedId
    private ActivityKey key;

    @ManyToOne
    @MapsId("personId")
    private Person person;


    @ManyToOne
    @MapsId("programId")
    private Program program;


    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal budget;

    public Activity(final Actor actor,
                    final Program program,
                    final BigDecimal budget) {
        this.person = actor;
        this.program = program;
        this.budget = budget;
    }
    public Activity(final Producer producer,
                    final Program program,
                    final BigDecimal budget) {
        this.person = producer;
        this.program = program;
        this.budget = budget;
    }

    public Activity(final Director director,
                    final Program program,
                    final BigDecimal budget) {
        this.person = director;
        this.program = program;
        this.budget = budget;
    }


}
