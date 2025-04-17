package com.elasticsearch.demo.jobs;

import com.elasticsearch.demo.models.UserPostgre;
import com.elasticsearch.demo.repository.UserRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class UserJob {

    private final UserRepository userRepository;


    @Scheduled(fixedDelay = 50)
    public void saveDataInDb() {
        Faker faker = new Faker();
        UserPostgre user = new UserPostgre(null, faker.name().username(),faker.internet().emailAddress(),faker.name().firstName(),faker.name().lastName(),faker.date().birthday(),false, Instant.now());
        userRepository.save(user);
    }
}