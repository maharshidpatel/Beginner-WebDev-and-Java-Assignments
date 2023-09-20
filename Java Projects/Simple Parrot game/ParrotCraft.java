package assignment2_000738366;

import java.util.Scanner;

/**
 * The ParrotCraft class implements a view that consists of a text-based conversation with the user.
 * ParrotCraft is a simple game world loosely based on MineCraft Parrot objects.
 * Created on Feb 01, 2023
 *
 * @author Maharshi Patel
 */
public class ParrotCraft {
    /**
     * A method to test the object Parrot
     *
     * @param args unused
     */
    public static void main(String[] args) {
        //created 3 Parrots and set names
        Parrot p1 = new Parrot();
        p1.setName("Lola");
        Parrot p2 = new Parrot();
        p2.setName("Mark");
        Parrot p3 = new Parrot();
        p3.setName("Popat");

        //A String representation of a all 3 Parrots
        System.out.println("1." + p1);
        System.out.println("2." + p2);
        System.out.println("3." + p3 + "\n");


        Scanner input = new Scanner(System.in);

        int Choice = 0; //user's choice of interaction
        int ParrotChoice = 0; //Parrot section to interaction

        while (Choice != 5) {
            System.out.println("1.Feed  2.Command  3.Play  4.Hit  5.Quit"); // prompt
            System.out.print("Choice: "); // prompt
            Choice = input.nextInt(); // obtain user input
            if (Choice == 1 || Choice == 2 || Choice == 3 || Choice == 4) {
                System.out.print("Which Parrot: "); // prompt
                ParrotChoice = input.nextInt(); // obtain user input

                //1.Feed
                if (Choice == 1 && ParrotChoice == 1) {

                    if (p1.isAlive() == "Alive") {

                        System.out.print("How Much: ");// prompt
                        double crackerCrumbs = input.nextDouble(); // obtain user input
                        p1.feed(crackerCrumbs);
                        if (p1.isTamed() == "Tamed") {
                            System.out.printf("You tamed %s. \n", p1.getName());
                        }
                    } else {
                        System.out.printf("%s is not alive. \n", p1
                                .getName());
                    }
                }

                if (Choice == 1 && ParrotChoice == 2) {

                    if (p2.isAlive() == "Alive") {

                        System.out.print("How Much: ");
                        double crackerCrumbs = input.nextDouble();
                        p2.feed(crackerCrumbs);
                        if (p2.isTamed() == "Tamed") {
                            System.out.printf("You tamed %s. \n", p2.getName());
                        }
                    } else {
                        System.out.printf("%s is not alive. \n", p2
                                .getName());
                    }
                }


                if (Choice == 1 && ParrotChoice == 3) {

                    if (p3.isAlive() == "Alive") {

                        System.out.print("How Much: ");
                        double crackerCrumbs = input.nextDouble();
                        p3.feed(crackerCrumbs);
                        if (p3.isTamed() == "Tamed") {
                            System.out.printf("You tamed %s. \n", p3.getName());
                        }
                    } else {
                        System.out.printf("%s is not alive. \n", p3
                                .getName());
                    }
                }

                //2.Command
                if (Choice == 2 && ParrotChoice == 1) {
                    if (p1.isTamed() == "Tamed" && p1.isAlive() == "Alive") {
                        System.out.print("Choose 1 for fly or 2 for stay: "); // prompt
                        int Command = input.nextInt(); // obtain user input
                        p1.command(Command);
                        System.out.printf("%s is %s. \n", p1.getName(), p1.isFlying());
                    } else {
                        System.out.printf("%s is not following any command. \n", p1.getName());
                    }
                }


                if (Choice == 2 && ParrotChoice == 2) {
                    if (p2.isTamed() == "Tamed" && p2.isAlive() == "Alive") {
                        System.out.print("Choose 1 for fly or 2 for stay: ");
                        int Command = input.nextInt();
                        p2.command(Command);
                        System.out.printf("%s is %s. \n", p2.getName(), p2.isFlying());
                    } else {
                        System.out.printf("%s is not following any command. \n", p2.getName());
                    }
                }

                if (Choice == 2 && ParrotChoice == 3) {
                    if (p3.isTamed() == "Tamed" && p3.isAlive() == "Alive") {
                        System.out.print("Choose 1 for fly or 2 for stay: ");
                        int Command = input.nextInt();
                        p3.command(Command);
                        System.out.printf("%s is %s. \n", p3.getName(), p3.isFlying());
                    } else {
                        System.out.printf("%s is not following any command. \n", p3.getName());
                    }
                }

                //3.Play
                if (Choice == 3 && ParrotChoice == 1) {
                    if (p1.isTamed() == "Tamed" && p1.isAlive() == "Alive") {
                        System.out.print("With which Parrot: "); // prompt
                        // obtain user input
                        int ParrotChoice2 = input.nextInt(); // ParrotChoice2 is for another parrot choice to get play with first chosen parrot.

                        if (((ParrotChoice2 == 2) && (p2.isTamed() == "Tamed" && p2.isAlive() == "Alive"))) {
                            System.out.printf("%s and %s is playing. \n", p1.getName(), p2.getName());
                            p1.play();
                            p2.play();
                        }
                        if ((p2.isAlive() == "Dead" || p2.isTamed() != "Tamed") && ParrotChoice2 == 2) {
                            System.out.printf("%s is not tamed or alive. \n", p2.getName());
                        }

                        if (((ParrotChoice2 == 3) && (p3.isTamed() == "Tamed" && p3.isAlive() == "Alive"))) {
                            System.out.printf("%s and %s is playing. \n", p1.getName(), p3.getName());
                            p1.play();
                            p3.play();
                        }
                        if ((p3.isAlive() == "Dead" || p3.isTamed() != "Tamed") && ParrotChoice2 == 3) {
                            System.out.printf("%s is not tamed or alive. \n", p3.getName());
                        }
                    } else {
                        System.out.printf("%s is not tamed or alive. \n", p1.getName());
                    }
                }

                if (Choice == 3 && ParrotChoice == 2) {
                    if (p2.isTamed() == "Tamed" && p2.isAlive() == "Alive") {
                        System.out.print("With which Parrot: ");
                        int ParrotChoice2 = input.nextInt();
                        if (((ParrotChoice2 == 1) && (p1.isTamed() == "Tamed" && p1.isAlive() == "Alive"))) {
                            System.out.printf("%s and %s is playing. \n", p2.getName(), p1.getName());
                            p1.play();
                            p2.play();
                        }
                        if ((p1.isAlive() == "Dead" || p1.isTamed() != "Tamed") && ParrotChoice2 == 1) {
                            System.out.printf("%s is not tamed or alive. \n", p1.getName());
                        }

                        if (((ParrotChoice2 == 3) && (p3.isTamed() == "Tamed" && p3.isAlive() == "Alive"))) {
                            System.out.printf("%s and %s is playing. \n", p2.getName(), p3.getName());
                            p3.play();
                            p2.play();
                        }
                        if ((p3.isAlive() == "Dead" || p3.isTamed() != "Tamed") && ParrotChoice2 == 3) {
                            System.out.printf("%s is not tamed or alive. \n", p3.getName());
                        }
                    } else {
                        System.out.printf("%s is not tamed or alive. \n", p2.getName());
                    }
                }

                if (Choice == 3 && ParrotChoice == 3) {
                    if (p3.isTamed() == "Tamed" && p3.isAlive() == "Alive") {
                        System.out.print("With which Parrot: ");
                        int ParrotChoice2 = input.nextInt();
                        if (((ParrotChoice2 == 2) && (p2.isTamed() == "Tamed" && p2.isAlive() == "Alive"))) {
                            System.out.printf("%s and %s is playing. \n", p3.getName(), p2.getName());
                            p3.play();
                            p2.play();
                        }
                        if ((p2.isAlive() == "Dead" || p2.isTamed() != "Tamed") && ParrotChoice2 == 2) {
                            System.out.printf("%s is not tamed or alive. \n", p2.getName());
                        }

                        if (((ParrotChoice2 == 1) && (p1.isTamed() == "Tamed" && p1.isAlive() == "Alive"))) {
                            System.out.printf("%s and %s is playing \n", p3.getName(), p1.getName());
                            p1.play();
                            p3.play();
                        }
                        if ((p1.isAlive() == "Dead" || p1.isTamed() != "Tamed") && ParrotChoice2 == 1) {
                            System.out.printf("%s is not tamed or alive.. \n", p1.getName());
                        }
                    } else {
                        System.out.printf("%s is not tamed or alive. \n", p3
                                .getName());
                    }
                }

                //4.Hit
                if (Choice == 4 && ParrotChoice == 1) {
                    if (p1.isAlive() == "Alive") {
                        p1.hit();
                        System.out.println("Ouch! \n");
                    } else {
                        System.out.printf("%s is not alive. \n", p1
                                .getName());
                    }
                }

                if (Choice == 4 && ParrotChoice == 2) {
                    if (p2.isAlive() == "Alive") {
                        p2.hit();
                        System.out.println("Ouch! \n");
                    } else {
                        System.out.printf("%s is not alive. \n", p2
                                .getName());
                    }
                }

                if (Choice == 4 && ParrotChoice == 3) {
                    if (p3.isAlive() == "Alive") {
                        p3.hit();
                        System.out.println("Ouch! \n");
                    } else {
                        System.out.printf("%s is not alive. \n", p3
                                .getName());
                    }
                }

                System.out.println("1." + p1);
                System.out.println("2." + p2);
                System.out.println("3." + p3 + "\n");
            }

            if (Choice == 5) {
                System.out.println("Thanks for playing");
            } else {
                System.out.println("Please enter valid input between 1 to 5 for given choices");
            }
        }


    } // end main class
} // end ParrotCraft class
