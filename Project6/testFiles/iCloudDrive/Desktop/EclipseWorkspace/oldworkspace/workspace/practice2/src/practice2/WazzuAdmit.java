package practice2;

import java.util.Scanner;

public class WazzuAdmit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Washington State University Admission Program");
		System.out.print("What is your GPA? ");
		Double gpa = sc.nextDouble();
		System.out.println("What is your SAT score? ");
		int sat = sc.nextInt();
		if (gpa >= 1.8 || sat >=900) {
			System.out.println("You were accepted!");
		} else {
			System.out.println("You were rejected!");
		}

	}

}
