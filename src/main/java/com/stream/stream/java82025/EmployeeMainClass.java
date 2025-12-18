package com.stream.stream.java82025;

import org.springframework.cglib.core.Local;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmployeeMainClass {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1L, "Sachin", "Waghmare", "Sachin Waghmare", 28, 60000, "IT", "Male", "Pune",
                Arrays.asList("Java", "Spring", "SQL"), LocalDate.of(2020, 5, 10),
                5000, 4.5, "sachin@gmail.com", 4));

        employees.add(new Employee(2L, "Amit", "Shah", "Amit Shah", 32, 85000, "Finance", "Male", "Mumbai",
                Arrays.asList("Excel", "SAP"), LocalDate.of(2018, 3, 15),
                8000, 4.2, "amit@gmail.com", 7));

        employees.add(new Employee(3L, "Riya", "Jain", "Riya Jain", 26, 55000, "HR", "Female", "Delhi",
                Arrays.asList("Communication", "Recruitment"), LocalDate.of(2021, 7, 5),
                3000, 4.0, "riya.jain@gmail.com", 3));

        employees.add(new Employee(4L, "Vikas", "Patil", "Vikas Patil", 35, 95000, "IT", "Male", "Pune",
                Arrays.asList("Java", "Microservices", "AWS"), LocalDate.of(2017, 11, 12),
                10000, 4.8, "vikas.patil@gmail.com", 9));

        employees.add(new Employee(5L, "Neha", "Kulkarni", "Neha Kulkarni", 30, 70000, "Marketing", "Female", "Bangalore",
                Arrays.asList("SEO", "Content Writing"), LocalDate.of(2019, 4, 20),
                6000, 4.3, "neha.kulkarni@gmail.com", 6));

        employees.add(new Employee(6L, "Suresh", "Shetty", "Suresh Shetty", 40, 120000, "Finance", "Male", "Mumbai",
                Arrays.asList("Accounting", "Tax", "SAP"), LocalDate.of(2015, 1, 18),
                15000, 4.6, "suresh.shetty@gmail.com", 12));

        employees.add(new Employee(7L, "Priya", "Nair", "Priya Nair", 27, 65000, "IT", "Female", "Chennai",
                Arrays.asList("JavaScript", "React", "UI/UX"), LocalDate.of(2020, 9, 1),
                4500, 4.1, "priya.nair@gmail.com", 4));

        employees.add(new Employee(8L, "Rohit", "More", "Rohit More", 29, 50000, "Support", "Male", "Pune",
                Arrays.asList("Ticketing", "Linux"), LocalDate.of(2022, 2, 25),
                2000, 3.9, "rohit.more@gmail.com", 3));

        employees.add(new Employee(9L, "Meera", "Joshi", "Meera Joshi", 33, 78000, "Admin", "Female", "Hyderabad",
                Arrays.asList("Operations", "Management"), LocalDate.of(2019, 6, 15),
                7000, 4.4, "meera.joshi@gmail.com", 8));

        employees.add(new Employee(10L, "Karan", "Deshmukh", "Karan Deshmukh", 31, 90000, "IT", "Male", "Pune",
                Arrays.asList("Java", "Spring Boot", "Kafka"), LocalDate.of(2018, 12, 10),
                9000, 4.7, "karan.deshmukh@gmail.com", 7));

        employees.add(new Employee(11L, "Sachin", "Kadam", "Sachin Kadam", 29, 60000, "IT", "Male", "Mumbai",
                Arrays.asList("Java", "Docker"), LocalDate.of(2020, 5, 10),
                5000, 4.0, "sachin.kadam@gmail.com", 3));

        employees.add(new Employee(12L, "Anita", "Rao", "Anita Rao", 28, 70000, "Marketing", "Female", "Bangalore",
                Arrays.asList("SEO", "Branding"), LocalDate.of(2019, 5, 10),
                6000, 4.1, "anita.rao@gmail.com", 5));

        employees.add(new Employee(13L, "Deepak", "Sharma", "Deepak Sharma", 45, 110000, "Operations", "Male", "Delhi",
                null, LocalDate.of(2014, 6, 12),
                12000, 4.3, "deepak.sharma@gmail.com", 15));

        employees.add(new Employee(14L, "Swapnil", "Jadhav", "Swapnil Jadhav", 25, 40000, "Support", "Male", "Pune",
                Collections.emptyList(), LocalDate.of(2023, 2, 5),
                1500, 3.5, "swapnil.jadhav@gmail.com", 2));

        employees.add(new Employee(15L, "Mahesh", "Kale", "Mahesh Kale", 38, 180000, "Management", "Male", "Mumbai",
                Arrays.asList("Leadership", "Strategy"), LocalDate.of(2012, 9, 1),
                20000, 4.9, "mahesh.kale@gmail.com", 18));

        employees.add(new Employee(16L, "Pooja", "Shinde", "Pooja Shinde", 24, 30000, "Support", "Female", "Pune",
                Arrays.asList("Customer Service"), LocalDate.of(2023, 6, 1),
                1000, 3.2, "pooja.shinde@gmail.com", 1));

        employees.add(new Employee(17L, "Harish", "Mehta", "Harish Mehta", 50, 160000, "Finance", "Male", "Mumbai",
                Arrays.asList("Audit", "Compliance"), LocalDate.of(2008, 4, 15),
                25000, 4.4, "harish.mehta@gmail.com", 20));

        employees.add(new Employee(18L, "Sneha", "Desai", "Sneha Desai", 29, 85000, "HR", "Female", "Pune",
                Arrays.asList("Recruitment", "Payroll"), LocalDate.of(2020, 8, 10),
                7000, 4.2, "sneha.desai@gmail.com", 5));

        employees.add(new Employee(19L, "Vinay", "Kulkarni", "Vinay Kulkarni", 33, 95000, "IT", "Male", "Hyderabad",
                Arrays.asList("Java", "Microservices"), LocalDate.of(2017, 3, 20),
                9000, 4.8, "vinay.kulkarni@gmail.com", 10));

        employees.add(new Employee(20L, "Vikas", "Patil", "Vikas Patil", 35, 95000, "IT", "Male", "Pune",
                Arrays.asList("Java", "Microservices", "AWS"), LocalDate.of(2017, 11, 12),
                10000, 4.8, "vikas.patil@gmail.com", 9));

        //Print all employee full names using stream().
        employees.stream().forEach(emp -> System.out.println(emp.getFullName()));

        // Print all unique cities where employees live.
        Set<String> uniqueCity = employees.stream().map(emp -> emp.getCity()).collect(Collectors.toSet());
        System.out.println(uniqueCity);

        //Find all employees who live in Pune.
        List<Employee> list = employees.stream().filter(emp -> emp.getCity().equalsIgnoreCase("Pune")).toList();
        System.out.println(list);

        //Find all female employees.
        List<Employee> list1 = employees.stream().filter(emp -> emp.getGender().equalsIgnoreCase("Female")).toList();
        System.out.println(list1);

        //Find employees whose salary is greater than 70,000.
        List<Employee> list2 = employees.stream().filter(emp -> emp.getSalary() > 70000).toList();
        System.out.println(list2);

        //Get a list of all employee emails.
        List<String> list3 = employees.stream().map(emp -> emp.getEmail()).toList();
        System.out.println(list3);

        //Sort employees by first name in ascending order.
        List<Employee> list4 = employees.stream().sorted(Comparator.comparing(Employee::getFirstName)).toList();
        System.out.println(list4);

        //Sort employees by salary in descending order.
        List<Employee> list5 = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();
        System.out.println(list5);

        //Find employees who joined after 2020.
        List<Employee> list6 = employees.stream().filter(emp -> emp.getJoiningDate().getYear() > 2020).toList();
        System.out.println(list6);

        //Get all departments (with duplicates).
        List<String> list7 = employees.stream().map(Employee::getDepartment).toList();
        System.out.println(list7);

        //Get distinct departments.
        List<String> list8 = employees.stream().map(Employee::getDepartment).distinct().toList();
        System.out.println(list8);

        //Count how many employees belong to IT department.
        long count = employees.stream().filter(emp -> emp.getDepartment().equalsIgnoreCase("IT")).count();
        System.out.println(count);

        //Find all employees older than 30.
        List<Employee> list9 = employees.stream().filter(emp -> emp.getAge() > 30).toList();
        System.out.println(list9);

        //Extract list of all skills from all employees (flatMap).
        List<String> list10 = employees.stream().flatMap(emp -> Optional.ofNullable(emp.getSkills()).orElseGet(Collections::emptyList).stream()).toList();
        System.out.println(list10);

        //Find employees who have “Java” as a skill.
        List<Employee> list11 = employees.stream().filter(emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).contains("Java")).toList();
        System.out.println(list11);

        //or
        List<Employee> java = employees.stream().filter(emp -> emp.getSkills() != null && emp.getSkills().contains("Java")).toList();
        System.out.println(java);

        //Find the employee with the maximum salary.
        Employee employee = employees.stream().max(Comparator.comparing(Employee::getSalary)).orElse(new Employee());
        System.out.println(employee);

        //Find the employee with the minimum salary.
        Employee employee1 = employees.stream().min(Comparator.comparing(Employee::getSalary)).orElse(new Employee());
        System.out.println(employee1);

        //Convert List<Employee> into a Map<Id, Employee>.
        Map<Long, Employee> collect = employees.stream().collect(Collectors.toMap(emp -> emp.getId(), emp -> emp, (e, n) -> n));
        System.out.println(collect);

        //Convert List<Employee> into a Map<Department, List<Employee>>.
        Map<String, List<Employee>> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect1);

        //Print full names (first + last).
        employees.stream().forEach(emp -> System.out.println(emp.getFirstName() + " " + emp.getLastName()));

        //Get employees whose bonus is greater than 9000.
        List<Employee> list12 = employees.stream().filter(emp -> emp.getBonus() > 9000).toList();
        System.out.println(list12);

        //Get employees who joined before 2018.
        List<Employee> list13 = employees.stream().filter(emp -> emp.getJoiningDate().isBefore(LocalDate.of(2018, 01, 01))).toList();
        System.out.println(list13);

        //Count how many employees have rating above 4.5.
        long count1 = employees.stream().filter(emp -> emp.getRating() > 4.5).count();
        System.out.println(count1);

        //Create a list of employee ages.
        List<Integer> list14 = employees.stream().map(emp -> emp.getAge()).toList();
        System.out.println(list14);

        //Get employee names who have empty or null skills.
        List<Employee> list15 = employees.stream().filter(emp -> emp.getSkills() == null || emp.getSkills().isEmpty()).toList();
        System.out.println(list15);

        //Get employee names who live in Mumbai and work in Finance.
        List<Employee> list16 = employees.stream().filter(emp -> emp.getCity().equals("Mumbai") && emp.getDepartment().equals("Finance")).toList();
        System.out.println(list16);

        //Sort employees by join date (oldest first).
        List<Employee> list17 = employees.stream().sorted(Comparator.comparing(Employee::getJoiningDate)).toList();
        System.out.println(list17);

        //Sort employees by join date (newest first).
        List<Employee> list18 = employees.stream().sorted(Comparator.comparing(Employee::getJoiningDate).reversed()).toList();
        System.out.println(list18);

        //Find employees whose lastname starts with “K”.
        List<Employee> k = employees.stream().filter(emp -> emp.getFirstName().startsWith("K")).toList();
        System.out.println(k);

        //Display all employees whose skills contain more than 2 items.
        List<Employee> list19 = employees.stream().filter(emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).size() > 2).toList();
        System.out.println(list19);

        //Group employees by department.
        Map<String, List<Employee>> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect2);

        //Group employees by city
        Map<String, List<Employee>> collect3 = employees.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println(collect3);

        //Group employees by gender.
        Map<String, List<Employee>> collect4 = employees.stream().collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(collect4);

        //Count number of employees in each department.
        Map<String, Long> collect5 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(collect5);

        //Find the average salary of each department.
        Map<String, Double> collect6 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect6);

        //Find the highest salary in each department.
        HashMap<String, Double> collect7 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                HashMap::new,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                        (e) -> e.get().getSalary()
                )));

        System.out.println(collect7);

        //Find the lowest salary in each department.
        HashMap<String, Double> collect8 = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        HashMap::new,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparing(Employee::getSalary)),
                                minsalary -> minsalary.get().getSalary()
                        )
                )
        );
        System.out.println(collect8);

        //Find the sum of salaries of all employees.
        double sum = employees.stream().mapToDouble(emp -> emp.getSalary()).sum();
        System.out.println(sum);

        //Find the sum of salaries grouped by gender.
        Map<String, Double> collect9 = employees.stream().collect(Collectors.groupingBy(
                Employee::getGender,
                Collectors.summingDouble(Employee::getSalary)
        ));
        System.out.println(collect9);

        //Count how many employees have Java skill.
        long count2 = employees.stream().filter(emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).contains("Java")).count();
        System.out.println(count2);

        //Get each city and list max salary employee living in that city.
        HashMap<String, List<Employee>> collect10 = employees.stream().collect(Collectors.groupingBy(
                Employee::getCity,
                HashMap::new,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                        opt -> opt.map(List::of).orElse(List.of())
                )
        ));

        //Partition employees based on salary > 80,000.
        Map<Boolean, List<Employee>> collect11 = employees.stream().collect(Collectors.partitioningBy(
                emp -> emp.getSalary() > 80000
        ));
        System.out.println(collect11);

        //Partition employees based on rating > 4.5.
        Map<Boolean, List<Employee>> collect12 = employees.stream().collect(Collectors.partitioningBy(
                emp -> emp.getRating() > 4.5
        ));
        System.out.println(collect12);
        //Find the total bonus distributed by company.
        double sum1 = employees.stream().mapToDouble(Employee::getBonus).sum();
        System.out.println(sum1);

        //Create a Map<Department, Total Bonus>.
        Map<String, Double> collect13 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.summingDouble(Employee::getBonus)
        ));
        System.out.println(collect13);

        //Get the most experienced employee per department.
        HashMap<String, Employee> collect14 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                HashMap::new,
                Collectors.collectingAndThen(
                        Collectors.minBy(Comparator.comparing(Employee::getJoiningDate)),
                        Optional::get
                )
        ));

        System.out.println(collect14);

        // Group employees by year of joining.
        Map<Integer, List<Employee>> collect15 = employees.stream().collect(Collectors.groupingBy(emp -> emp.getJoiningDate().getYear()));
        System.out.println(collect15);

        //Find top 3 highly paid employees.
        List<Employee> list20 = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3L).toList();
        System.out.println(list20);

        //Find bottom 3 lowest paid employees.
        List<Employee> list21 = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).limit(3L).toList();
        System.out.println(list21);

        //Get distinct skill list from all employees.
        List<String> list22 = employees.stream().flatMap(emp -> Optional.ofNullable(emp.getSkills()).orElseGet(Collections::emptyList).stream()).distinct().toList();
        System.out.println(list22);

        //Count employees for each skill (skill → count).
        Map<String, Long> collect16 = employees.stream().
                filter(emp -> emp.getSkills() != null).
                flatMap(emp -> emp.getSkills().stream()).
                collect(Collectors.groupingBy(
                        skills -> skills,
                        Collectors.counting()
                ));


        System.out.println(collect16);

        //Find employees whose skill list contains "AWS" or "Kafka".
        List<Employee> list23 = employees.stream().
                filter(emp -> emp.getSkills() != null && (emp.getSkills().contains("AWS") || emp.getSkills().contains("Kafka"))).toList();
        System.out.println(list23);

        //or

        List<Employee> list24 = employees.stream().
                filter(emp -> Optional.ofNullable(emp.getSkills()).orElseGet(Collections::emptyList).stream().anyMatch(skills -> skills.equals("AWS") || skills.equals("Kafka"))).toList();

        System.out.println(list24);

        // or  using set
        Set<String> skillsSet = Set.of("AWS", "Kafka");
        List<Employee> list25 = employees.stream().filter(emp ->
                Optional.ofNullable(emp.getSkills()).orElseGet(Collections::emptyList).stream().anyMatch(skillsSet::contains)
        ).toList();

        System.out.println(list25);

        //Group employees by number of skills they have.
        Map<Integer, List<Employee>> collect17 = employees.stream().collect(Collectors.groupingBy(
                emp -> Optional.ofNullable(emp.getSkills()).orElseGet(Collections::emptyList).size()

        ));

        System.out.println(collect17);

        //Find average rating of IT employees.
        Double average = employees.stream().filter(emp -> emp.getDepartment().equalsIgnoreCase("It")).mapToDouble(emp -> emp.getRating()).average().getAsDouble();
        System.out.println(average);

        //Create a Map<City, Average Bonus>.
        Map<String, Double> collect18 = employees.stream().collect(Collectors.groupingBy(emp -> emp.getCity(), Collectors.averagingDouble(Employee::getBonus)));
        System.out.println(collect18);

        //Create a Map<Boolean, List<Employee>> → true if salary > rating * 20000.
        Map<Boolean, List<Employee>> collect19 = employees.stream().collect(Collectors.partitioningBy(emp -> (emp.getSalary()) > (emp.getRating() * 20000)));
        System.out.println(collect19);

        //Get top 5 employees based on bonus.
        List<Employee> list26 = employees.stream().sorted(Comparator.comparing(Employee::getBonus).reversed()).limit(5).toList();
        System.out.println(list26);
        System.out.println(list26.size());

        //Sort employees by multiple fields: dept → salary desc → name.
        List<Employee> list27 = employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Comparator.comparing(Employee::getSalary).reversed()).thenComparing(Comparator.comparing(Employee::getFirstName))).toList();
        System.out.println(list27);

        //Create comma-separated string of all employee emails.
        String collect20 = employees.stream().map(Employee::getEmail).collect(Collectors.joining(","));
        System.out.println(collect20);

        //Find second highest salary employee.
        Employee employee2 = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
        System.out.println(employee2);

        //Find second lowest salary employee.
        Employee employee3 = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1).findFirst().get();
        System.out.println(employee3);

        //Get employees with exactly 3 skills.
        List<Employee> list28 = employees.stream().filter(emp -> Optional.ofNullable(emp.getSkills()).orElseGet(Collections::emptyList).size() == 3).toList();
        System.out.println(list28);

        //Get employees having the same salary.
        List<Employee> list29 = employees.stream().collect(Collectors.groupingBy(Employee::getSalary)).values().stream().filter(emp -> emp.size() > 1).flatMap(List::stream).toList();
        System.out.println(list29);

        //Create Map<Department, Count of Employees With Rating > 4>.
        Map<String, Long> collect21 = employees.stream().filter(emp -> emp.getRating() > 4).collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.counting()
        ));
        System.out.println(collect21);

        //Find employee with longest first name.
        Optional<Employee> max = employees.stream().max(Comparator.comparing(emp -> emp.getFirstName().length()));
        max.ifPresent(e -> System.out.println("max name employee" + e));

        //Remove duplicates from employee list using stream distinct().
        List<Employee> list30 = employees.stream().map(emp -> emp).distinct().toList();
        System.out.println(list30.size());

        //Remove duplicates based on firstName + lastName combination.
        HashSet<String> distinctFullNames = new HashSet<>();
        List<Employee> list31 = employees.stream().filter(emp -> distinctFullNames.add(emp.getFirstName() + " " + emp.getLastName())).toList();
        System.out.println(list31);

        //Sort employees by skill count, then rating, then salary.
        List<Employee> list32 = employees.stream().sorted(Comparator.comparing((Employee emp) -> emp.getSkills() == null ? 0 : emp.getSkills().size())
                .thenComparing(Employee::getRating)
                .thenComparing(Employee::getSalary)
        ).toList();
        System.out.println(list32);


        //Find the employee whose name appears more than once.
        HashSet<String> strings = new HashSet<>();
        List<Employee> list33 = employees.stream().filter(emp -> !strings.add(emp.getFirstName())).toList();
        System.out.println(list33);

        //Find employees earning above department average salary.
        Map<String, Double> avgDeptSal = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        List<Employee> list34 = employees.stream().filter(emp -> emp.getSalary() > avgDeptSal.get(emp.getDepartment())).toList();
        System.out.println(list34);

        //Find employees earning below department average salary.
        Map<String, Double> collect22 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        employees.stream().filter(emp -> emp.getSalary() < collect22.get(emp.getDepartment())).toList();

        //Find employee who joined earliest but has rating < 4.
        Employee employee4 = employees.stream().filter(emp -> emp.getRating() < 4).min(Comparator.comparing(Employee::getJoiningDate)).get();
        System.out.println(employee4);

        //Find employees having at least one common skill with “Vikas Patil”.
        List<String> VikasSkilllList = employees.stream().filter(emp -> emp.getFullName().equalsIgnoreCase("Vikas Patil")).findFirst().get().getSkills();
        List<Employee> list35 = employees.stream().filter(emp -> Optional.ofNullable(emp.getSkills()).orElseGet(Collections::emptyList).stream().anyMatch(VikasSkilllList::contains)).toList();
        System.out.println(list35);

        //Create Map<Skill, List<Employee>> (reverse mapping).
