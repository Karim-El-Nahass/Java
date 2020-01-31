import java.awt.*;

/**
 * Volvo240 class
 */
public class Volvo240 extends Vehicle {

    public static void main(String[] args) {
        System.out.println("Success");
    }

    private final static double trimFactor = 1.25;

    /**
     * constructor for Volvo240
     */
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }

    public Volvo240(double x, double y){
        super(4, Color.black, 100, "Volvo240", x, y);
    }

    /**
     * @return returns speed factor
     */
    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}