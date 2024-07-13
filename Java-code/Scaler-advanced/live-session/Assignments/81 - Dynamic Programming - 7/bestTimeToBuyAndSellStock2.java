import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bestTimeToBuyAndSellStock2 {
    public int maxProfitWithoutDP(final List<Integer> A) {
        int N = A.size();
        int profit = 0;
        for(int i = 0; i < N-1; i++) {
            if(A.get(i) >= A.get(i+1)) {
                continue;
            }
            profit += A.get(i+1) - A.get(i);
        }
        System.out.println(profit);
        return profit;
    }

    // ==============================================
    // correct approach but Stack Overflow error.
    public int maxProfit(final List<Integer> A) {
        int N = A.size();
        if(N == 0) {
            return 0;
        }
        int[][] dp = new int[N][2];
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        helper(0, 0, dp, A);
        // System.out.println(dp[0][0]);
        return dp[0][0];
    }
    private int helper(int i, int j, int[][] dp, List<Integer> A) {
        if(i == A.size()) {
            return 0;
        }

        if(dp[i][j] == -1) {
            if(j == 0) {
                dp[i][j] = Integer.max(helper(i+1, 0, dp, A), -1*A.get(i) + helper(i+1, 1, dp, A));
            } else {
                dp[i][j] = Integer.max(helper(i+1, 1, dp, A), A.get(i) + helper(i+1, 0, dp, A));
            }
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        bestTimeToBuyAndSellStock2 bst2 = new bestTimeToBuyAndSellStock2();
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 2, 4));
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2));
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(5,2,10));

        bst2.maxProfit(A);
    }
    
}
