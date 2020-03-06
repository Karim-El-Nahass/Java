package Interface;

import Vehicles.Vehicle;
import Vehicles.Volvo240;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    CarController carC;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController carC) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.darkGray);
        this.carC = carC;
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Remember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a single cars position
   /* Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();*/


    // TODO: Make this general for all cars
    void moveit(int index, int x, int y){
        carC.carPoint.get(index).x = x;
        carC.carPoint.get(index).y = y;

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                if (j % 2 == 0) {
                    g.setColor(Color.white);
                    g.drawLine(20+j * 50, i * 61, 20+(j + 1) * 50, i * 61);
                } else {
                    g.setColor(Color.darkGray);
                    g.drawLine(20+j * 50, i * 61, 20+(j + 1) * 50, i * 61);
                }
            }
        }

        int index = 0;
        for (Point point : carC.carPoint) {
            String carModel = carC.cars.get(index).getModelName();
            switch (carModel) {
                case "Volvo240":
                    g.drawImage(volvoImage, point.x, point.y, null); // see javadoc for more info on the parameters
                    break;
                case "Saab95":
                    g.drawImage(saabImage, point.x, point.y, null); // see javadoc for more info on the parameters
                    break;
                case "Scania":
                    g.drawImage(scaniaImage, point.x, point.y, null); // see javadoc for more info on the parameters
                    break;
            }
            index++;
        }
        if (carC.carPoint.size() == 1) {
            repaint();
        }
    }
}