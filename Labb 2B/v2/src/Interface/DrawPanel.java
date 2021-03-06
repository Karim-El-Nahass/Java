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

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.black);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Remember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            backgroundImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Background.jpg"));

            images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Just a single image, TODO: Generalize
    ArrayList<BufferedImage> images = new ArrayList<>();

    BufferedImage backgroundImage;
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a single cars position
    ArrayList<Point> points = new ArrayList<>();

    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    // TODO: Make this general for all cars
    void moveit(/*String modelName,*/ String name, int x, int y){

        /*switch (modelName) {
            case "Volvo240":
                //points.get()
                break;
            case "Saab95":
                break;
            case "Scania":
        }*/

        if (name.equals("Volvo240")) {
            volvoPoint.x = x;
            volvoPoint.y = y;
        }
        if (name.equals("Saab95")) {
            saabPoint.x = x;
            saabPoint.y = y;
        }
        if (name.equals("Scania")) {
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);

        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null); // see javadoc for more info on the parameters
    }
}