package assignment4_000738366;

/**
 * A DieCollection class is array of Die objects. It can also show minimum, maximum and addition of current showing sides.Its histogram method can roll 100000 times and shows the addition of all Die objects
 * Created on Feb 26, 2023
 *
 * @author Maharshi Patel
 */

public class DiceCollection {
    /**
     * number of Die objects
     **/
    private int numberOfDices;
    /**
     * Array for number of sides of
     **/
    private int[] numberOfSides;
    /**
     * Array for Die objects
     **/
    private Die[] dices;
    /**
     * Addition of all objects' (in DiceCollection) number of sides
     **/
    private int maximum = 0;
    /**
     * Addition of all objects' (in DiceCollection) currently showing sides
     **/
    private int currentSum = 0;

    /**
     * Constructor.
     *
     * @param numberOfDices Number of dices
     * @param numberOfSides An array for Number of sides of Die
     */
    public DiceCollection(int numberOfDices, int[] numberOfSides) {
        this.numberOfDices = numberOfDices;
        this.numberOfSides = new int[numberOfDices];
        dices = new Die[numberOfDices];
        for (int i = 0; i < numberOfDices; i++) {
            this.numberOfSides[i] = numberOfSides[i];
            dices[i] = new Die(numberOfSides[i]);
        }
    }

    /**
     * method that returns addition of minimum possible side of all Die objects
     *
     * @return numberOfSide
     **/
    public int getMinimum() {
        return numberOfDices;
    }

    /**
     * method that returns addition of maximum possible side of all Die objects
     *
     * @return numberOfSide
     **/
    public int getMaximum() {
        maximum = 0;
        for (int i = 0; i < numberOfDices; i++) {
            maximum += dices[i].getNumberOfSide();
        }
        return maximum;
    }

    /**
     * method that returns addition of currently showing side of all Die objects
     *
     * @return numberOfSide
     **/
    public int getCurrentSum() {
        if (currentSum == 0) {
            ;
            for (int i = 0; i < numberOfDices; i++) {
                System.out.println(dices[i]);
                currentSum += dices[i].getCurrentSide();
            }
            return currentSum;
        } else {
            currentSum = 0;
            for (int i = 0; i < numberOfDices; i++) {
                dices[i].dieRoll();
                System.out.println(dices[i]);
                currentSum += dices[i].getCurrentSide();
            }
            return currentSum;
        }
    }

    /**
     * method that rolls all dices 100000 times and prints arrays of all objects' sides addition's total outcome.
     **/
    public void histogram() {
        maximum = 0;
        for (int i = 0; i < numberOfDices; i++) {
            maximum += dices[i].getNumberOfSide();
        }

        int[] histogramArray = new int[maximum + 1];

        for (int loop = 1; loop <= 100000; loop++) {
            currentSum = 0;
            for (int i = 0; i < numberOfDices; i++) {
                dices[i].dieRoll();
                currentSum += dices[i].getCurrentSide();
            }
            histogramArray[currentSum]++;
        }
        for (int i = numberOfDices; i < maximum + 1; i++) {
            if (i < 10) {
                System.out.print(" ");
            }
            if (histogramArray[i] < 10000) {
                System.out.print(" ");
            }
            int starCount = (histogramArray[i] / 1000);
            String star = "";
            for (int j = 1; j <= starCount; j++) {
                star += "*";
            }
            System.out.println(i + ": " + histogramArray[i] + "  " + star);
        }
    }

    /**
     * @return A String representation of a DieCollection with minimum addition,  maximum addition and addition of currently showing side
     */
    @Override
    public String toString() {
        return String.format("Min=%d, Max=%d, Current=%d", getMinimum(), getMaximum(), getCurrentSum());
    }
}

