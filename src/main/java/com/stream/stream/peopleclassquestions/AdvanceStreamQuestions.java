package com.stream.stream.peopleclassquestions;

import com.stream.stream.entity.People;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvanceStreamQuestions {
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


        //Print all people names.
        peopleList.stream().forEach(people -> System.out.println(people.getName()));

        //Get list of people whose salary > 50,000.
        List<People> salariespeople = peopleList.stream().filter(people -> people.getSalary() > 50000).toList();
        System.out.println("salariespeople->" + salariespeople);

        //Sort people by name alphabetically.
        List<People> PeopleSortedListByName = peopleList.stream().sorted(Comparator.comparing(People::getName)).toList();
        System.out.println("PeopleSortedListByName->" + PeopleSortedListByName);

        //Sort people by salary (descending).
        List<People> descendingSortedListBySalary = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).toList();
        System.out.println("descendingSortedListBySalary->" + descendingSortedListBySalary);

        //Remove duplicate people based on name.
        HashSet<String> strings = new HashSet<>();
        List<People> duplicateRemovedList = peopleList.stream().filter(people -> strings.add(people.getName())).toList();
        System.out.println("duplicateRemovedList" + duplicateRemovedList);

        //or

        Map<String, People> nonDuplicateByName = peopleList.stream().collect(Collectors.toMap(People::getName, people -> people, (pervious, newone) -> pervious));
        System.out.println("nonDuplicateByName" + nonDuplicateByName);

        //Convert List<People> to List<String> of names.
        List<String> peopleNameList = peopleList.stream().map(People::getName).toList();
        System.out.println("peopleNameList->" + peopleNameList);

        //Convert List<People> to Map<id, name>.
        peopleList.stream().collect(Collectors.toMap(
                people -> people.getId(),
                people -> people.getName()
        ));

        //Filter people who joined after 2021.
        List<People> peopleJoinedAfter2021 = peopleList.stream().filter(people -> people.getJoiningDate().getYear() > 2021).toList();
        System.out.println("peopleJoinedAfter2021" + peopleJoinedAfter2021);

        //Get all people living in city "Pune".
        List<People> puneCityPeople = peopleList.stream().filter(people -> people.getCity().equalsIgnoreCase("pune")).toList();
        System.out.println("puneCityPeople" + puneCityPeople);

        //Count people with salary below 40,000.
        List<People> peopleListWithBelow40000Salary = peopleList.stream().filter(people -> people.getSalary() < 40000).toList();
        System.out.println("peopleListWithBelow40000Salary" + peopleListWithBelow40000Salary);

        //Group people by city → Map<String, List<People>>.
        Map<String, List<People>> cityWisePeopleList = peopleList.stream().collect(Collectors.groupingBy(People::getName, Collectors.mapping(Function.identity(), Collectors.toList())));
        System.out.println("cityWisePeopleList->" + cityWisePeopleList);

        //Count people per city → Map<String, Long>.
        Map<String, Long> cityWisePeopleCount = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting()));
        System.out.println("cityWisePeopleCount->" + cityWisePeopleCount);

        //Average salary per city.
        Map<String, Double> cityWiseAverageSalary = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getSalary)));
        System.out.println("cityWiseAverageSalary" + cityWiseAverageSalary);

        //Find city with the most residents.
        String s = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(people -> people.getKey()).get();
        System.out.println(s);

        //Find highest-paid person in each city.
        Map<String, People> collect = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(People::getSalary)), opt -> opt.orElse(null))));
        System.out.println(collect);

        //or

        Map<String, People> collect1 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.collectingAndThen(Collectors.toList(), people -> people.stream().sorted(Comparator.comparing(People::getSalary).reversed()).findFirst().get())));
        System.out.println(collect1);

        //List cities with average salary > 60,000.
        Map<String, Double> collect2 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getSalary))).entrySet().stream().filter(people -> people.getValue() > 60000).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
        ));

        System.out.println(collect2);

        //or
        Map<String, Double> collect3 = peopleList.stream().collect(
                Collectors.groupingBy(
                        People::getCity,
                        Collectors.collectingAndThen(
                                Collectors.averagingDouble(People::getSalary),
                                avgSalary -> avgSalary > 60000 ? avgSalary : null)
                ));

        System.out.println(collect3);

        //Create Map<City, List<People>> sorted by city name.
        Map<String, List<People>> collect4 = peopleList.stream().collect(
                Collectors.groupingBy(
                        People::getCity,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream().sorted(
                                        Comparator.comparing(People::getCity)).toList()
                        )));

        System.out.println(collect4);

        //or

        LinkedHashMap<String, List<People>> collect5 = peopleList.stream().collect(
                Collectors.groupingBy(People::getCity)).entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (E, N) -> E, LinkedHashMap::new));
        System.out.println(collect5);

        //Partition people by salary > 60,000.
        Map<Boolean, List<People>> collect6 = peopleList.stream().collect(Collectors.partitioningBy(people -> people.getSalary() > 60000));
        System.out.println(collect6);

        //Find duplicate names.
        HashSet<String> peopleName = new HashSet<>();
        List<String> list = peopleList.stream().map(People::getName).filter(name -> !peopleName.add(name)).toList();
        System.out.println(list);

        //Create a comma-separated string of all names.
        String collect7 = peopleList.stream().map(People::getName).collect(Collectors.joining(","));
        System.out.println(collect7);

        //or

        String s1 = peopleList.stream().map(People::getName).reduce((people, people2) -> people + "," + people2).get();
        System.out.println(s1);

        //Get summary statistics (min, max, avg, sum, count) for salary.

        DoubleSummaryStatistics collect8 = peopleList.stream().collect(Collectors.summarizingDouble(People::getSalary));
        System.out.println(collect8.getMin());
        System.out.println(collect8.getMax());
        System.out.println(collect8.getSum());
        System.out.println(collect8.getCount());
        System.out.println(collect8.getAverage());

        //Join all people names in uppercase with commas.
        String collect9 = peopleList.stream().map(people -> people.getName().toUpperCase()).collect(Collectors.joining(","));
        System.out.println(collect9);

        //or

        String s2 = peopleList.stream().map(people -> people.getName().toUpperCase()).reduce("", (string, string2) -> string.isEmpty() ? string2 : string + "," + string2);
        System.out.println(s2);

        //Sort people by city, then by name.
        List<People> list2 = peopleList.stream().sorted(Comparator.comparing(People::getCity).thenComparing(People::getName)).toList();
        System.out.println(list2);

        //Convert list of people names to a Set.
        TreeSet<String> collect10 = peopleList.stream().map(People::getName).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect10);

        //List all people whose names start with "A".
        List<People> list1 = peopleList.stream().filter(people -> people.getName().startsWith("A")).toList();
        System.out.println(list1);

        //Check if any person earns more than 1,00,000.
        List<People> list3 = peopleList.stream().filter(people -> people.getSalary() > 100000).toList();
        System.out.println(list3);
        //or
        boolean hasHighEarner = peopleList.stream()
                .anyMatch(p -> p.getSalary() > 100000);
        System.out.println(hasHighEarner);


        //Check if all people are from the same city.
        boolean b = peopleList.stream().map(People::getCity).distinct().count() == 1;
        System.out.println(b);

        //or

        boolean b1 = peopleList.stream().allMatch(p -> p.getCity().equals(peopleList.get(0).getCity()));
        System.out.println(b1);

        //Get list of cities sorted by number of people.
        List<String> list4 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).map(city -> city.getKey()).toList();
        System.out.println(list4);

        //Get all unique cities.
        List<String> list5 = peopleList.stream().map(People::getCity).distinct().toList();
        System.out.println(list5);

        //Get person by ID using Optional (return "Unknown" if absent).
        People people1 = peopleList.stream().filter(people -> people.getId() == 1).findFirst().orElse(null);
        System.out.println(people1);

        //Find the second-highest salary person.
        People people = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).skip(1).findFirst().get();
        System.out.println(people);

        //Find all people with salary equal to the max salary.
        List<People> people2 = peopleList.stream().collect(Collectors.groupingBy(People::getSalary)).entrySet().stream().max(Map.Entry.comparingByKey()).map(Map.Entry::getValue).orElse(List.of());
        System.out.println(people2);

        //List top 3 highest-paid people.
        List<People> list6 = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).limit(3).toList();
        System.out.println(list6);

        //Get people who joined in the last 2 years.
        LocalDate twoYearsAgo = LocalDate.now().minusYears(2);
        List<People> recentJoines = peopleList.stream().filter(peo -> peo.getJoiningDate().isAfter(twoYearsAgo)).toList();
        System.out.println(recentJoines);

        //Count people in each city with salary > 50,000
        Map<String, Long> collect11 = peopleList.stream().filter(peo -> peo.getSalary() > 50000).collect(Collectors.groupingBy(People::getCity, Collectors.counting()));
        System.out.println(collect11);

        //Create Map<City, People> with the highest-paid person per city.
        Map<String, People> highestPaidByCity = peopleList.stream()
                .collect(Collectors.groupingBy(
                        People::getCity,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(People::getSalary)),
                                opt -> opt.orElse(null)
                        )
                ));
        System.out.println(highestPaidByCity);

        //Remove duplicate names, keeping only the first occurrence.
        HashSet<Object> peoplenames = new HashSet<>();
        List<String> list7 = peopleList.stream().filter(mep -> peoplenames.add(mep.getName())).map(People::getName).toList();
        System.out.println(list7);

        //or

        List<String> list8 = peopleList.stream().map(People::getName).distinct().toList();
        System.out.println(list8);

        //Calculate total salary paid per city.
        Map<String, Double> collect12 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.summingDouble(People::getSalary)));
        System.out.println(collect12);

        //Find youngest and oldest person by joining date.
        Map<String, People> collect13 = peopleList.stream().collect(Collectors.teeing(
                Collectors.maxBy(Comparator.comparing(People::getJoiningDate)),
                Collectors.minBy(Comparator.comparing(People::getJoiningDate)),
                (youngest, oldest) -> Map.of(
                        "Youngest", youngest.orElse(null),
                        "Oldest", oldest.orElse(null)
                )
        ));

        System.out.println(collect13);


        //Partition people into before and after 2020 joining.
        Map<Boolean, List<People>> collect14 = peopleList.stream().collect(Collectors.partitioningBy(peop -> peop.getJoiningDate().getYear() > 2020));
        System.out.println(collect14);

        //Convert people list to TreeMap<City, Set<PeopleName>>.
        TreeMap<String, Set<People>> collect15 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, TreeMap::new, Collectors.toSet()));
        System.out.println(collect15);

        //Check if any two people have the same salary.
        boolean b2 = peopleList.stream().collect(Collectors.groupingBy(People::getSalary, Collectors.counting())).values().stream().anyMatch(val -> val > 1);
        System.out.println(b2);

        //Get all names sorted in reverse alphabetical order.
        List<String> list9 = peopleList.stream().map(People::getName).sorted(Comparator.reverseOrder()).toList();
        System.out.println(list9);

        //Create Map<Name, List<Salary>> for duplicate names.
        Map<String, List<Double>> duplicateNameSalaryMap = peopleList.stream()
                .collect(Collectors.groupingBy(
                        People::getName,
                        Collectors.mapping(People::getSalary, Collectors.toList())
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(duplicateNameSalaryMap);

        //Find city with the lowest average salary.
        String s3 = peopleList.stream().collect(Collectors.groupingBy(People::getCity, Collectors.averagingDouble(People::getSalary))).entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
        System.out.println(s3);

        //Convert list to LinkedHashMap (preserve insertion order).
        LinkedHashMap<Integer, People> collect16 = peopleList.stream().collect(Collectors.toMap(People::getId, p -> p, (existing, replacement) -> existing, LinkedHashMap::new));
        System.out.println(collect16);

        //Group names by city into a comma-separated string.
        String collect17 = peopleList.stream().map(People::getCity).collect(Collectors.joining(","));
        System.out.println(collect17);

        //Get people whose salary is in the top 20%.
        List<People> list10 = peopleList.stream().sorted(Comparator.comparing(People::getSalary).reversed()).limit((long) Math.ceil(peopleList.size() * 0.2)).toList();
        System.out.println(list10);

        //Sort people by ID but keep only one entry per name.
        HashSet<String> seen = new HashSet<>();
        List<People> list11 = peopleList.stream()
                .sorted(Comparator.comparing(People::getId))
                .filter(p -> seen.add(p.getName())).toList();

        System.out.println(list11);

        //Return people with min and max salary in one pass.
        Map<String, People> collect18 = peopleList.stream().collect(Collectors.teeing(
                Collectors.maxBy(Comparator.comparing(People::getSalary)),
                Collectors.minBy(Comparator.comparing(People::getSalary)),
                (maxSalary, minSalary) -> Map.of(
                        "MaxSalary", maxSalary.orElse(null),
                        "MinSalary", minSalary.orElse(null)
                )
        ));
        System.out.println(collect18);

        //Create List<String> like "Alice - Pune", "Bob - Mumbai".
        List<String> list12 = peopleList.stream().map(people3 -> people3.getName() + "-" + people3.getCity()).toList();
        System.out.println(list12);

        //Collect names of people whose salary is divisible by 10,000.
        List<String> list13 = peopleList.stream().filter(people3 -> people3.getSalary() % 10000 == 0).map(People::getName).toList();
        System.out.println(list13);

        //Get person with the highest salary in "Pune".
        People people4 = peopleList.stream().filter(people3 -> people3.getCity().equalsIgnoreCase("pune")).max(Comparator.comparing(People::getSalary)).get();
        System.out.println(people4);

        //Create Map<PeopleId, People> keeping only the latest joined person for duplicate IDs.

        Map<Integer, People> collect19 = peopleList.stream()
                .collect(Collectors.toMap(
                        People::getId,
                        p -> p,
                        (p1, p2) -> p1.getJoiningDate().isAfter(p2.getJoiningDate()) ? p1 : p2
                ));

        System.out.println(collect19);

        //Get distinct salaries sorted in ascending order.
        List<Double> list14 = peopleList.stream().map(People::getSalary).distinct().sorted().toList();
        System.out.println(list14);

        //Filter people whose name length > 5.
        List<People> list15 = peopleList.stream().filter(people3 -> people3.getName().length() > 5).toList();
        System.out.println(list15);

        //Find common salaries among two different cities.
        List<Double> pune = new ArrayList<>(peopleList.stream().filter(people3 -> people3.getCity().equalsIgnoreCase("pune")).map(People::getSalary).toList());
        List<Double> delhi = new ArrayList<>(peopleList.stream().filter(people3 -> people3.getCity().equalsIgnoreCase("delhi")).map(People::getSalary).toList());
        pune.retainAll(delhi);
        System.out.println(pune);

        //Create Map<Year, List<People>> grouped by joining year.
        Map<Integer, List<People>> collect20 = peopleList.stream().collect(Collectors.groupingBy(people3 -> people3.getJoiningDate().getYear()));
        System.out.println(collect20);

        //List people grouped by month of joining.
        Map<Month, List<People>> collect21 = peopleList.stream().collect(Collectors.groupingBy(people3 -> people3.getJoiningDate().getMonth(),TreeMap::new,Collectors.toList()));
        System.out.println(collect21);

        //Print names of people who joined on weekends.
        List<String> collect22 = peopleList.stream().filter(people3 -> {
            DayOfWeek dayOfWeek = people3.getJoiningDate().getDayOfWeek();
            return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        }).map(People::getName).collect(Collectors.toList());
        System.out.println(collect22);

      //Get average salary of people whose names start with a vowel.
        List<Character> vowels = Arrays.asList('A', 'E', 'I', 'O', 'U');
        List<People> vowelNamePeople = peopleList.stream()
                .filter(p -> vowels.stream()
                        .anyMatch(v -> Character.toUpperCase(p.getName().charAt(0))== v))
                .toList();
        System.out.println(vowelNamePeople);

        //




    }
}
