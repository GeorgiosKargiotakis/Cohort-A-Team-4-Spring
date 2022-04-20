package com.example.cohortateam4spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnore
    private ActivityKey key;

    @ManyToOne
    @MapsId("personId")
    private Person person;


    @ManyToOne
    @JsonIgnoreProperties({"programId"})
    @MapsId("programId")
    private Program program;


    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal budget;

    public Activity(final Person person,
                    final Program program,
                    final BigDecimal budget) {
        this.key = new ActivityKey(person.getId(), program.getId());
        this.person = person;
        this.program = program;
        this.budget = budget;
    }


}
