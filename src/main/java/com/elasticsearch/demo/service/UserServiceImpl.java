package com.elasticsearch.demo.service;

import com.elasticsearch.demo.models.UserElastic;
import com.elasticsearch.demo.models.UserPostgre;
import com.elasticsearch.demo.repository.UserElasticRepository;
import com.elasticsearch.demo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class UserServiceImpl{

    private final UserRepository userRepository;
    private final UserElasticRepository userElasticRepository;

    public UserServiceImpl(UserRepository userRepository, UserElasticRepository userElasticRepository) {
        this.userRepository = userRepository;
        this.userElasticRepository = userElasticRepository;
    }

    public Long getCount() {
        return userRepository.count();
    }

    public Long getElasticCount() {
        return userElasticRepository.count();
    }

    public Page<UserPostgre> getAllUser(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return  userRepository.findAllBy(pageable);

    }

    public Page<UserElastic> getAllUserForElastic(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return userElasticRepository.findAllBy(pageable);

    }

    public UserElastic getUserByNameFromElastic(String name) {
        return userElasticRepository.findByUsername(name);
    }

    public UserPostgre getUserByName(String name) {
        return userRepository.findUserByName(name);
    }
}