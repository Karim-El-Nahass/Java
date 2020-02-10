import java.util.ArrayList;

public class Garage<T extends ICar> {
    int max;
    T type;
    ArrayList<T> spaces = new ArrayList<T>();

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
        T x = null;

        for (T v : spaces) {
             if (v.equals(vehicle)) {

                 x = vehicle;
                 spaces.remove(vehicle);
                 break;
             }
        }
        return x;
    }
}