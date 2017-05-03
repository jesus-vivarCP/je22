package com.gcit.training.assignments.one;

import java.util.*;

public class Yikai2 {
	public static void main(String[] args) {

		// create a Scanner
		Scanner in = new Scanner(System.in);

		// create a map whose key is playerID, value is playerName
		Map<Integer, String> playerNames = new HashMap<Integer, String>();
		collectPlayerNames(2, playerNames, in);

		// prompt user chips count
		int chipsCount = collectChipsCount(in);

		// play the game
		playGame(playerNames, chipsCount, in);

		// close scanner
		in.close();

	} // end of main

	private static void playGame(Map<Integer, String> playerNames, int chipsCount, Scanner in) {

		// start playing the game
		do {

			// initiate player status
			String[] names = new String[2];
			names[0] = playerNames.get(1);
			names[1] = playerNames.get(2);
			int[] chips = new int[2];

			int roundCounter = 0;
			int tempChipsCount = chipsCount;
			while (tempChipsCount > 0) {

				System.out.println("\n\n********************\n\n");

				// display player status
				System.out.printf("%s has %d chips.\n", names[0], chips[0]);
				System.out.printf("%s has %d chips.\n", names[1], chips[1]);

				// determine which player's turn
				int currentPlayer = -1;
				switch (roundCounter % 2) {
				case 0:
					System.out.printf("It is your turn, %s.\n", names[0]);
					currentPlayer = 0;
					break;
				case 1:
					System.out.printf("It is your turn, %s.\n", names[1]);
					currentPlayer = 1;
					break;
				}

				// display chips and possible move
				System.out.printf("There are %d chip%s remaining.\n", tempChipsCount, tempChipsCount > 1 ? "s" : "");
				int tempMax = tempChipsCount / 2;
				if (tempMax >= 1)
					System.out.printf("You may take any number of chips from 1 to %d. ", tempMax);
				else
					tempMax = 1;

				// prompt user chips to be taken
				System.out.printf("How many will you take, %s? ", names[currentPlayer]);
				int tempTake = in.nextInt();
				while (tempTake < 1 || tempTake > tempMax) {

					if (tempTake < 1)
						System.out.print("Illegal move: you must take at least one chip. ");
					else
						System.out.printf("Illegal move: you may not take more than %d chips. ", tempMax);

					System.out.printf("How many will you take, %s? ", names[currentPlayer]);
					tempTake = in.nextInt();
				}

				// change status of the game
				chips[currentPlayer] += tempTake;
				tempChipsCount -= tempTake;

				// determine winner if applicable
				if (tempChipsCount == 0) {

					// display player status
					System.out.printf("%s has %d chips.\n", names[0], chips[0]);
					System.out.printf("%s has %d chips.\n", names[1], chips[1]);

					// announce winner
					if (chips[0] % 2 == 0)
						System.out.printf("%s wins!\n\n\n", names[0]);
					else
						System.out.printf("%s wins!\n\n\n", names[1]);
					break;
				}

				roundCounter++;
			}

			System.out.print("Play another game? (y/n) ");
		} while (in.next().equals("y"));

	}

	private static void collectPlayerNames(int numOfPlayers, Map<Integer, String> playerNames, Scanner in) {

		// prompt player names
		int counter = 0;
		while (counter++ < numOfPlayers) {
			System.out.print("What is the name of the first player? ");
			String tempName = in.next();

			while (playerNames.containsValue(tempName)) {
				System.out.printf("Both players cannot be named %s. Enter a different name: ", tempName);
				tempName = in.next();
			}

			playerNames.put(counter, tempName);
		}

	}

	private static int collectChipsCount(Scanner in) {

		System.out.print("How many chips does the initial pile contain? ");

		int tempChipsCount = in.nextInt();
		while (tempChipsCount < 3 || tempChipsCount % 2 == 0) {
			if (tempChipsCount < 3) {
				System.out.print("You have to start with at least 3 chips. Choose another number: ");
			} else {
				System.out.print("You have to start with an odd number of chips. Choose another number: ");
			}

			tempChipsCount = in.nextInt();
			continue;
		}

		return tempChipsCount;
	}
}
