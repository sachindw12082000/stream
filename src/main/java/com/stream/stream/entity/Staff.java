package com.stream.stream.entity;

import java.time.LocalDate;

public class Staff {
    private int id;
    private String name;
    private int departmentId;
    private String departmentName;
    private int salary;
    private LocalDate joiningDate;

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

    public Staff(int id, String name, int departmentId, String departmentName, int salary, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

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

    @Override
    public String toString() {
        return "Staff{id=" + id + ", name='" + name + '\'' +
                ", department='" + departmentName + '\'' +
                ", salary=" + salary + ", joiningDate=" + joiningDate + '}';
    }
}
