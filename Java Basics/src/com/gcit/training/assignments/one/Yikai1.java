package com.gcit.training.assignments.one;

import java.util.*;

public class Yikai1 {
	public static void main(String[] args) {

		// generate a random number
		Random randomGenerator = new Random();
		int randomNum = randomGenerator.nextInt();

		// instantiate a user input scanner
		Scanner in = new Scanner(System.in);

		// give user chances to guess the number
		int chance = 5;
		while (chance > 0) {

			int userInput = in.nextInt();

			if (Math.abs(userInput - randomNum) <= 10) {
				System.out.printf("answer is %d", randomNum);
				break;
			}

			chance--;
		}
		in.close();

		System.out.println("Sorry");
	}
}
