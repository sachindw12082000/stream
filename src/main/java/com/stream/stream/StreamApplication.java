package com.stream.stream;

import com.stream.stream.entity.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
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
        System.out.println("filtered employee-> " + list5);
        //or
        List<Employee> list6 = employees.stream().filter(((Predicate<Employee>) emp -> emp.getSalary() >= 30000).and((Predicate<Employee>) emp -> emp.getSalary() <= 60000)).toList();
        System.out.println(list6);

        //Convert names to uppercase list
        List<Employee> list7 = employees.stream().map(emp -> new Employee(emp.getId(), emp.getName().toUpperCase(), emp.getDepartmentId(), emp.getDepartmentName(), emp.getSalary(), emp.getJoiningDate())).toList();
        System.out.println(list7);


        //Check if any employee earns > 1 lakh
        List<Employee> collect5 = employees.stream().filter(emp -> emp.getSalary() > 100000).collect(Collectors.toList());
        List<Employee> collect7 = employees.stream().filter(emp -> emp.getSalary() > 100000).toList();

        System.out.println(collect5 + " " + collect7);

        // Check if all employees belong to same department

        Boolean it = employees.stream().map(Employee::getDepartmentName).distinct().count() == 1;
        System.out.println(it);

        // Find employees whose names start with 'A'
        List<Employee> a = employees.stream().filter(emp -> emp.getName().startsWith("A")).toList();
        System.out.println(a);

        // Get employee by name using Optional Return "Not Found" if absent
        String name = "sachin";
        String aNull = employees.stream().filter(emp -> emp.getName().equalsIgnoreCase(name)).findFirst().map(emp -> emp.getName()).orElse("Not Found");
        System.out.println(aNull);

        //Safely get employee salary using Optional
        //Return default if null
        Integer i = employees.stream().map(Employee::getSalary).findFirst().orElse(null);
        System.out.println(i);

        // Comma-separated string of all employee names
        String collect8 = employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
        System.out.println(collect8);

        //Partition employees based on salary > 50,000
        //Map<Boolean, List<Employee>>

        Map<Boolean, List<Employee>> collect9 = employees.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() > 50000));
        System.out.println(collect9);

        //Get distinct department IDs as list

        List<Integer> list8 = employees.stream().map(Employee::getDepartmentId).distinct().toList();
        System.out.println(list8);

        //Use method reference to print all employee names
        employees.stream().map(Employee::getName).forEach(System.out::println);

        //Create new list of employees using constructor reference
        List<Employee> list9 = employees.stream().map(Employee::new).toList();
        System.out.println(list9);

        //Use parallel stream to count salary > 60,000
        List<Employee> list10 = employees.parallelStream().filter(emp -> emp.getSalary() > 50000).toList();
        System.out.println(list10);

        //Write Predicate<Employee> for salary > 40k
        Predicate<Employee> sal = (emp) -> emp.getSalary() > 40000;
        List<Employee> list11 = employees.stream().filter(sal).toList();
        System.out.println(list11);

        //Use Function<Employee, String> to extract name

        Function<Employee, String> restring = Employee::getName;
        List<String> list12 = employees.stream().map(restring).toList();
        System.out.println(list12);

        //Consumer<Employee> to print details
        Consumer<Employee> tsa = employee -> System.out.println(employee.getName());
        employees.stream().forEach(tsa);


        // Supplier<Employee> for dummy employee
        Supplier<Employee> sup = () -> new Employee(7, "Grace", 10, "HR", 45000, LocalDate.of(2021, 11, 8));

        Employee employee = sup.get();

        System.out.println(employee);

        //Find second-highest salary employee
        Employee employee1 = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
        System.out.println(employee1);

        //Find department with maximum employees
        Optional<Map.Entry<String, Long>> max = employees.stream().collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println(max.get().getKey());

        //Top 3 earners in the organization
        List<Employee> limit = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).toList();
        System.out.println(limit);

        //Remove duplicate employees by name (keep first only)
        Set<String> empset = new HashSet<>();
        List<Employee> list13 = employees.stream().filter(emp -> empset.add(emp.getName())).toList();
        System.out.println(list13);

        //Print joining date in dd-MM-yyyy format
        String dateFormate = "dd-MMM-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormate);
        employees.forEach(emp-> System.out.println(emp.getJoiningDate().format(formatter)));





    }
     public int returnAmount(int amount ){
        return amount;
    }


}
