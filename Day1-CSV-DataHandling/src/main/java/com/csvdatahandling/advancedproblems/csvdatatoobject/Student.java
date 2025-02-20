package com.csvdatahandling.advancedproblems.csvdatatoobject;

import com.opencsv.bean.CsvBindByName;


public class Student {
    private String name;
    private int age;
    private String course;
    private double marks;

    public Student(String name, int age, String course, double marks) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", marks=" + marks +
                '}';
    }

}
