package assignment4_000738366;

import java.util.Scanner;

public class TestDiceCollection {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // *** input for number of Dices
        System.out.print("Enter number of Dices: ");
        int numberOfDices = sc.nextInt();
        int[] numberOfSides = new int[numberOfDices];
        //loop for number of sides' input
        for (int i = 0; i < numberOfDices; i++) {
            System.out.printf("Enter number of Sides for Dice %d: ", i + 1);
            numberOfSides[i] = sc.nextInt();
        }
        //Created a DiceCollection object with 2 parameters
        DiceCollection game = new DiceCollection(numberOfDices, numberOfSides);
        System.out.println(game);

        System.out.print("1=roll once, 2=roll 100000 times, 3=quit: ");
        // *** input for rolling Dices or quit
        int answer = sc.nextInt();
        if (answer == 1 || answer == 2 || answer == 3) {
            while (answer != 3) {
                if (answer == 1) {
                    System.out.println(game);
                    System.out.print("1=roll once, 2=roll 100000 times, 3=quit: ");
                    answer = sc.nextInt();
                }
                if (answer == 2) {
                    game.histogram();
                    System.out.println(game);
                    System.out.print("1=roll once, 2=roll 100000 times, 3=quit: ");
                    answer = sc.nextInt();
                }
            }
            if (answer == 3) {
                System.out.println("Bye!!!");
            }
        }
    }
}

