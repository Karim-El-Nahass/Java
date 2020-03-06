package Interface;

import Vehicles.Vehicle;
import Vehicles.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final static int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private static Timer timer = new Timer(delay, new TimerListener());

    // Instance of this class
    static CarController carController = new CarController();

    // The frame that represents this instance View of the MVC pattern
    // Start a new view and send a reference of self
    static CarView frame = new CarView("CarSim 1.0", carController);

    public static void main(String[] args) {
        // carController.createCar(new Volvo240(100,100));
        // carController.createCar(new Volvo240(100, 170));
        // carController.setCarsDir("East");

        // Start the timer
        timer.start();
    }

    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : carController.cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                if (x < 0) {
                    car.setCurrentSpeed(0.1);
                    car.setCurrentDir("East");
                } else if (x > frame.getX() - 120 /*90*/) {
                    car.setCurrentSpeed(0.1);
                    car.setCurrentDir("West");
                }

                if (carController.cars.size() != 0) {
                    int carIndex = carController.cars.indexOf(car);

                    frame.drawPanel.moveit(x, y, carIndex);
                }

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
}
