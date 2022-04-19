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
    @MapsId("actorId")
    private Actor actor;

    @ManyToOne
    @MapsId("producerId")
    private Producer producer;

    @ManyToOne
    @MapsId("directorId")
    private Director director;

    @ManyToOne
    @MapsId("filmId")
    private Film film;

    @ManyToOne
    @MapsId("tvShowId")
    private TvShow tvShow;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal budget;

    public Activity(final ActivityKey key,
                    final Actor actor,
                    final Producer producer,
                    final Director director,
                    final Film film,
                    final TvShow tvShow,
                    final BigDecimal budget) {
        this.key = key;
        this.actor = actor;
        this.producer = producer;
        this.director = director;
        this.film = film;
        this.tvShow = tvShow;
        this.budget = budget;
    }
}
