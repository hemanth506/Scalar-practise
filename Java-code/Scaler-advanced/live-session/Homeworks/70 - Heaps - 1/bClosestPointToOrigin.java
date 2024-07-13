import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    int val;
    ArrayList<Integer> arr = new ArrayList<>();

    Pair(int value, ArrayList<Integer> A) {
        this.val = value;
        this.arr = A;
    }
}

class comparePair implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return Long.compare(o1.val, o2.val);
    }
}

public class bClosestPointToOrigin {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> {
            int OriginToCord1 = a.get(0) * a.get(0) + a.get(1) * a.get(1);
            int OriginToCord2 = b.get(0) * b.get(0) + b.get(1) * b.get(1);
            return OriginToCord1 - OriginToCord2;
        });
        for (ArrayList<Integer> i : A) {
            pq.add(i);
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < B; i++) {
            res.add(pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        bClosestPointToOrigin bc = new bClosestPointToOrigin();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        A.add(new ArrayList<Integer>(Arrays.asList(-2, 2)));

        int B = 1;

        bc.solve(A, B);
    }
}
