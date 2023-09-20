package assignment3_000738366;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * The Window is a circle. Its location is its center.
 * Created on Feb 16, 2023
 *
 * @author Maharshi Patel
 */

public class Window {
    /**
     * Circle's center point's x coordinate
     **/
    private double x;
    /**
     * Circle's center point's y coordinate
     **/
    private double y;
    /**
     * Circle's diameter
     **/
    private double diameter;

    /**
     * Constructor.
     *
     * @param diameter The value of diameter
     * @param x        The x value
     * @param y        The y value
     */

    public Window(double x, double y, double diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    /**
     * Draws the circle on a GraphicsContext object.
     *
     * @param gc The GraphicsContext to draw on.
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillOval(x, y, diameter, diameter);
    }
}


