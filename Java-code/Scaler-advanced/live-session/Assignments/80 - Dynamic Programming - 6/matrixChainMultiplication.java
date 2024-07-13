import java.util.ArrayList;
import java.util.Arrays;

public class matrixChainMultiplication {
    int[][] dp;
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        dp = new int[N+1][N+1];
        for(int i = 0; i < N+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(Arrays.deepToString(dp));
        int minV = minCost(A, 1, N-1);
        System.out.println(minV);
        return 0;
    }

    public int minCost(ArrayList<Integer> A, int i, int j) {
        if(i == j) {
            System.out.println("return " + i + " " + j);
            return 0;
        }

        System.out.println(i + " " + j);
        if(dp[i][j] == -1) {
            int c = Integer.MAX_VALUE;
            for(int k = i; k < j; k++) {
                int val = minCost(A, i, k) + minCost(A, k+1, j) + A.get(i-1) * A.get(k) * A.get(j);
                c = Integer.min(c, val);
            }
            dp[i][j] = c;
        }
        return dp[i][j];
    }
    
    public static void main(String[] args) {
        matrixChainMultiplication mcm = new matrixChainMultiplication();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(40, 20, 30, 10, 30));
        mcm.solve(A);
    }
}
