package com.ge.hibernateexamples.components;

import com.ge.hibernateexamples.entities.*;
import com.ge.hibernateexamples.repositories.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class Test {

    private final StudentRepository studentRepository;
    private final BackpackRepository backpackRepository;
    private final NotepadRepository notepadRepository;
    private final NoteRepository noteRepository;
    private final ProfessorRepository professorRepository;


    public Test(StudentRepository studentRepository, BackpackRepository backpackRepository, NotepadRepository notepadRepository, NoteRepository noteRepository, ProfessorRepository professorRepository) {
        this.studentRepository = studentRepository;
        this.backpackRepository = backpackRepository;
        this.notepadRepository = notepadRepository;
        this.noteRepository = noteRepository;
        this.professorRepository = professorRepository;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void callTest(){
       try{
           test2();
           System.out.println("test");
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }



    @Transactional
    public void test() {
        Backpack backpack = new Backpack();
        backpack.setBrand("salewa");

        backpackRepository.save(backpack);
        Student student = new Student();
        student.setName("arek");
        student.setBackpack(backpack);
/*        if (true) {
            throw new RuntimeException();
        }*/
        studentRepository.save(student);


        // studentRepository.getStudent("arek").forEach(System.out::println);

    }

    public void test2() {
        System.out.println("Hello test 2");
        List<Note> noteList = new ArrayList<>();
        Note note = new Note();
        note.setTitle("Note1");
        noteList.add(note);
        note = new Note();
        note.setTitle("Note2");
        noteList.add(note);
        noteRepository.saveAll(noteList);
        List<Notepad> notepadList = new ArrayList<>();
        Notepad notepad = new Notepad();
        notepad.setTitle("Halo");
        notepad.setNoteList(noteList);
        notepadList.add(notepad);

        note = new Note();
        note.setTitle("Note3");
        noteList = new ArrayList<>();
        noteList.add(note);
        note = new Note();
        note.setTitle("Note4");
        noteList.add(note);
        noteRepository.saveAll(noteList);

        notepad = new Notepad();
        notepad.setTitle("Halo2");
        notepad.setNoteList(noteList);
        notepadList.add(notepad);
        notepadRepository.saveAll(notepadList);
        Backpack backpack = new Backpack();
        backpack.setBrand("salewa");
        backpack.setNotepadList(notepadList);
        backpackRepository.save(backpack);
        Student student = new Student();
        student.setName("Arek");
        student.setBackpack(backpack);


        Professor professor = new Professor();
        professor.setName("Piotr");
        professor.setSurname("Kowalski");
        professorRepository.save(professor);

        student.setProfessorList(Collections.singletonList(professor));
        studentRepository.save(student);


        // studentRepository.getStudent("arek").forEach(System.out::println);

    }


}
