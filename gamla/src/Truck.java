import java.awt.*;
import java.util.Stack;
/**
 * Truck class.
 */
public class Truck extends Vehicle implements Movable, ITruck {

    boolean flatBedUp;
    Stack<Vehicle> stack = new Stack<Vehicle>();

    /**
     * constructor for truck.
     * @param color
     * @param modelName
     * @param x
     * @param y
     * @param size
     */
   public Truck(Color color, String modelName, double x, double y, double size) {
        super(2, 500, color, "Man", 0, 0, 30);
        flatBedUp = false;
    }

    /**
     * Loads the truck with vehicles with given conditions.
     * @param vehicle
     * @throws Exception
     */
    public void load(Vehicle vehicle) throws Exception {

        boolean conditionX = (vehicle.getX() - this.getX()) <= 10;
        boolean conditionY = (vehicle.getY() - this.getY()) <= 10;
        boolean vehicleIsClose = conditionX && conditionY;

        if ((vehicle.getSize() <= 5.5) && !(flatBedUp) && vehicleIsClose && (stack.size() < 8)) {
            stack.push(vehicle);
        } else if (stack.size() == 8) {
            throw new Exception("Truck Full!");
        } else if (vehicle.getSize() > 5.5) {
            throw new Exception("Vehicle too large!");
        } else if (flatBedUp) {
            throw new Exception("Flatbed is up!");
        } else if (!vehicleIsClose) {
            throw new Exception("Vehicle is too far away!");
        }
    }
    /**
     * Unloads vehicles from the flatbed.
     */
    public void unload() {

        if (!flatBedUp) {
            Vehicle vehicle = stack.pop();
            vehicle.setX(this.getX() + 10);
            vehicle.setY(this.getY() + 10);
        }
    }

    /**
     * raises the flatbed
     */
    public void raise() {
        if (getCurrentSpeed() == 0) {
            flatBedUp = true;
        }
    }

    /**
     * lowers the flatbed
     */
    public void lower() {

        if (getCurrentSpeed() == 0) {
            flatBedUp = false;
        }
    }

    /**
     * Decides speed.
     * @return
     */
    public double speedFactor() {
        return enginePower * 0.01;
    }

    /**
     * Increases speed.
     * @param amount
     */
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Decreases speed.
     * @param amount
     */
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Checks if flatbed is up.
     * @return
     */
    public boolean isFlatBedUp() {
        return flatBedUp;
    }

    /**
     * Makes the flatbed go up.
     * @param flatBedUp
     */
    public void setFlatBedUp(boolean flatBedUp) {
        this.flatBedUp = flatBedUp;
    }

    /**
     * Describes how both truck and vehicles on the truck moves.
     */
    @Override
    public void move() {
        switch (this.getCurrentDir()) {
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

        for (Vehicle car: stack) {
            car.setX(this.getX());
            car.setY(this.getY());
        }
    }
}