package com.example.cohortateam4spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ActivityKey implements Serializable {
    private Long tvShowId;
    private Long filmId;
    private Long actorId;
    private Long producerId;
    private Long directorId;
    private Long personId;
}
