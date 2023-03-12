package com.studentdatabase.app;

import java.util.Scanner;

public class Student {
	public Scanner s = new Scanner(System.in);

	// Setting up the variables
	// Defined as 'private' so that these cannot be accessed directly
	private static int noOfStudents = 0;
	private String name;
	private int year;
	private String id;
	private int balance;
	private String[] coursesArr = new String[5];

	// Constructor to receive the student's name and year
	public Student() {
		noOfStudents++;

		System.out.print("Enter full name: ");
		this.name = s.nextLine();
		System.out.println("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior");
		System.out.print("Enter year: ");
		this.year = s.nextInt();

		// Setting the student's ID
		this.id = generate_ID();
	}

	// Generating the 5-digit unique ID
	private String generate_ID() {
		String id = this.year + "";
		int nod = (int) Math.floor(Math.log10(noOfStudents) + 1);
		for (int i = 0; i < 4 - nod; i++) {
			id += "0";
		}
		id += noOfStudents;
		return id;
	}

	// Enroll in courses
	public void courses() {
		int flag = -1;

		System.out.println("ENTER THE COURSES YOU WISH TO ENTER\n" + "1.History\n2.Maths\n3.English\n4.Chemistry\n"
				+ "5.Comp Science");

		while (true) {
			System.out.println("ENTER CODE OF COURSE TO ENROLL // -1 TO EXIT: ");
			int choice = s.nextInt();

			if (choice == -1) {
				break;
			} else {
				if (choice > 0 && choice < 6) {
					flag++;
					this.balance += 600;
					switch (choice) {
					case 1:
						this.coursesArr[flag] = "History";
						break;
					case 2:
						this.coursesArr[flag] = "Maths";
						break;
					case 3:
						this.coursesArr[flag] = "English";
						break;
					case 4:
						this.coursesArr[flag] = "Chemistry";
						break;
					case 5:
						this.coursesArr[flag] = "Comp Science";
						break;
					}
				} else {
					System.out.println("ENTER A VALID CHOICE!");
				}
			}
		}
	}

	// View balance
	private void viewBalance() {
		System.out.println("Your Balance is: $" + this.balance);
	}

	// Pay Tuition
	public void payTuition() {
		this.viewBalance();
		System.out.print("Enter the amount you want to pay: $");
		int payment = s.nextInt();
		this.balance = this.balance - payment;
		System.out.println("Thanks for the payment!");
		this.viewBalance();
	}

	// Returning the student's courses
	private String showCourses() {
		String str = "";
		for (String course : this.coursesArr) {
			if (course != null)
				str += course + ", ";
		}
		return str;
	}

	// Displaying the student's information
	public void showInfo() {
		System.out.println("Name: " + this.name + "\nID: " + this.id + "\nCourses Enrolled: " + this.showCourses());
		this.viewBalance();

	}

}
