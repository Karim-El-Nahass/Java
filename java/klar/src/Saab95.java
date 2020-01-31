import java.awt.*;

/**
 * Saab95 class
 */
public class Saab95 extends Vehicle {

    public static void main(String[] args) {
        System.out.println("Success");
    }

    private boolean turboOn;

    /**
     * constructor for Saab95
     */
    public Saab95(){
        super(2, Color.red, 125, "Saab95");
        turboOn = false;
    }

    public Saab95(double x, double y){
        super(2, Color.red, 125, "Saab95", x, y);
        turboOn = false;
    }

    /**
     * sets turbo on
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * sets turbo off
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * @return returns speed factor
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}