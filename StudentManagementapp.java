 package studentManagementSystemsrc;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementapp {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Student> students = new ArrayList<>();

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n===== Student Management System ====");
			System.out.println("1.Add Student");
			System.out.println("2.Add Marks");
			System.out.println("3.Display All students");
			System.out.println("4.Search Student");
			System.out.println("5. Highest Average");
			System.out.println("6. Exit");
			System.out.println("Choose:");

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
				System.out.println("Goodbye!");
				input.close();
				return;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

	public static void addStudent() {
		System.out.println("Enter Student ID:  ");
		int id = input.nextInt();
		input.nextLine();

		// check if the ID is already used
		boolean found = false;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				found = true;
			}
		}
		if (found == true) {
			System.out.println("Error: This ID already exists.");
			return;
		}

		System.out.println("Enter Student Name:  ");
		String name = input.nextLine();

		if (name.equals("")) {
			System.out.println("Error: Name cannot be empty.");
			return;
		}

		Student student = new Student(id, name);
		students.add(student);
		System.out.println("Student Added Successfully.  ");
	}

	public static void addMarks() {
		System.out.println("Enter Student ID:  ");
		int id = input.nextInt();

		Student student = null;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				student = students.get(i);
			}
		}

		if (student == null) {
			System.out.println("Error: Student not found.");
			return;
		}

		System.out.println("Enter Mark (0-100):  ");
		int mark = input.nextInt();

		boolean added = student.addMark(mark);
		if (added == true) {
			System.out.println("Mark Added Successfully.");
		} else {
			System.out.println("Error: Mark must be between 0 and 100.");
		}
	}

	public static void displayStudent() {
		if (students.size() == 0) {
			System.out.println("No students found.");
			return;
		}
		for (int i = 0; i < students.size(); i++) {
			System.out.println("----------------------");
			students.get(i).printDetails();
		}
	}

	public static void searchStudent() {
		System.out.println("Enter Student ID:  ");
		int id = input.nextInt();

		Student student = null;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				student = students.get(i);
			}
		}

		if (student == null) {
			System.out.println("Student not found.");
		} else {
			student.printDetails();
		}
	}

	public static void highestAverang() {
		if (students.size() == 0) {
			System.out.println("No students found.");
			return;
		}

		Student top = students.get(0);
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).calculateAverage() > top.calculateAverage()) {
				top = students.get(i);
			}
		}

		System.out.println("Top Student:");
		top.printDetails();
	}
}