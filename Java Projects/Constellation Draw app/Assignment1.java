import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import java.util.Scanner;

import static javax.swing.text.StyleConstants.Italic;

/**
 * Program: Assignment1.java
 * Author: Maharshi Patel
 * Date: Jan 22, 2023
 * <p>
 * Purpose: Create nighttime star field. Allow user to enter number of star and its coordinates to create constellation by connecting lines to the user's entered stars.
 *
 * @author Maharshi Patel
 */
public class Assignment1 extends Application {

    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(1000, 750); // Set canvas Size in Pixels
        stage.setTitle("Constellation"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //CODE STARTS HERE
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 1000, 750); //BLACK COLORED CANVAS

        //Randomly Placed stars in background
        int bigStarCount = 0;
        while (bigStarCount < 300) {
            gc.setFill(Color.rgb(253, 254, 255));
            gc.fillRect(Math.random() * 1000, Math.random() * 750, 2.5, 2.5);
            bigStarCount += 1;
        }
        int smallStarCount = 0;
        while (smallStarCount < 700) {
            gc.setFill(Color.WHITE);
            gc.fillRect(Math.random() * 1000, Math.random() * 750, 1.5, 1.5);
            smallStarCount += 1;
        }

        Scanner input = new Scanner(System.in);
        int starCount;
        // *** input
        System.out.print("Enter the number of stars to create constellation: ");
        starCount = input.nextInt();

        // *** processing
        if (starCount > 1) { //Minimum 2 number of stars required to start processing
            boolean good = true;
            while (good) { //loop for input if user enters coordinates outside of canvas range
                int xCoordinate;
                int yCoordinate;
                int count = 0;
                // *** input
                System.out.print("Please enter x coordinate for star 1: ");
                xCoordinate = input.nextInt();
                System.out.print("Please enter y coordinate for star 1: ");
                yCoordinate = input.nextInt();

                if (xCoordinate < 1000 && xCoordinate > 0 && yCoordinate < 750 && yCoordinate > 0) {
                    // *** processing
                    //condition to check first star's coordinates
                    int xCoordinate2 = 0;
                    int yCoordinate2 = 0;
                    if (count == 0) {
                        gc.setFill(Color.RED);
                        gc.fillOval(xCoordinate, yCoordinate, 6.5, 6.5); //Draws first star
                        while (good) {
                            // *** input for second star
                            System.out.print("Please enter x coordinate for star 2: ");
                            xCoordinate2 = input.nextInt();
                            System.out.print("Please enter y coordinate for star 2: ");
                            yCoordinate2 = input.nextInt();
                            // *** processing
                            //condition to check second star's coordinates
                            if (xCoordinate2 < 1000 && xCoordinate2 > 0 && yCoordinate2 < 750 && yCoordinate2 > 0) {
                                gc.setFill(Color.RED);
                                gc.fillOval(xCoordinate2, yCoordinate2, 6.5, 6.5); //Draws second star
                                gc.setStroke(Color.RED);
                                gc.strokeLine(xCoordinate + 1.5, yCoordinate + 1.5, xCoordinate2 + 1.5, yCoordinate2 + 1.5); //Draws line connecting first and second stars
                                good = false;
                                count += 2;
                            } else {
                                // *** output
                                System.out.println("Please enter star coordinates in range 0 to 1000 for x and 0 to 750 for y");
                            }
                        }
                    }
                    if (count > 0 && count <= starCount - 1) {
                        //loop for drawing third star to last and their connecting lines
                        while (count <= starCount - 1) {
                            //*** input
                            System.out.printf("Please enter x coordinate for star %d: ", count + 1);
                            int xCoordinate3 = input.nextInt();
                            System.out.printf("Please enter y coordinate for star %d: ", count + 1);
                            int yCoordinate3 = input.nextInt();

                            if (xCoordinate3 < 1000 && xCoordinate3 > 0 && yCoordinate3 < 750 && yCoordinate3 > 0) {
                                gc.setFill(Color.RED);
                                gc.fillOval(xCoordinate3, yCoordinate3, 6.5, 6.5);
                                gc.setStroke(Color.RED);
                                gc.strokeLine(xCoordinate2 + 1.5, yCoordinate2 + 1.5, xCoordinate3 + 1.5, yCoordinate3 + 1.5);
                                count += 1;
                                xCoordinate2 = xCoordinate3;
                                yCoordinate2 = yCoordinate3;
                            } else {
                                // *** output
                                System.out.println("Please enter star coordinates in range 0 to 1000 for x and 0 to 750 for y");
                            }
                        }
                    }
                    // *** processing
                    // Draws line connecting last and first stars.
                    if (count == starCount) {
                        gc.setStroke(Color.RED);
                        gc.strokeLine(xCoordinate2 + 1.5, yCoordinate2 + 1.5, xCoordinate + 1.5, yCoordinate + 1.5);
                    }
                } else {
                    // *** output
                    System.out.println("Please enter star coordinates in range 0 to 1000 for x and 0 to 750 for y");
                }
            }
            // *** input for constellation name
            String constellationName;
            System.out.print("Please enter constellation name: ");
            constellationName = input.next();
            Font font = Font.font("Times New Roman", FontPosture.ITALIC, 28);
            gc.setFont(font);
            gc.setFill(Color.DARKORANGE);
            gc.fillText(constellationName, 650, 100);
            gc.setFill(Color.DARKORANGE);
            gc.setFont(new Font("Times New Roman", 18));
            gc.fillText("Assignment 1 by Maharshi Patel", 650, 135);
        } else {
            // *** output
            System.out.println("Minimum 2 stars required to form constellation.");
        }
        //CODE STOPS HERE
        stage.show();
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
