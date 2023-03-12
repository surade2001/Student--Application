package com.studentdatabase.app;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// Ask how many new students we want to add
		System.out.print("NO OF STUDENTS? ");
		int n = s.nextInt();

		// Create an array of Student objects of size 'n'
		Student[] students = new Student[n];
		for (int i = 0; i < n; i++) {
			students[i] = new Student();
			int choice = -1;

			do {
				System.out.println("\n**************************\nENTER YOUR CHOICE\n1.Show Info\n2.Enrollment"
						+ "\n3.Pay Tuition\n4.Exit");
				choice = s.nextInt();
				switch (choice) {
				case 1:
					students[i].showInfo();
					break;
				case 2:
					students[i].courses();
					break;
				case 3:
					students[i].payTuition();
					break;
				case 4:
					System.out.println("\nTHANKS!!!");
					break;
				default:
					System.out.println("INVALID CHOICE! ENTER AGAIN!");
				}

			} while (choice != 4);

		}
		s.close();
	}

}

