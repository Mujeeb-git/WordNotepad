package test.test;

import java.util.Scanner;

public class StringIntroduction {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		/* Enter your code here. Print output to STDOUT. */
		System.out.println(A.length() + B.length());
		int lowLength = (A.length() < B.length() ? A.length() : B.length());

		if (A.compareTo(B) > 0) {
			System.out.println("Yes");

		} else if (A.compareTo(B) < 0) {
			System.out.println("No");

		} else {
			System.out.println("No");

		}

		if (A.length() > 1 && B.length() > 1) {
			System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1).toLowerCase() + "\t"
					+ B.substring(0, 1).toUpperCase() + B.substring(1).toLowerCase());
		} else if (A.length() > 1 && B.length() < 1) {
			System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1).toLowerCase() + "\t"
					+ B.substring(0, 1).toUpperCase());
		} else if (A.length() < 1 && B.length() > 1) {
			System.out.println(A.substring(0, 1).toUpperCase() + "\t" + B.substring(0, 1).toUpperCase()
					+ B.substring(1).toLowerCase());
		} else if (A.length() < 1 && B.length() < 1) {
			System.out.println(A.substring(0, 1).toUpperCase() + "\t" + B.substring(0, 1).toUpperCase());
		}

	}
}
