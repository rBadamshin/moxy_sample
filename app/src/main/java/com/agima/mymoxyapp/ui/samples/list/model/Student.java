package com.agima.mymoxyapp.ui.samples.list.model;


public class Student {

    private static Integer idIncrementor = 0;

    private String id;

    private String name;

    private String surname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Student(String name, String surname) {
        idIncrementor++;
        this.id = String.valueOf(idIncrementor);
        this.name = name;
        this.surname = surname;
    }
}
