package com.example.cohortateam4spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "PROGRAMS")
@SequenceGenerator(name = "idGenerator", sequenceName = "PROGRAMS_SEQ", initialValue = 1, allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Program extends BaseModel {

    @NotNull
    @Column(length = 200, nullable = false)
    private String title;

    @Column(precision = 10, scale = 1)
    private double rating;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties({"program"})
    @OneToMany(mappedBy = "program", fetch = FetchType.EAGER)
    private Set<Activity> activities = new HashSet<>();


}
