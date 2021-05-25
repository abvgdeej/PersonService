package com.example.personalservice.persist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
    @Override
    List<PersonEntity> findAll();
}
