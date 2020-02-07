import java.util.ArrayList;

public class Garage<T extends ICar> {
    int max;
    T type;
    ArrayList<T> spaces;

    Garage(int max) {
        this.max = max;
//        this.type = type;
    }

    public void insert(T vehicle) {
        if (spaces.size() != max) {
            spaces.add(vehicle);
        }
    }

    T pickUp(T vehicle) {
//        int index;

        for (T v : spaces) {
             if (v.equals(vehicle)) {

                 spaces.remove(vehicle);
             }
        }
        return vehicle;
    }
}