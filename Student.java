package studentManagementSystemsrc;

import java.util.ArrayList;

public class Student {

    private int id;
    private int age;
    private String name;
    private ArrayList<Integer> marks;

    public Student(int id2, String name2, int age2) {
        this.id = id2;
        this.name = name2;
        this.age = age2;
        marks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean addMark(int mark) {
        if (mark < 0 || mark > 100) {
            return false;
        }
        marks.add(mark);
        return true;
    }

    public double calculateAverage() {
        if (marks.size() == 0) {
            return 0;
        }

        int total = 0;

        for (int i = 0; i < marks.size(); i++) {
            total = total + marks.get(i);
        }

        double average = total / (double) marks.size();
        return average;
    }

    public String calculateGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public void printDetails() {
        System.out.println("Student ID   -> " + id);
        System.out.println("Name         -> " + name);
        System.out.println("Age          -> " + age);
        System.out.println("Marks Count  -> " + marks.size());
        System.out.println("Average      -> " + calculateAverage());
        System.out.println("Final Grade  -> " + calculateGrade());
    }
}
