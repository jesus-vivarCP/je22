package com.gcit.training.assignments.one;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sailusha1 {
    List<Sailusha2> playerList = new ArrayList<>();
    int turn = 0;
    int totalCount = 0;

    public static void main(String[] args) {
        Sailusha1 obj = new Sailusha1();
        obj.createPlayers();
        obj.initializeChipCount();
        obj.startGame();
        obj.displayWinner();
    }

    private void createPlayers() {
        Scanner obj = new Scanner(System.in);
        while (playerList.size() < 2) {
            System.out.println("Enter Player" + (playerList.size() + 1) + " Name: ");
            Sailusha2 p = null;
            try {
                p = Sailusha2.createPlayer(obj.next());
            } catch (Sailusha4 e) {
                System.out.println(e.getMessage());
            }
            if (p == null) {
                System.out.println("Illegal move:");
            } else if (playerList.contains(p)) {
                System.out.println("Both players cannot be named " + p.getName() + ".");
            } else {
                playerList.add(p);
            }

        }
    }

    private void initializeChipCount() {

        Scanner obj = new Scanner(System.in);
        System.out.println("How many chips does the initial pile contain? ");
        while (totalCount < 5 || totalCount % 2 == 0) {
            if (!obj.hasNextInt()) {
                System.out.println("Invalid data: Choose number:");
                obj.next();
                continue;
            }
            totalCount = obj.nextInt();
            if (totalCount < 5) {
                System.out.println("You have to start with at least 3 chips.  Choose another number: ");
            } else if (totalCount % 2 == 0) {
                   System.out.println("You have to start with an odd number of chips.  Choose another number:");
                }
            }
        }

    private void startGame() {
        boolean flag=true;
        while (flag) {

            System.out.println("**************");
            System.out.println(playerList.get(turn).getName() + " has " + playerList.get(turn).getChipCount() + " chips. ");
            System.out.println(playerList.get(1 - turn).getName() + " has " + playerList.get(1 - turn).getChipCount() + " chips. ");
            System.out.println("It is your turn, " + playerList.get(turn).getName() + ". ");
            if(totalCount==1){
                flag=false;
                System.out.println("But there is only one chip remaining, so");
                playerList.get(turn).addChipCount(1);

            }
            else {
                System.out.println("There are " + totalCount + " chips remaining. ");
                getTurnCount();
            }

        }



    }

    private void getTurnCount() {
        int num = 0;
        int count = (totalCount % 2 == 0) ? (totalCount / 2) : (totalCount - 1) / 2;
        System.out.println("You may take any number of chips from 1 to " + count);
        Scanner obj = new Scanner(System.in);

        while (num < 1 || num > count) {
            System.out.println("How many will you take, " + playerList.get(turn).getName() + " ?");
            if (!obj.hasNextInt()) {
                System.out.println("Illegal move:only Integers are allowed");
                return;
            }
            num = obj.nextInt();
            if (num < 1) {
                System.out.println("Illegal move: you must take at least one chip. ");
            } else if (num > count) {
                System.out.println("Illegal move: you may not take more than " + count + " chips.  ");
            } else {
                totalCount = totalCount - num;
                playerList.get(turn).addChipCount(num);
                turn = 1 - turn;
            }
        }

    }

    private void displayWinner() {
        if (totalCount==1) {
            playerList.forEach(p ->System.out.println(p.getName() + " has " + p.getChipCount() +" chips. "));
            for (Sailusha2 p : playerList) {
                if (p.getChipCount() % 2 == 0) {
                    System.out.println(p.getName() + " wins!!!!!");
                }
            }
        }

    }


}