package com.stream.stream.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private int departmentId;
    private String departmentName;
    private int salary;
    private LocalDate joiningDate;

    // Constructors
    public Employee(int id, String name, int departmentId, String departmentName, int salary, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Employee employee) {
    }

    public Employee() {

    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    // toString() for printing
    @Override
    public String toString() {
        return "Employee{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", departmentId=" + departmentId +
               ", departmentName='" + departmentName + '\'' +
               ", salary=" + salary +
               ", joiningDate=" + joiningDate +
               '}';
    }

    // equals and hashCode for comparisons and distinct()
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Employee)) return false;
//        Employee employee = (Employee) o;
//        return Objects.equals(name, employee.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}
