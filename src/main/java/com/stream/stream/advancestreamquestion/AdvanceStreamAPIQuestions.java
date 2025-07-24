package com.stream.stream.advancestreamquestion;

import com.stream.stream.entity.Staff;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AdvanceStreamAPIQuestions {
    public static void main(String[] args) {
        List<Staff> staffList = new ArrayList<>();

        staffList.add(new Staff(1, "Alice", 10, "HR", 55000, LocalDate.of(2020, 1, 15))); // Normal, duplicate name
        staffList.add(new Staff(2, "Bob", 20, "Finance", 70000, LocalDate.of(2019, 3, 10))); // High salary
        staffList.add(new Staff(3, "Charlie", 10, "HR", 40000, LocalDate.of(2021, 6, 25))); // Salary in 40k range
        staffList.add(new Staff(4, "David", 30, "IT", 45000, LocalDate.of(2018, 9, 12))); // Same salary as Ivan
        staffList.add(new Staff(5, "Eve", 20, "Finance", 95000, LocalDate.of(2020, 5, 5))); // One of top 3 salaries
        staffList.add(new Staff(6, "Frank", 30, "IT", 30000, LocalDate.of(2022, 2, 28))); // Low salary
        staffList.add(new Staff(7, "Grace", 10, "HR", 45000, LocalDate.of(2021, 11, 8))); // Mid salary, HR
        staffList.add(new Staff(8, "Heidi", 40, "Admin", 35000, LocalDate.of(2023, 4, 19))); // Recently joined
        staffList.add(new Staff(9, "Ivan", 30, "IT", 60000, LocalDate.of(2017, 12, 1))); // Same salary as David
        staffList.add(new Staff(10, "Judy", 20, "Finance", 40000, LocalDate.of(2020, 8, 30))); // Same salary as Charlie
        staffList.add(new Staff(11, "Alice", 50, "Legal", 50000, LocalDate.of(2019, 10, 14))); // Duplicate name
        staffList.add(new Staff(12, "Kevin", 60, "Compliance", 100000, LocalDate.of(2024, 3, 20))); // Highest salary, recent
        staffList.add(new Staff(13, "Liam", 70, "R&D", 50000, LocalDate.of(2022, 12, 12))); // Same salary as Alice (Legal)
        staffList.add(new Staff(14, "Mia", 30, "IT", 75000, LocalDate.of(2023, 1, 5))); // Top 3 salary, recent
        staffList.add(new Staff(15, "Nina", 20, "Finance", 30000, LocalDate.of(2021, 2, 2))); // Lowest salary
        staffList.add(new Staff(16, "Oscar", 10, "HR", 62000, LocalDate.of(2018, 7, 19))); // HR, above average salary
        staffList.add(new Staff(17, "Paul", 80, "Marketing", 47000, LocalDate.of(2023, 5, 10))); // New joiner, 47k salary
        staffList.add(new Staff(18, "Quinn", 30, "IT", 47000, LocalDate.of(2023, 6, 11))); // Same salary as Paul
        staffList.add(new Staff(19, "Rita", 90, "Operations", 56000, LocalDate.of(2019, 9, 9))); // Unique dept
        staffList.add(new Staff(20, "Steve", 100, "Sales", 43000, LocalDate.of(2022, 4, 4))); // Sales, moderate salary

        //Print all employee names
        List<String> list = staffList.stream().map(staff -> staff.getName()).toList();
        System.out.println(list);

        //List employees with salary > 50,000
        List<Staff> collect = staffList.stream().filter(emp -> emp.getSalary() > 50000).collect(Collectors.toList());
        System.out.println(collect);

        //Sort employees by salary (descending)
        List<Staff> list1 = staffList.stream().sorted(Comparator.comparing(Staff::getSalary).reversed()).toList();
        System.out.println(list1);

        //Sort employees by name alphabetically
        List<Staff> list2 = staffList.stream().sorted(Comparator.comparing(Staff::getName)).toList();
        System.out.println(list2);

        //Remove duplicate employees based on name
        Set<String> staffNameSet = new HashSet<>();
        List<Staff> uniqueStaffBAseOnName = staffList.stream().filter(emp -> staffNameSet.add(emp.getName())).toList();
        System.out.println(uniqueStaffBAseOnName);

        //Group employees by department
        Map<String, List<Staff>> collect1 = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName));
        System.out.println(collect1);

        //Count employees in each department
        Map<String, Long> collect2 = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName, Collectors.counting()));
        System.out.println(collect2);

        //Find highest-paid employee in each department
        Map<String, Optional<Staff>> collect3 = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName, Collectors.collectingAndThen(Collectors.toList(), emp -> emp.stream().max(Comparator.comparing(Staff::getSalary)))));
        System.out.println(collect3);
        //OR
        Map<String, Staff> collect4 = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(Staff::getSalary)),
                        Optional::get
                )
        ));

        //Calculate average salary of all employees
        Double collect5 = staffList.stream().collect(Collectors.averagingDouble(Staff::getSalary));
        System.out.println(collect5);

        //Get names of employees with salary between 30k–60k
        Predicate<Staff> salaryGreaterThan30k = s -> s.getSalary() > 30000;
        Predicate<Staff> salaryLessThan50k = s -> s.getSalary() < 50000;

        List<Staff> filtered = staffList.stream()
                .filter(salaryGreaterThan30k.and(salaryLessThan50k))
                .toList();
        System.out.println(filtered);

        //Convert names to uppercase list
        List<String> list3 = staffList.stream().map(staff -> staff.getName().toUpperCase()).toList();
        System.out.println(list3);

        //Check if any employee earns >= 1 lakh
        List<Staff> list4 = staffList.stream().filter(staff -> staff.getSalary() >= 100000).toList();
        System.out.println(list4);

        //Check if all employees belong to same department
        boolean compliance = staffList.stream().map(Staff::getDepartmentName).distinct().count() == 1;
        System.out.println(compliance);

        //Find employees whose names start with 'A'
        List<Staff> a = staffList.stream().filter(staff -> staff.getName().startsWith("A")).toList();
        System.out.println(a);

        //Get employee by name using Optional
        Optional<Staff> alice = staffList.stream().filter(staff -> staff.getName().equalsIgnoreCase("Alice")).findFirst();
        System.out.println(alice.orElse(null));

        //Comma-separated string of all employee names
        String collect6 = staffList.stream().map(staff -> staff.getName()).collect(Collectors.joining(","));
        System.out.println(collect6);

        //Partition employees based on salary > 50,000
        Map<Boolean, List<Staff>> collect7 = staffList.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() > 50000));
        System.out.println(collect7);

        //Get distinct department IDs as list
        List<Integer> list5 = staffList.stream().map(staff -> staff.getDepartmentId()).distinct().toList();
        System.out.println(list5);

        //Use method reference to print all employee names
        staffList.stream().map(Staff::getDepartmentName).forEach(System.out::println);

        //Use parallel stream to count salary > 60,000
        long count = staffList.parallelStream().filter(staff -> staff.getSalary() > 60000).count();
        System.out.println(count);

        //Find second-highest salary employee
        Staff staff = staffList.stream().sorted(Comparator.comparing(Staff::getSalary).reversed()).skip(1).findFirst().get();
        System.out.println(staff);

        //Find department with maximum employees
        Optional<Map.Entry<String, Long>> max = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());


        //Top 3 earners in the organization
        List<Staff> list6 = staffList.stream().sorted(Comparator.comparing(Staff::getSalary).reversed()).limit(3).toList();
        System.out.println(list6);

        //Remove duplicate employees by name (keep first only)
        Set<String> stringSet = new HashSet<>();
        List<Staff> list7 = staffList.stream().filter(emp -> stringSet.add(emp.getName())).toList();
        System.out.println(list7);

        //Print joining date in dd-MM-yyyy format
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        staffList.stream().forEach(emp -> System.out.println(emp.getJoiningDate().format(dateTimeFormatter)));

        //Count employees joined after specific date
        LocalDate targetDate = LocalDate.parse("2020-01-15");
        List<Staff> list8 = staffList.stream()
                .filter(staf -> staf.getJoiningDate().equals(targetDate))
                .toList();
        System.out.println(list8);

        //Print all employee names.
        staffList.stream().forEach(emp -> System.out.println(emp.getName()));

        //Convert list of employees to Map<id, name>.
        Map<Integer, String> collect8 = staffList.stream().collect(Collectors.toMap(Staff::getId, Staff::getName));
        System.out.println(collect8);

        //Filter employees who joined after 2021.
        List<Staff> list9 = staffList.stream().filter(emp -> emp.getJoiningDate().getYear() == 2021).toList();
        System.out.println(list9);

        //Average salary per department.
        Map<String, Double> collect9 = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName, Collectors.averagingInt(Staff::getSalary)));
        System.out.println(collect9);

        //Find the department with the max employees.
        Map<String, Optional<Staff>> collect10 = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName, Collectors.collectingAndThen(Collectors.toList(), emp -> emp.stream().sorted(Comparator.comparing(Staff::getSalary).reversed()).findFirst())));

        System.out.println(collect10);

        Map<String, Staff> collect11 = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Staff::getSalary)), Optional::get)));
        System.out.println(collect11);

        //Find the highest-paid employee in each department.
        Map<String, Staff> collect12 = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName, Collectors.collectingAndThen(Collectors.toList(), emp -> emp.stream().sorted(Comparator.comparing(Staff::getSalary).reversed()).findFirst().get())));
        System.out.println("max salary employee in each department" + collect12);

        //List departments with average salary > 60k
        List<String> collect13 = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName, Collectors.averagingDouble(Staff::getSalary))).entrySet().stream().filter(emp -> emp.getValue() > 60000).map(s -> s.getKey()).toList();
        System.out.println(collect13);

        //Create Map<DepartmentName, List<Employee>> sorted by department name.
        Map<String, List<Staff>> collect15 = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName));
        System.out.println(collect15);

        //Partition employees by salary > 60k.
        Map<Boolean, List<Staff>> collect14 = staffList.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() > 60000));
        System.out.println(collect14);

        Set<String> duplicateNames = new HashSet<>();
        //Find duplicate employee names.
        List<String> list10 = staffList.stream().filter(emp -> !duplicateNames.add(emp.getName())).map(filterfedstaff -> filterfedstaff.getName()).toList();
        System.out.println(list10);
        //or
        List<String> list11 = staffList.stream().collect(Collectors.groupingBy(Staff::getName, Collectors.counting())).entrySet().stream().filter(emp -> emp.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println(list11);

        //Create comma-separated string of employee names.
        String collect16 = staffList.stream().map(st -> st.getName()).collect(Collectors.joining(","));
        System.out.println(collect16);

        // Get summary of salaries (min, max, avg, sum, count).

        DoubleSummaryStatistics collect17 = staffList.stream().collect(Collectors.summarizingDouble(Staff::getSalary));
        System.out.println(collect17.getMax());
        System.out.println(collect17.getAverage());
        System.out.println(collect17.getCount());
        System.out.println(collect17.getSum());
        System.out.println(collect17.getMin());

        //Join all employee names in uppercase with commas.
        String collect18 = staffList.stream().map(staffnames -> staffnames.getName().toUpperCase()).collect(Collectors.joining(","));
        System.out.println(collect18);

        //Sort employees by department, then by name.
        List<Staff> list13 = staffList.stream()
                .sorted(Comparator.comparing(Staff::getDepartmentName)
                        .thenComparing(Staff::getName))
                .toList();
        System.out.println(list13);

        //Convert list of employee names to a Set.
        Set<String> employeeNames = staffList.stream()
                .map(Staff::getName)
                .collect(Collectors.toSet());
        System.out.println(employeeNames);

        //List employees whose names start with ‘A’.
        List<Staff> a1 = staffList.stream().filter(emp -> emp.getName().startsWith("A")).toList();
        System.out.println(a1);

        //Check if any employee earns more than 1L.
        boolean b = staffList.stream().anyMatch(emp -> emp.getSalary() > 100000);
        System.out.println(b);

        //Check if all employees belong to the same department.
        boolean b1 = staffList.stream().map(emp -> emp.getName()).distinct().count() == 1;
        System.out.println(b1);

        //Get list of departments sorted by number of employees.
        List<String> list12 = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).map(Map.Entry::getKey).toList();
        System.out.println(list12);

        //Get list of all unique department names.
        List<String> list14 = staffList.stream().map(emp -> emp.getDepartmentName()).distinct().toList();
        System.out.println(list14);

        //or

        Set<String> collect19 = staffList.stream().map(Staff::getDepartmentName).collect(Collectors.toSet());
        System.out.println(collect19);

        //Get employee by ID using Optional (return "Unknown" if absent).
        String unknown = staffList.stream().filter(emp -> emp.getId() == 6).map(Staff::getName).findFirst().orElse("unknown");
        System.out.println(unknown);

        //Find the second-highest salary employee.
        Staff staff1 = staffList.stream().sorted(Comparator.comparing(Staff::getSalary).reversed()).skip(1).findFirst().orElse(null);
        System.out.println(staff1);

        //List top 3 highest-paid employees.
        List<Staff> limit = staffList.stream().sorted(Comparator.comparing(Staff::getSalary).reversed()).limit(3).toList();
        System.out.println(limit);

        //Get employees joined in the last 2 years.

        LocalDate twoYearsAgo = LocalDate.now().minusYears(2);
        List<Staff> list15 = staffList.stream().filter(emp -> emp.getJoiningDate() != null && !emp.getJoiningDate().isBefore(twoYearsAgo)).toList();
        System.out.println(list15);

        //Count employees in each department with salary > 50k.
        Map<String, Long> collect21 = staffList.stream().filter(emp -> emp.getSalary() > 50000).collect(Collectors.groupingBy(Staff::getDepartmentName, Collectors.counting()));
        System.out.println(collect21);

        //Create Map<Department, Employee> with highest salary in each.
        Map<String, Staff> highestPaidByDept = staffList.stream()
                .collect(Collectors.toMap(
                        Staff::getDepartmentName,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Staff::getSalary))
                ));


        System.out.println(highestPaidByDept);

        //Remove duplicate employees by name (keep first)
        HashSet<String> objects = new HashSet<>();
        List<Staff> list16 = staffList.stream().filter(emp -> objects.add(emp.getName())).toList();
        System.out.println(list16);

        //Get total salary paid per department.
        Map<String, Double> collect20 = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName, Collectors.summingDouble(Staff::getSalary)));
        System.out.println(collect20);

        Map<String, Integer> totalSalaryByDept = staffList.stream()
                .collect(Collectors.toMap(
                        Staff::getDepartmentName,
                        Staff::getSalary,
                        Integer::sum
                ));

        //Find youngest and oldest employee by joining date.
        Staff staff2 = staffList.stream().max(Comparator.comparing(Staff::getJoiningDate)).get();
        Staff staff3 = staffList.stream().min(Comparator.comparing(Staff::getJoiningDate)).get();

        System.out.println(staff2 + " " + staff3);

        //Partition employees into before and after 2020
        Map<Boolean, List<Staff>> collect22 = staffList.stream().collect(Collectors.partitioningBy(emp -> emp.getJoiningDate().getYear() > 2020));
        System.out.println(collect22);

        //Convert employee list to TreeMap<DeptId, Set<EmployeeName>>.
        TreeMap<Integer, Set<String>> collect23 = staffList.stream().collect(Collectors.groupingBy(staf -> staf.getId(), TreeMap::new, Collectors.mapping(Staff::getName, Collectors.toSet())));
        System.out.println(collect23);

        //Check if any two employees have the same salary.
        boolean b2 = staffList.stream().collect(Collectors.groupingBy(Staff::getSalary, Collectors.counting())).values().stream().anyMatch(emp -> emp > 1);

        //Find all employee names sorted in reverse alphabetical order
        List<String> list17 = staffList.stream().map(Staff::getName).sorted(Comparator.reverseOrder()).toList();
        System.out.println(list17);

        //Create Map<EmployeeName, List<Salary>> for duplicate names
        Map<String, List<String>> collect24 = staffList.stream().collect(Collectors.groupingBy(Staff::getName, Collectors.mapping(Staff::getName, Collectors.toList()))).entrySet().stream().filter(emp -> emp.getValue().size() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collect24);

        //Find department with lowest average salary
        Map.Entry<String, Double> stringDoubleEntry = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartmentName, Collectors.averagingInt(Staff::getSalary))).entrySet().stream().min(Map.Entry.comparingByValue()).orElse(null);
        System.out.println(stringDoubleEntry);

        //Convert list to LinkedHashMap with insertion order maintained
        LinkedHashMap<Integer, Staff> collect25 = staffList.stream().collect(Collectors.toMap(Staff::getId,
                staf -> staf,
                (e, n) -> e,
                LinkedHashMap::new
        ));
        System.out.println(collect25);

        //Group employee names by department into a comma-separated string.
        String collect26 = staffList.stream().map(emp -> emp.getName()).collect(Collectors.joining(","));
        System.out.println(collect26);

        //Get list of employee objects whose salary is in top 20%.
        List<Staff> top20PercentEmployees = staffList.stream()
                .sorted(Comparator.comparing(Staff::getSalary).reversed())  // sort high → low
                .limit((long) Math.ceil(staffList.size() * 0.2))            // top 20%
                .collect(Collectors.toList());

        System.out.println(top20PercentEmployees);

        //Sort employees by ID but keep duplicates by name removed.
        Set<String> strings = new HashSet<>();
        List<Staff> list18 = staffList.stream().sorted(Comparator.comparing(Staff::getId)).filter(emp -> strings.add(emp.getName())).toList();
        System.out.println(list18);

        //Return employees with min and max salary in one pass.
        Map.Entry<Staff, Staff> minMaxSalaryEmployees = staffList.stream()
                .collect(Collectors.teeing(
                        Collectors.minBy(Comparator.comparing(Staff::getSalary)),  // find min
                        Collectors.maxBy(Comparator.comparing(Staff::getSalary)),  // find max
                        (min, maxx) -> new AbstractMap.SimpleEntry<>(
                                min.orElse(null),
                                maxx.orElse(null)
                        )
                ));
        System.out.println(minMaxSalaryEmployees);

        //Create List<String> as “Alice - HR”, “Bob - Finance”.
        List<String> list19 = staffList.stream().map(emp -> emp.getName() + "-" + emp.getDepartmentName()).toList();
        System.out.println(list19);

        //Filter and collect employee names with salary divisible by 10k.
        Map<String, Integer> collect27 = staffList.stream().filter(emp -> emp.getSalary() % 10 == 0).collect(Collectors.toMap(Staff::getName, Staff::getSalary,(x,y)-> x));
        System.out.println(collect27);

        //Get employee with highest salary in "HR" department.
        Staff staff4 = staffList.stream().filter(emp -> emp.getDepartmentName().equalsIgnoreCase("hr")).max(Comparator.comparing(Staff::getSalary)).get();
        System.out.println(staff4);

        //Map<EmployeeId, Employee> keeping the latest joined employee for duplicate IDs.
        Map<Integer, Staff> collect29 = staffList.stream().collect(Collectors.toMap(Staff::getId, staf -> staf, (existing, replacement) -> existing.getJoiningDate().isAfter(replacement.getJoiningDate()) ? existing : replacement));
        System.out.println(collect29);

        //Get distinct list of salaries in sorted order.
        List<Integer> list20 = staffList.stream().map(Staff::getSalary).sorted().distinct().toList();
        System.out.println(list20);

        //Filter employees whose name has more than 5 characters.
        List<Staff> list21 = staffList.stream().filter(emp -> emp.getName().length() > 5).toList();
        System.out.println(list21);

        //Find common salary among 2 different department employees.
        Set<Integer> itSalaries = staffList.stream().filter(emp -> emp.getDepartmentName().equalsIgnoreCase("IT")).map(Staff::getSalary).collect(Collectors.toSet());
        Set<Integer> hrDepartmentSalaries = staffList.stream().filter(emp -> emp.getDepartmentName().equalsIgnoreCase("hr")).map(Staff::getSalary).collect(Collectors.toSet());
        itSalaries.retainAll(hrDepartmentSalaries);
        System.out.println(itSalaries);

        //Create a Map<Year, List<Employee>> based on joining year.
        Map<Integer, List<Staff>> collect28 = staffList.stream().collect(Collectors.groupingBy(emp -> emp.getJoiningDate().getYear()));
        System.out.println(collect28);

        //List employees grouped by month of joining.
        Map<Month, List<Staff>> collect30 = staffList.stream().collect(Collectors.groupingBy(emp -> emp.getJoiningDate().getMonth()));
        System.out.println(collect30);

        //Print names of employees who joined on weekends.
        List<String> list22 = staffList.stream().filter(emp -> {
            DayOfWeek dayOfWeek = emp.getJoiningDate().getDayOfWeek();
            return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        }).map(Staff::getName).toList();

        System.out.println(list22);

        //Get average salary of employees whose name starts with vowel.
        HashSet<String> strings1 = new HashSet<>(Arrays.asList("A", "E", "I", "O", "U"));
        double v = staffList.stream().filter(emp -> {
            String substring = emp.getName().substring(0, 1);
            return strings1.contains(substring);
        }).mapToDouble(Staff::getSalary).average().orElse(0.00);

        System.out.println(v);

        //Find the second highest salary from a list of employees using Streams.
        List<Integer> list23 = staffList.stream().sorted(Comparator.comparing(Staff::getSalary).reversed()).map(emp -> emp.getSalary()).distinct().toList();
        System.out.println(list23.size());
        Integer i = staffList.stream().sorted(Comparator.comparing(Staff::getSalary).reversed()).map(emp -> emp.getSalary()).skip(1).findFirst().get();
        System.out.println(i);

        //Find the employee(s) with the highest salary per department.
        Map<String, Optional<Staff>> highestPaidByDept2 =
                staffList.stream()
                        .collect(Collectors.groupingBy(
                                Staff::getDepartmentName,
                                Collectors.maxBy(Comparator.comparing(Staff::getSalary))
                        ));
        System.out.println(highestPaidByDept2);
    }

}
