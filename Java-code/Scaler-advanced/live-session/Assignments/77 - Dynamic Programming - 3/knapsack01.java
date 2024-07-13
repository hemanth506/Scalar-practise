import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class knapsack01 {
    public int knapsack(ArrayList<Integer> A, ArrayList<Integer> B, int C, HashMap<String, Integer> hm, int i, int N) {
        if (i < 0) {
            return 0;
        }

        String st = C + "_" + i;
        if (!hm.containsKey(st)) {
            int leaveIt = knapsack(A, B, C, hm, i - 1, N);
            int takeIt = 0;
            if (C >= B.get(i)) {
                takeIt = (knapsack(A, B, (C - B.get(i)), hm, i - 1, N) + A.get(i));
            }
            int val = Integer.max(leaveIt, takeIt);
            hm.put(st, val);
        }

        return hm.get(st);
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int N = A.size();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int maxV = knapsack(A, B, C, hm, N - 1, N);
        System.out.println(maxV);
        return maxV;
    }
    
    

    public static void main(String[] args) {
        knapsack01 ks = new knapsack01();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(60, 100, 120));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(10, 20, 30));
        int C = 50;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(12, 13, 15, 19));
        // int C = 10;
        ks.solve(A, B, C);
    }
}
