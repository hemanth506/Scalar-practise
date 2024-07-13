import java.util.ArrayList;
import java.util.Arrays;
// todo
public class bestTimeToBuyAndSellStockCooldown {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        if(N == 0) {
            return 0;
        }

        int[][] dp = new int[N+1][2];
        for(int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[N][0] = dp[N][1] = 0;
        dp[N-1][0] = dp[N-1][1] = 0;

        for(int i = 2; i < N-2; i++) {
            for(int j = 0; j < 2; j++) {
                if(j == 0) {
                    int notBuy = dp[i-1][0];
                    int buy = -1*A.get(i) + dp[i-1][1];
                    dp[i][j] = Integer.max(notBuy, buy);
                } 
                // Sell
                else {
                    int notSell = dp[i-1][1];
                    int sell = A.get(i) + dp[i-2][0];
                    dp[i][j] = Integer.max(notSell, sell);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[0][0]);
        return 0;
    }
    public static void main(String[] args) {
        bestTimeToBuyAndSellStockCooldown cd = new bestTimeToBuyAndSellStockCooldown();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 0, 2));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 1));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(9, 14, 11, 1, 4, 15, 10, 7, 12, 9, 7, 16, 11, 11));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(9, 20, 6, 9, 3, 5, 7, 11, 11, 7, 6, 12, 15));


        cd.solve(A);
    }
}