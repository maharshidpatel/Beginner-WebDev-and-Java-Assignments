package assignment3_000738366;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A House is a square. Its location is the top left corner, and it contains a window and door.
 * Created on Feb 16, 2023
 *
 * @author Maharshi Patel
 */

public class House {
    /**
     * square's top left corner's x coordinate
     **/
    private double x;
    /**
     * square's top left corner's y coordinate
     **/
    private double y;
    /**
     * square's height or width
     **/
    private double size;
    /**
     * House's occupants
     **/
    private int occupants = (int) (Math.random() * 15);
    /**
     * House's color
     **/
    private Color color;
    /**
     * Created Door class's object
     **/
    private Door door;
    /**
     * Created Window class's object
     **/
    private Window window;

    /**
     * Constructor.
     * @param color The color of house
     * @param size The value of height
     * @param x The x value
     * @param y The y value
     */
    public House(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y - size;
        this.size = size;
        this.color = color;
        door = new Door(x + (size * 0.65), y - (size * 0.4), size * 0.40);
        window = new Window(x + (size * 0.2), y - (size * 0.75), size * 0.25);
    }
    /**
     * Constructor.
     *
     * @param x The x value
     * @param y The y value
     */
    public House(double x, double y) {
        this(x, y, 250, Color.ORANGE);
        occupants = 1;
    }
    /**
     * method that returns the occupants
     * @return occupants
     **/
    public int getOccupants() {
        return occupants;
    }
    /**
     * method that sets the occupants
     **/
    public void setOccupants(int occupants) {
        this.occupants = occupants;
    }

    /**
     * Draws the Square on a GraphicsContext object.
     * Draw the Door.
     * Draw the Window.
     *
     * @param gc The GraphicsContext to draw on.
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, size, size);
        door.draw(gc);
        window.draw(gc);
    }
    /**
     * method that returns the square's height or width
     * @return size
     **/
    public double getSize() {
        return size;
    }
}

