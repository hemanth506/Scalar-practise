import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Pair {
    int position;
    int speed;
    Pair(int p, int s) {
        this.position = p;
        this.speed = s;
    }
}

public class carFleet_Q853 {

    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        ArrayList<Pair> carArr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            carArr.add(new Pair(position[i], speed[i]));
        }

        Collections.sort(carArr, new CustomSort());
        for(int i = 0; i < N; i++) {
            System.out.println(carArr.get(i).position + " " + carArr.get(i).speed);
        }

        int totalCarFleet = 0;
        double lastCarArrivalTime = 0;
        for(int i = N-1; i >= 0; i--) {
            double arrivalTime = (target - carArr.get(i).position) / (double) carArr.get(i).speed;

            if (arrivalTime > lastCarArrivalTime) {
                totalCarFleet++;
                lastCarArrivalTime = arrivalTime;
            }
        }

        System.out.println(totalCarFleet);

        return totalCarFleet;
    }

    public static void main(String[] args) {
        carFleet_Q853 cf = new carFleet_Q853();
        // int target = 100;
        // int[] position = { 0, 2, 4 };
        // int[] speed = { 4, 2, 1 };

        // int target = 12;
        // int[] position = { 10, 8, 0, 5, 3 };
        // int[] speed = { 2, 4, 1, 1, 3 };

        // int target = 10;
        // int[] position = { 3 };
        // int[] speed = { 3 };

        // int target = 10;
        // int[] position = { 2, 4 };
        // int[] speed = { 3, 2 };

        int target = 20;
        int[] position = { 6, 2, 17 };
        int[] speed = { 3, 9, 2 };
        cf.carFleet(target, position, speed);
    }
}

class CustomSort implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        if(o1.position > o2.position) {
            return 1;
        } else if(o1.position < o2.position) {
            return -1;
        }
        return 0;
    }

}