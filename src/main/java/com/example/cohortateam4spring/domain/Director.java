package com.example.cohortateam4spring.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "DIRECTORS")
@SequenceGenerator(name = "idGenerator", sequenceName = "DIRECTOR_SEQ", initialValue = 1, allocationSize = 1)
public class Director extends Person{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
