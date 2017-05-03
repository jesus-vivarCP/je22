package com.gcit.training.assignments.one;
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Vignesh1 {
    public static void main(String[] args) {
        int a  = 50;
        int cnt = 0;

        Scanner reader = new  Scanner(System.in);
        System.out.println("Enter a number: ");
        int b = reader.nextInt();
        while (cnt < 4) {

            if (b >= 40 && b <= 60) {
                System.out.println("You guessed it right. The number around which you were supposed to guess was 50");
                break;
            } else {
                cnt++;
                System.out.println("Sorry. Wrong. Guess again!");
                b = reader.nextInt();
            }
        }
        System.out.println(cnt);
        if (cnt >= 4) System.out.println("Wrong and sorry, you are out of chances!");

    }
}





