import java.util.ArrayList;
import java.util.Arrays;

public class knapsack012 {
    // need to work on this.
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int N = B.size();
        int[] dp = new int[C+1];

        for(int i = 1; i <= C; i++) {
            for(int j = 0; j < N; j++) {
                if(B.get(j) <= i) {
                    dp[i] = Integer.max(dp[i-1], dp[i-B.get(j)]+A.get(j));
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return C;
    }
    public static void main(String[] args) {
        knapsack012 kp = new knapsack012();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(8, 5));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 20));
        int C = 17;
        kp.solve(A, B, C);
    }
}
