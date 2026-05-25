package com.example.recyclerviewapp;

public class Student {

    private String name;
    private String rollNumber;
    private String department;
    private String grade;

    public Student(String name, String rollNumber, String department, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.department = department;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getDepartment() {
        return department;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
