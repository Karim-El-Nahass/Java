package Vehicles;


import Interface.CarView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GroupCars {
    public GroupCars() {

        carFactory = new CarFactory();
        cars = new ArrayList<>();
        carPoints = new ArrayList<>();
    }

    public CarFactory carFactory;
    public ArrayList<Vehicle> cars;
    public ArrayList<Point> carPoints;

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    //methods:
    public void setCarsDir(String direction) {
        for (Vehicle car : cars) {
            car.setCurrentDir(direction);
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        // System.out.println(gas);
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    // Calls the gas method for each car once
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    public void startEngine() {
        for (Vehicle car : cars) {
            if (!car.engineOn) {
                car.startEngine();
            }
        }
    }

    public void stopEngine() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }

    public void turboOn() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Saab95")) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Saab95")) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public void liftBed() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                ((Scania) car).raise(30);
                System.out.println(((Scania) car).getFlatBedAngle());
            }
        }
    }

    public void lowerBed() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                ((Scania) car).lower(30);
                System.out.println(((Scania) car).getFlatBedAngle());
            }
        }
    }

    public void createCar(/*Vehicle carType*/) {
        if (cars.size() != 10) {

            String[] options = new String[]{"Volvo240", "Saab95", "Scania", "Random"};
            int response = JOptionPane.showOptionDialog(null, "What car do you want to add?", "Add a Car",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            Random random = new Random();

            if (response == 3) {
                // Random random = new Random();
                response = random.nextInt(3);
            }

            int size = cars.size();
            int yPos = 60 * size;

            if ((cars.size() < 10) && (response != -1)) {
                Vehicle car = carFactory.makeCar(response, 0, yPos);
                cars.add(car);
                carPoints.add(new Point());
            }
        }
    }

    public void removeCar(CarView carView) {
        if (cars.size() > 0) {
            cars.remove(cars.get(cars.size() - 1));
            carPoints.remove(carPoints.get(carPoints.size() - 1));
            carView.repaint();
        }
    }
}