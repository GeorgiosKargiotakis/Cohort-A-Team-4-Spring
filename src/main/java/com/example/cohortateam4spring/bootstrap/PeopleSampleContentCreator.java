package com.example.cohortateam4spring.bootstrap;

import com.example.cohortateam4spring.base.BaseComponent;
import com.example.cohortateam4spring.domain.Actor;
import com.example.cohortateam4spring.service.ActorService;
import com.example.cohortateam4spring.service.DirectorService;
import com.example.cohortateam4spring.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("generate-content")
@RequiredArgsConstructor
public class PeopleSampleContentCreator extends BaseComponent implements CommandLineRunner {
    private final ProducerService producerService;
    private final ActorService actorService;
    private final DirectorService directorService;

    @Override
    public void run(final String... args) throws Exception {

    }
}
