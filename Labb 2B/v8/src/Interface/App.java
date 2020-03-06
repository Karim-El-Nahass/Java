package Interface;

import Vehicles.GroupCars;
import Vehicles.Vehicle;
import Vehicles.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final static int delay = 50;

    // The timer is started with an listener (see below) that executes the statements, each step between delays.
    private static Timer timer = new Timer(delay, new TimerListener());
    public static GroupCars groupCars = new GroupCars();

    // The frame that represents this instance View of the MVC pattern
    // Start a new view and send a reference of self
    static CarView carView = new CarView("CarSim 1.0", groupCars.cars);

    static CarController carController = new CarController(carView, groupCars);

    public static void main(String[] args) {
        // Start the timer
        timer.start();
    }

    private static void updateCarPos(Vehicle car) {
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
    }

    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : groupCars.cars) {

                updateCarPos(car);
                // repaint() calls the paintComponent method of the panel
                carView.drawPanel.repaint();
            }
        }
    }
}
