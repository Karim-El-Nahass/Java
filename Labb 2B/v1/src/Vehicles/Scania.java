package Vehicles;

import java.awt.*;

/**
 * Scania class
 */
public class Scania extends Vehicle implements ITruck {
    private double flatBedAngle;

    public static void main(String[] args) {
        System.out.println("Success");
    }

    public Scania(Color color, int enginePower, String modelName) {
        super(2, enginePower, color, modelName, 0, 0, 20);
        this.flatBedAngle = 0;
    }

    public double getFlatBedAngle() {
        return flatBedAngle;
    }

    /**
     * raises the flatbed
     * @param amount amount
     */
    public void raise(double amount) {
        double temp = flatBedAngle;
        flatBedAngle = flatBedAngle + amount;

        if (getCurrentSpeed() > 0 || flatBedAngle < 0 || flatBedAngle > 70) {
            flatBedAngle = temp;
        }
    }

    /**
     * lowers the flatbed
     * @param amount amount
     */
    public void lower(double amount) {
        double temp = flatBedAngle;
        flatBedAngle = flatBedAngle - amount;

        if (getCurrentSpeed() > 0 || flatBedAngle < 0 || flatBedAngle > 70) {
            flatBedAngle = temp;
        }
    }

    /**
     * moves the
     */
    @Override
    public void move() {
        if (flatBedAngle == 0) {
            switch (getCurrentDir()) {
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
    }

    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }

    @Override
    public void incrementSpeed(double amount) {
        this.setCurrentSpeed(this.getCurrentSpeed() + amount);
    }

    @Override
    public void decrementSpeed(double amount) {
        //
    }
}