//        Map<String, List<Employee>> collect23 = employees.stream().flatMap(emp -> emp.getSkills().stream().map(skill -> Map.entry(skill, emp))).collect(Collectors.groupingBy(
//                Map.Entry::getKey,
//                Collectors.mapping(Map.Entry::getValue, Collectors.toList())
//        ));

        //Find employee pairs who have same salary.
        Map<Double, List<Employee>> collect24 = employees.stream().collect(Collectors.groupingBy(emp -> Optional.ofNullable(emp.getSalary()).orElse(0.0))).entrySet().stream().filter(val -> val.getValue().size() > 1).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
        ));
        System.out.println(collect24);

        //Find employee pairs who have same department and same rating.
        Map<String, List<Employee>> collect23 = employees.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment() + "-" + emp.getRating()));
        System.out.println(collect23);

        //Sort employees inside each department by salary.
        Map<String, List<Employee>> collect25 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                Collectors.toList(),
                emp -> emp.stream().sorted(Comparator.comparing(Employee::getSalary)).toList()

        )));
        System.out.println(collect25);

        //Get top-rated employee from each city.
        Map<String, Employee> collect26 = employees.stream().collect(
                Collectors.groupingBy(Employee::getCity,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employee::getRating)),
                                Optional::get
                        )));

        System.out.println(collect26);

        //Find unique skills sorted alphabetically.
        List<String> uniqueSkills = employees.stream().flatMap(emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream()).sorted().distinct().toList();
        System.out.println(uniqueSkills);

        //or
        TreeSet<String> collect27 = employees.stream().flatMap(
                emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream()
        ).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect27);

        //Get average age of employees per city.
        Map<String, Double> collect28 = employees.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.averagingDouble(Employee::getAge)));
        System.out.println(collect28);

        //Find employees whose skill count is greater than skill count of "Vikas".
        Integer vikasSkillCount = employees.stream().filter(emp -> emp.getFirstName().equalsIgnoreCase("vikas")).map(emp -> emp.getSkills().size()).findFirst().orElse(0);
        List<Employee> employeeOtherThanVikas = employees.stream().filter(emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).size() > vikasSkillCount && !emp.getFirstName().equalsIgnoreCase("vikas")).toList();
        System.out.println(employeeOtherThanVikas);

        //Sort employees by age difference from employee with ID 1.
        Integer baseAge = employees.stream().filter(emp -> emp.getId() == 1).map(emp -> emp.getAge()).findFirst().orElse(0);
        List<Employee> list36 = employees.stream().sorted(Comparator.comparing(emp -> Math.abs(emp.getAge() - baseAge))).toList();
        System.out.println(list36);

        //Find next highest salary employee after Karan.
        Double KaranSalary = employees.stream().filter(emp -> emp.getFirstName().equalsIgnoreCase("Karan")).map(emp -> emp.getSalary()).findFirst().orElse(0.0);
        Employee employee5 = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).filter(emp -> emp.getSalary() > KaranSalary).findFirst().orElse(new Employee());
        System.out.println(employee5);

        //Create a nested map → Department → City → List<Employee>.
        Map<String, Map<String, List<Employee>>> collect29 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getCity)));
        System.out.println(collect29);

        //Create Map<JoiningYear, Set<Skills>>.
        Map<Integer, Set<String>> collect30 = employees.stream().collect(Collectors.groupingBy(
                emp -> emp.getJoiningDate().getYear(),
                Collectors.mapping(
                        emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()),
                        Collectors.flatMapping(List::stream, Collectors.toSet())

                )
        ));

        //Find the total experience (years) of all IT employees combined.
        Integer sum2 = employees.stream().filter(emp -> emp.getDepartment().equalsIgnoreCase("IT")).mapToInt(emp -> emp.getExperienceYears()).sum();
        System.out.println(sum2);

        //Find youngest employee in each department.
        Map<String, Employee> collect31 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.minBy(Comparator.comparing(Employee::getAge)),
                        Optional::get
                )
        ));

        // Find oldest employee in each city.
        Map<String, Employee> collect32 = employees.stream().collect(Collectors.groupingBy(Employee::getCity,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(
                                Employee::getAge
                        )),
                        Optional::get
                )));
        System.out.println(collect32);

        //Group employees by department and find average rating.
        Map<String, Double> collect33 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getRating)
        ));
        System.out.println(collect33);

        //Find employees with palindromic first names (“level”, “madam”).
        List<Employee> list37 = employees.stream().filter(emp -> emp.getFirstName().equalsIgnoreCase(new StringBuilder(emp.getFirstName()).reverse().toString())).toList();
        System.out.println(list37);

        //Get top 3 employees by salary per department.
        Map<String, List<Employee>> collect34 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                Collectors.toList(),
                li -> li.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).toList()
        )));
        System.out.println(collect34);

        //Compare salaries of Pune vs Mumbai employees.
        Map<String, Double> collect36 = employees.stream().filter(emp -> emp.getCity().equalsIgnoreCase("Pune") || emp.getCity().equalsIgnoreCase("Mumbai")).collect(Collectors.groupingBy(
                Employee::getCity,
                Collectors.summingDouble(Employee::getSalary)
        ));

        System.out.println(collect36);
        //Create Map<Boolean, Employees> → true if skills ≥ 2 AND rating > 4.
        Map<Boolean, List<Employee>> collect35 = employees.stream().collect(Collectors.partitioningBy(emp -> (Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).size() >= 2) && (emp.getRating()) > 4));
        System.out.println(collect35);

        //From each department, find employee whose name is lexicographically smallest.
        Map<String, Employee> collect37 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.minBy(Comparator.comparing(Employee::getFirstName)),
                        Optional::get
                )
        ));
        System.out.println(collect37);

        //Determine if all employees have non-null email.
        boolean b1 = employees.stream().map(Employee::getEmail).allMatch(Objects::nonNull);
        System.out.println(b1);

        //or
        boolean b = employees.stream().allMatch(emp -> emp.getEmail() != null);
        System.out.println(b);


        //Check if any employee has rating < 3.
        boolean b2 = employees.stream().anyMatch(emp -> emp.getRating() < 3);
        System.out.println(b2);

        //Find employee having maximum skill length (skill string characters).
        Employee employee6 = employees.stream().max(Comparator.comparing(emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream().mapToInt(String::length).max().orElse(0)
        )).orElse(null);
        System.out.println(employee6);

        //Create Map<City, Map<Department, Average Salary>>>.
        Map<String, Map<String, Double>> collect38 = employees.stream().collect(Collectors.groupingBy(
                Employee::getCity,
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                )
        ));

        //Find employees whose salary is within ±10% of the department’s average salary.
        Map<String, Double> DeptAvgSal = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
        ));

        List<Employee> list38 = employees.stream().filter(emp -> {
            Double avgSal = DeptAvgSal.get(emp.getDepartment());
            double lowerSal = avgSal * 0.90;
            double higherSal = avgSal * 1.10;

            return emp.getSalary() >= lowerSal && emp.getSalary() <= higherSal;
        }).toList();

        System.out.println(list38);


        //Sort employees by: dept → city → rating desc → bonus desc → age asc.
        List<Employee> list39 = employees.stream().sorted(
                Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getCity)
                        .thenComparing(Comparator.comparing(Employee::getRating).reversed())
                        .thenComparing(Comparator.comparing(Employee::getBonus).reversed())
                        .thenComparing(Employee::getAge)
        ).toList();

        //Find employees whose skill list shares at least two skills with Karan.
        List<String> karanSkills = employees.stream().filter(emp -> emp.getFirstName().equalsIgnoreCase("karan")).findFirst().get().getSkills();
        System.out.println(karanSkills);

        List<Employee> list40 = employees.stream().filter(emp -> emp.getSkills() != null)
                .filter(emp -> {
                            long count3 = emp.getSkills().stream()
                                    .filter(karanSkills::contains).count();
                            return count3 >= 2;
                        }
                ).toList();

        System.out.println(list40);

        //Find employees having skill names longer than the average skill name length.
        double v = employees.stream().filter(emp -> emp.getSkills() != null)
                .flatMap(emp -> emp.getSkills().stream())
                .mapToInt(String::length)
                .average()
                .orElse(0.0);

        List<Employee> list41 = employees.stream().filter(emp -> emp.getSkills() != null)
                .filter(emp -> emp.getSkills().stream().anyMatch(skill -> skill.length() > v)).toList();
        System.out.println(list41);

        //Find employees who joined in the same month as “Neha Kulkarni”
        Month nehaKulkarni = employees.stream().filter(emp -> emp.getFullName().equalsIgnoreCase("Neha Kulkarni"))
                .findFirst().get().getJoiningDate().getMonth();

        System.out.println(nehaKulkarni);
        List<Employee> list42 = employees.stream().filter(emp -> !emp.getFullName().equalsIgnoreCase("Neha Kulkarni")).filter(emp -> emp.getJoiningDate().getMonth() == nehaKulkarni).toList();
        System.out.println(list42);

        //Find employees whose email domain occurs more than once.
        Map<String, Long> domainCollection = employees.stream().map(emp -> emp.getEmail().substring(emp.getEmail().indexOf('@') + 1)).collect(Collectors.groupingBy(domain -> domain, Collectors.counting()));
        System.out.println(domainCollection);

        List<Employee> list43 = employees.stream().filter(emp ->
                {
                    String domain = emp.getEmail().substring(emp.getEmail().indexOf('@') + 1);
                    return domainCollection.get(domain) > 1;

                }
        ).toList();

        System.out.println(list43);

        //Find employees whose bonus is in the top 20% of the company.
        List<Employee> sortedByBonus = employees.stream().sorted(Comparator.comparing(Employee::getBonus).reversed()).toList();
        int cutofIndex = (int) Math.floor((sortedByBonus.size() * 0.20));
        if (cutofIndex == 0) cutofIndex = 1;
        double bonus = sortedByBonus.get(cutofIndex - 1).getBonus();

        List<Employee> top20BonusEmployees = employees.stream().filter(emp -> emp.getBonus() >= bonus).toList();
        System.out.println("a" + top20BonusEmployees);

        List<Double> list44 = employees.stream().filter(emp -> emp.getBonus() >= bonus).map(emp -> emp.getBonus()).toList();
        System.out.println(list44);

        List<Double> sortedByB = employees.stream().sorted(Comparator.comparing(Employee::getBonus).reversed()).map(emp -> emp.getBonus()).toList();

        System.out.println(sortedByB);

        List<Double> list45 = employees.stream().sorted(Comparator.comparing(Employee::getBonus).reversed()).limit((long) (employees.size() * 0.20)).map(emp -> emp.getBonus()).toList();
        System.out.println(list45);

        //Find employees where (rating * bonus) > salary.
        List<Employee> list46 = employees.stream().filter(emp -> (emp.getRating() * emp.getBonus()) > emp.getSalary()).toList();
        System.out.println(list46);

