package com.ge.hibernateexamples.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "backpacks")
@Entity
public class Backpack {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String brand;

    @OneToMany
    @JoinColumn(name = "backpacks_id")
    private List<Notepad> notepadList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Notepad> getNotepadList() {
        return notepadList;
    }

    public void setNotepadList(List<Notepad> notepadList) {
        this.notepadList = notepadList;
    }
}
