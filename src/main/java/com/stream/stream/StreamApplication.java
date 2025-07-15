package com.stream.stream;

import com.stream.stream.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

@SpringBootApplication
public class StreamApplication {

    public static void main(String[] args) {
        //SpringApplication.run(StreamApplication.class, args);

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Alice", 10, "HR", 55000, LocalDate.of(2020, 1, 15)));
        employees.add(new Employee(2, "Bob", 20, "Finance", 70000, LocalDate.of(2019, 3, 10)));
        employees.add(new Employee(3, "Charlie", 10, "HR", 40000, LocalDate.of(2021, 6, 25)));
        employees.add(new Employee(4, "David", 30, "IT", 60000, LocalDate.of(2018, 9, 12)));
        employees.add(new Employee(5, "Eve", 20, "Finance", 95000, LocalDate.of(2020, 5, 5)));
        employees.add(new Employee(6, "Frank", 30, "IT", 30000, LocalDate.of(2022, 2, 28)));
        employees.add(new Employee(7, "Grace", 10, "HR", 45000, LocalDate.of(2021, 11, 8)));
        employees.add(new Employee(8, "Heidi", 40, "Admin", 35000, LocalDate.of(2023, 4, 19)));
        employees.add(new Employee(9, "Ivan", 30, "IT", 60000, LocalDate.of(2017, 12, 1)));
        employees.add(new Employee(10, "Judy", 20, "Finance", 40000, LocalDate.of(2020, 8, 30)));
        employees.add(new Employee(11, "Alice", 50, "Legal", 50000, LocalDate.of(2019, 10, 14))); // Duplicate name

        // Print all employee names
        List<String> list = employees.stream().map(emp -> emp.getName()).toList();
        System.out.println(list);

        //List employees with salary > 50,000
        List<Employee> list1 = employees.stream().filter(emp -> emp.getSalary() > 50000).toList();
        System.out.println(list1);

        //Sort employees by salary (descending)
        List<Employee> list2 = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();

        System.out.println(list2);

        // Sort employees by name alphabetically

        List<Employee> list3 = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();

        System.out.println(list3);

        // Remove duplicate employees based on name

        List<Employee> list4 = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        e -> e,
                        (existing, duplicate) -> existing
                ))
                .values().stream().toList();
        System.out.println(list4);

        // Group employees by department
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartmentName));
        System.out.println(collect);

        //Count employees in each department

        Map<String, Long> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.counting()));
        System.out.println(collect1);

        //Find employee with the highest salary

        Optional<Employee> first = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst();
        first.ifPresent(System.out::println);

        //Calculate average salary of all employees
        Double collect2 = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect2);

        //Find highest-paid employee in each department
        Map<String, Optional<Employee>> collect3 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(collect3);
        //or
        Map<String, Employee> collect4 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)), Optional::get)));
        System.out.println(collect4);

        //group the employee by department sort employee in each department in descending order by name
        Map<String, List<Employee>> collect6 = employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getDepartmentName,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        lis -> lis.stream()
                                                .sorted(Comparator.comparing(Employee::getName)
                                                        .reversed()).toList()
                                )
                        )
                );
        System.out.println(collect6);
        // Get names of employees with salary between 30k–60k
        List<Employee> list5 = employees.stream().filter(emp -> emp.getSalary() >= 30000 && emp.getSalary() <= 60000).toList();
        System.out.println("filtered employee-> "+list5);
    }
}
