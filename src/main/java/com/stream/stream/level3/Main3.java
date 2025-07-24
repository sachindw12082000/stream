package com.stream.stream.level3;

import com.fasterxml.jackson.core.JsonToken;
import com.stream.stream.complex.Order;
import com.stream.stream.complex.Product;
import com.stream.stream.complex.Student;

import javax.sound.midi.spi.SoundbankReader;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {
    public static void main(String[] args) {

        // 1. Employee3
        List<Employee3> employees = Arrays.asList(
                new Employee3(1, "John", "IT", 50000, "Pune", LocalDate.of(2020, 1, 15), Arrays.asList("12345", "67890"), Arrays.asList("ProjectA", "ProjectB")),
                new Employee3(2, "Alice", "HR", 70000, "Mumbai", LocalDate.of(2022, 3, 10), Arrays.asList("11111"), Arrays.asList("ProjectC", "ProjectD")),
                new Employee3(3, "Bob", "IT", 60000, "Delhi", LocalDate.of(2019, 11, 20), Arrays.asList("22222", "33333"), Arrays.asList("ProjectE", "ProjectF")),
                new Employee3(4, "Charlie", "Finance", 90000, "Nagpur", LocalDate.of(2021, 6, 5), Arrays.asList("44444"), Arrays.asList("ProjectG", "ProjectH")),
                new Employee3(5, "Daisy", "Finance", 80000, "Pune", LocalDate.of(2023, 2, 12), Arrays.asList("55555"), Arrays.asList("ProjectI", "ProjectJ"))
        );

        // 2. Product3
        List<Product3> products = Arrays.asList(
                new Product3(1, "iPhone", "Electronics", 999.99, "Apple"),
                new Product3(2, "Samsung TV", "Electronics", 499.99, "Samsung"),
                new Product3(3, "Nike Shoes", "Fashion", 120.00, "Nike"),
                new Product3(4, "Levi's Jeans", "Fashion", 80.00, "Levi's"),
                new Product3(5, "Dell Laptop", "Electronics", 850.00, "Dell"),
                new Product3(6, "Nike Shoes2", "Fashion", 111.00, "Nike"),
                new Product3(7, "iPhone", "Electronics", 998.99, "Apple")
        );

        // 3. Student3
        List<Student3> students = Arrays.asList(
                new Student3(1, "Rahul", "A", 85),
                new Student3(2, "Sneha", "A", 78),
                new Student3(3, "Amit", "B", 88),
                new Student3(4, "Priya", "B", 65),
                new Student3(5, "Rohit", "C", 92)
        );

        // 4. BlogPost3
        List<BlogPost3> blogPosts = new ArrayList<>();
        blogPosts.add(new BlogPost3("Intro to Java", "John", "Programming", 150, Arrays.asList("Java", "Basics", "OOP")));
        blogPosts.add(new BlogPost3("Spring Boot Guide", "Alice", "Programming", 250, Arrays.asList("Java", "Spring", "Backend")));
        blogPosts.add(new BlogPost3("Top 10 Places", "Bob", "Travel", 180, Arrays.asList("Travel", "Adventure", "Nature")));
        blogPosts.add(new BlogPost3("Fashion Trends", "Daisy", "Lifestyle", 220, Arrays.asList("Fashion", "Style", "Trends")));


        // 5. Transaction3
        List<Transaction3> transactions = Arrays.asList(
                new Transaction3("TX1001", "Neha", 5000, LocalDate.of(2023, 1, 10)),
                new Transaction3("TX1002", "Amit", 12000, LocalDate.of(2023, 3, 15)),
                new Transaction3("TX1003", "Sneha", 15000, LocalDate.of(2024, 5, 5))
        );

        // 6. Invoice3
        List<Invoice3> invoices = Arrays.asList(
                new Invoice3(101, "John Pvt Ltd", 1500.50, Arrays.asList("Laptop", "Mouse")),
                new Invoice3(102, "XYZ Corp", 3200.75, Arrays.asList("Monitor", "Keyboard", "Chair"))
        );

        // 7. Order3
        List<Order3> orders = Arrays.asList(
                new Order3(1, "Sachin", Arrays.asList(
                        new Product3(1, "Book", "Education", 400.0, null),
                        new Product3(2, "Pen", "Stationery", 50.0, null)
                ), "Delivered"),

                new Order3(2, "Ravi", Arrays.asList(
                        new Product3(3, "Phone", "Electronics", 20000.0, null)
                ), "Pending")
        );

        // Now you can perform any stream operations on these lists for practice.
        System.out.println("Data initialized for stream operations.");
        System.out.println("Level 3 questions");


        //Group employees by department, then find top 3 highest-paid employees in each department.
        Map<String, List<Employee3>> collect = employees.stream().collect(Collectors.groupingBy(
                Employee3::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().sorted(Comparator.comparing(Employee3::getSalary).reversed()).limit(3).toList()
                )
        ));
        System.out.println(collect);

        //Given a list of employees, each with multiple projects, flatten and group project names by city.
        Map<String, List<String>> collect1 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getCity,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().flatMap(e -> e.getProjects().stream()).toList()
                )
        ));

        System.out.println(collect1);

        //Partition employees by those earning more than 50K. For both groups, calculate average and total salary.
        Map<Boolean, DoubleSummaryStatistics> collect2 = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 50000, Collectors.summarizingDouble(Employee3::getSalary)));
        System.out.println(collect2);

        //Group employees by city and then by department. For each group, calculate total salary and count.
        Map<String, Map<String, DoubleSummaryStatistics>> collect3 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getCity,
                Collectors.groupingBy(
                        Employee3::getDepartment,
                        Collectors.summarizingDouble(Employee3::getSalary)
                )
        ));

        System.out.println(collect3);
        System.out.println(collect3.get("Delhi").get("IT").getAverage());


        //From a list of products, group by category and calculate total price using reducing collector.
        Map<String, Double> collect4 = products.stream().collect(Collectors.groupingBy(
                Product3::getCategory,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().mapToDouble(Product3::getPrice).reduce(0.0, Double::sum)

                )
        ));

        //From a list of strings, remove duplicates, sort them, and collect into an unmodifiable list.
        List<String> apple = List.of("Apple",
                "Banana",
                "Orange",
                "Apple",
                "Mango",
                "Banana",
                "Grapes",
                "Apple");

        List<String> collect5 = apple.stream().distinct().sorted().collect(Collectors.toUnmodifiableList());
        System.out.println(collect5);


        //Create a map of department to total salary and sort it in descending order of salary.
        LinkedHashMap<String, Double> collect6 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getDepartment,
                Collectors.summingDouble(Employee3::getSalary)
        )).entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
        ));

        System.out.println(collect6);

        //From a list of employee names, find the name that appears most frequently.
        Optional<String> s = employees.stream().collect(Collectors.groupingBy(
                Employee3::getName,
                Collectors.counting()
        )).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);

        System.out.println(s);

        //Given a list of employees, each with optional emergency contact numbers
        // (List<Optional<String>>), flatten and collect all non-empty contact numbers.
        List<String> list1 = employees.stream()
                .flatMap(emp -> emp.getPhoneNumbers().stream())
                .filter(emp -> !emp.isEmpty())
                .toList();

        System.out.println(list1);

        //From a list of orders (with customer name,
        // list of product names, and total), generate a map of customer name → total spent.
        Map<String, Double> collect7 = orders.stream().collect(Collectors.groupingBy(
                Order3::getCustomerName,
                Collectors.summingDouble(order -> order.getProducts().stream().mapToDouble(Product3::getPrice).sum())
        ));

        System.out.println(collect7);

        //Group employees by department and list all employees in each.
        Map<String, List<Employee3>> collect8 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getDepartment
        ));

        //Group employees by city and count how many employees per city.
        Map<String, Long> collect9 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getCity,
                Collectors.counting()
        ));
        System.out.println(collect9);

        //Group employees by department and get the total salary of each group.
        Map<String, Double> collect10 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getDepartment,
                Collectors.summingDouble(Employee3::getSalary)
        ));
        System.out.println(collect10);

        //Group products by category and get the average price in each category.
        Map<String, Double> collect11 = products.stream().collect(Collectors.groupingBy(
                Product3::getCategory,
                Collectors.averagingDouble(Product3::getPrice)
        ));
        System.out.println(collect11);

        //Group students by grade and count how many got above 80 marks.
        Map<String, Long> collect12 = students.stream().filter(student3 -> student3.getMarks() > 80).collect(Collectors.groupingBy(
                Student3::getGrade,
                Collectors.counting()
        ));
        System.out.println(collect12);

        //or
        long count = students.stream().filter(student3 -> student3.getMarks() > 80).count();
        System.out.println(count);

        //Group orders by customer name and get the total amount spent per customer.
        Map<String, Double> collect13 = orders.stream().collect(Collectors.groupingBy(
                Order3::getCustomerName,
                Collectors.summingDouble(
                        order -> order.getProducts().stream().mapToDouble(Product3::getPrice).sum()
                )
        ));

        System.out.println(collect13);

        //Group employees by department, then get the employee with the highest salary in each.
        Map<String, Employee3> collect14 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Employee3::getSalary)),
                        Optional::get
                )
        ));
        System.out.println(collect14);

        //Group employees by city and department (multi-level grouping).
        Map<String, Map<String, List<Employee3>>> collect15 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getCity,
                Collectors.groupingBy(
                        Employee3::getDepartment
                )
        ));

        System.out.println(collect15);

        //Partition employees by whether their salary is greater than 50K, then count each group.
        Map<Boolean, Long> collect16 = employees.stream().collect(Collectors.partitioningBy(
                emp -> emp.getSalary() > 50000,
                Collectors.counting())
        );
        System.out.println(collect16);


        //Partition students by whether they passed (marks >= 40), then get average marks for both groups.
        Map<Boolean, Double> collect17 = students.stream().collect(Collectors.partitioningBy(
                student3 -> student3.getMarks() >= 40,
                Collectors.averagingDouble(Student3::getMarks)
        ));
        System.out.println(collect17);

        //Group orders by status (Delivered, Pending, Cancelled) and count.
        Map<String, Long> collect18 = orders.stream().collect(Collectors.groupingBy(
                Order3::getStatus,
                Collectors.counting()
        ));
        System.out.println(collect18);

        //Group products by manufacturer and sort the products in each group by price.
        Map<String, List<Product3>> collect19 = products.stream().collect(Collectors.groupingBy(
                Product3::getManufacturer,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().sorted(Comparator.comparing(Product3::getPrice)).toList()
                )
        ));

        System.out.println(collect19);

        // or
        LinkedHashMap<String, List<Product3>> collect20 = products.stream().sorted(
                        Comparator.comparing(Product3::getManufacturer)
                                .thenComparing(Product3::getPrice))
                .collect(Collectors.groupingBy(
                        Product3::getManufacturer,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));

        System.out.println(collect20);



        List<Product3> list = products.stream()
                .sorted(Comparator.comparing(Product3::getManufacturer)
                        .thenComparing(Product3::getPrice)).toList();
        System.out.println(list);

        //Get all employees with salary > 60K and city is pune.
        List<Employee3> pune = employees.stream().filter(employee3 -> employee3.getSalary() > 60000 && employee3.getCity().equalsIgnoreCase("pune")).toList();
        System.out.println(pune);

        //Find top 5 highest-paid employees across all departments.
        List<Employee3> list2 = employees.stream().sorted(Comparator.comparing(Employee3::getSalary).reversed()).limit(5).toList();
        System.out.println(list2);

        //Find the employee with the earliest joining date.
        Employee3 employee3 = employees.stream().min(Comparator.comparing(Employee3::getJoiningDate)).orElse(null);
        System.out.println(employee3);

        //Get distinct department names in sorted order.
        List<String> list3 = employees.stream().map(Employee3::getDepartment).distinct().sorted(Comparator.naturalOrder()).toList();
        System.out.println(list3);

        //From a list of projects with duplicate names, collect unique names.
        List<String> list4 = products.stream().map(Product3::getName).distinct().toList();
        System.out.println(list4);

        //Sort employees by salary descending and then by name ascending.
        List<Employee3> list5 = employees.stream().sorted(Comparator.comparing(Employee3::getSalary).thenComparing(Employee3::getName)).toList();
        System.out.println(list5);

        //Get employees joined in the last 2 years and sort them by joining date.
        LocalDate now = LocalDate.now().minusYears(2);
        List<Employee3> list6 = employees.stream().filter(emp -> emp.getJoiningDate().isAfter(now)).sorted(Comparator.comparing(Employee3::getJoiningDate)).toList();
        System.out.println(list6);

        //Filter out students who failed and sort them by total marks.
        List<Student3> passedStudents = students.stream()
                .filter(student -> student.getMarks() >= 35)
                .sorted(Comparator.comparing(Student3::getMarks))
                .toList();

        System.out.println(passedStudents);

        //Get top 3 customers with highest total purchases.

        //Remove duplicate email addresses from a list and collect into sorted set.
