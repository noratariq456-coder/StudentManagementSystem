 package studentManagementSystemsrc;

import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private ArrayList<Integer> marks;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        marks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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
        int sum = 0;
        for (int i = 0; i < marks.size(); i++) {
            sum = sum + marks.get(i);
        }
        double average = sum / (double) marks.size();
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
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Number of Marks: " + marks.size());
        System.out.println("Average: " + calculateAverage());
        System.out.println("Grade: " + calculateGrade());
    }
}