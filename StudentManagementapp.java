package studentManagementSystemsrc;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementapp {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n---------- Student Records System ----------");
            System.out.println("[1] Register a new student");
            System.out.println("[2] Record a mark for a student");
            System.out.println("[3] View all students");
            System.out.println("[4] Look up a student by ID");
            System.out.println("[5] Find the top-performing student");
            System.out.println("[6] Quit");
            System.out.print("Select an option: ");

            int choice = input.nextInt();

            switch (choice) {

            case 1:
                addStudent();
                break;

            case 2:
                addMarks();
                break;

            case 3:
                displayStudent();
                break;

            case 4:
                searchStudent();
                break;

            case 5:
                highestAverang();
                break;

            case 6:
                System.out.println("Program closed. See you next time!");
                input.close();
                return;

            default:
                System.out.println("That option doesn't exist, try again.");
                break;
            }
        }
    }

    public static void addStudent() {

        System.out.print("Student ID: ");
        int id = input.nextInt();
        input.nextLine();

        boolean idTaken = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                idTaken = true;
            }
        }

        if (idTaken == true) {
            System.out.println("This ID is already registered, use a different one.");
            return;
        }

        System.out.print("Full name: ");
        String name = input.nextLine();

        System.out.println("Enter student Age :");
        int age = input.nextInt();

        if (name.equals("")) {
            System.out.println("Name field can't stay empty.");
            return;
        }

        Student student = new Student(id, name, age);
        students.add(student);

        System.out.println("New student registered.");
    }

    public static void addMarks() {

        System.out.print("Which student ID? ");
        int id = input.nextInt();

        Student student = null;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                student = students.get(i);
            }
        }

        if (student == null) {
            System.out.println("Couldn't find a student with that ID.");
            return;
        }

        System.out.print("Mark to record (0-100): ");
        int mark = input.nextInt();

        boolean added = student.addMark(mark);

        if (added == true) {
            System.out.println("Mark saved.");
        } else {
            System.out.println("That mark is out of range, must be 0-100.");
        }
    }

    public static void displayStudent() {

        if (students.size() == 0) {
            System.out.println("There are no students registered yet.");
            return;
        }

        System.out.println("\nList of registered students:");

        for (int i = 0; i < students.size(); i++) {
            System.out.println("=====================");
            students.get(i).printDetails();
        }
    }

    public static void searchStudent() {

        System.out.print("Enter the ID you're looking for: ");
        int id = input.nextInt();

        Student student = null;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                student = students.get(i);
            }
        }

        if (student == null) {
            System.out.println("No student matches that ID.");
        } else {
            student.printDetails();
        }
    }

    public static void highestAverang() {

        if (students.size() == 0) {
            System.out.println("There are no students registered yet.");
            return;
        }

        Student top = students.get(0);

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).calculateAverage() > top.calculateAverage()) {
                top = students.get(i);
            }
        }

        System.out.println("\nBest performing student:");
        top.printDetails();
    }
}
