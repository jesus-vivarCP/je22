package com.gcit.training.assignments.one;
import java.util.*;

class GameStruc {
	private String player1="", player2="";
	private int numberOfChips;
	private int chipsForPlayer1, chipsForPlayer2; 
	private int maxchips, minchips;
	Scanner enter = new Scanner(System.in);

	public GameStruc() {
		game(true);
	}

	private void game(boolean start) {
		if(!start)
			return;

		player1= "";
		player2= "";
		numberOfChips=0;
		chipsForPlayer1=0;
		chipsForPlayer2=0;
		maxchips=0;
		minchips=1;

		System.out.println("What is the name of the first player?");
		varifyPlayerName("first player");
		chipPile();

		game(startGame(player1));

	}

	private void varifyPlayerName(String player) {
		String name="";

		name = enter.nextLine();

		if (player.compareTo("first player")==0) {
			player1 = name;
			System.out.println("What is the name of the second player?");
			varifyPlayerName("second player");
		} else if (name.toLowerCase().compareTo(player1.toLowerCase())==0) {
			System.out.println("Both players cannot be named " + name + ". Enter a different name: ");
			varifyPlayerName("second player");
		} else
			player2 = name;

	}

	private void chipPile() {
		System.out.println("How many chips does the initial pile contain?");
		varifyChipCount();
	}

	private void varifyChipCount() {
		numberOfChips = enter.nextInt();

		if (numberOfChips < 3) {
			System.out.println("You have to start with at least 3 chips. Choose another number: ");
			varifyChipCount();
		} else if (numberOfChips%2==0) {
			System.out.println("You have to start with an odd number of chips. Choose another number:");
			varifyChipCount();
		}

		maxchips = numberOfChips/2;
	}

	private boolean startGame(String player) {
		String next="";

		takenChips(player);

		if (varifyWinner()) {
			System.out.println("\nPlay another game?(y/n)");
			enter.nextLine();
			next = enter.nextLine();

			return next.compareTo("y")==0 ? true : false;

		}else {    
			next = turn(player);
			return startGame(next);
		}
	}

	private boolean varifyWinner() {
		if (numberOfChips == 0) {
			if (chipsForPlayer1%2==0)
				System.out.println(player1 + " wins!");
			else
				System.out.println(player2 + " wins!");

		}

		return numberOfChips==0 ? true : false;
	}

	private String turn(String player) {
		int chips = 0;

		System.out.println("It is your turn, " + player + ".");
		System.out.println("There are " + numberOfChips + " chips remaining.");

		if (numberOfChips!=1) 
			System.out.print("You may take any number of chips from " + minchips + " to " + maxchips + ". ");

		chips= varifyTakenChips(player);

		numberOfChips -= chips;     
		maxchips = numberOfChips/2;

		if(maxchips==0) 
			maxchips = 1;

		if (player.compareTo(player1)==0) { 
			chipsForPlayer1 += chips;
			return player2;
		} else {
			chipsForPlayer2 += chips;
			return player1;
		}
	}

	private int varifyTakenChips(String player) {
		int chips;

		System.out.println("How many will you take, " + player + "?");
		chips = enter.nextInt();

		if (chips < minchips) {
			System.out.println("Illegal move: you must take at least one chip.");
			return varifyTakenChips(player);
		} else if (chips > maxchips) {
			System.out.println("Illegal move: you may not take more than " + maxchips + " chips.");
			return varifyTakenChips(player);
		}

		return chips;
	}

	private void takenChips(String player) {
		if (player.compareTo(player1)==0 && numberOfChips==0) {
			playerState(player2, chipsForPlayer2);
			playerState(player1, chipsForPlayer1);
		} else if (player.compareTo(player2)==0 && numberOfChips==0) {
			playerState(player1, chipsForPlayer1);
			playerState(player2, chipsForPlayer2);
		} else if (player.compareTo(player1)==0) {
			System.out.println(player1 + " has " + chipsForPlayer1 + " chips.");
			System.out.println(player2 + " has " + chipsForPlayer2 + " chips.");
		} else {
			System.out.println(player2 + " has " + chipsForPlayer2 + " chips.");
			System.out.println(player1 + " has " + chipsForPlayer1 + " chips.");
		}
	}

	private void playerState(String player, int chips) {
		System.out.println(player + " has " + chips + " chips.");
	}
}

class Jesus2 {
	public static void main(String[] argv) {
		GameStruc game = new GameStruc();    
	}
}
