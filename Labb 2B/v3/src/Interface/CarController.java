package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import Vehicles.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    ArrayList<Point> carPoint = new ArrayList<>();

    //methods:


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int index = 0;
            for (Vehicle car : cars) {
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
                frame.drawPanel.moveit(index, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                index++;
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            if (car.engineOn) {
                car.gas(gas);

            }
        }
    }

    // Calls the gas method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            if (car.engineOn && car.getCurrentSpeed() > 0) {
                car.brake(brake);
                if (car.getCurrentSpeed() < 0) {
                    car.setCurrentSpeed(0);
                }
            }
        }
    }

    void startEngine() {
        for (Vehicle car : cars) {
            if (!car.engineOn) {
                car.startEngine();
            }
        }
    }
    void stopEngine() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Saab95")) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Saab95")) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                ((Scania) car).raise(30);
                System.out.println(((Scania) car).getFlatBedAngle());
            }
        }
    }

    void lowerBed() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                ((Scania) car).lower(30);
                System.out.println(((Scania) car).getFlatBedAngle());

            }
        }

    }

    void addCar() {
        int size = cars.size();
        if (size != 10) {
            double yPos = 61 * size;


            String[] options = new String[] {"Volvo240", "Saab95", "Scania", "Random"};
            int response = JOptionPane.showOptionDialog(null, "What car do you want to add?", "Add a Car",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            if (response == 3) {
                Random random = new Random();
                response = random.nextInt(3);
            }

            if (response == 0) {
                cars.add(new Volvo240(0, yPos));
                carPoint.add(new Point());
            } else if (response == 1) {
                cars.add(new Saab95(0, yPos));
                carPoint.add(new Point());
            } else if (response == 2) {
                cars.add(new Scania(0, yPos));
                carPoint.add(new Point());
            }

        }
    }
    void removeCar() {
        if (cars.size() > 0) {
            cars.remove(cars.get(cars.size() - 1));
            carPoint.remove(carPoint.get(carPoint.size() - 1));
        }
    }
}