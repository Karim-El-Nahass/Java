import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class test {

    private Saab95 saab95 = new Saab95(0,0);
    private Volvo240 volvo240 = new Volvo240(0,0);

    @Before
    public void init() {
        saab95.setCurrentSpeed(30); saab95.setDirection(Vehicle.Direction.NORTH);
        volvo240.setCurrentSpeed(30); volvo240.setDirection(Vehicle.Direction.NORTH);
    }

    @Test
    public void testMove() {
        double temp1 = saab95.getY();
        double temp2 = volvo240.getY();

        saab95.move();
        assertTrue(saab95.getY() < temp1);

        volvo240.move();
        assertTrue(volvo240.getY() < temp2);
    }

    @Test
    public void testTurnLeft() {
        saab95.turnLeft();
        assertTrue(saab95.getDirection() == Vehicle.Direction.WEST);

        saab95.turnLeft();
        assertTrue(saab95.getDirection() == Vehicle.Direction.SOUTH);

        saab95.turnLeft();
        assertTrue(saab95.getDirection() == Vehicle.Direction.EAST);

        saab95.turnLeft();
        assertTrue(saab95.getDirection() == Vehicle.Direction.NORTH);

        volvo240.turnLeft();
        assertTrue(volvo240.getDirection() == Vehicle.Direction.WEST);

        volvo240.turnLeft();
        assertTrue(volvo240.getDirection() == Vehicle.Direction.SOUTH);

        volvo240.turnLeft();
        assertTrue(volvo240.getDirection() == Vehicle.Direction.EAST);

        volvo240.turnLeft();
        assertTrue(volvo240.getDirection() == Vehicle.Direction.NORTH);
    }

    @Test
    public void testTurnRight() {
        saab95.turnRight();
        assertTrue(saab95.getDirection() == Vehicle.Direction.EAST);

        saab95.turnRight();
        assertTrue(saab95.getDirection() == Vehicle.Direction.SOUTH);

        saab95.turnRight();
        assertTrue(saab95.getDirection() == Vehicle.Direction.WEST);

        saab95.turnRight();
        assertTrue(saab95.getDirection() == Vehicle.Direction.NORTH);

        volvo240.turnRight();
        assertTrue(volvo240.getDirection() == Vehicle.Direction.EAST);

        volvo240.turnRight();
        assertTrue(volvo240.getDirection() == Vehicle.Direction.SOUTH);

        volvo240.turnRight();
        assertTrue(volvo240.getDirection() == Vehicle.Direction.WEST);

        volvo240.turnRight();
        assertTrue(volvo240.getDirection() == Vehicle.Direction.NORTH);
    }
}