package com.stream.stream.level3;

import java.time.LocalDate;
import java.util.List;

public class Employee3 {
    private int id;
    private String name;
    private String department;
    private double salary;
    private String city;
    private LocalDate joiningDate;
    private List<String> phoneNumbers;
    private List<String> projects;

    public Employee3() {
    }

    public Employee3(int id, String name, String department, double salary, String city, LocalDate joiningDate, List<String> phoneNumbers, List<String> projects) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.city = city;
        this.joiningDate = joiningDate;
        this.phoneNumbers = phoneNumbers;
        this.projects = projects;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                ", joiningDate=" + joiningDate +
                ", phoneNumbers=" + phoneNumbers +
                ", projects=" + projects +
                '}';
    }
}
