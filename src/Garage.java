import java.util.ArrayList;

public class Garage<T extends ICar> {
    int max;
    T type;
    ArrayList<T> spaces;

    Garage(int max, T type) {
        this.max = max;
        this.type = type;
    }

    public void insert(T vehicle) {
        spaces.add(vehicle);
    }

    public void pickUp(T vehicle) {
        int index;

        for (T v : spaces) {
             if (v.equals(vehicle)) {
                 spaces.remove(vehicle);
             }
        }
    }
}