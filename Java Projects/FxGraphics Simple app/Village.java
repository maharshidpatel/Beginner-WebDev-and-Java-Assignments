package assignment3_000738366;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * A village is a collection of three houses that are all the same color. The houses in a village are in a straight line
 * from left to right, spaced out, the location of a village corresponds to the bottom left corner of
 * the first house.
 * Created on Feb 16, 2023
 *
 * @author Maharshi Patel
 */

public class Village {
    /**
     * The first house's bottom left corner's x coordinate
     **/
    private double x;
    /**
     * The first house's bottom left corner's y coordinate
     **/
    private double y;
    /**
     * The Width of the village
     **/
    private double size;
    /**
     * The Name of the village with its size and total occupants
     **/
    private String name;
    /**
     * The color of village's houses
     **/
    private Color color;
    /**
     * Created House class's 3 objects
     **/
    private House house1, house2, house3;

    /**
     * Constructor.
     *
     * @param name  name of the villages
     * @param color The color of house
     * @param x     The x value
     * @param y     The y value
     */
    public Village(String name, double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;


        house1 = new House(x, y, (Math.random() * 100) + 25, color);
        house2 = new House(x + 125 + (Math.random() * 10) + 5, y, (Math.random() * 100) + 25, color);
        double house3_x = x + 250 + (Math.random() * 10) + 10;
        house3 = new House(house3_x, y, (Math.random() * 100) + 25, color);

        double house3_size = house3.getSize() * 0.2;

        size = (house3_x - x) * 0.2 + house3_size;

        int population = house1.getOccupants() + house2.getOccupants() + house3.getOccupants();

        this.name = String.format("%s (Size: %.1fm, Population: %d)", name, size, population);

    }

    /**
     * Draws the 3 Houses on a GraphicsContext object.
     * Draw/Writes name variable
     *
     * @param gc The GraphicsContext to draw on.
     */
    public void draw(GraphicsContext gc) {
        house1.draw(gc);
        house2.draw(gc);
        house3.draw(gc);
        gc.setFill(Color.DARKORANGE);
        gc.setFont(new Font("Times New Roman", 18));
        gc.fillText(name, x + 10, y + 30);
    }

}
