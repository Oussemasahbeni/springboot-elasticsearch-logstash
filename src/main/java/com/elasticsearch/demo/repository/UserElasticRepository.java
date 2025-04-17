package com.elasticsearch.demo.repository;

import com.elasticsearch.demo.models.UserElastic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserElasticRepository extends ElasticsearchRepository<UserElastic,String> {

    Page<UserElastic> findAllBy(Pageable pageable);

    @Query("{\"match\": {\"username\": {\"query\": \"?0\"}}}")
    UserElastic findByUsername(String username);
}