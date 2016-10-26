/**
 * Brian Donovan
 * 915106202
 * 10/14/16
 * 1068-001 Lab 7
 * This program will allow 2 users to play the Nim game
 */
package nimgame2;

import java.util.Random;
import java.util.Scanner;

class Game {

    //object and variable initializations
    Random rand = new Random(); //random object to randomise piles
    Scanner keyboard = new Scanner(System.in); //scanner object to read user inputs
    String play1;  // new string to represent player 1
    String play2;  // new string to represent player 2
    int a = rand.nextInt(6) + 5;  // new ints to represent a pile with random 
    int b = rand.nextInt(6) + 5;  // values for the 3 piles
    int c = rand.nextInt(6) + 5;
    int subtract;   // value entered to take counters away
    char choice;    // pile player chooses
    int count = 1;  // counter to switch between players

    public void createPlayers() { // creates 2 players with user input names
        // players 1 & 2 name entries
        System.out.print("Player 1 enter your name: ");
        play1 = keyboard.nextLine();
        System.out.print("Player 2 enter your name: ");
        play2 = keyboard.nextLine();
    }

    public void nonNegative() { // prevents non negative or zero entries
        while (subtract < 1) {
            System.out.print("You must choose at least one. How many? ");
            subtract = keyboard.nextInt();
        }
    }

    public void notGreater() { //prevents input numbers greate than amount in pile
        if (choice == 'A') { //checks for pile a
            while (subtract > a) {
                System.out.print("A doesn't have that many. Try again: ");
                subtract = keyboard.nextInt();
            }
            nonNegative();
        } else if (choice == 'B') { // checks for pile b
            while (subtract > b) {
                System.out.print("B doesn't have that many. Try again: ");
                subtract = keyboard.nextInt();
            }
            nonNegative();
        } else if (choice == 'C') { // checks for pile c
            while (subtract > c) {
                System.out.print("C doesn't have that many. Try again: ");
                subtract = keyboard.nextInt();
            }
            nonNegative();
        }

    }

    public void playGame() { //lets users play Nim's game
        // condition to keep game going until winner determined
        createPlayers();
        while (a != 0 || b != 0 || c != 0) {
            player1();
            player2();
        }
    }

    public void player1() { // actions for player 1's turn
        if (count % 2 != 0) { // determines when it is player 1's turn

            // displays piles and counters in piles
            System.out.print("A: ");
            for (int i = 0; i < a; i++) {
                System.out.print("*");
            }
            System.out.println();
            System.out.print("B: ");
            for (int i = 0; i < b; i++) {
                System.out.print("*");
            }
            System.out.println();
            System.out.print("C: ");
            for (int i = 0; i < c; i++) {
                System.out.print("*");
            }
            System.out.println();

            // player 1's pile choice
            System.out.print("\n" + play1 + " choose a pile: ");
            choice = keyboard.next().toUpperCase().charAt(0);

            // while and if statements prevent invalid entries
            while (choice != 'A' && choice != 'B' && choice != 'C') {
                System.out.print("Please enter a valid choice: ");
                choice = keyboard.next().toUpperCase().charAt(0);
            }
            if (choice == 'A' && a == 0 || choice == 'B' && b == 0 || choice == 'C' && c == 0) {
                System.out.print("Nice try, " + play1 + ". That pile is empty. Choose again: ");
                choice = keyboard.next().toUpperCase().charAt(0);
            }

            // determines counters to be taken from pile
            System.out.print("How many to remove from pile " + play1 + ": ");
            subtract = keyboard.nextInt();

            /**
             * switch statement executes a while test to ensure the number to
             * subtract is less than or equal to the amount of counters while
             * also being a non negative or zero entry then subtracts the
             * counters if valid entry detected.
             */
            switch (choice) {
                case 'A':
                    while (subtract < 1 || subtract > a) {
                        nonNegative();
                        notGreater();
                    }
                    a -= subtract;
                    break;

                case 'B':
                    while (subtract < 1 || subtract > b) {
                        nonNegative();
                        notGreater();
                    }
                    b -= subtract;
                    break;

                case 'C':
                    while (subtract < 1 || subtract > c) {
                        nonNegative();
                        notGreater();
                    }
                    c -= subtract;
                    break;
            }
            System.out.println();
            count++; // increases count to alternate players

            /**
             * if statement displays the amount of counters then determines if a
             * player has already won. If a player has won, a message informs
             * the players and exits th program.
             */
            if ((a <= 0 && b <= 0 && c != 0) || (a <= 0 && c <= 0 && b != 0) || (b <= 0 && c <= 0 && a != 0)) {
                System.out.print("A: ");
                for (int i = 0; i < a; i++) {
                    System.out.print("*");
                }
                System.out.println();
                System.out.print("B: ");
                for (int i = 0; i < b; i++) {
                    System.out.print("*");
                }
                System.out.println();
                System.out.print("C: ");
                for (int i = 0; i < c; i++) {
                    System.out.print("*");
                }
                System.out.println();
                System.out.println("\n" + play2 + " you must take the remaining "
                        + "counter so you lose. " + play1 + " wins!");
                System.exit(0);
            }

        }
    }

