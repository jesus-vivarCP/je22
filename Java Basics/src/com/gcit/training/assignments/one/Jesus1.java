package com.gcit.training.assignments.one;
import java.util.*;

class Jesus1 {
	private int randomNumber = 0;
	private final int max = 100;
	private final int min = 1;
	private final int range = 10;
	private int maxRange, minRange;

	Scanner enterGuess = new Scanner(System.in);

	public Jesus1() {
		Random rand = new Random();

		randomNumber = rand.nextInt(max) + min; 
		maxRange = randomNumber + range; 
		minRange = randomNumber - range; 
	}

	public void startGame(int endGame, int guess) {
		if (guess >= minRange  && guess <= maxRange) {
			System.out.println("Number was: " + randomNumber);
			return ;
		} else  if (endGame-1==0) {
			System.out.println("Sorry");
			return ;
		}

		startGame(endGame-1, enterGuess.nextInt());
	}

}

class Jesus {
	public static void main(String[] argv) {
		Scanner enterGuess = new Scanner(System.in);
		Jesus1 game = new Jesus1();

		System.out.println("Guess my number");
		game.startGame(5,enterGuess.nextInt());

	}
}
