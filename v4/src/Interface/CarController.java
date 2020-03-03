package Interface;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import Vehicles.*;

import javax.swing.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    // A list of cars, modify if needed
    CarFactory carFactory = new CarFactory();
    ArrayList<Vehicle> cars = new ArrayList<>();
    ArrayList<Point> carPoints = new ArrayList<>();

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    //methods:
    void createCar(/*Vehicle carType*/) {

        String[] options = new String[] {"Volvo240", "Saab95", "Scania", "Random"};
        int response = JOptionPane.showOptionDialog(null, "What car do you want to add?", "Add a Car",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        Random random = new Random();

        if (response == 3) {
            // Random random = new Random();
            response = random.nextInt(3);
        }

        int xPos = random.nextInt(600) + 100;
        int yPos = 20;

        for (Point point : carPoints) {
            int temp = 80;
            if ((point.y == yPos) && (cars.size() < 7)) {
                yPos = yPos + temp;
                temp += 80;
            }
        }

        if ((cars.size() < 7) && (response != -1)) {
            Vehicle car = carFactory.makeCar(response, 0, yPos);
            cars.add(car);
            carPoints.add(new Point());
        }
    }

    void removeFirstCar() {
        cars.remove(0);
        carPoints.remove(0);
    }

    void setCarsDir(String direction) {
        for (Vehicle car : cars) {
            car.setCurrentDir(direction);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    // Calls the gas method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
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

    /*
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
    */
}