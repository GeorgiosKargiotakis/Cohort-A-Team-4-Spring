package com.example.cohortateam4spring.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public abstract class Program extends BaseModel {

    @NotNull
    @Column(length = 200, nullable = false)
    private String title;

    @Column(precision = 10, scale = 1)
    private BigDecimal rating;



}
