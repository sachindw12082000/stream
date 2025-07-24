package com.stream.stream.complex;

import java.time.LocalDate;
import java.util.List;

public class Employee2 {
    private int id;
    private String name;
    private String city;
    private String department;
    private double salary;
    private LocalDate joiningDate;
    private List<String> phoneNumbers;

    public Employee2(int id, String name, String city, String department, double salary, LocalDate joiningDate, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.phoneNumbers = phoneNumbers;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        return "Employee2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
