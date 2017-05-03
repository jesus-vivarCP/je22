/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcit.training.assignments.one;

import java.util.Random;
import java.util.Scanner;

//By Charles
public class Tang1 {
    int range  = 100;
    int target = 0;
    int diff   = 10;
    public static void main(String[] args) {

        Tang1 game = new Tang1();
        Scanner sc = new Scanner(System.in);
        game.randomNum();
        
        System.out.print("Walcome! Please enter a number:\t->");
        for (int i = 0; i < 5; i++) {
            boolean result = game.checkNum(Integer.parseInt(sc.next()));
            if (result) {
                System.out.print("\nYou win!");
                return;
            }
            else if (i < 4) {
                System.out.print("Please try again. Thank you!\n");
            }
            else {
                 System.out.print("Sorry.");
            }
        }
        
    }

    boolean checkNum(int i) {
        if (Math.abs(i - target) <= diff) {
            System.out.print("The correct answer is: " + target);
            return true;
        } else {  
            return false;
        }
    }

    void randomNum() {
        Random rm = new Random();
        target = rm.nextInt(range);
    }

}
