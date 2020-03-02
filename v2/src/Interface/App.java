package Interface;

import Vehicles.Saab95;
import Vehicles.Scania;
import Vehicles.Vehicle;
import Vehicles.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new CarController.TimerListener());

    Timer getTimer() {
        return timer;
    }

    static CarController cc = new CarController();
    // Start a new view and send a reference of self
    static CarView frame = new CarView("CarSim 1.0", cc);

    public static void main(String[] args) {

        cc.cars.add(new Volvo240(0, 100));
        cc.cars.add(new Saab95(0, 250));
        cc.cars.add(new Scania(0,400));
        Timer ccTimer = cc.getTimer();

        for (Vehicle car : cc.cars) {
            car.setCurrentDir(Vehicle.direction.WEST);
        }

        // Start the timer
        ccTimer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (Vehicle car : cc.cars) {
                car.move();
                if (car.getX() > 685) {
                    car.setX(685);
                    car.stopEngine();
                    car.setCurrentDir(Vehicle.direction.WEST);
                    car.startEngine();

                } else if (car.getX() < 0) {
                    car.setX(0);
                    car.stopEngine();
                    car.setCurrentDir(Vehicle.direction.EAST);
                    car.startEngine();
                }
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                String name = car.getModelName();
                frame.drawPanel.moveit(name, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
}