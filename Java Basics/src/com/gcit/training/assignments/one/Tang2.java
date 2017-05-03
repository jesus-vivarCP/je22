/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcit.training.assignments.one;
//By Charles

import java.util.Scanner;

public class Tang2 {

    static int chipsPool  = 0;
    String player1 = "",
           player2 = "";
    int    player1Chips = 0,
           player2Chips = 0;
    
    public static void main(String[] args) {
        Tang2 chipgame = new Tang2();
        for(;;){
            boolean newGameFlag = false;
            chipgame.initSetup();
            chipgame.run();
            newGameFlag = chipgame.finalStage();
            if (newGameFlag) continue;
            else break;
        }
        
    }
    
    void initSetup(){
        Scanner sc = new Scanner(System.in);
        player1Chips = 0;
        player2Chips = 0;
        chipsPool = 0;
        System.out.print("What is the name of the first player?\t->");
        player1 = sc.next();
        System.out.print("What is the name of the second player?\t->");
        player2 = sc.next();
        while (player1.equalsIgnoreCase(player2)) {
            System.out.print("Both player cannot be named " + player1
                    + ". Enter a different name:\t->");
            player2 = sc.next();
        }
        System.out.print("How many chips does the initial pile conatin?\t->");
        chipsPool = sc.nextInt();
        while (chipsPool < 3 || chipsPool % 2 != 1) {
            if (chipsPool < 3 ) {
            System.out.print("You have to start with at least 3 chips. " 
                    + "Choose another number:\t->");
            chipsPool = sc.nextInt();
            }
            else if (chipsPool % 2 != 1) {
            System.out.print("You have to start with an odd number of chips."
                    + "Choose another number:\t->");
            chipsPool = sc.nextInt();
            }
        }
    }
    
    void playerRemoveChips(String player){
        Scanner sc = new Scanner(System.in);
        int currMaxRemovable = currentMaxRemovable();
        int currChipsRemove = 0;
        
        if (player.equalsIgnoreCase(player1)) {
            System.out.print(player1 + " has " + player1Chips + " chips.");
            System.out.print(player2 + " has " + player2Chips + " chips.");
        }
        else {
            System.out.print(player2 + " has " + player2Chips + " chips.");
            System.out.print(player1 + " has " + player1Chips + " chips.");
        }    
        System.out.print("It is your turn, " + player + ". ");
        System.out.print("There are " + chipsPool + " chips remaining. \n");
        System.out.print("You may take any number of chips from 1 to " 
                + currMaxRemovable + ". How many will you take, " 
                + player + "?\t->");
        do{ 
            currChipsRemove = sc.nextInt();
        } while (!checkRemovable(currChipsRemove, currMaxRemovable, player));
        chipsPool -= currChipsRemove;
        if (player.equalsIgnoreCase(player1)) {
            player1Chips += currChipsRemove;
        }
        else {
            player2Chips += currChipsRemove;
        }
        
    }
/*
    void playerTwoRemoveChips(){
        Scanner sc = new Scanner(System.in);
        int currMaxRemovable = currentMaxRemovable();
        int currChipsRemove = 0;
        System.out.print(player1 + " has " + player1Chips + " chips.");
        System.out.print(player2 + " has " + player2Chips + " chips.");
        System.out.print("It is your turn, " + player2 + ". ");
        System.out.print("There are " + chipsPool + " chips remaining. \n");
        System.out.print("You may take any number of chips from 1 to " 
                + currMaxRemovable + ". How many will you take, " 
                + player2 + "?");
        do{ 
            currChipsRemove = sc.nextInt();
        } while (!checkRemovement(currChipsRemove, currMaxRemovable, player2));
        chipsPool -= currChipsRemove;
        player2Chips += currChipsRemove;
    }
*/    
    boolean checkRemovable(int i, int limit, String player) {
        if(i < 1) {
            System.out.print("Illegal move: you must take at least one chip.");
            System.out.print("How many will you take, " + player + "?\t->");
            return false;
        }
        if(i > limit) {
            System.out.print("Illegal move: you can not take over " + limit + " chips");
            System.out.print("How many will you take, " + player + "?\t->");
            return false;
        }
        return true;
    }
    
    int currentMaxRemovable(){
        if (chipsPool == 1) {
            return 1;
        }
        else if (chipsPool % 2 == 1){
            return (chipsPool-1) / 2;
        }
        else {
            return (chipsPool / 2);
        }
    }
    
    void run(){
        while (chipsPool >= 1) {
            if (chipsPool < 1) break;
            playerRemoveChips(player1);
            if (chipsPool < 1) break;
            playerRemoveChips(player2);
        }
    }
    
    boolean finalStage(){
        String winner = "";
        Scanner sc = new Scanner(System.in);
        System.out.print(player1 + " has " + player1Chips + " chips \n");
        System.out.print(player2 + " has " + player2Chips + " chips \n");
        winner = player1Chips > player2Chips ? player1 : player2;
        System.out.print("Winner is: " + winner + "\n");
        System.out.print("Player another game?(y/n)\t->");
        return sc.next().equalsIgnoreCase("y");
    }
    
}
