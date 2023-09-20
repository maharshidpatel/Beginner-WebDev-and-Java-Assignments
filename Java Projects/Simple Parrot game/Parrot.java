package assignment2_000738366;
/**The Parrot class is the model.
 * ParrotCraft is a simple game world loosely based
 * on MineCraft Parrot objects.
 * Created on Feb 01, 2023
 * @author Maharshi Patel
 */
public class Parrot {
    /**
     * The current parrot name (default Julius)
     **/
    private String name = "Julius"; // instance variable
    /**
     * The current parrot name health (default 3)
     **/
    private int health = 3; // instance variable
    /**
     * The current parrot cracker crumbs in its stomach (default 0.1kg)
     **/
    private double crumbs = 0.1; // instance variable

    /**
     * Current behavior tamed or untamed (default untamed)
     **/
    private boolean tamed = false; // instance variable

    /**
     * dead or alive (default alive)
     **/
    private boolean alive = true; // instance variable

    /**
     * Current activity flying or sitting (default flying)
     **/
    private boolean flying = true; // instance variable

    /**
     * method that sets the name
     **/
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method that returns the name
     * @return name
     **/
    public String getName() {
        return name;
    }

    /**
     * method that returns the health
     * @return health
     **/
    public int getHealth() {
        return health;
    }

    /**
     * method that returns the cracker crumbs in its stomach
     * @return crumbs
     **/
    public double getCrumbs() {
        return crumbs;
    }

    /**
     * method that returns the behavior tamed or untamed
     * @return string Tamed or Untamed
     **/
    public String isTamed() {
        if (tamed) {
            return "Tamed";
        } else {
            return "Untamed";
        }
    }

    /**
     * method that returns dead or alive
     * @return string Dead or Alive
     **/
    public String isAlive() {
        if (!alive || health <= 0) {
            return "Dead";
        }
        return "Alive";
    }

    /**
     * method that returns the activity flying or sitting
     * @return string flying or sitting still or Seems dead
     **/
    public String isFlying() {
        if (health > 0) {
            if (flying) {
                return "flying";
            }
            if (!flying) {
                return "sitting still";
            }

        }
        return "Seems dead";
    }

    /**
     * method that add cracker crumbs in its stomach
     * @param crackerCrumbs add cracker crumbs to total in its stomach
     **/
    public void feed(double crackerCrumbs) {
        if (alive && crackerCrumbs > 0.0) {
            crumbs += crackerCrumbs;

            double percentageChance = 100 / (crackerCrumbs * 20);

            int randomNum = (int) (Math.random() * percentageChance);

            if (randomNum == 0) {
                tamed = true;
            }

            if (crumbs < 2.5) {
                health++;
            } else {
                health = health - 2;
                if (health <= 0) {
                    health = 0;
                }
            }
        }
    }
    /**
     * method that set flying variable based on user input
     * @param Command is user input about Parrot's activity flying or sitting
     **/
    public void command(int Command) {
        if (Command == 1)
            flying = true;

        if (Command == 2)
            flying = false;

    }
    /**
     * method that change decrease health variable by 1 and change tamed variable to false
     **/
    public void hit() {
        if (alive) {
            health--;
            if (health <= 0) {
                health = 0;
            }
            if (tamed) {
                tamed = false;
            }
        }
    }
    /**
     * method that change tamed variable to false
     **/
    public void play() {
        if (tamed && alive) {
            tamed = false;
        }
    }

    /**
     * @return A String representation of a Parrot
     */
    @Override
    public String toString() {
        return String.format("%s %s Parrot %s: %.2fkg crumbs, %d hearts, %s", isTamed(), isAlive(), getName(), getCrumbs(), getHealth(), isFlying());
    }
} // end class Parrot

