package com.gcit.training.assignments.one;
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Vignesh2 {
    public static void main(String[] args) {
        boolean yes = true;
        Scanner reader = null;
        while (yes == true) {
            reader = new Scanner(System.in);
            System.out.println("What is the name of the first player?");
            String playa1 = reader.nextLine();

            System.out.println("What is the name of the first player?");
            String playa2 = reader.nextLine();

            while (playa1.equals(playa2)) {
                System.out.println("Both players cannot be named " + playa1 + "! Enter a different name:");
                playa2 = reader.nextLine();
            }

            System.out.println("How many chips does the initial pile contain?");
            int totalChips = reader.nextInt();
            while (totalChips < 3) {
                System.out.println("You have to at least start with 3 chips. Choose another number: ");
                totalChips = reader.nextInt();
            }

            while (totalChips % 2 == 0) {
                System.out.println("You have to start with an odd number of chips. Choose another number");
                totalChips = reader.nextInt();
            }

            int playa1Cnt = 0;
            int playa2Cnt = 0;
            boolean playOne = true;

            while (totalChips != 0) {
                System.out.println(playa1 + " has " + playa1Cnt + " chips!");
                System.out.println(playa2 + " has " + playa2Cnt + " chips!");
                if (playOne == true) {
                    System.out.println("It is your turn, " + playa1 + "!");
                    if (totalChips == 1) {
                        System.out.println("There is 1 chip remaining!");
                        System.out.println("How many will you take, " + playa1 + "?");
                        int thisTurn = reader.nextInt();
                        while (thisTurn != 1) {
                            System.out.println("You only have one chip left. You need to take it, " + playa1 + "!");
                            thisTurn = reader.nextInt();
                        }
                        totalChips -= thisTurn;
                        playa1Cnt += thisTurn;
                        continue;
                    }
                    System.out.println("There are " + totalChips + " remaining!");
                    if (totalChips % 2 != 0) {
                        System.out.println("You may take any number of chips from 1 to " + (totalChips - 1) / 2 + "!");
                        System.out.println("How many will you take, " + playa1 + "?");
                        int thisTurn = reader.nextInt();
                        while (thisTurn < 1) {
                            System.out.println("Illegal move: you must take at least one chip!");
                            System.out.println("How many will you take, " + playa1 + "?");
                            thisTurn = reader.nextInt();
                        }
                        while (thisTurn > (totalChips - 1) / 2) {
                            System.out.println("Illegal move: you may not take more than " + (totalChips - 1) / 2 + " chips!");
                            System.out.println("How many will you take, " + playa1 + "?");
                            thisTurn = reader.nextInt();
                        }
                        totalChips = totalChips - thisTurn;
                        playa1Cnt = playa1Cnt + thisTurn;
                        playOne = false;
                    } else {
                        System.out.println("You may take any number of chips from 1 to " + totalChips / 2 + "!");
                        System.out.println("How many will you take, " + playa1 + "?");
                        int thisTurn = reader.nextInt();
                        while (thisTurn < 1) {
                            System.out.println("Illegal move: you must take at least one chip!");
                            System.out.println("How many will you take, " + playa1 + "?");
                            thisTurn = reader.nextInt();
                        }
                        while (thisTurn > totalChips / 2) {
                            System.out.println("Illegal move: you may not take more than " + totalChips / 2 + " chips!");
                            System.out.println("How many will you take, " + playa1 + "?");
                            thisTurn = reader.nextInt();
                        }
                        totalChips = totalChips - thisTurn;
                        playa1Cnt = playa1Cnt + thisTurn;
                        playOne = false;
                    }
                } else {
                    System.out.println("It is your turn, " + playa2 + "!");
                    if (totalChips == 1) {
                        System.out.println("There is 1 chip remaining!");
                        System.out.println("How many will you take, " + playa2 + "?");
                        int thisTurn = reader.nextInt();
                        while (thisTurn != 1) {
                            System.out.println("You only have one chip left. You need to take it, " + playa2 + "!");
                            thisTurn = reader.nextInt();
                        }
                        totalChips -= thisTurn;
                        playa2Cnt += thisTurn;
                        continue;
                    }
                    System.out.println("There are " + totalChips + " remaining!");
                    if (totalChips % 2 != 0) {
                        System.out.println("You may take any number of chips from 1 to " + (totalChips - 1) / 2 + "!");
                        System.out.println("How many will you take, " + playa2 + "?");
                        int thisTurn = reader.nextInt();
                        while (thisTurn < 1) {
                            System.out.println("Illegal move: you must take at least one chip!");
                            System.out.println("How many will you take, " + playa2 + "?");
                            thisTurn = reader.nextInt();
                        }
                        while (thisTurn > (totalChips - 1) / 2) {
                            System.out.println("Illegal move: you may not take more than " + (totalChips - 1) / 2 + " chips!");
                            System.out.println("How many will you take, " + playa2 + "?");
                            thisTurn = reader.nextInt();
                        }
                        totalChips = totalChips - thisTurn;
                        playa2Cnt = playa2Cnt + thisTurn;
                        playOne = true;
                    } else {
                        System.out.println("You may take any number of chips from 1 to " + totalChips / 2 + "!");
                        System.out.println("How many will you take, " + playa2 + "?");
                        int thisTurn = reader.nextInt();
                        while (thisTurn < 1) {
                            System.out.println("Illegal move: you must take at least one chip!");
                            System.out.println("How many will you take, " + playa2 + "?");
                            thisTurn = reader.nextInt();
                        }
                        while (thisTurn > totalChips / 2) {
                            System.out.println("Illegal move: you may not take more than " + totalChips / 2 + " chips!");
                            System.out.println("How many will you take, " + playa2 + "?");
                            thisTurn = reader.nextInt();
                        }
                        totalChips = totalChips - thisTurn;
                        playa2Cnt = playa2Cnt + thisTurn;
                        playOne = true;
                    }
                }
            }

            System.out.println(playa1 + " has " + playa1Cnt + " chip(s)!");
            System.out.println(playa2 + " has " + playa2Cnt + " chip(s)!");

            if (playa1Cnt % 2 == 0) System.out.println(playa1 + " wins!");
            else System.out.println(playa2 + " wins!");

            System.out.println("Play another game? y/n");
            String a = reader.nextLine();
            while (!a.equals("y") && !a.equals("n")) {
                System.out.println("Invalid input. Try again!");
                a = reader.nextLine();
            }
            if (a.equals("n")) yes = false;

        }

    }
}





