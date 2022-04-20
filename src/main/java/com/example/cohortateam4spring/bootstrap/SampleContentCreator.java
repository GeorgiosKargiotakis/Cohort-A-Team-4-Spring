package com.example.cohortateam4spring.bootstrap;

import com.example.cohortateam4spring.base.BaseComponent;
import com.example.cohortateam4spring.domain.*;
import com.example.cohortateam4spring.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("generate-content")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {
    private final ProducerService producerService;
    private final ActorService actorService;
    private final DirectorService directorService;
    private final FilmService filmService;
    private final TvShowService tvShowService;

    @Override
    public void run(final String... args) throws Exception {

        Actor firstActor =  Actor.builder().name("firstActor").age(25).awards("none").build();
        Actor secondActor =  Actor.builder().name("secondActor").age(30).awards("one").build();
        Actor thirdActor =  Actor.builder().name("thirdActor").age(50).awards("none").build();

        actorService.createAll(firstActor, secondActor, thirdActor);


        Producer firstProducer = Producer.builder().name("firstProducer").age(25).producerDifferent("firstDiff").build();
        Producer secondProducer = Producer.builder().name("secondProducer").age(30).producerDifferent("secondDiff").build();
        Producer thirdProducer =  Producer.builder().name("thirdProducer").age(50).producerDifferent("thirdDiff").build();

        producerService.createAll(firstProducer, secondProducer, thirdProducer);


        Director firstDirector =  Director.builder().name("firstDirector").age(25).gender(Gender.MALE).build();
        Director secondDirector =  Director.builder().name("secondDirector").age(30).gender(Gender.FEMALE).build();
        Director thirdDirector = Director.builder().name("thirdDirector").age(50).gender(Gender.MALE).build();

        directorService.createAll(firstDirector, secondDirector, thirdDirector);


        Film firstFilm = Film.builder().title("firstFilm").rating(9.9).genre("horror").plotSummary("a film").build();
        Film secondFilm = Film.builder().title("secondFilm").rating(5.0).genre("comedy").plotSummary("a film").build();
        Film thirdFilm = Film.builder().title("thirdFilm").rating(6.8).genre("action").plotSummary("a film").build();

        filmService.createAll(firstFilm, secondFilm, thirdFilm);

        TvShow firstTvShow = TvShow.builder().title("firstTvShow").rating(3.2).seasons(1).episodes(8).build();
        TvShow secondTvShow = TvShow.builder().title("secondTvShow").rating(2.3).seasons(3).episodes(40).build();
        TvShow thirdTvShow = TvShow.builder().title("thirdTvShow").rating(8.7).seasons(4).episodes(60).build();

        tvShowService.createAll(firstTvShow, secondTvShow, thirdTvShow);

        actorService.assign(firstActor, firstTvShow, BigDecimal.valueOf(2001L));
    }
}
