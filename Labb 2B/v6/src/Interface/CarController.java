package Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    GroupCars groupCars = new GroupCars();
    CarView carView = new CarView("CarSim 1.0", this);


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */


    //methods:
    // void addCarButton() { groupCars.createCar(); }

    void setCarsDir(Vehicle.direction dir) { groupCars.setCarsDir(dir); }

    // Calls the gas method for each car once
    ActionListener gasButton(CarView carView) {
        return (new ActionListener() { public void actionPerformed(ActionEvent e) {
            groupCars.gas(carView.gasAmount);
        }});
    }

    // Calls the gas method for each car once
    ActionListener brakeButton(CarView carView) {
        return (new ActionListener() { public void actionPerformed(ActionEvent e) {
            groupCars.brake(carView.gasAmount);
        }});
    }

    ActionListener startEngineButton() {
        return (new ActionListener() { public void actionPerformed(ActionEvent e) { groupCars.startEngine(); }});
    }

    ActionListener stopEngineButton() {
        return (new ActionListener() { public void actionPerformed(ActionEvent e) { groupCars.stopEngine(); }});
    }

    ActionListener turboOnButton() {
        return (new ActionListener() { public void actionPerformed(ActionEvent e) { groupCars.turboOn(); }});
    }

    ActionListener turboOffButton() {
        return (new ActionListener() { public void actionPerformed(ActionEvent e) { groupCars.turboOff(); }});
    }

    ActionListener liftBedButton() {
        return (new ActionListener() { public void actionPerformed(ActionEvent e) { groupCars.liftBed(); }});
    }

    ActionListener lowerBedButton() {
        return (new ActionListener() { public void actionPerformed(ActionEvent e) { groupCars.lowerBed(); }});
    }

    ActionListener addCarButton(CarView carView) {
        return (new ActionListener() { public void actionPerformed(ActionEvent e) {
            groupCars.createCar();
            carView.repaint();
        }});
    }

    ActionListener removeCarButton(CarView carView) {
        return (new ActionListener() { public void actionPerformed(ActionEvent e) {
            groupCars.removeCar(carView);
        }});
    }
}