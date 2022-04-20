package com.example.cohortateam4spring.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "TVSHOWS")
@SequenceGenerator(name = "idGenerator", sequenceName = "SHOW_SEQ", initialValue = 1, allocationSize = 1)
public class TvShow extends Program {

    @NotNull
    @Column(length = 100, nullable = false)
    private Integer seasons;

    @NotNull
    @Column(length = 100, nullable = false)
    private Integer episodes;


}