    public void player2() {  // actions for player 2's turn

        if (count % 2 == 0) {  // determines when it is player 2's turn

            // displays piles and counters in piles
            System.out.print("A: ");
            for (int i = 0; i < a; i++) {
                System.out.print("*");
            }
            System.out.println();
            System.out.print("B: ");
            for (int i = 0; i < b; i++) {
                System.out.print("*");
            }
            System.out.println();
            System.out.print("C: ");
            for (int i = 0; i < c; i++) {
                System.out.print("*");
            }
            System.out.println();

            // player 2's pile choice
            System.out.print("\n" + play2 + " choose a pile: ");
            choice = keyboard.next().toUpperCase().charAt(0);

            // while and if statements prevent invalid entries
            while (choice != 'A' && choice != 'B' && choice != 'C') {
                System.out.print("Please enter a valid choice: ");
                choice = keyboard.next().toUpperCase().charAt(0);
            }
            if (choice == 'A' && a == 0 || choice == 'B' && b == 0 || choice == 'C' && c == 0) {
                System.out.print("Nice try, " + play2 + ". That pile is empty. Choose again: ");
                choice = keyboard.next().toUpperCase().charAt(0);
            }

            // determines counters to be taken from pile
            System.out.print("How many to remove from pile " + play2 + ": ");
            subtract = keyboard.nextInt();

            /**
             * switch statement executes a while test to ensure the number to
             * subtract is less than or equal to the amount of counters while
             * also being a non negative or zero entry then subtracts the
             * counters if valid entry detected.
             */
            switch (choice) {
                case 'A':
                    while (subtract < 1 || subtract > a) {
                        nonNegative();
                        notGreater();
                    }
                    a -= subtract;
                    break;

                case 'B':
                    while (subtract < 1 || subtract > b) {
                        nonNegative();
                        notGreater();
                    }
                    b -= subtract;
                    break;

                case 'C':
                    while (subtract < 1 || subtract > c) {
                        nonNegative();
                        notGreater();
                    }
                    c -= subtract;
                    break;
            }
            System.out.println();
            count++; // increases count to alternate players

            /**
             * if statement displays the amount of counters then determines if a
             * player has already won. If a player has won, a message informs
             * the players and exits th program.
             */
            if ((a <= 0 && b <= 0 && c != 0) || (a <= 0 && c <= 0 && b != 0) || (b <= 0 && c <= 0 && a != 0)) {
                System.out.print("A: ");
                for (int i = 0; i < a; i++) {
                    System.out.print("*");
                }
                System.out.println();
                System.out.print("B: ");
                for (int i = 0; i < b; i++) {
                    System.out.print("*");
                }
                System.out.println();
                System.out.print("C: ");
                for (int i = 0; i < c; i++) {
                    System.out.print("*");
                }
                System.out.println();
                System.out.println("\n" + play1 + " you must take the remaining "
                        + "counter so you lose. " + play2 + " wins!");
                System.exit(0);
            }
        }
    }
}

public class NimGame2 {

    public static void main(String[] args) {
        Game nim = new Game();  // creates a new Game object
        nim.playGame();  // operates the game and allows 2 players
    }

}
