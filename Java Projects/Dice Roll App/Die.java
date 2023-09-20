package assignment4_000738366;


/**
 * A Die object have any integer number of sides it saves it in array. It can also show currently showing side and report number of sides of object.
 * Created on Feb 26, 2023
 *
 * @author Maharshi Patel
 */
public class Die {
    /**
     * Die's number of sides
     **/
    private int numberOfSide;
    /**
     * An array that store Die's number of sides.
     **/
    private int[] side;
    /**
     * Die's currently showing side.
     **/
    private int currentSide;
    /**
     * Constructor.
     *
     * @param numberOfSide Number of sides
     *
     */
    public Die(int numberOfSide) {
        side = new int[numberOfSide];
        this.numberOfSide = numberOfSide;
        for (int i = 0; i < numberOfSide; i++) {
            side[i] = i + 1;
        }
        currentSide = (int) (Math.random() * ((numberOfSide - 1) + 1));
        int dieRolled = side[currentSide];
    }
    /**
     * method that rolls the dice and change currentSide variable randomly
     **/
    public void dieRoll() {
        currentSide = (int) (Math.random() * ((numberOfSide - 1) + 1));
        int dieRolled = side[currentSide];
    }
    /**
     * method that returns the current side from Dies array
     * @return side[currentSide]
     **/
    public int getCurrentSide() {
        return side[currentSide];
    }
    /**
     * method that returns number of sides
     * @return numberOfSide
     **/
    public int getNumberOfSide() {
        return numberOfSide;
    }
    /**
     * @return A String representation of a Die with number of Sides and currently showing side
     */
    @Override
    public String toString() {
        return String.format("%d sided Die showing %d", getNumberOfSide(), side[currentSide]);
    }
}