//        TreeSet<Object> collect21 = employees.stream().map(Employee3::getEmail).distinct().collect(Collectors.toCollection(TreeSet::new));
//        System.out.println(collect21);

        //Flatten a list of lists of strings into a single list of strings.
        List<List<String>> list7 = List.of(Arrays.asList("A"),
                Arrays.asList("B"),
                Arrays.asList("C"),
                Arrays.asList("D"));
        List<String> list8 = list7.stream().flatMap(li -> li.stream()).toList();
        System.out.println(list8);

        //From a list of employees with multiple phone numbers, flatten all phone numbers into one list.
        List<String> list9 = employees.stream().flatMap(employee4 -> employee4.getPhoneNumbers().stream()).toList();
        System.out.println(list9);

        //Get all product names from a list of orders (each order has a list of product names).
        List<String> list10 = orders.stream().flatMap(order -> order.getProducts().stream().map(Product3::getName)).toList();
        System.out.println(list10);

        //Convert a list of names into uppercase.
        List<String> list11 = employees.stream().map(employee4 -> employee4.getName().toUpperCase()).toList();
        System.out.println(list11);

        //Create a comma-separated string of all product names from a list.
        String collect21 = products.stream().map(Product3::getName).collect(Collectors.joining(","));
        System.out.println(collect21);

        //Get a map of employee ID to employee name.
        Map<Integer, String> collect22 = employees.stream().collect(Collectors.toMap(
                Employee3::getId,
                Employee3::getName,
                (existing, replacement) -> existing,
                LinkedHashMap::new

        ));

        System.out.println(collect22);

        //From a list of transactions, extract all transaction IDs.
        List<String> list12 = transactions.stream().map(Transaction3::getTransactionId).toList();
        System.out.println(list12);

        //From a list of blog posts with multiple tags, flatten and get all unique tags.
        List<String> list13 = blogPosts.stream().flatMap(blogPost3 -> blogPost3.getTags().stream()).distinct().toList();
        System.out.println(list13);

        //Calculate the total salary of all employees.
        Double collect23 = employees.stream().mapToDouble(Employee3::getSalary).sum();
        System.out.println(collect23);

        //Get average age of all employees.
        OptionalDouble average = employees.stream().mapToDouble(Employee3::getSalary).average();
        double asDouble = average.getAsDouble();
        System.out.println(asDouble);

        //Find the highest salary among all employees.
        Employee3 employee4 = employees.stream().max(Comparator.comparing(
                Employee3::getSalary
        )).orElse(null);

        System.out.println(employee4);

        //Find the most expensive product.
        Product3 product3 = products.stream().max(Comparator.comparing(Product3::getPrice)).orElse(null);
        System.out.println(product3);

        //Count number of orders per product category.
        Map<String, Long> collect24 = products.stream().collect(Collectors.groupingBy(
                Product3::getCategory,
                Collectors.counting()
        ));
        System.out.println(collect24);

        //Find the longest word in a list of strings.
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("Daisy");

        String s1 = names.stream().max(Comparator.comparing(string -> string.length())).orElse(null);
        System.out.println(s1);

        //From a list of strings, get the frequency of each word.
        Map<String, Long> collect25 = names.stream().collect(Collectors.groupingBy(
                string -> string,
                Collectors.counting()
        ));
        System.out.println(collect25);

        //Calculate the sum of squares of all numbers in a list.
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        int sum = numbers.stream().mapToInt(number -> number * number).sum();
        System.out.println(sum);

        //Get a comma-separated string of employee names.
        String collect26 = employees.stream().map(Employee3::getName).collect(Collectors.joining(","));
        System.out.println(collect26);

        //From a list of student, get summary statistics for marks(min, max, avg, sum).
        DoubleSummaryStatistics collect27 = students.stream().collect(Collectors.summarizingDouble(Student3::getMarks));
        System.out.println(collect27);

        //From a map of <Department, List<Employee>>, find top performer per department.
        LinkedHashMap<String, Optional<Employee3>> collect28 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getDepartment,
                LinkedHashMap::new,
                Collectors.maxBy(Comparator.comparing(Employee3::getSalary))

        ));
        System.out.println(collect28);

        //From list of employees, find those who fall in the top 10% by salary.
        List<Employee3> list14 = employees.stream().sorted(Comparator.comparing(Employee3::getSalary).reversed()).limit((long) Math.ceil(employees.size() * 0.1)).toList();
        System.out.println(list14);

        //Group employees by department, then find top 3 highest-paid employees in each department.
        Map<String, List<Employee3>> collect29 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        li -> li.stream().sorted(Comparator.comparing(Employee3::getSalary).reversed()).limit(3).toList()
                )
        ));
        System.out.println(collect29);

        //Given a list of employees, each with multiple projects, flatten and group project names by city.
        Map<String, List<String>> collect30 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getCity,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        lis -> lis.stream().flatMap(employee5 -> employee5.getProjects().stream()).toList()
                )
        ));
        System.out.println(collect30);

        // or
        Map<String, List<String>> projectsByCity = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee3::getCity,
                        Collectors.flatMapping(
                                e -> e.getProjects().stream(),
                                Collectors.toList()
                        )
                ));

        System.out.println(projectsByCity);

        //Partition employees by those earning more than 50K. For both groups, calculate average and total salary.
        Map<Boolean, DoubleSummaryStatistics> collect31 = employees.stream().collect(Collectors.partitioningBy(
                employee5 -> employee5.getSalary() > 50000,
                Collectors.summarizingDouble(Employee3::getSalary)
        ));

        System.out.println(collect31);

        //Group employees by city and then by department. For each group, calculate total salary and count.
        Map<String, Map<String, DoubleSummaryStatistics>> collect32 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getCity,
                Collectors.groupingBy(
                        Employee3::getDepartment,
                        Collectors.summarizingDouble(Employee3::getSalary)
                )
        ));

        System.out.println(collect32);

        //From a list of products, group by category and calculate total price using reducing collector.
        Map<String, Double> collect33 = products.stream().collect(Collectors.groupingBy(
                Product3::getCategory,
                Collectors.reducing(
                        0.0,
                        Product3::getPrice,
                        Double::sum
                )
        ));

        System.out.println(collect33);

        //From a list of strings, remove duplicates, sort them, and collect into an unmodifiable list.
        List<String> collect34 = names.stream().distinct().sorted().collect(Collectors.toUnmodifiableList());
        System.out.println(collect34);

        //Create a map of department to total salary and sort it in descending order of salary.
        LinkedHashMap<String, Double> collect35 = employees.stream().collect(Collectors.groupingBy(
                Employee3::getDepartment,
                Collectors.summingDouble(Employee3::getSalary)
        )).entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
        ));

        System.out.println(collect35);

    }
}
