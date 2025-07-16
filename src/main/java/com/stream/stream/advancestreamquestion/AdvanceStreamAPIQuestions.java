package com.stream.stream.advancestreamquestion;

import com.stream.stream.entity.Staff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdvanceStreamAPIQuestions {
    public static void main(String[] args) {
        List<Staff> staffList= new ArrayList<>();

        staffList.add(new Staff(1, "Alice", 10, "HR", 55000, LocalDate.of(2020, 1, 15))); // Normal, duplicate name
        staffList.add(new Staff(2, "Bob", 20, "Finance", 70000, LocalDate.of(2019, 3, 10))); // High salary
        staffList.add(new Staff(3, "Charlie", 10, "HR", 40000, LocalDate.of(2021, 6, 25))); // Salary in 40k range
        staffList.add(new Staff(4, "David", 30, "IT", 60000, LocalDate.of(2018, 9, 12))); // Same salary as Ivan
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
    }
}
