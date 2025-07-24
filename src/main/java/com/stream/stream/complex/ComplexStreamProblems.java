package com.stream.stream.complex;

import com.stream.stream.entity.People;

import java.rmi.StubNotFoundException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComplexStreamProblems {
    public static void main(String[] args) {
        // Employees
        List<Employee2> employees = List.of(
                new Employee2(1, "Alice", "Pune", "IT", 70000, LocalDate.of(2019, 5, 10), List.of("111", "222")),
                new Employee2(2, "Bob", "Mumbai", "HR", 60000, LocalDate.of(2021, 3, 15), List.of("333")),
                new Employee2(3, "Charlie", "Pune", "IT", 80000, LocalDate.of(2018, 1, 20), List.of("444")),
                new Employee2(4, "David", "Delhi", "Finance", 75000, LocalDate.of(2020, 7, 5), List.of("555")),
                new Employee2(5, "Eve", "Mumbai", "HR", 65000, LocalDate.of(2022, 8, 25), List.of("666"))
        );

        // People
        List<Person> people = List.of(
                new Person("Tom", "Pune", 30),
                new Person("Jerry", "Mumbai", 25),
                new Person("Mickey", "Pune", 22),
                new Person("Donald", "Mumbai", 29)
        );

        // Products
        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 50000),
                new Product("Mouse", "Electronics", 2000),
                new Product("Shirt", "Apparel", 1500),
                new Product("Jeans", "Apparel", 2500)
        );

        // Students
        List<Student> students = List.of(
                new Student("Aman", "A", 85),
                new Student("Rita", "B", 78),
                new Student("Rahul", "A", 90),
                new Student("Kiran", "B", 82)
        );

        // Transactions
        List<Transaction> transactions = List.of(
                new Transaction("TXN1", 500, LocalDate.of(2023, 3, 10)),
                new Transaction("TXN2", 1000, LocalDate.of(2023, 3, 15)),
                new Transaction("TXN3", 700, LocalDate.of(2024, 1, 5)),
                new Transaction("TXN4", 800, LocalDate.of(2024, 1, 20))
        );

        // Orders
        List<Order> orders = List.of(
                new Order("John", List.of("Phone", "Charger")),
                new Order("John", List.of("Headphones")),
                new Order("Jane", List.of("Laptop")),
                new Order("Jane", List.of("Mouse", "Keyboard"))
        );

        // Integers
        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 3, 4, 5);

        // Sentences
        List<String> sentences = List.of("Hello world!", "World of Java", "Hello Java stream world!");

        // File paths
        List<String> filePaths = List.of("report.pdf", "image.png", "summary.doc", "slide.ppt", "report.doc");

        // Now you can apply all your stream questions on these datasets.

        //Group employees by department and find the highest-paid employee in each department.
        Map<String, Employee2> collect = employees.stream().collect(Collectors.groupingBy(
                Employee2::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Employee2::getSalary)),
                        Optional::get
                )
        ));
        System.out.println(collect);

        //From a list of people, find the youngest person per city.
        Map<String, Person> collect1 = people.stream().collect(Collectors.groupingBy(
                Person::getCity,
                Collectors.collectingAndThen(
                        Collectors.minBy(Comparator.comparing(Person::getAge)),
                        Optional::get
                )
        ));
        System.out.println(collect1);

        //Group products by category and find the total revenue per category.
        Map<String, Double> collect2 = products.stream().collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.collectingAndThen(
                        Collectors.summingDouble(Product::getRevenue),
                        d -> d

                )
        ));

        System.out.println(collect2);

        //or
        Map<String, Double> collect3 = products.stream().collect(
                Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.summingDouble(Product::getRevenue)
                )
        );
        System.out.println(collect3);

        //Group a list of students by grade and collect only those who scored more than 80.
        Map<String, List<Student>> collect4 = students.stream().filter(
                        student -> student.getScore() > 80).
                collect(Collectors.groupingBy(
                        Student::getGrade
                ));
        System.out.println(collect4);

        //Find the department with the highest average salary.
        Map<String, Double> collect5 = employees.stream().collect(Collectors.groupingBy(Employee2::getDepartment, Collectors.averagingDouble(Employee2::getSalary))).entrySet().stream().max(Map.Entry.comparingByValue()).stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collect5);

        //Partition employees by whether they joined before or after 2020 and find average salaries in both groups.
        Map<String, Double> collect6 = employees.stream().collect(Collectors.partitioningBy(
                        employee2 -> employee2.getJoiningDate().getYear() > 2020
                )).entrySet().stream().
                collect(Collectors.toMap(
                        key -> key.getKey() ? "After 2020" : "Before 2020",
                        e -> e.getValue().stream().collect(Collectors.averagingDouble(Employee2::getSalary))
                ));
        System.out.println(collect6);

        Map<String, String> collect7 = orders.stream().collect(Collectors.groupingBy(
                Order::getCustomerName,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        orderList -> orderList.stream()
                                .flatMap(order -> order.getProductNames().stream())
                                .collect(Collectors.joining(","))
                )
        ));
        System.out.println(collect7);

        //Create a Map<City, List<Employee>> sorted by city name and sort employees in each list by salary (descending).
        TreeMap<String, List<Employee2>> collect9 = employees.stream().collect(Collectors.groupingBy(
                Employee2::getCity,
                TreeMap::new,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().sorted(Comparator.comparing(Employee2::getSalary).reversed()).toList()
                )
        ));
        System.out.println(collect9);

        //For each department, find the employee with the earliest joining date.
        Map<String, Employee2> collect8 = employees.stream().collect(Collectors.groupingBy(
                Employee2::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.minBy(Comparator.comparing(Employee2::getJoiningDate)),
                        Optional::get
                )
        ));
        System.out.println(collect8);

        //From a list of transactions, group by year and month, and count transactions per period.
        Map<YearMonth, Long> collect10 = transactions.stream().collect(Collectors.groupingBy(
                e -> YearMonth.from(e.getDate()),
                Collectors.counting()
        ));
        System.out.println(collect10);

        //Find the top 3 highest-paid employees across all departments.
        List<Employee2> list1 = employees.stream().sorted(Comparator.comparing(Employee2::getSalary).reversed()).limit(3).toList();
        System.out.println(list1);

        //Sort employees by salary (desc), then by name (asc) within the same salary.
        List<Employee2> list = employees.stream().sorted(Comparator.comparing(Employee2::getSalary).reversed().thenComparing(Employee2::getName)).toList();
        System.out.println(list);

        //Find the second-highest salary without using skip() or limit().
        TreeSet<Double> collect11 = employees.stream().map(Employee2::getSalary).collect(Collectors.toCollection(TreeSet::new));
        Double last = collect11.last();
        Double lower = collect11.lower(last);
        System.out.println(lower);

        //Return a list of employees, removing duplicates by name but keeping the one with the highest salary.
        Collection<Employee2> values = employees.stream().collect(Collectors.toMap(
                Employee2::getName,
                e -> e,
                (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2
        )).values();
        System.out.println(values);

        //Sort transactions first by amount (desc) then by date (asc).
        List<Transaction> list2 = transactions.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getDate)).toList();
        System.out.println(list2);

        //Get the city with the lowest average salary.
        Map.Entry<String, Double> stringDoubleEntry = employees.stream().collect(Collectors.groupingBy(
                Employee2::getCity,
                Collectors.averagingDouble(Employee2::getSalary)
        )).entrySet().stream().min(Map.Entry.comparingByValue()).orElse(null);
        System.out.println(stringDoubleEntry);

        //From a list of integers, return the three most frequent elements (most occurring).
        Integer key = numbers.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println(key);

        //Find the most common joining year among employees.
        Optional<LocalDate> localDate = employees.stream().collect(Collectors.groupingBy(Employee2::getJoiningDate, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
        localDate.ifPresent(System.out::println);

        //Merge two lists of employees, remove duplicates (by ID), and sort by name.
        List<Employee2> collect12 = Stream.concat(employees.stream(), employees.stream()).collect(Collectors.toMap(
                        employee2 -> employee2.getId(),
                        e -> e,
                        (existing, replacement) -> existing

                )).values()
                .stream()
                .sorted(Comparator.comparing(Employee2::getName)) // Sort by name
                .collect(Collectors.toList());
        System.out.println(collect12);

        //Convert List<Employee> to Map<Department, List<String>> (department to employee names).
        Map<String, List<String>> collect13 = employees.stream().collect(Collectors.groupingBy(
                Employee2::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        li -> li.stream().map(Employee2::getName).toList()
                )
        ));

        System.out.println(collect13);

        //or
        Map<String, List<String>> collect14 = employees.stream().collect(Collectors.groupingBy(
                Employee2::getDepartment,
                Collectors.mapping(
                        Employee2::getName,
                        Collectors.toList()
                )
        ));
        System.out.println(collect14);

        //From a list of students, create a Map<Grade, Double> with the average score per grade.
        Map<String, Double> collect15 = students.stream().collect(Collectors.groupingBy(Student::getGrade,
                Collectors.averagingDouble(Student::getScore)

        ));
        System.out.println(collect15);

        //Create a Map<Boolean, List<Employee>> partitioned by whether salary > 50,000.
        Map<Boolean, List<Employee2>> collect16 = employees.stream().collect(
                Collectors.partitioningBy(
                        employee2 -> employee2.getSalary() > 50000
                ));
        System.out.println(collect16);

        //Merge salaries from multiple branches and sum them for each employee ID.
        Map<Integer, Double> collect17 = employees.stream().collect(Collectors.groupingBy(
                Employee2::getId,
                Collectors.summingDouble(Employee2::getSalary)
        ));
        System.out.println(collect17);

        //Create a map where the key is joining year, and the value is a Set of cities employees joined from.
        Map<Integer, Set<String>> collect18 = employees.stream().collect(Collectors.groupingBy(
                employee2 -> employee2.getJoiningDate().getYear(),
                Collectors.mapping(Employee2::getCity, Collectors.toSet())
        ));

        System.out.println(collect18);

        //Flatten a List<List<Integer>> into a sorted, distinct list.
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(5, 2, 3),
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(6, 7, 1)
        );
        List<Integer> integerList = nestedList.stream().flatMap(List::stream).distinct().sorted().toList();
        System.out.println(integerList);

        //Combine multiple maps into one (handling duplicate keys by summing values).
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2);
        Map<String, Integer> map2 = Map.of("C", 3, "D", 4);

        Map<String, Integer> collect19 = Stream.of(map1, map2).
                flatMap(m -> m.entrySet().stream()).collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (s1, s2) -> s1 + s2
                ));
        System.out.println(collect19);

        //Combine multiple maps into one (handling duplicate keys by summing values).
        Map<String, Integer> a = Map.of("A", 1, "B", 2);
        Map<String, Integer> b = Map.of("A", 1, "B", 2);

        Map<String, Integer> collect20 = Stream.of(a, b).flatMap(e -> e.entrySet().stream()).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (S1, S2) -> S1 + S2
        ));
        System.out.println(collect20);

        //Convert Map<String, List<Employee>> to Map<String, Double> (average salary per city).
        Map<String, List<Employee2>> collect21 = employees.stream().collect(Collectors.groupingBy(Employee2::getCity));

        Map<String, Double> collect22 = collect21.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> e.getValue().stream().mapToDouble(Employee2::getSalary).sum()
        ));

        //Group numbers by even and odd, then return the sum for each group.

        Map<String, Integer> collect23 = numbers.stream().collect(Collectors.teeing(
                Collectors.filtering(n -> n % 2 == 0, Collectors.toList()),
                Collectors.filtering(n -> n % 2 != 0, Collectors.toList()),
                (even, odd) -> Map.of(
                        "even", even.stream().mapToInt(Integer::intValue).sum(),
                        "odd", odd.stream().mapToInt(Integer::intValue).sum()

                )
        ));

        //or
        Map<String, Double> collect24 = numbers.stream().collect(Collectors.groupingBy(
                e -> e % 2 == 0 ? "even" : "odd",
                Collectors.averagingDouble(Integer::intValue)

        ));

        //From a list of sentences, find the top 5 most frequent words.
        LinkedHashMap<String, Long> collect25 = sentences.stream()
                .flatMap(
                        sentence -> Arrays.stream(sentence.split("\\s+")))
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                )).entrySet().stream().limit(5).collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (existing, replacement) -> existing,
                        LinkedHashMap::new
                ));

        System.out.println(collect25);

        //Remove duplicate words (case-insensitive) from a list of strings, preserving insertion order.
        LinkedHashSet<String> collect26 = sentences.stream().flatMap(
                        sentence -> Arrays.stream(sentence.split("\\s+")))
                .map(String::toLowerCase).
                collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println(collect26);

        //Convert a list of file paths into a unique list of file extensions sorted alphabetically.
        List<String> list3 = filePaths.stream().map(fileextension -> fileextension.substring(fileextension.lastIndexOf(".") + 1)).distinct().sorted().toList();
        System.out.println(list3);

        //For each employee, calculate their annual bonus as 10% of salary and return a Map<Name, BonusAmount>.
        Map<String, List<Double>> collect27 = employees.stream().collect(Collectors.groupingBy(
                Employee2::getName,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        li -> li.stream().map(salary -> {
                                    double salary1 = ((salary.getSalary()) * (0.1));
                                    return salary1;
                                }
                        ).toList()
                )

        ));

        System.out.println(collect27);

        // or

        Map<String, Double> collect28 = employees.stream().collect(Collectors.toMap(
                Employee2::getName,
                e -> e.getSalary() * 0.1,
                (e1, e2) -> e1,
                TreeMap::new
        ));

        System.out.println(collect28);


        //From a list of numbers, create pairs (i, j) where i + j == target, without duplicates.
        int target=7;
        Set<String> collect29 = numbers.stream().flatMap(i ->
                numbers.stream().filter(j -> i < j && i + j == target)
                        .map(j -> i + "," + j)
        ).collect(Collectors.toSet());
        System.out.println(collect29);


        //Given a list of employees with multiple phone numbers, flatten into a single List<String> of all phone numbers.

        List<String> collect30 = employees.stream().flatMap(
                e -> e.getPhoneNumbers().stream()
        ).collect(Collectors.toList());
        System.out.println(collect30);

        //Find all employees who have salaries in the top 10% of the company.
        List<Employee2> list4 = employees.stream().sorted(Comparator.comparing(Employee2::getSalary).reversed()).limit((long) Math.ceil(employees.size() * 0.1)).toList();
        System.out.println(list4);




    }
}
