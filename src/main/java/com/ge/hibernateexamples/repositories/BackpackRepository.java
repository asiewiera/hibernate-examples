package com.ge.hibernateexamples.repositories;

import com.ge.hibernateexamples.entities.Backpack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackpackRepository extends CrudRepository<Backpack, Long> {
}
