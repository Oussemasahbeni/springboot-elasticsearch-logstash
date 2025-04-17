package com.elasticsearch.demo.repository;

import org.springframework.data.domain.Page;
import com.elasticsearch.demo.models.UserPostgre;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<UserPostgre,String> {

    Page<UserPostgre> findAllBy(Pageable pageable);

    @Query(value = "from UserPostgre u where u.username = ?1")
    UserPostgre findUserByName(String name);

}