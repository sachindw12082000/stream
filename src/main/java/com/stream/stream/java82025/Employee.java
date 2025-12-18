package com.stream.stream.java82025;

import java.time.LocalDate;
import java.util.List;

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private int age;
    private double salary;
    private String department;
    private String gender;          // "Male", "Female"
    private String city;
    private List<String> skills;    // Java, Spring, SQL, AWS
    private LocalDate joiningDate;
    private double bonus;
    private double rating;          // 1–5
    private String email;
    private int experienceYears;

    public Employee() {}

    public Employee(Long id, String firstName, String lastName,String fullName, int age, double salary,
                    String department, String gender, String city,
                    List<String> skills, LocalDate joiningDate,
                    double bonus, double rating, String email, int experienceYears) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName=fullName;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.gender = gender;
        this.city = city;
        this.skills = skills;
        this.joiningDate = joiningDate;
        this.bonus = bonus;
        this.rating = rating;
        this.email = email;
        this.experienceYears = experienceYears;
    }

    // ------------ Getters & Setters ------------------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }

    public LocalDate getJoiningDate() { return joiningDate; }
    public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }


    // ------------ Convenience Methods ------------------

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", skills=" + skills +
                ", joiningDate=" + joiningDate +
                ", bonus=" + bonus +
                ", rating=" + rating +
                ", email='" + email + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }
}
