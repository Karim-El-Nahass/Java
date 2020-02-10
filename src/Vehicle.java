import java.awt.*;

/**
 * General class describing vehicle
 */
public abstract class Vehicle implements Movable {
    private direction currentDir = direction.NORTH;
    private double x;
    private double y;

    private int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    public String modelName; // The car model name
    private double length;

    /**
     * Constructor for vehicle.
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     * @param x
     * @param y
     * @param length
     */
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y, double length) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.length = length;
        stopEngine();
    }

    public double getSize() {
        return length;
    }

    /**
     * @return number of doors
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * @return engine power
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * @return current speed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * @return vehicle color
     */
    public Color getColor(){
        return color;
    }

    /**
     @param clr setter for color
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * starts engine
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * stops engine
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * @return returns speed factor
     */
    public abstract double speedFactor();

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    public direction getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(direction currentDir) {
        this.currentDir = currentDir;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public enum direction {
        NORTH,
        EAST,
        SOUTH,
        WEST;
    }

    /**
     * moves car forward
     */
    @Override
    public void move() {
       switch (currentDir) {
           case NORTH:
               setY(getY() - getCurrentSpeed());
               break;

           case EAST:
               setX(getX() + getCurrentSpeed());
               break;

           case SOUTH:
               setY(getY() + getCurrentSpeed());
               break;

           case WEST:
               setX(getX() - getCurrentSpeed());
               break;
       }
    }

    /**
     * changes direction to left
     */
    @Override
    public void turnLeft() {
        switch (currentDir) {
            case NORTH:
                setCurrentDir(direction.WEST);
                break;

            case EAST:
                setCurrentDir(direction.NORTH);
                break;

            case SOUTH:
                setCurrentDir(direction.EAST);
                break;

            case WEST:
                setCurrentDir(direction.SOUTH);
                break;

        }
    }

    /**
     * changes direction to right
     */
    @Override
    public void turnRight() {
        switch (currentDir) {
            case NORTH:
                setCurrentDir(direction.EAST);
                break;

            case EAST:
                setCurrentDir(direction.SOUTH);
                break;

            case SOUTH:
                setCurrentDir(direction.WEST);
                break;

            case WEST:
                setCurrentDir(direction.NORTH);
                break;

        }
    }

    /**
     * increases speed
     * @param amount
     */


    // TODO fix this method according to lab pm
    public void gas(double amount){

        double temp = currentSpeed;

        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }

        if (currentSpeed < temp) {
            currentSpeed = temp;
        }
    }


    /** decreases speed
     * @param amount
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){

        double temp = currentSpeed;

        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }

        if (currentSpeed > temp) {
            currentSpeed = temp;
        }
    }

}
