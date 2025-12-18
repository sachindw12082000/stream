package com.stream.stream.peopleclassquestions;

import com.stream.stream.entity.Employee;
import com.stream.stream.entity.People;
import org.apache.logging.log4j.util.PropertySource;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdvanceStreamQuestions {
    private static int getQuarter(LocalDate date) {
        return (date.getMonthValue() - 1) / 3 + 1;
    }

    public static void main(String[] args) {
        ArrayList<People> peopleList = new ArrayList<>();
        peopleList.add(new People(1, "Alice", 28, "Female", "Pune", 55000, LocalDate.of(2020, 1, 15)));   // Duplicate name later
        peopleList.add(new People(2, "Bob", 35, "Male", "Mumbai", 70000, LocalDate.of(2019, 3, 10)));    // High salary
        peopleList.add(new People(3, "Charlie", 24, "Male", "Pune", 40000, LocalDate.of(2021, 6, 25)));  // Mid salary
        peopleList.add(new People(4, "David", 30, "Male", "Delhi", 45000, LocalDate.of(2018, 9, 12)));   // Same salary as Ivan later
        peopleList.add(new People(5, "Eve", 29, "Female", "Mumbai", 95000, LocalDate.of(2020, 5, 5)));   // Top 3 salaries
        peopleList.add(new People(6, "Frank", 31, "Male", "Delhi", 30000, LocalDate.of(2022, 2, 28)));   // Low salary
        peopleList.add(new People(7, "Grace", 26, "Female", "Pune", 45000, LocalDate.of(2021, 11, 8)));  // Duplicate salary
        peopleList.add(new People(8, "Heidi", 27, "Female", "Nagpur", 35000, LocalDate.of(2023, 4, 19))); // Recent joiner
        peopleList.add(new People(9, "Ivan", 34, "Male", "Delhi", 45000, LocalDate.of(2017, 12, 1)));    // Duplicate salary with David
        peopleList.add(new People(10, "Judy", 25, "Female", "Mumbai", 40000, LocalDate.of(2020, 8, 30))); // Same salary as Charlie
        peopleList.add(new People(11, "Alice", 40, "Female", "Chennai", 50000, LocalDate.of(2019, 10, 14))); // Duplicate name
        peopleList.add(new People(12, "Kevin", 38, "Male", "Hyderabad", 100000, LocalDate.of(2024, 3, 20))); // Highest salary
        peopleList.add(new People(13, "Liam", 29, "Male", "Pune", 50000, LocalDate.of(2022, 12, 12)));    // Duplicate salary (Alice)
        peopleList.add(new People(14, "Mia", 33, "Female", "Delhi", 75000, LocalDate.of(2023, 1, 5)));    // Top 3 salary
        peopleList.add(new People(15, "Nina", 23, "Female", "Mumbai", 30000, LocalDate.of(2021, 2, 2)));  // Lowest salary
        peopleList.add(new People(16, "Oscar", 35, "Male", "Pune", 62000, LocalDate.of(2018, 7, 19)));    // Above avg salary
        peopleList.add(new People(17, "Paul", 32, "Male", "Chennai", 47000, LocalDate.of(2023, 5, 10)));  // Same salary as Quinn
        peopleList.add(new People(18, "Quinn", 29, "Female", "Delhi", 47000, LocalDate.of(2023, 6, 11))); // Same salary as Paul
        peopleList.add(new People(19, "Rita", 31, "Female", "Nagpur", 56000, LocalDate.of(2019, 9, 9)));  // Unique city
        peopleList.add(new People(20, "Steve", 36, "Male", "Goa", 43000, LocalDate.of(2022, 4, 4)));      // Goa resident
        peopleList.add(new People(21, "Tom", 37, "Male", "Delhi", 65000, LocalDate.of(2020, 10, 10)));    // High salary
        peopleList.add(new People(22, "Uma", 34, "Female", "Mumbai", 72000, LocalDate.of(2021, 8, 18)));  // High salary
        peopleList.add(new People(23, "Victor", 28, "Male", "Nagpur", 36000, LocalDate.of(2023, 2, 23))); // Recent joiner
        peopleList.add(new People(24, "Wendy", 39, "Female", "Pune", 80000, LocalDate.of(2018, 5, 30)));  // Top earner in Pune
        peopleList.add(new People(25, "Xander", 41, "Male", "Chennai", 42000, LocalDate.of(2019, 7, 1))); // Mid salary
        peopleList.add(new People(26, "Yara", 30, "Female", "Mumbai", 50000, LocalDate.of(2022, 11, 12))); // Duplicate salary group
        peopleList.add(new People(27, "Zane", 29, "Male", "Pune", 60000, LocalDate.of(2020, 9, 29)));     // Decent salary
        peopleList.add(new People(28, "Ivy", 26, "Female", "Hyderabad", 47000, LocalDate.of(2021, 3, 16))); // Duplicate salary (Paul, Quinn)
        peopleList.add(new People(29, "Oliver", 24, "Male", "Chennai", 30000, LocalDate.of(2023, 7, 20))); // Low salary
        peopleList.add(new People(30, "Penny", 27, "Female", "Delhi", 85000, LocalDate.of(2024, 1, 10))); // Top salary, recent


//        //Print all people names.
//        peopleList.stream().forEach(people -> System.out.println(people.getName()));
//
//        //Get list of people whose salary > 50,000.
//        List<People> salariespeople = peopleList.stream().filter(people -> people.getSalary() > 50000).toList();
//        System.out.println("salariespeople->" + salariespeople);
//
//        //Sort people by name alphabetically.
//        List<People> PeopleSortedListByName = peopleList.stream().sorted(Comparator.comparing(People::getName)).toList();
//        System.out.println("PeopleSortedListByName->" + PeopleSortedListByName);
//
//        //Sort people by salary (descending).
//        List<People> descendingSortedListBySalary = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).toList();
//        System.out.println("descendingSortedListBySalary->" + descendingSortedListBySalary);
//
//        //Remove duplicate people based on name.
//        HashSet<String> strings = new HashSet<>();
//        List<People> duplicateRemovedList = peopleList.stream().filter(people -> strings.add(people.getName())).toList();
//        System.out.println("duplicateRemovedList" + duplicateRemovedList);
//
//        //or
//
//        Map<String, People> nonDuplicateByName = peopleList.stream().collect(Collectors.toMap(People::getName, people -> people, (pervious, newone) -> pervious));
//        System.out.println("nonDuplicateByName" + nonDuplicateByName);
//
//        //Convert List<People> to List<String> of names.
//        List<String> peopleNameList = peopleList.stream().map(People::getName).toList();
//        System.out.println("peopleNameList->" + peopleNameList);
//
//        //Convert List<People> to Map<id, name>.
//        peopleList.stream().collect(Collectors.toMap(
//                people -> people.getId(),
//                people -> people.getName()
//        ));
//
//        //Filter people who joined after 2021.
//        List<People> peopleJoinedAfter2021 = peopleList.stream().filter(people -> people.getJoiningDate().getYear() > 2021).toList();
//        System.out.println("peopleJoinedAfter2021" + peopleJoinedAfter2021);
//
//        //Get all people living in city "Pune".
//        List<People> puneCityPeople = peopleList.stream().filter(people -> people.getCity().equalsIgnoreCase("pune")).toList();
//        System.out.println("puneCityPeople" + puneCityPeople);
//
//        //Count people with salary below 40,000.
//        List<People> peopleListWithBelow40000Salary = peopleList.stream().filter(people -> people.getSalary() < 40000).toList();
//        System.out.println("peopleListWithBelow40000Salary" + peopleListWithBelow40000Salary);
//
//        //Group people by city → Map<String, List<People>>.
//        Map<String, List<People>> cityWisePeopleList = peopleList.stream().collect(Collectors.groupingBy(People::getName, Collectors.mapping(Function.identity(), Collectors.toList())));
//        System.out.println("cityWisePeopleList->" + cityWisePeopleList);
//
//        //Count people per city → Map<String, Long>.
//        Map<String, Long> cityWisePeopleCount = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting()));
//        System.out.println("cityWisePeopleCount->" + cityWisePeopleCount);
//
//        //Average salary per city.
//        Map<String, Double> cityWiseAverageSalary = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getSalary)));
//        System.out.println("cityWiseAverageSalary" + cityWiseAverageSalary);
//
//        //Find city with the most residents.
//        String s = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(people -> people.getKey()).get();
//        System.out.println(s);
//
//        //Find highest-paid person in each city.
//        Map<String, People> collect = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(People::getSalary)), opt -> opt.orElse(null))));
//        System.out.println(collect);
//
//        //or
//
//        Map<String, People> collect1 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.collectingAndThen(Collectors.toList(), people -> people.stream().sorted(Comparator.comparing(People::getSalary).reversed()).findFirst().get())));
//        System.out.println(collect1);
//
//        //List cities with average salary > 60,000.
//        Map<String, Double> collect2 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getSalary))).entrySet().stream().filter(people -> people.getValue() > 60000).collect(Collectors.toMap(
//                Map.Entry::getKey,
//                Map.Entry::getValue
//        ));
//
//        System.out.println(collect2);
//
//        //or
//        Map<String, Double> collect3 = peopleList.stream().collect(
//                Collectors.groupingBy(
//                        People::getCity,
//                        Collectors.collectingAndThen(
//                                Collectors.averagingDouble(People::getSalary),
//                                avgSalary -> avgSalary > 60000 ? avgSalary : null)
//                ));
//
//        System.out.println(collect3);
//
//        //Create Map<City, List<People>> sorted by city name.
//        Map<String, List<People>> collect4 = peopleList.stream().collect(
//                Collectors.groupingBy(
//                        People::getCity,
//                        Collectors.collectingAndThen(
//                                Collectors.toList(),
//                                list -> list.stream().sorted(
//                                        Comparator.comparing(People::getCity)).toList()
//                        )));
//
//        System.out.println(collect4);
//
//        //or
//
//        LinkedHashMap<String, List<People>> collect5 = peopleList.stream().collect(
//                Collectors.groupingBy(People::getCity)).entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (E, N) -> E, LinkedHashMap::new));
//        System.out.println(collect5);
//
//        //Partition people by salary > 60,000.
//        Map<Boolean, List<People>> collect6 = peopleList.stream().collect(Collectors.partitioningBy(people -> people.getSalary() > 60000));
//        System.out.println(collect6);
//
//        //Find duplicate names.
//        HashSet<String> peopleName = new HashSet<>();
//        List<String> list = peopleList.stream().map(People::getName).filter(name -> !peopleName.add(name)).toList();
//        System.out.println(list);
//
//        //Create a comma-separated string of all names.
//        String collect7 = peopleList.stream().map(People::getName).collect(Collectors.joining(","));
//        System.out.println(collect7);
//
//        //or
//
//        String s1 = peopleList.stream().map(People::getName).reduce((people, people2) -> people + "," + people2).get();
//        System.out.println(s1);
//
//        //Get summary statistics (min, max, avg, sum, count) for salary.
//
//        DoubleSummaryStatistics collect8 = peopleList.stream().collect(Collectors.summarizingDouble(People::getSalary));
//        System.out.println(collect8.getMin());
//        System.out.println(collect8.getMax());
//        System.out.println(collect8.getSum());
//        System.out.println(collect8.getCount());
//        System.out.println(collect8.getAverage());
//
//        //Join all people names in uppercase with commas.
//        String collect9 = peopleList.stream().map(people -> people.getName().toUpperCase()).collect(Collectors.joining(","));
//        System.out.println(collect9);
//
//        //or
//
//        String s2 = peopleList.stream().map(people -> people.getName().toUpperCase()).reduce("", (string, string2) -> string.isEmpty() ? string2 : string + "," + string2);
//        System.out.println(s2);
//
//        //Sort people by city, then by name.
//        List<People> list2 = peopleList.stream().sorted(Comparator.comparing(People::getCity).thenComparing(People::getName)).toList();
//        System.out.println(list2);
//
//        //Convert list of people names to a Set.
//        TreeSet<String> collect10 = peopleList.stream().map(People::getName).collect(Collectors.toCollection(TreeSet::new));
//        System.out.println(collect10);
//
//        //List all people whose names start with "A".
//        List<People> list1 = peopleList.stream().filter(people -> people.getName().startsWith("A")).toList();
//        System.out.println(list1);
//
//        //Check if any person earns more than 1,00,000.
//        List<People> list3 = peopleList.stream().filter(people -> people.getSalary() > 100000).toList();
//        System.out.println(list3);
//        //or
//        boolean hasHighEarner = peopleList.stream()
//                .anyMatch(p -> p.getSalary() > 100000);
//        System.out.println(hasHighEarner);
//
//
//        //Check if all people are from the same city.
//        boolean b = peopleList.stream().map(People::getCity).distinct().count() == 1;
//        System.out.println(b);
//
//        //or
//
//        boolean b1 = peopleList.stream().allMatch(p -> p.getCity().equals(peopleList.get(0).getCity()));
//        System.out.println(b1);
//
//        //Get list of cities sorted by number of people.
//        List<String> list4 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).map(city -> city.getKey()).toList();
//        System.out.println(list4);
//
//        //Get all unique cities.
//        List<String> list5 = peopleList.stream().map(People::getCity).distinct().toList();
//        System.out.println(list5);
//
//        //Get person by ID using Optional (return "Unknown" if absent).
//        People people1 = peopleList.stream().filter(people -> people.getId() == 1).findFirst().orElse(null);
//        System.out.println(people1);
//
//        //Find the second-highest salary person.
//        People people = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).skip(1).findFirst().get();
//        System.out.println(people);
//
//        //Find all people with salary equal to the max salary.
//        List<People> people2 = peopleList.stream().collect(Collectors.groupingBy(People::getSalary)).entrySet().stream().max(Map.Entry.comparingByKey()).map(Map.Entry::getValue).orElse(List.of());
//        System.out.println(people2);
//
//        //List top 3 highest-paid people.
//        List<People> list6 = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).limit(3).toList();
//        System.out.println(list6);
//
//        //Get people who joined in the last 2 years.
//        LocalDate twoYearsAgo = LocalDate.now().minusYears(2);
//        List<People> recentJoines = peopleList.stream().filter(peo -> peo.getJoiningDate().isAfter(twoYearsAgo)).toList();
//        System.out.println(recentJoines);
//
//        //Count people in each city with salary > 50,000
//        Map<String, Long> collect11 = peopleList.stream().filter(peo -> peo.getSalary() > 50000).collect(Collectors.groupingBy(People::getCity, Collectors.counting()));
//        System.out.println(collect11);
//
//        //Create Map<City, People> with the highest-paid person per city.
//        Map<String, People> highestPaidByCity = peopleList.stream()
//                .collect(Collectors.groupingBy(
//                        People::getCity,
//                        Collectors.collectingAndThen(
//                                Collectors.maxBy(Comparator.comparing(People::getSalary)),
//                                opt -> opt.orElse(null)
//                        )
//                ));
//        System.out.println(highestPaidByCity);
//
//        //Remove duplicate names, keeping only the first occurrence.
//        HashSet<Object> peoplenames = new HashSet<>();
//        List<String> list7 = peopleList.stream().filter(mep -> peoplenames.add(mep.getName())).map(People::getName).toList();
//        System.out.println(list7);
//
//        //or
//
//        List<String> list8 = peopleList.stream().map(People::getName).distinct().toList();
//        System.out.println(list8);
//
//        //Calculate total salary paid per city.
//        Map<String, Double> collect12 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.summingDouble(People::getSalary)));
//        System.out.println(collect12);
//
//        //Find youngest and oldest person by joining date.
//        Map<String, People> collect13 = peopleList.stream().collect(Collectors.teeing(
//                Collectors.maxBy(Comparator.comparing(People::getJoiningDate)),
//                Collectors.minBy(Comparator.comparing(People::getJoiningDate)),
//                (youngest, oldest) -> Map.of(
//                        "Youngest", youngest.orElse(null),
//                        "Oldest", oldest.orElse(null)
//                )
//        ));
//
//        System.out.println(collect13);
//
//
//        //Partition people into before and after 2020 joining.
//        Map<Boolean, List<People>> collect14 = peopleList.stream().collect(Collectors.partitioningBy(peop -> peop.getJoiningDate().getYear() > 2020));
//        System.out.println(collect14);
//
//        //Convert people list to TreeMap<City, Set<PeopleName>>.
//        TreeMap<String, Set<People>> collect15 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, TreeMap::new, Collectors.toSet()));
//        System.out.println(collect15);
//
//        //Check if any two people have the same salary.
//        boolean b2 = peopleList.stream().collect(Collectors.groupingBy(People::getSalary, Collectors.counting())).values().stream().anyMatch(val -> val > 1);
//        System.out.println(b2);
//
//        //Get all names sorted in reverse alphabetical order.
//        List<String> list9 = peopleList.stream().map(People::getName).sorted(Comparator.reverseOrder()).toList();
//        System.out.println(list9);
//
//        //Create Map<Name, List<Salary>> for duplicate names.
//        Map<String, List<Double>> duplicateNameSalaryMap = peopleList.stream()
//                .collect(Collectors.groupingBy(
//                        People::getName,
//                        Collectors.mapping(People::getSalary, Collectors.toList())
//                ))
//                .entrySet().stream()
//                .filter(entry -> entry.getValue().size() > 1)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        System.out.println(duplicateNameSalaryMap);
//
//        //Find city with the lowest average salary.
//        String s3 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getSalary))).entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
//        System.out.println(s3);
//
//        //Convert list to LinkedHashMap (preserve insertion order).
//        LinkedHashMap<Integer, People> collect16 = peopleList.stream().collect(Collectors.toMap(People::getId, p -> p, (existing, replacement) -> existing, LinkedHashMap::new));
//        System.out.println(collect16);
//
//        //Group names by city into a comma-separated string.
//        String collect17 = peopleList.stream().map(People::getCity).collect(Collectors.joining(","));
//        System.out.println(collect17);
//
//        //Get people whose salary is in the top 20%.
//        List<People> list10 = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).limit((long) Math.ceil(peopleList.size() * 0.2)).toList();
//        System.out.println(list10);
//
//        //Sort people by ID but keep only one entry per name.
//        HashSet<String> seen = new HashSet<>();
//        List<People> list11 = peopleList.stream()
//                .sorted(Comparator.comparing(People::getId))
//                .filter(p -> seen.add(p.getName())).toList();
//
//        System.out.println(list11);
//
//        //Return people with min and max salary in one pass.
//        Map<String, People> collect18 = peopleList.stream().collect(Collectors.teeing(
//                Collectors.maxBy(Comparator.comparing(People::getSalary)),
//                Collectors.minBy(Comparator.comparing(People::getSalary)),
//                (maxSalary, minSalary) -> Map.of(
//                        "MaxSalary", maxSalary.orElse(null),
//                        "MinSalary", minSalary.orElse(null)
//                )
//        ));
//        System.out.println(collect18);
//
//        //Create List<String> like "Alice - Pune", "Bob - Mumbai".
//        List<String> list12 = peopleList.stream().map(people3 -> people3.getName() + "-" + people3.getCity()).toList();
//        System.out.println(list12);
//
//        //Collect names of people whose salary is divisible by 10,000.
//        List<String> list13 = peopleList.stream().filter(people3 -> people3.getSalary() % 10000 == 0).map(People::getName).toList();
//        System.out.println(list13);
//
//        //Get person with the highest salary in "Pune".
//        People people4 = peopleList.stream().filter(people3 -> people3.getCity().equalsIgnoreCase("pune")).max(Comparator.comparing(People::getSalary)).get();
//        System.out.println(people4);
//
//        //Create Map<PeopleId, People> keeping only the latest joined person for duplicate IDs.
//
//        Map<Integer, People> collect19 = peopleList.stream()
//                .collect(Collectors.toMap(
//                        People::getId,
//                        p -> p,
//                        (p1, p2) -> p1.getJoiningDate().isAfter(p2.getJoiningDate()) ? p1 : p2
//                ));
//
//        System.out.println(collect19);
//
//        //Get distinct salaries sorted in ascending order.
//        List<Double> list14 = peopleList.stream().map(People::getSalary).distinct().sorted().toList();
//        System.out.println(list14);
//
//        //Filter people whose name length > 5.
//        List<People> list15 = peopleList.stream().filter(people3 -> people3.getName().length() > 5).toList();
//        System.out.println(list15);
//
//        //Find common salaries among two different cities.
//        List<Double> pune = new ArrayList<>(peopleList.stream().filter(people3 -> people3.getCity().equalsIgnoreCase("pune")).map(People::getSalary).toList());
//        List<Double> delhi = new ArrayList<>(peopleList.stream().filter(people3 -> people3.getCity().equalsIgnoreCase("delhi")).map(People::getSalary).toList());
//        pune.retainAll(delhi);
//        System.out.println(pune);
//
//        //Create Map<Year, List<People>> grouped by joining year.
//        Map<Integer, List<People>> collect20 = peopleList.stream().collect(Collectors.groupingBy(people3 -> people3.getJoiningDate().getYear()));
//        System.out.println(collect20);
//
//        //List people grouped by month of joining.
//        Map<Month, List<People>> collect21 = peopleList.stream().collect(Collectors.groupingBy(people3 -> people3.getJoiningDate().getMonth(), TreeMap::new, Collectors.toList()));
//        System.out.println(collect21);
//
//        //Print names of people who joined on weekends.
//        List<String> collect22 = peopleList.stream().filter(people3 -> {
//            DayOfWeek dayOfWeek = people3.getJoiningDate().getDayOfWeek();
//            return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
//        }).map(People::getName).collect(Collectors.toList());
//        System.out.println(collect22);
//
//        //Get average salary of people whose names start with a vowel.
//        List<Character> vowels = Arrays.asList('A', 'E', 'I', 'O', 'U');
//        List<People> vowelNamePeople = peopleList.stream()
//                .filter(p -> vowels.stream()
//                        .anyMatch(v -> Character.toUpperCase(p.getName().charAt(0)) == v))
//                .toList();
//        System.out.println(vowelNamePeople);
//
//        //Print all people names.
//        peopleList.stream().forEach(name -> System.out.println(name.getName()));
//
//        //Get a list of people whose salary is greater than 50,000.
//        List<People> list16 = peopleList.stream().filter(people3 -> people3.getSalary() > 50000).toList();
//        System.out.println(list16);
//
//        //Sort people by name alphabetically.
//        List<People> list17 = peopleList.stream().sorted(Comparator.comparing(People::getName)).toList();
//
//        //Sort people by salary descending.
//        List<People> list18 = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).toList();
//        System.out.println(list18);
//
//        //Remove duplicate people by name.
//        HashSet<String> strings1 = new HashSet<>();
//        List<People> list19 = peopleList.stream().filter(people3 -> strings1.add(people3.getName())).toList();
//        System.out.println(list19);
//
//        //Convert List<People> to List<String> of names.
//        List<String> list20 = peopleList.stream().map(People::getName).toList();
//        System.out.println(list20);
//
//        //Convert List<People> to Map<id, name>.
//        Map<Integer, String> collect23 = peopleList.stream().collect(Collectors.toMap(
//                People::getId,
//                People::getName
//        ));
//        System.out.println(collect23);
//
//        //Filter people who joined after 2021.
//        List<People> list21 = peopleList.stream().filter(people3 -> people3.getJoiningDate().getYear() > 2021).toList();
//        System.out.println(list21);
//
//        //Get all people living in city "Pune"
//        List<People> pune1 = peopleList.stream().filter(people3 -> people3.getCity().equalsIgnoreCase("pune")).toList();
//        System.out.println(pune1);
//
//        //Count people with salary below 40,000.
//        List<People> list22 = peopleList.stream().filter(people3 -> people3.getSalary() < 40000).toList();
//        System.out.println(list22);
//
//        //Convert all names to uppercase list.
//        List<String> list23 = peopleList.stream().map(people3 -> people3.getName().toUpperCase()).toList();
//
//        //Check if any person earns more than 1 lakh.
//        boolean b3 = peopleList.stream().anyMatch(people3 -> people3.getSalary() > 100000);
//        System.out.println(b3);
//
//        //Check if all people belong to the same city.
//        boolean b4 = peopleList.stream().map(people3 -> people3.getCity()).distinct().count() == 1;
//        System.out.println(b4);
//
//        //Find people whose names start with "A".
//        List<People> a = peopleList.stream().filter(people3 -> people3.getName().startsWith("A")).toList();
//        System.out.println(a);
//
//        //Get distinct list of all city names.
//        List<String> list24 = peopleList.stream().map(People::getCity).distinct().toList();
//        System.out.println(list24);
//
//        //Get all salaries in a sorted list (no duplicates).
//        List<Double> list25 = peopleList.stream().map(People::getSalary).distinct().sorted().toList();
//        System.out.println(list25);
//
//        //Find all people younger than 30.
//        List<People> list26 = peopleList.stream().filter(people3 -> people3.getAge() < 30).toList();
//        System.out.println(list26);
//
//        //Get names of all people sorted in reverse order.
//        List<String> list27 = peopleList.stream().map(People::getName).sorted(Comparator.reverseOrder()).toList();
//        System.out.println(list27);
//
//        //Convert all people names to a Set.
//        Set<String> collect24 = peopleList.stream().map(People::getName).collect(Collectors.toSet());
//        System.out.println(collect24);
//
//        //Check if any person’s salary is divisible by 10,000.
//        boolean b5 = peopleList.stream().anyMatch(
//                people3 -> people3.getSalary() % 10000 == 0
//        );
//        System.out.println(b5);
//
//        //Group people by city → Map<String, List<People>>.
//        Map<String, List<People>> collect25 = peopleList.stream().collect(Collectors.groupingBy(People::getCity));
//        System.out.println(collect25);
//
//        //Count people per city → Map<String, Long>.
//        Map<String, Long> collect26 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting()));
//        System.out.println(collect26);
//
//        //Average salary per city.
//        Map<String, Double> collect27 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.summingDouble(People::getSalary)));
//        System.out.println(collect27);
//
//        //Find the city with the most residents.
//        Map.Entry<String, Long> stringLongEntry = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
//        System.out.println(stringLongEntry);
//
//        //Find the highest-paid person in each city.
//        Map<String, List<People>> collect28 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.collectingAndThen(Collectors.toList(), li -> li.stream().sorted(Comparator.comparing(People::getSalary)).toList())));
//        System.out.println(collect28);
//
//        //List cities with average salary > 60,000.
//        Map<String, Double> collect29 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getSalary))).entrySet().stream().filter(entry -> entry.getValue() > 60000).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        System.out.println(collect29);
//
//        //Create Map<City, List<People>> sorted by city name.
//        TreeMap<String, List<People>> collect30 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, TreeMap::new, Collectors.toList()));
//        System.out.println(collect30);
//
//        //Partition people by salary > 60,000.
//        Map<Boolean, List<People>> collect31 = peopleList.stream().collect(Collectors.partitioningBy(people3 -> people3.getSalary() > 60000));
//        System.out.println(collect31);
//
//        //Find duplicate names and group them.
//        Map<String, List<People>> collect32 = peopleList.stream().collect(Collectors.groupingBy(People::getName)).entrySet().stream().filter(entry -> entry.getValue().size() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        System.out.println(collect32);
//
//        //Create a comma-separated string of all names.
//        String collect33 = peopleList.stream().map(People::getName).collect(Collectors.joining(","));
//        System.out.println(collect33);
//
//        //Sort people by city, then by name.
//        List<People> list28 = peopleList.stream().sorted(Comparator.comparing(People::getCity).thenComparing(People::getName)).toList();
//        System.out.println(list28);
//
//        //Find all unique joining years.
//        List<Integer> list30 = peopleList.stream().map(people3 -> people3.getJoiningDate().getYear()).distinct().sorted().toList();
//        System.out.println(list30);
//
//        //Get a list of cities sorted by number of people.
//        List<Map.Entry<String, Long>> list29 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
//        System.out.println(list29);
//
//        //or only for list
//        List<String> list31 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).toList();
//        System.out.println(list31);
//
//        //Get the top 3 cities by total salary paid.
//        List<String> list32 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.summingDouble(People::getSalary))).entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).toList();
//        System.out.println(list32);
//
//        //Find average age per city.
//        Map<String, Double> collect34 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.summingDouble(People::getSalary)));
//        System.out.println(collect34);
//
//        //Partition people by gender.
//        Map<Boolean, List<People>> male = peopleList.stream().collect(Collectors.partitioningBy(people3 -> people3.getGender().equalsIgnoreCase("male")));
//        System.out.println(male);
//
//        //Count people with salary > 60k grouped by city.
//        Map<String, Long> collect35 = peopleList.stream().filter(people3 -> people3.getSalary() > 60000).collect(Collectors.groupingBy(People::getCity, Collectors.counting()));
//        System.out.println(collect35);
//
//        //Find the city with the highest average salary.
//        String s4 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getSalary))).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
//        System.out.println(s4);
//
//        //Find all people who joined in the same month grouped together.
//        Map<Month, List<People>> collect36 = peopleList.stream().collect(Collectors.groupingBy(people3 -> people3.getJoiningDate().getMonth()));
//        System.out.println(collect36);
//
//        //Create Map<City, DoubleSummaryStatistics> for salaries.
//        Map<String, DoubleSummaryStatistics> collect37 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.summarizingDouble(People::getSalary)));
//        System.out.println(collect37);
//
//        //Get total salary per city.
//        Map<String, Double> collect38 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.summingDouble(People::getSalary)));
//        System.out.println(collect38);
//
//        //Count people per joining year.
//        Map<Integer, Long> collect39 = peopleList.stream().collect(Collectors.groupingBy(people3 -> people3.getJoiningDate().getYear(), Collectors.counting()));
//        System.out.println(collect39);
//
//        //Group names by city as a comma-separated string.
//        String collect40 = peopleList.stream().map(People::getCity).collect(Collectors.joining(","));
//        System.out.println(collect40);
//
//        //Find the department (city) with the lowest average salary.
//        Optional<String> s5 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getSalary))).entrySet().stream().min(Map.Entry.<String, Double>comparingByValue()).map(Map.Entry::getKey);
//        System.out.println(s5);
//
//        //Get all unique joining months.
//        List<Month> list33 = peopleList.stream().map(people3 -> people3.getJoiningDate().getMonth()).distinct().toList();
//        System.out.println(list33);
//
//        //Find the most common joining year.
//        Optional<Integer> year = peopleList.stream().collect(Collectors.groupingBy(people3 -> people3.getJoiningDate().getYear(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
//        year.ifPresent(System.out::println);
//
//        //Find all people whose salary is a multiple of 15,000.
//        List<People> list34 = peopleList.stream().filter(people3 -> people3.getSalary() % 15000 == 0).toList();
//        System.out.println(list34);
//
//        //Get all salaries grouped by city.
//        Map<String, List<Double>> collect41 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.mapping(People::getSalary, Collectors.toList())));
//
//        System.out.println(collect41);
//
//        //Find the second-highest salary person.
//        Optional<People> first = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).skip(1).findFirst();
//        first.ifPresent(System.out::println);
//
//        //Find all people with salary equal to the max salary.
//        double salary = peopleList.stream().max(Comparator.comparing(People::getSalary)).get().getSalary();
//        List<People> list35 = peopleList.stream().filter(people3 -> people3.getSalary() == salary).toList();
//        System.out.println(list35);
//
//        // or
//        List<People> people3 = peopleList.stream().collect(Collectors.groupingBy(People::getSalary)).entrySet().stream().max(Map.Entry.comparingByKey()).map(Map.Entry::getValue).orElse(List.of());
//        System.out.println(people3);
//
//        //List top 3 highest-paid people.
//        List<People> list36 = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).limit(3).toList();
//        System.out.println(list36);
//
//        //Get people who joined in the last 2 years.
//        LocalDate twoYearPrevious = LocalDate.now().minusYears(2);
//        List<People> peopleStream = peopleList.stream().filter(people5 -> people5.getJoiningDate().isAfter(twoYearPrevious)).toList();
//        System.out.println(peopleStream);
//
//        //Count people in each city with salary > 50,000.
//        Map<String, Long> collect42 = peopleList.stream().filter(people5 -> people5.getSalary() > 50000).collect(Collectors.groupingBy(People::getCity, Collectors.counting()));
//        System.out.println(collect42);
//
//        //Create Map<City, People> with the highest-paid person per city.
//        Map<String, People> collect43 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(People::getSalary)), Optional::get)));
//        System.out.println(collect43);
//
//        //Remove duplicate names, keeping only the first occurrence.
//        HashSet<String> uniqueNames = new HashSet<>();
//        List<String> list37 = peopleList.stream().filter(people5 -> uniqueNames.add(people5.getName())).map(People::getName).toList();
//        System.out.println(list37);
//
//        //Return people with min and max salary in one pass.
//        Map<String, People> collect44 = peopleList.stream().collect(Collectors.teeing(
//                Collectors.maxBy(Comparator.comparing(People::getSalary)),
//                Collectors.minBy(Comparator.comparing(People::getSalary)),
//                (maximun, minimum) -> Map.of(
//                        "Maximum", maximun.orElse(null),
//                        "Minimum", minimum.orElse(null)
//
//                )
//        ));
//        System.out.println(collect44);
//
//        Map<String, People> collect45 = peopleList.stream()
//                .collect(Collectors.teeing(
//                        Collectors.maxBy(Comparator.comparing(People::getJoiningDate)),  // Most recent (youngest)
//                        Collectors.minBy(Comparator.comparing(People::getJoiningDate)),  // Earliest (oldest)
//                        (youngest, oldest) -> Map.of(
//                                "Youngest", youngest.orElse(null),
//                                "Oldest", oldest.orElse(null)
//                        )
//                ));
//
//        System.out.println(collect45);
//
//        //Partition people into before and after 2020 joining.
//        Map<String, List<People>> collect46 = peopleList.stream().collect(Collectors.partitioningBy(people5 -> people5.getJoiningDate().getYear() < 2020)).entrySet().stream().collect(Collectors.toMap(
//                e -> e.getKey() ? "Before 2020" : "After 2020",
//                Map.Entry::getValue
//        ));
//        System.out.println(collect46);
//
//        //Convert people list to TreeMap<City, Set<Name>>.
//        TreeMap<String, Set<String>> collect47 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, TreeMap::new, Collectors.mapping(People::getName, Collectors.toSet())));
//        System.out.println(collect47);
//
//        //Check if any two people have the same salary.
//        boolean b6 = peopleList.stream().collect(Collectors.groupingBy(People::getSalary, Collectors.counting())).values().stream().anyMatch(value -> value > 1);
//        System.out.println(b6);
//
//        //Get all names sorted in reverse alphabetical order.
//        List<String> list38 = peopleList.stream().map(People::getName).sorted(Comparator.reverseOrder()).toList();
//        System.out.println(list38);
//
//        //Create Map<Name, List<Salary>> for duplicate names.
//        Map<String, List<Double>> collect48 = peopleList.stream().collect(Collectors.groupingBy(People::getName, LinkedHashMap::new, Collectors.mapping(People::getSalary, Collectors.toList())));
//        System.out.println(collect48);
//
//        //Sort people by joining date first, then salary descending.
//        List<People> list39 = peopleList.stream().sorted(Comparator.comparing(People::getJoiningDate).thenComparing(People::getSalary).reversed()).toList();
//        System.out.println(list39);
//
//        //Get people whose salary is in the top 20%.
//        List<People> list40 = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).limit((long) (peopleList.size() * 0.2)).toList();
//        System.out.println(list40);
//
//        //Get a list of "Name (length)" for all people.
//        List<String> list41 = peopleList.stream().map(people5 -> people5.getName() + " (" + people5.getName().length() + ")").toList();
//        System.out.println(list41);
//
//        //Find the city with the lowest average salary.
//        String s6 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getSalary))).entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
//        System.out.println(s6);
//
//        //Find the city with the maximum number of people.
//        Optional<String> s7 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
//        System.out.println(s7);
//
//        //Get all people who joined on weekends.
//        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
//        List<People> peopleList1 = peopleList.stream().filter(people5 -> {
//            DayOfWeek dayOfWeek1 = people5.getJoiningDate().getDayOfWeek();
//            return dayOfWeek1 == DayOfWeek.SATURDAY || dayOfWeek1 == DayOfWeek.SUNDAY;
//        }).toList();
//
//        System.out.println(peopleList1);
//
//        //Get average salary of people whose name starts with a vowel.
//        List<String> a1 = List.of("A", "E", "I", "O", "U");
//        List<Double> list42 = peopleList.stream().filter(people5 ->
//                a1.stream().anyMatch(v -> people5.getName().startsWith(v))
//        ).map(People::getSalary).toList();
//        System.out.println(list42);
//
//        //Get 5 people with the lowest salaries.
//        List<People> list43 = peopleList.stream().sorted(Comparator.comparing(People::getSalary)).limit(5).toList();
//        System.out.println(list43);
//
//        //Find all unique salaries in descending order.
//        List<Double> list44 = peopleList.stream().map(People::getSalary).distinct().sorted(Comparator.reverseOrder()).toList();
//        System.out.println(list44);
//
//        //Create Map<JoiningYear, List<People>> based on joining year.
//        Map<Integer, List<People>> collect49 = peopleList.stream().collect(Collectors.groupingBy(people5 -> people5.getJoiningDate().getYear()));
//        System.out.println(collect49);
//
//        //Create a LinkedHashMap of people preserving insertion order.
//        LinkedHashMap<String, People> collect50 = peopleList.stream().collect(Collectors.toMap(
//                people5 -> people5.getName(),
//                people6 -> people6,
//                (existing, replacement) -> existing,
//                LinkedHashMap::new
//        ));
//        System.out.println(collect50);
//
//        //Get all duplicate salaries grouped by salary.
//        List<Double> list45 = peopleList.stream().collect(Collectors.groupingBy(People::getSalary, Collectors.counting())).entrySet().stream().filter(value -> value.getValue() > 1).map(Map.Entry::getKey).toList();
//        System.out.println(list45);
//
//        //Find all people whose names contain the letter "e" (case-insensitive).
//        List<People> e = peopleList.stream().filter(people5 -> people5.getName().contains("e")).toList();
//        System.out.println(e);
//
//        //Find the oldest person in each city.
//        Map<String, People> collect51 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(People::getAge)), opt -> opt.orElse(null))));
//        System.out.println(collect51);
//
//        //Find youngest female and youngest male.
//        Map<String, People> collect52 = peopleList.stream().collect(Collectors.groupingBy(
//                People::getCity,
//                Collectors.collectingAndThen(
//                        Collectors.minBy(Comparator.comparing(People::getAge)),
//                        opt -> opt.orElse(null)
//                )
//        ));
//
//        System.out.println(collect52);
//
//        //Find all people who joined before 2020.
//        List<People> list46 = peopleList.stream().filter(people5 -> people5.getJoiningDate().getYear() < 2020).toList();
//        System.out.println(list46);
//
//        //or
//        List<People> list47 = peopleList.stream().filter(people5 -> people5.getJoiningDate().isBefore(LocalDate.of(2020, 1, 1))).toList();
//        System.out.println(list47);
//
//        //Create TreeMap<City, Set<Name>> where names are sorted.
//        TreeMap<String, Set<String>> collect53 = peopleList.stream().collect(Collectors.groupingBy(People::getCity,
//                TreeMap::new,
//                Collectors.mapping(People::getName,
//                        Collectors.toCollection(TreeSet::new)
//                )
//        ));
//
//        System.out.println(collect53);
//
//        //Get top 2 highest earners per city.
//        Map<String, List<People>> collect54 = peopleList.stream().collect(Collectors.groupingBy(
//                People::getCity,
//                Collectors.collectingAndThen(
//                        Collectors.toList(),
//                        li -> li.stream().sorted(Comparator.comparing(People::getSalary).reversed()).limit(2).toList()
//                )
//        ));
//        System.out.println(collect54);
//
//        //or
//
//        Map<String, List<People>> collect55 = peopleList.stream().collect(Collectors.groupingBy(People::getCity)).entrySet().stream().
//                collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        e1 -> e1.getValue().stream().sorted(Comparator.comparing(People::getSalary).reversed()).limit(2).toList()
//                ));
//
//        System.out.println(collect55);
//
//        //Find people joined on a Monday.
//        List<People> list48 = peopleList.stream().filter(people5 -> people5.getJoiningDate().getDayOfWeek() == DayOfWeek.MONDAY
//        ).toList();
//        System.out.println(list48);
//
//        //Partition people by those who joined after 2022 vs others.
//        Map<String, List<People>> collect56 = peopleList.stream().collect(Collectors.partitioningBy(people5 ->
//                        people5.getJoiningDate().isBefore(LocalDate.of(2022, 1, 1))))
//                .entrySet().stream().collect(Collectors.toMap(
//                        p -> p.getKey() ? "Before 2020" : "After 2020",
//                        Map.Entry::getValue
//
//                ));
//        System.out.println(collect56);
//
//        //Get a Map<City, DoubleSummaryStatistics> for salary (min, max, avg, sum).
//        Map<String, DoubleSummaryStatistics> collect57 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.summarizingDouble(People::getSalary)));
//        System.out.println(collect57);
//
//        //Create Map<JoiningYear, Count> for people with salary > 60,000.
//        Map<Integer, Long> collect58 = peopleList.stream().filter(people5 -> people5.getSalary() > 60000).collect(Collectors.groupingBy(people5 -> people5.getJoiningDate().getYear(), Collectors.counting()));
//        System.out.println(collect58);
//
//        //Find the most common salary (mode).
//        double commonSalary = peopleList.stream().collect(Collectors.groupingBy(People::getSalary, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(0.0);
//        System.out.println(commonSalary);
//
//        //Get person with the earliest joining date overall.
//        People people5 = peopleList.stream().min(Comparator.comparing(People::getJoiningDate)).orElse(null);
//        System.out.println(people5);
//
//        //Find people with duplicate salaries and group them.
//        Map<Double, List<People>> collect59 = peopleList.stream().collect(
//                Collectors.groupingBy(
//                        People::getSalary
//                )
//        ).entrySet().stream().filter(v -> v.getValue().size() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        System.out.println(collect59);
//
//        //Create Map<PeopleId, People> keeping only the latest joined person for duplicate IDs.
//        HashMap<Integer, People> collect60 = peopleList.stream().collect(Collectors.toMap(
//                People::getId,
//                people6 -> people6,
//                (existing, replacement) -> existing.getJoiningDate().isAfter(replacement.getJoiningDate()) ? existing : replacement,
//                HashMap::new
//        ));
//        System.out.println(collect60);
//
//        //Get distinct salaries sorted in ascending order.
//        List<Double> list49 = peopleList.stream().map(People::getSalary).distinct().sorted().toList();
//        System.out.println(list49);
//
//        //Find common salaries among two different cities.
//        List<Double> pune2 = peopleList.stream().filter(people6 -> people6.getCity().equalsIgnoreCase("pune")).map(People::getSalary).toList();
//        ArrayList<Double> people7 = new ArrayList<>(pune2);
//        List<Double> delhi1 = peopleList.stream().filter(people6 -> people6.getCity().equalsIgnoreCase("Delhi")).map(People::getSalary).toList();
//        people7.retainAll(delhi1);
//        System.out.println(people7);
//
//        // or
//
//        List<Double> commonSalaries = peopleList.stream()
//                .filter(p -> p.getCity().equalsIgnoreCase("pune") || p.getCity().equalsIgnoreCase("delhi"))
//                .collect(Collectors.groupingBy(
//                        People::getSalary,
//                        Collectors.mapping(p -> p.getCity().toLowerCase(), Collectors.toSet())
//                ))
//                .entrySet().stream()
//                .filter(e2 -> e2.getValue().containsAll(Set.of("pune", "delhi")))
//                .map(Map.Entry::getKey)
//                .toList();
//
//        System.out.println(commonSalaries);
//
//
//        System.out.println("quarter" + getQuarter(LocalDate.of(2022, 1, 1)));
//
//        System.out.println(LocalDate.of(2022, 1, 1).getMonthValue());
//
//        //Find all people who joined in the same quarter.
//        Map<Integer, List<People>> peopleByQuarter = peopleList.stream()
//                .collect(Collectors.groupingBy(p -> getQuarter(p.getJoiningDate())));
//        System.out.println(peopleByQuarter);
//
//        //Find names of people grouped by first letter.
//        Map<Character, List<String>> collect61 = peopleList.stream().collect(Collectors.groupingBy(people6 -> people6.getName().charAt(0), Collectors.mapping(People::getName,Collectors.toList())));
//        System.out.println(collect61);
//
//        //Find people who joined during a leap year.
//        List<People> list50 = peopleList.stream().filter(people6 -> people6.getJoiningDate().isLeapYear()).toList();
//        System.out.println(list50);
//
//        //Count people with salary divisible by 5,000.
//        long count = peopleList.stream().filter(people6 -> people6.getSalary() % 5000 == 0).count();
//        System.out.println(count);
//
//        //Get top 10% earners list.
//        List<People> list51 = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).limit((long) (peopleList.size() * 0.1)).toList();
//        System.out.println(list51);
//
//        //Get all female people earning more than 60,000.
//        List<People> female = peopleList.stream().filter(people6 -> people6.getSalary() > 60000 && people6.getGender().equalsIgnoreCase("female")).toList();
//        System.out.println(female);
//
//        //List people aged between 25 and 35, sorted by salary descending.
//        List<People> list52 = peopleList.stream().filter(people6 -> people6.getAge() > 25 && people6.getAge() < 35).sorted(Comparator.comparing(People::getSalary).reversed()).toList();
//        System.out.println(list52);
//
//        //Create a Map<City, AverageAge> for all people.
//        Map<String, Double> collect62 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getAge)));
//        System.out.println(collect62);
//
//        //Find the oldest person in each city.
//        Map<String, People> collect63 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.collectingAndThen(Collectors.toList(), li -> li.stream().max(Comparator.comparing(People::getAge)).orElse(null))));
//        System.out.println(collect63);
//
//        //or
//        Map<String, People> collect64 = peopleList.stream().collect(Collectors.groupingBy(
//                People::getCity,
//                Collectors.collectingAndThen(
//                        Collectors.maxBy(Comparator.comparing(People::getSalary)),
//                        opt -> opt.orElse(null)
//                )
//        ));
//        System.out.println(collect64);
//
//        //Count males vs females → Map<String, Long>.
//        Map<String, Long> collect65 = peopleList.stream().collect(Collectors.groupingBy(People::getGender, Collectors.counting()));
//        System.out.println(collect65);
//
//        //Create a Map<AgeGroup, List<People>> (<30, 30-40, >40).
//        Map<String, List<People>> collect66 = peopleList.stream().collect(Collectors.groupingBy(people6 -> {
//            if (people6.getAge() < 30) return "<30";
//            else if (people6.getAge() > 40) return ">40";
//            else return "30-40";
//        }));
//
//        System.out.println(collect66);
//
//        //Find the average salary of people who joined in the last 3 years.
//        Double collect67 = peopleList.stream().filter(people6 -> people6.getJoiningDate().isAfter(LocalDate.now().minusYears(3))).collect(Collectors.averagingDouble(People::getSalary));
//        System.out.println(collect67);
//
//        //Find the person with the earliest joining date overall.
//        People people6 = peopleList.stream().min(Comparator.comparing(People::getJoiningDate)).orElse(null);
//        System.out.println(people6);
//
//        //Check if there’s anyone from Nagpur earning more than 50,000.
//        boolean nagpur = peopleList.stream().anyMatch(people8 -> people8.getCity().equalsIgnoreCase("nagpur") && people8.getSalary() > 50000);
//        System.out.println(nagpur);
//
//        //Create a TreeMap<City, Set<Name>> where names are sorted.
//        TreeMap<String, Set<String>> collect68 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, TreeMap::new, Collectors.mapping(People::getName, Collectors.toCollection(TreeSet::new))));
//        System.out.println(collect68);
//
//        //Get the 5 people with the lowest salaries.
//        List<People> list53 = peopleList.stream().sorted(Comparator.comparing(People::getSalary)).limit(5).toList();
//        System.out.println(list53);
//
//        List<People> list54 = peopleList.stream().sorted(Comparator.comparing(People::getName)).toList();
//        System.out.println("-->"+list54);
//
//        Map<Boolean, List<People>> collect69 = peopleList.stream().collect(Collectors.partitioningBy(p2 -> p2.getJoiningDate().getYear() > 2021));
//        System.out.println(collect69);


        //Print all people names.
        peopleList.stream().forEach(people -> System.out.println(people.getName()));

        //Get list of people whose salary > 50,000.
        List<People> list = peopleList.stream().filter(people -> people.getSalary() > 50000).toList();
        System.out.println(list);

        //Sort people by name alphabetically.
        List<People> sortedByName = peopleList.stream().sorted(Comparator.comparing(People::getName)).toList();
        System.out.println(sortedByName);

        //Sort people by salary (descending).
        List<People> SortedBySalaryDesc = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).toList();
        System.out.println(SortedBySalaryDesc);

        //Remove duplicate people based on name.
        HashSet<String> strings = new HashSet<>();
        List<People> list1 = peopleList.stream().filter(emp -> strings.add(emp.getName())).toList();
        System.out.println(list1);

        //Convert List<People> to List<String> of names.
        List<String> list2 = peopleList.stream().map(People::getName).toList();
        System.out.println(list2);

        //Convert List<People> to Map<id, name>.
        Map<Integer, String> collect = peopleList.stream().collect(Collectors.toMap(People::getId, People::getName));
        System.out.println(collect);

        //Filter people who joined after 2021.
        List<People> list3 = peopleList.stream().filter(peo -> peo.getJoiningDate().getYear() > 2021).toList();

        //or

        List<People> list4 = peopleList.stream().filter(peo -> peo.getJoiningDate().isAfter(LocalDate.of(2021, 12, 31))).toList();

        //Get all people living in city "Pune".
        List<People> list5 = peopleList.stream().filter(peo -> peo.getCity().equalsIgnoreCase("Pune")).toList();
        System.out.println(list5);

        //Count people with salary below 40,000.
        List<People> list6 = peopleList.stream().filter(peo -> peo.getSalary() < 40000).toList();
        System.out.println(list6);

        //Group people by city → Map<String, List<People>>.
        Map<String, List<People>> collect1 = peopleList.stream().collect(Collectors.groupingBy(peo -> peo.getCity()));
        System.out.println(collect1);

        // or

        Map<String, People> collect2 = peopleList.stream().collect(Collectors.toMap(
                peo -> peo.getCity(),
                people -> people,
                (existingCity, newCity) -> existingCity

        ));
        System.out.println(collect2);

        //Count people per city → Map<String, Long>.
        Map<String, Long> collect3 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting()));
        System.out.println(collect3);

        //Average salary per city.
        Map<String, Double> collect4 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getSalary)));
        System.out.println(collect4);

        //Find city with the most residents.
        Map.Entry<String, Long> stringLongEntry = peopleList.stream().collect(Collectors.groupingBy(people -> people.getCity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(stringLongEntry);

        //Find highest-paid person in each city.
        Map<String, People> collect5 = peopleList.stream().collect(Collectors.groupingBy(
                        People::getCity,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(People::getSalary)),
                                Optional::get
                        )
                )
        );

        //List cities with average salary > 60,000.
        Map<String, Double> collect6 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getSalary))).entrySet().stream().filter(peo -> peo.getValue() > 60000).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
        ));
        System.out.println(collect6);

        //Create Map<City, List<People>> sorted by city name.
        TreeMap<String, List<People>> collect7 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, TreeMap::new, Collectors.toList()));
        System.out.println(collect7);

        //Partition people by salary > 60,000.
        Map<Boolean, List<People>> collect8 = peopleList.stream().collect(Collectors.partitioningBy(peo -> peo.getSalary() > 60000));
        System.out.println(collect8);

        //Find duplicate names.
        List<People> list7 = peopleList.stream().filter(peo -> !strings.add(peo.getName())).toList();
        System.out.println(list7);

        //Create a comma-separated string of all names.
        String collect9 = peopleList.stream().map(peo -> peo.getName()).collect(Collectors.joining(","));
        System.out.println(collect9);

        //Get summary statistics (min, max, avg, sum, count) for salary.
        DoubleSummaryStatistics collect10 = peopleList.stream().collect(Collectors.summarizingDouble(People::getSalary));
        System.out.println(collect10.getSum());

        //Join all people names in uppercase with commas.
        String collect11 = peopleList.stream().map(peo -> peo.getName().toUpperCase()).collect(Collectors.joining(","));
        System.out.println(collect11);

        //Sort people by city, then by name.
        List<People> list8 = peopleList.stream().sorted(Comparator.comparing(People::getCity).thenComparing(Comparator.comparing(People::getName))).toList();
        System.out.println(list8);

        //Convert list of people names to a Set.
        Set<String> collect12 = peopleList.stream().map(peo -> peo.getName()).collect(Collectors.toSet());
        System.out.println(collect12);

        //List all people whose names start with "A".
        List<People> a = peopleList.stream().filter(people -> people.getName().startsWith("A")).toList();
        System.out.println(a);

        //Check if any person earns more than 1,00,000.
        boolean b = peopleList.stream().anyMatch(peo -> peo.getSalary() > 100000);
        System.out.println(b);

        //Check if all people are from the same city.
        boolean b1 = peopleList.stream().map(peo -> peo.getCity()).distinct().count() == 1;
        System.out.println(b1);

        //Get list of cities sorted by number of people.
        List<String> list9 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).map(city -> city.getKey()).toList();
        System.out.println(list9);

        //Get all unique cities.
        List<String> list10 = peopleList.stream().map(people -> people.getCity()).distinct().toList();
        System.out.println(list10);
        //or

        Set<String> collect13 = peopleList.stream().map(people -> people.getCity()).collect(Collectors.toSet());
        System.out.println(collect13);

        //Get person by ID using Optional (return "Unknown" if absent).
        String s = peopleList.stream().filter(people -> people.getId() == 5).map(People::getName).findFirst().orElse("Unknown");
        System.out.println(s);

        //Find the second-highest salary person.
        People people = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).skip(1).findFirst().orElse(null);
        System.out.println(people);

        //or

        People secondHighestSalary = peopleList.stream().map(People::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().map(salary -> peopleList.stream().filter(emp -> emp.getSalary() == salary).findFirst().orElse(null)).orElse(null);
        System.out.println(secondHighestSalary);

        //Find all people with salary equal to the max salary.
        List<People> people1 = peopleList.stream().map(People::getSalary).distinct().sorted(Comparator.reverseOrder()).findFirst().map(maxsalary -> peopleList.stream().filter(peop -> peop.getSalary() == maxsalary).toList()).orElse(null);
        System.out.println(people1);

        //or

        List<People> people3 = peopleList.stream().collect(Collectors.groupingBy(
                people2 -> people2.getSalary()
        )).entrySet().stream().max(Map.Entry.comparingByKey()).map(Map.Entry::getValue).orElse(List.of());
        System.out.println(people3);

        //List top 3 highest-paid people.
        Set<Double> collect14 = peopleList.stream().map(People::getSalary).sorted(Comparator.reverseOrder()).distinct().limit(3).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(collect14);
        List<People> list11 = peopleList.stream().filter(peo -> collect14.contains(peo.getSalary())).toList();
        System.out.println(list11);

        //Get people who joined in the last 2 years.
        int year = LocalDate.now().minusYears(2).getYear();
        List<People> list12 = peopleList.stream().filter(peo -> peo.getJoiningDate().isAfter(LocalDate.of(year, 12, 31))).toList();
        System.out.println(list12);

        //Count people in each city with salary > 50,000.
        Map<String, People> collect15 = peopleList.stream().collect(Collectors.groupingBy(
                People::getCity,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        li -> li.stream().max(Comparator.comparing(People::getSalary)).orElse(null)
                )
        ));
        System.out.println(collect15);

        //Create Map<City, People> with the highest-paid person per city.
        Map<String, People> collect16 = peopleList.stream().collect(Collectors.groupingBy(
                People::getCity,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(People::getSalary)),
                        Optional::get
                )
        ));
        System.out.println(collect16);

        //Remove duplicate names, keeping only the first occurrence.
        HashSet<String> strings1 = new HashSet<>();
        List<People> list13 = peopleList.stream().filter(peo -> strings1.add(peo.getName())).toList();
        System.out.println(strings1);

        //Calculate total salary paid per city.
        Map<String, Double> collect17 = peopleList.stream().collect(Collectors.groupingBy(
                peo -> peo.getCity(),
                Collectors.summingDouble(People::getSalary)
        ));
        System.out.println(collect17);

        //Find youngest and oldest person by joining date.
        People people2 = peopleList.stream().sorted(Comparator.comparing(People::getJoiningDate)).findFirst().orElse(null);
        People people4 = peopleList.stream().sorted(Comparator.comparing(People::getJoiningDate)).skip((peopleList.size() - 1)).findFirst().orElse(null);

        //Partition people into before and after 2020 joining.
        Map<Boolean, List<People>> collect18 = peopleList.stream().collect(Collectors.partitioningBy(people5 -> people5.getJoiningDate().isAfter(LocalDate.of(2020, 12, 31))));
        System.out.println(collect18);

        //Convert people list to TreeMap<City, Set<PeopleName>>.
        TreeMap<String, Set<String>> collect19 = peopleList.stream().collect(Collectors.groupingBy(
                People::getCity,
                TreeMap::new,
                Collectors.mapping(
                        People::getName,
                        Collectors.toSet()
                )
        ));

        //Check if any two people have the same salary.
        Map<Double, Long> collect20 = peopleList.stream().collect(Collectors.groupingBy(people5 -> people5.getSalary(), Collectors.counting()));
        boolean b2 = collect20.values().stream().anyMatch(salarycount -> salarycount > 1);
        System.out.println(b2);

        //or
        boolean b3 = peopleList.stream().map(People::getSalary).collect(Collectors.toSet()).size() != peopleList.size();
        System.out.println(b3);

        //Get all names sorted in reverse alphabetical order.
        List<String> list14 = peopleList.stream().map(People::getName).sorted(Comparator.reverseOrder()).toList();
        System.out.println(list14);

        //Create Map<Name, List<Salary>> for duplicate names.
        Map<String, Long> collect21 = peopleList.stream().collect(Collectors.groupingBy(People::getName, Collectors.counting()));

        Map<String, List<Double>> collect22 = peopleList.stream().filter(peo -> collect21.get(peo.getName()) > 1).collect(Collectors.groupingBy(
                People::getName,
                Collectors.mapping(
                        People::getSalary,
                        Collectors.toList()

                )
        ));

        //Find city with the lowest average salary.
        String lowAvgSalCIty = peopleList.stream().collect(Collectors.groupingBy(People::getCity,
                Collectors.averagingDouble(People::getSalary))).entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
        System.out.println(lowAvgSalCIty);

        //Convert list to LinkedHashMap (preserve insertion order).
        LinkedHashMap<String, Long> collect23 = peopleList.stream().collect(Collectors.groupingBy(
                People::getCity,
                LinkedHashMap::new,
                Collectors.counting()
        ));

        //Group names by city into a comma-separated string.
        String collect24 = peopleList.stream().map(People::getCity).collect(Collectors.joining(","));
        System.out.println(collect24);

        //Get people whose salary is in the top 20%.
        List<Double> list15 = peopleList.stream().map(People::getSalary).sorted(Comparator.reverseOrder()).distinct().toList();
        int ceil = (int)Math.ceil(list15.size() * 0.20)-1;
        Double baseSalary = list15.get(ceil);
        List<People> list16 = peopleList.stream().filter(peo -> peo.getSalary() >= baseSalary).toList();

        //Sort people by ID but keep only one entry per name.
        HashSet<String> strings2 = new HashSet<>();
        List<People> list17 = peopleList.stream().filter(peo -> strings2.add(peo.getName())).sorted(Comparator.comparing(People::getId)).toList();
        System.out.println(list17);

        //Return people with min and max salary in one pass.
        DoubleSummaryStatistics collect25 = peopleList.stream().collect(Collectors.summarizingDouble(People::getSalary));

        System.out.println(collect25.getMax());
        System.out.println(collect25.getMin());

        //Create List<String> like "Alice - Pune", "Bob - Mumbai".
        List<String> list18 = peopleList.stream().map(peo -> peo.getName() + "-" + peo.getCity()).toList();
        System.out.println(list18);

        //Collect names of people whose salary is divisible by 10,000.
        List<People> list19 = peopleList.stream().filter(peo -> (peo.getSalary() % 10000) == 0).toList();
        System.out.println(list19);

        //Get person with the highest salary in "Pune".
        People people5 = peopleList.stream().filter(peo -> peo.getCity().equalsIgnoreCase("Pune")).max(Comparator.comparing(People::getSalary)).orElse(null);
        System.out.println(people5);

        //Create Map<PeopleId, People> keeping only the latest joined person for duplicate IDs.
        HashMap<Integer, People> collect26 = peopleList.stream().collect(Collectors.toMap(
                peo -> peo.getId(),
                peop -> peop,
                (e, n) -> n,
                HashMap::new
        ));
        System.out.println(collect26);

        //Get distinct salaries sorted in ascending order.
        List<Double> list20 = peopleList.stream().map(peo -> peo.getSalary()).distinct().sorted().toList();
        System.out.println(list20);

        //Filter people whose name length > 5.
        List<People> list21 = peopleList.stream().filter(peo -> peo.getName().length() > 5).toList();
        System.out.println(list21);

        //Find common salaries among two different cities.
        List<People> punePeople = peopleList.stream().filter(peo -> peo.getGender().equalsIgnoreCase("Pune")).toList();
        List<People> MumbaiPeople = peopleList.stream().filter(peo -> peo.getGender().equalsIgnoreCase("Mumbai")).toList();

        List<People> list22 = punePeople.stream().filter(MumbaiPeople::contains).distinct().toList();
        System.out.println(list22);

        //Create Map<Year, List<People>> grouped by joining year.
        Map<Integer, List<People>> collect27 = peopleList.stream().collect(Collectors.groupingBy(
                people6 -> people6.getJoiningDate().getYear()
        ));

        //List people grouped by month of joining.
        Map<Month, List<People>> collect28 = peopleList.stream().collect(Collectors.groupingBy(people6 -> people6.getJoiningDate().getMonth()));
        System.out.println(collect28);

        //Print names of people who joined on weekends.
        List<People> list23 = peopleList.stream().filter(peo -> peo.getJoiningDate().getDayOfWeek() == DayOfWeek.SATURDAY || peo.getJoiningDate().getDayOfWeek() == DayOfWeek.SUNDAY).toList();
        System.out.println(list23);

        //or

        Set<DayOfWeek> dayOfWeeks = Set.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        List<People> list24 = peopleList.stream().filter(peo -> dayOfWeeks.contains(peo.getJoiningDate().getDayOfWeek())).toList();
        System.out.println(list24);

        //Get average salary of people whose names start with a vowel.
        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U');
        double avgSalNameStVowel = peopleList.stream().filter(people6 -> vowels.contains(people6.getName().charAt(0))).mapToDouble(People::getSalary).average().orElse(0.0);
        System.out.println(avgSalNameStVowel);






    }


}
