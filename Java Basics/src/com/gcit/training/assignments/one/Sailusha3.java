package com.gcit.training.assignments.one;
import java.util.Scanner;
public class Sailusha3 {
    public static void main(String[] args) {
        int count = 5;
        int guessNumber =(int) (Math.random()*100);
        System.out.println("Welcome to the GuessNumber");
        while (count > 0) {
            System.out.println("Enter your choice");
            Scanner obj = new Scanner(System.in);
            if (obj.hasNextInt()) {
                int input = obj.nextInt();
                if (Math.abs(input - guessNumber) < 10) {
                    System.out.println("WON THE GAME");
                    System.out.println("Guess Number:" + guessNumber);
                    break;

                } else {
                    count = count - 1;
                    System.out.println("Sorry!!! wrong guess");
                    System.out.println("You have " + count + " chances to guess");
                }
            } else {
                System.out.println("Invalid entry");
            }
        }
        System.out.println("Guess Number is:" +guessNumber);

    }
}
