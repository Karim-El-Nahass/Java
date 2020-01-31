import java.awt.*;

/**
 * General class describing vehicle
 */
public abstract class Vehicle implements Movable {

    private double x;
    private double y;
    private Direction direction;

    private int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    public Vehicle(int nrDoors, Color color, int enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    public Vehicle(int nrDoors, Color color, int enginePower, String modelName, double x, double y) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
        this.x = x;
        this.y = y;
    }

    public enum Direction { NORTH, EAST, SOUTH, WEST }

    /**
     * @return number of doors
     */
    public int getNrDoors(){
        return nrDoors;
    }

    public Direction getDirection() { return direction; }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * @return engine power
     */
    public double getEnginePower(){
        return enginePower;
    }

    public void setCurrentSpeed(double currentSpeed) { this.currentSpeed = currentSpeed; }

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
     * @param clr setter for color
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

    private void incrementSpeed(double amount){
        double change = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);

        if (!(change < 0) && (change > enginePower)) {
            currentSpeed = change;
        }
    }

    private void decrementSpeed(double amount){
        double change = Math.max(getCurrentSpeed() - speedFactor() * amount,0);

        if (!(change < 0) && (change > enginePower)) {
            currentSpeed = change;
        }
    }

    /**
     * increases speed
     * @param amount
     */
    // TODO fix this method according to lab pm
    public void gas(double amount){

        double temp = currentSpeed;

        if ((amount >= 0) && (amount <= 1)) {
            incrementSpeed(amount);
        }

        if (currentSpeed < temp) {
            currentSpeed = temp;
        }
    }

    /**
     * decreases speed
     * @param amount
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){

        double temp = currentSpeed;

        if ((amount >= 0) && (amount <= 1)) {
            decrementSpeed(amount);
        }

        if (currentSpeed > temp) {
            currentSpeed = temp;
        }
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    private void changeX(double amount) {
        this.x = x + amount;
    }

    private void changeY(double amount) {
        this.y = y + amount;
    }

    public void setDirection(Direction dir) {
        direction = dir;
    }

    /**
     * moves car forward
     */
    public void move() {
        switch (direction) {
            case NORTH:
                changeY(-1*currentSpeed);
                break;
            case EAST:
                changeX(currentSpeed);
                break;
            case SOUTH:
                changeY(currentSpeed);
                break;
            case WEST:
                changeX(-1*currentSpeed);
        }
    }

    /**
     * changes direction to left
     */
    public void turnLeft() {
        switch (direction) {
            case NORTH:
                setDirection(Direction.WEST);
                break;
            case EAST:
                setDirection(Direction.NORTH);
                break;
            case SOUTH:
                setDirection(Direction.EAST);
                break;
            case WEST:
                setDirection(Direction.SOUTH);
        }
    }

    /**
     * changes direction to right
     */
    public void turnRight() {
        switch (direction) {
            case NORTH:
                setDirection(Direction.EAST);
                break;
            case EAST:
                setDirection(Direction.SOUTH);
                break;
            case SOUTH:
                setDirection(Direction.WEST);
                break;
            case WEST:
                setDirection(Direction.NORTH);
        }
    }
}