//        //Find employees who have no skill starting with any vowel.
//        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U');
//        employees.stream().filter(emp -> vowels.contains(emp.getSkills().stream().noneMatch(skill -> Character.toUpperCase(skill.charAt(0))))
//        ).toList();


        //Find employees whose firstname has duplicate characters (e.g., “Priya”).
        List<Employee> list47 = employees.stream().filter(emp -> {
                    String firstName = emp.getFirstName().toLowerCase();
                    return firstName.chars().distinct().count() < emp.getFirstName().length();
                }
        ).toList();
        System.out.println(list47);

        //Find employees whose lastname has at least 3 consonants in a row.
        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U');
        List<Employee> list48 = employees.stream().filter(emp -> {
            String lastName = emp.getLastName().toUpperCase();
            int ct = 0;
            for (char c : lastName.toCharArray()) {
                if (!vowels.contains(c)) {
                    ct = ct + 1;
                    if (ct >= 3) return true;
                } else {
                    ct = 0;
                }
            }
            return false;

        }).toList();

        //Find employees whose city name length is a prime number.
        List<Employee> list49 = employees.stream().filter(emp -> {
            int cityLength = emp.getCity().length();
            if (cityLength == 1) return false;

            for (int i = 2; i <= Math.sqrt(cityLength); i++) {
                if (cityLength % i == 0) return false;
            }
            return true;
        }).toList();
        System.out.println(list49);

        //Sort employees by descending number of vowels in full name.
        Set<Character> vowel = Set.of('A', 'E', 'I', 'O', 'U');

        List<Employee> list50 = employees.stream().sorted((e1, e2) -> {

            String firstFullName = e1.getFullName().toUpperCase();
            String secondFullName = e2.getFullName().toUpperCase();

            int vowelCount1 = 0;
            int vowelCount2 = 0;

            for (char c : firstFullName.toCharArray()) if (vowel.contains(c)) vowelCount1++;
            for (char c : secondFullName.toCharArray()) if (vowel.contains(c)) vowelCount2++;

            return Integer.compare(vowelCount2, vowelCount1);
        }).toList();
        System.out.println(list50);

        //Identify employees having skill names that form palindromes when reversed.
        List<Employee> list51 = employees.stream().filter(emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream().anyMatch(skill -> skill.equalsIgnoreCase(
                new StringBuilder(skill).reverse().toString()
        ))).toList();
        System.out.println(list51);

        //Find employees whose joining date is on a weekend.
        List<Employee> list52 = employees.stream().filter(emp -> {
            DayOfWeek dayOfWeek = emp.getJoiningDate().getDayOfWeek();

            return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        }).toList();
        System.out.println(list52);
        //or

        List<Employee> list53 = employees.stream().filter(emp -> emp.getJoiningDate().getDayOfWeek().getValue() >= 6).toList();
        System.out.println(list53);

        //Find employees who joined on the same date (duplicate joining dates).
        Map<LocalDate, Long> collect39 = employees.stream().collect(Collectors.groupingBy(Employee::getJoiningDate, Collectors.counting()));
        List<Employee> list54 = employees.stream().filter(emp -> collect39.get(emp.getJoiningDate()) > 1).toList();

        //or
        List<Employee> list55 = employees.stream().collect(Collectors.groupingBy(
                Employee::getJoiningDate
        )).values().stream().filter(li -> li.size() > 1).flatMap(List::stream).toList();

        //Find employees whose rating is in the top 10% of the company.
        List<Double> distinctRating = employees.stream().map(emp -> emp.getRating()).sorted(Comparator.reverseOrder()).distinct().toList();

        int index = (int) Math.ceil(distinctRating.size() * 0.10) - 1;
        Double baseValue = distinctRating.get(index);

        List<Employee> list56 = employees.stream().filter(emp -> emp.getRating() >= baseValue).toList();
        System.out.println(list56);

        //Group employees by department → experience bracket (0–3, 4–7, 8+).
        Map<String, Map<String, List<Employee>>> collect40 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.groupingBy(
                        emp -> {
                            int experienceYears = emp.getExperienceYears();

                            if (experienceYears <= 3) return "0-3 year";
                            else if (experienceYears <= 7) return "4-7 year";
                            else return "8+ year";

                        })
        ));

        System.out.println(collect40);

        //Group employees by age decade (20s, 30s, 40s, 50s).
        Map<String, List<Employee>> collect41 = employees.stream().collect(Collectors.groupingBy(
                emp -> {
                    int age = emp.getAge();
                    int decade = (age / 10) * 10;
                    return decade + "s";
                }
        ));
        System.out.println(collect41);

        //Group employees by city → gender → skill count.
        Map<String, Map<String, Map<Long, List<Employee>>>> collect42 = employees.stream().collect(Collectors.groupingBy(
                Employee::getCity,
                Collectors.groupingBy(Employee::getGender,
                        Collectors.groupingBy(emp ->
                                Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream().distinct().count()
                        ))
        ));

        //Group employees by first letter of firstname → sort each group by salary.
        Map<Character, List<Employee>> collect43 = employees.stream().collect(Collectors.groupingBy(
                emp -> emp.getFirstName().charAt(0),
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        empList -> empList.stream()
                                .sorted(Comparator.comparing(Employee::getSalary))
                                .toList()
                )));

        System.out.println(collect43);

        //Generate summary: dept → average bonus → average salary → count.

        Map<String, Map<String, Object>> collect44 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.teeing(
                                Collectors.averagingDouble(Employee::getBonus),
                                Collectors.teeing(
                                        Collectors.averagingDouble(Employee::getSalary),
                                        Collectors.counting(),
                                        (avgSal, count10) -> Map.of(
                                                "avgSalary", avgSal,
                                                "count", count10
                                        )
                                ),
                                (avgBonus, innerMap) -> {
                                    Map<String, Object> map = new LinkedHashMap<>(innerMap);
                                    map.put("avgBonus", avgBonus);
                                    return map;
                                }
                        )
                ));

        System.out.println(collect44);

        //Partition employees based on whether any skill contains digits.
        Map<Boolean, List<Employee>> collect45 = employees.stream().collect(Collectors.partitioningBy(
                emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream().anyMatch(
                        skill -> {
                            for (char c : skill.toCharArray()) {
                                if (Character.isDigit(c)) return true;
                            }
                            return false;
                        }
                )


        ));
        System.out.println(collect45);

        //partition employees into: high-performers (>4.5), mid (4–4.5), low (<4).
        HashMap<String, Employee> collect46 = employees.stream().collect(Collectors.toMap(
                em -> {
                    double rating = em.getRating();
                    if (rating > 4.5) return "high";
                    else if (rating <= 4.5 && rating >= 4) return "mid";
                    else return "low";
                },
                emp -> emp,
                (e, n) -> e,
                HashMap::new
        ));

        System.out.println(collect46);

        //Find mode (most frequent) salary across all employees.
        Map.Entry<Double, Long> doubleLongEntry = employees.stream().collect(Collectors.groupingBy(
                Employee::getSalary,
                Collectors.counting()
        )).entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
        System.out.println(doubleLongEntry);

        //Group employees by skill count → sort each bucket by bonus.
        Map<Long, List<Employee>> collect47 = employees.stream().collect(Collectors.groupingBy(
                emp -> {
                    long count3 = Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream().count();
                    return count3;
                },
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        li -> li.stream().sorted(Comparator.comparing(Employee::getBonus)).toList()
                )
        ));
        System.out.println(collect47);

        //Partition employees by whether their salary equals department max salary.
        Map<String, Double> collect48 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                        salary -> salary.get().getSalary()

                )
        ));

        System.out.println(collect48);

        Map<Boolean, List<Employee>> collect49 = employees.stream().collect(Collectors.partitioningBy(emp -> collect48.get(emp.getDepartment()) == emp.getSalary()));
        System.out.println(collect49);

        //Group employees by year → find employee with lowest rating each year.
        Map<Integer, Employee> collect50 = employees.stream().collect(Collectors.groupingBy(
                emp -> emp.getJoiningDate().getYear(),
                Collectors.collectingAndThen(
                        Collectors.minBy(Comparator.comparing(Employee::getRating)),
                        opt -> opt.get()
                )
        ));
        System.out.println(collect50);

        //Partition employees by whether skills include any cloud tech (AWS, Azure, GCP).\
        Set<String> es = Set.of("AWS", "Azure", "GCP");
        Map<Boolean, List<Employee>> collect51 = employees.stream().collect(Collectors.partitioningBy(
                emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream().map(String::toUpperCase).anyMatch(es::contains)
        ));
        System.out.println(collect51);

        //Generate: dept → total salary → highest bonus → lowest bonus.
        Map<String, HashMap<String, Object>> collect52 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.teeing(
                        Collectors.summingDouble(Employee::getSalary),
                        Collectors.teeing(
                                Collectors.maxBy(Comparator.comparing(Employee::getBonus)),
                                Collectors.minBy(Comparator.comparing(Employee::getBonus)),
                                (maxBonus, minBonus) ->
                                        Map.of("highest bonus", maxBonus.get().getBonus(),
                                                "Lowest Bonus", minBonus.get().getBonus())

                        ),
                        (avgSalary, map) -> {
                            HashMap<String, Object> result = new HashMap<>();
                            result.put("avgSalary", avgSalary);
                            return result;

                        }
                )

        ));

        System.out.println(collect52);


        //Count number of employees grouped by email domain.
        String[] split = employees.get(1).getEmail().split("@");

        Map<String, Long> collect53 = employees.stream().collect(Collectors.groupingBy(
                emp -> {
                    String[] split1 = emp.getEmail().split("@");
                    return split1[1];
                },
                Collectors.counting()
        ));
        System.out.println(collect53);

        //or
        Map<String, Long> collect54 = employees.stream().collect(Collectors.groupingBy(
                emp -> {
                    String email = emp.getEmail();
                    int idx = emp.getEmail().indexOf('@');
                    return idx != -1 ? email.substring(idx + 1) : "Invalid";
                },
                Collectors.counting()
        ));

        System.out.println(collect54);

        //Group employees by age bucket (5-year ranges).
        Map<String, List<Employee>> collect55 = employees.stream().collect(Collectors.groupingBy(
                emp -> {
                    int age = emp.getAge();
                    int lowerAgeRange = (age / 5) * 5;
                    int upperAgeRange = lowerAgeRange + 4;
                    return lowerAgeRange + "-" + upperAgeRange;
                }
        ));
        System.out.println(collect55);

        //Group employees by month of joining → list employees sorted by rating.
        Map<Month, List<Employee>> collect56 = employees.stream().collect(Collectors.groupingBy(
                emp -> emp.getJoiningDate().getMonth(),
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        li -> li.stream().sorted(Comparator.comparing(Employee::getRating)).toList()
                )
        ));
        System.out.println(collect56);

        //Group employees by salary range: (0–50k, 50–100k, 100–150k, >150k).
        Map<String, List<Employee>> collect57 = employees.stream().collect(Collectors.groupingBy(
                emp -> {
                    double salary = emp.getSalary();
                    if (salary <= 50000) return "0-50K";
                    else if (salary <= 100000) return "50-100k";
                    else if (salary <= 150000) return "100-150k";
                    else return ">150K";

                }
        ));
        System.out.println(collect57);

        //Group employees by character length of fullname.
        Map<Integer, List<Employee>> collect58 = employees.stream().collect(Collectors.groupingBy(
                emp -> emp.getFullName().length()
        ));
        System.out.println(collect58);

        //Partition employees by whether their lastname appears more than once.
        Map<String, Long> collect59 = employees.stream().collect(Collectors.groupingBy(
                emp -> emp.getLastName(),
                Collectors.counting()
        ));

        Map<Boolean, List<Employee>> collect60 = employees.stream().collect(Collectors.partitioningBy(emp -> collect59.get(emp.getLastName()) > 1));
        System.out.println(collect60);

        //Group employees by department and find employee whose bonus is closest to the department average.
        Map<String, Employee> collect61 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        li -> {
                            double avgBonus = li.stream().mapToDouble(Employee::getBonus).average().orElse(0.0);
                            return li.stream().min(Comparator.comparingDouble(emp -> Math.abs(emp.getBonus() - avgBonus))).orElse(null);
                        }

                )
        ));
        System.out.println(collect61);

        //Group employees by gender and return top 3 salaries for each.
        Map<String, List<Employee>> collect62 = employees.stream().collect(Collectors.groupingBy(
                Employee::getGender,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        li -> li.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).toList()
                )
        ));

        //Create a Map<Skill, Total Salary of Employees Having That Skill>.
        Map<Object, Double> collect63 = employees.stream().flatMap(
                emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream().map(skill -> Map.entry(skill, emp.getSalary()))
        ).collect(Collectors.groupingBy(
                Map.Entry::getKey,
                Collectors.summingDouble(Map.Entry::getValue)
        ));

        System.out.println(collect63);


        //Create a sorted Map<Skill, Average Rating>.
        Map<String, Double> collect64 = employees.stream().flatMap(emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream().map(skill -> Map.entry(skill, emp.getRating()))).collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));
        System.out.println(collect64);

        //Compute global skill usage frequency normalized by employee count.
        int size = employees.size();
        Map<String, Double> collect65 = employees.stream().flatMap(emp ->
                Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream().map(skill -> Map.entry(skill, 1L))
        ).collect(Collectors.groupingBy(
                Map.Entry::getKey,
                Collectors.summingLong(Map.Entry::getValue)
        )).entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> e.getValue() / (double) size

        ));
        System.out.println(collect65);

        // Build Map<City, Map<Skill, Count>>.
        Map<String, Map<String, Long>> collect66 = employees.stream().collect(Collectors.groupingBy(
                Employee::getCity,
                Collectors.flatMapping(
                        emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream(),
                        Collectors.groupingBy(
                                skill -> skill,
                                Collectors.counting()
                        )
                )
        ));

        System.out.println(collect66);

        // Create a Map<EmployeeName, TotalSkillCharacterCount>.
        Map<String, Integer> collect67 = employees.stream().collect(Collectors.toMap(
                Employee::getFirstName,
                emp -> {
                    String skills = Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream().reduce("", (a, d) -> a + d);
                    return skills.toCharArray().length;
                },
                (e, n) -> e
        ));

        System.out.println(collect67);

        //or
        Map<String, Integer> collect68 = employees.stream().collect(Collectors.toMap(
                Employee::getFirstName,
                emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream().collect(Collectors.joining()).length(),
                (e, n) -> e
        ));
        System.out.println(collect68);

        //Build a nested map: Dept → Rating Bucket → Avg Salary.
        Map<String, Map<Double, Double>> collect69 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.groupingBy(
                        Employee::getRating,
                        Collectors.averagingDouble(Employee::getSalary)
                )
        ));

        System.out.println(collect69);

        //Find total number of unique characters used in all skills.
        String skillString = employees.stream().flatMap(emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream()).collect(Collectors.joining());
        long distinctSkillChars = skillString.chars().distinct().count();
        System.out.println(distinctSkillChars);

        //Build Map<Department, List<Employees Sorted by Experience Desc>>.
        Map<String, List<Employee>> collect70 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        li -> li.stream().sorted(Comparator.comparing(Employee::getExperienceYears).reversed()).toList()
                )
        ));
        System.out.println(collect70);

        //Compute the salary-to-bonus ratio for all employees and sort.
        List<Employee> list57 = employees.stream().sorted(Comparator.comparing(
                emp -> {
                    double salary = emp.getSalary();
                    double bonus1 = emp.getBonus();
                    return salary / bonus1;
                }
        )).toList();
        System.out.println(list57);


        //Find sum of squares of all employee ages (analytics problem).
        Integer reduce = employees.stream().map(Employee::getAge).reduce(0, (a, d) -> a + (d * d));
        System.out.println(reduce);
        //or
        int sum3 = employees.stream().mapToInt(emp -> emp.getAge() * emp.getAge()).sum();
        System.out.println(sum3);
        //or
        Integer collect71 = employees.stream().collect(Collectors.summingInt(emp -> emp.getAge() * emp.getAge()));

        //Build Map<Year, Count of New Skills Introduced>.
        Map<Integer, Long> collect72 = employees.stream().collect(Collectors.toMap(
                emp -> emp.getJoiningDate().getYear(),
                li -> Optional.ofNullable(li.getSkills()).orElse(Collections.emptyList()).stream().distinct().count(),
                (e, n) -> e
        ));
        System.out.println(collect72);

        //Create a flat frequency list of all letters used in all skills.
        Map<Character, Long> collect73 = employees.stream().flatMap(emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream()).flatMap(skill -> skill.chars().mapToObj(ch -> (char) ch)).collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        System.out.println(collect73);

        //Determine which skill contributes the highest salary pool.
        Map<String, Double> collect74 = employees.stream().flatMap(emp -> Optional.ofNullable(emp.getSkills())
                .orElse(Collections.emptyList())
                .stream()
                .map(skill -> Map.entry(skill, emp.getSalary()))
        ).collect(Collectors.groupingBy(
                Map.Entry::getKey,
                Collectors.summingDouble(Map.Entry::getValue)
        ));

        Map.Entry<String, Double> stringDoubleEntry = collect74.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
        System.out.println(stringDoubleEntry);

        //Determine which department has the highest skill diversity.
        Map<String, Set<String>> collect75 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.flatMapping(
                        emp -> Optional.ofNullable(emp.getSkills()).orElse(Collections.emptyList()).stream(),
                        Collectors.toSet()
                )
        ));

        Map.Entry<String, Set<String>> stringSetEntry = collect75.entrySet().stream().max(Comparator.comparing(value -> value.getValue().size())).orElse(null);
        System.out.println(stringSetEntry);

        //Compute longest chain of employees sorted by experience.
        Map.Entry<Integer, List<Employee>> integerListEntry = employees.stream().collect(Collectors.groupingBy(
                Employee::getExperienceYears,
                TreeMap::new,
                Collectors.toList()

        )).entrySet().stream().max(Comparator.comparing(entry -> entry.getValue().size())).orElse(null);
        System.out.println(integerListEntry);

        //Find employees who would qualify for promotion if:
        //salary > dept_avg AND rating > dept_avg_rating AND experience > 5.

        Map<String, Double> collect76 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
        ));

        Map<String, Double> collect77 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getRating)
        ));

        List<Employee> list58 = employees.stream().filter(emp -> emp.getSalary() > collect76.get(emp.getDepartment()) && emp.getRating() > collect77.get(emp.getDepartment()) && emp.getExperienceYears() > 5).toList();
        System.out.println(list58);


        //Recommend mentors from employees with:
        //experience > 10 AND rating > 4.5.

        List<Employee> list59 = employees.stream().filter(emp -> emp.getExperienceYears() > 10 && emp.getRating() > 4.5).toList();
        System.out.println(list59);

        //Build a compatibility matrix of employees based on shared skills and rating similarity.

    }

}

