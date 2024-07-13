import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Pair {
    int cost;
    int direction;
    Pair(int x, int y) {
        this.cost = x;
        this.direction = y;
    }
}

class customComp implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        if(o1.cost > o2.cost) {
            return 1;
        } else if (o1.cost < o2.cost){
            return -1;
        }
        return 0;
    }
}

public class damagedRoads {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        int M = B.size();
        int mod = 1000000007;
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            arr.add(new Pair(A.get(i), 1));
        }

        for(int i = 0; i < M; i++) {
            arr.add(new Pair(B.get(i), 0));
        }
        Collections.sort(arr, new customComp());

        N++;
        M++;
        long totCost = 0;
        for(int i = 0; i < arr.size(); i++) {
            int cost = arr.get(i).cost;
            int direction = arr.get(i).direction;
            if(direction == 1) {
                totCost = (totCost%mod + (cost%mod * M%mod)%mod)%mod;
                N--;
            } else {
                totCost = (totCost%mod + (cost%mod * N%mod)%mod)%mod;
                M--;
            }
        }
        System.out.println(totCost);
        return (int)totCost%mod;
    }
    public static void main(String[] args) {
        damagedRoads dr = new damagedRoads();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(4, 5, 6));

        dr.solve(A, B);
    }
}
