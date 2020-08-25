package com.ge.hibernateexamples.repositories;

import com.ge.hibernateexamples.entities.Notepad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotepadRepository extends CrudRepository<Notepad,Long> {



}
