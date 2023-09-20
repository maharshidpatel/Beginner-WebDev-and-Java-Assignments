package assignment3_000738366;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A Door is a rectangle that is half as wide as it is high. Its location is its top left corner.
 * Created on Feb 16, 2023
 *
 * @author Maharshi Patel
 */
public class Door {
    /**
     * rectangle's top left corner's x coordinate
     **/
    private double x;
    /**
     * rectangle's top left corner's y coordinate
     **/
    private double y;
    /**
     * rectangle's height
     **/
    private double height;

    /**
     * Constructor.
     *
     * @param height The value of height
     * @param x      The x value
     * @param y      The y value
     */

    public Door(double x, double y, double height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    /**
     * Draws the rectangle on a GraphicsContext object.
     *
     * @param gc The GraphicsContext to draw on.
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(x, y, height / 2, height);
    }
}
