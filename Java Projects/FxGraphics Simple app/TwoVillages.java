package assignment3_000738366;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * The TwoVillages class contains two villages and the emperor’s house – these three objects are the model. The view
 * for this assignment is a class created using the FXGraphicsTemplate which creates and draws the model.
 * Created on Feb 16, 2023
 * @author Maharshi Patel
 */
public class TwoVillages extends Application {

    /**
     * Start method
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(1000, 750); // Set canvas Size in Pixels
        stage.setTitle("TwoVillages"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //CODE STARTS HERE
        gc.setFill(Color.DARKBLUE);
        gc.fillRect(0, 0, 1000, 750); //DARK BLUE COLORED CANVAS

        //Created 2 Villages objects(with 4 parameters) and a House object(with 2 parameters - king's house)
        Village v1 = new Village("India", 200, 220, Color.RED);
        Village v2 = new Village("Canada", 200, 550, Color.GREEN);
        House king = new House(700, 450);

        // Drawn 2 above created Village class's objects and a House class's object
        v1.draw(gc);
        v2.draw(gc);
        king.draw(gc);

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
