package com.stream.stream.entity;
import java.time.LocalDate;

public class People {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String city;
    private double salary;
    private LocalDate joiningDate;

    public People(int id, String name, int age, String gender, String city, double salary, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public People() {

    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getCity() { return city; }
    public double getSalary() { return salary; }
    public LocalDate getJoiningDate() { return joiningDate; }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                '}';
    }
}