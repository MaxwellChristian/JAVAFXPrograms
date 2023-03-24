package com.maxwell.javafxprograms.networking_demo.student_demo;

import java.io.Serializable;
import java.io.StringReader;

public class Student implements Serializable {

    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Student() {
    }

    public Student(String name, String street, String city, String state, String zip) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
