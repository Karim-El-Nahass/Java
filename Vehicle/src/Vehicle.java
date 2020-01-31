import java.awt.*;

/**
 *
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

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        stopEngine();
    }


    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }


    public void stopEngine(){
        currentSpeed = 0;
    }

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

    private void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    private void setY(double y) {
        this.y = y;
    }

    public enum direction {
        NORTH,
        EAST,
        SOUTH,
        WEST;
    }

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
