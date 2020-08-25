package com.ge.hibernateexamples.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "notepads")
@Entity
public class Notepad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    @OneToMany
    @JoinColumn(name = "notepads_id")
    private List<Note> noteList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }
}
