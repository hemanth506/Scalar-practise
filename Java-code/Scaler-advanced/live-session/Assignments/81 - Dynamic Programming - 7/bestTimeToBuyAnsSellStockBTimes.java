import java.util.ArrayList;
import java.util.Arrays;

public class bestTimeToBuyAnsSellStockBTimes {

    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        if(N < B) {
            B = N;
        }
        if(N == 0) {
            return 0;
        }
        int[][][] dp = new int[N+1][2][B+1];
        for(int i = 0; i < B; i++) {
            dp[N][0][i] = 0;
        }

        for(int i = N-1; i >= 0; i--) {
            for(int j = 0; j < 2; j++) {
                for(int k = 1; k <= B; k++) {
                    if(j == 0) {
                        int notBuy = dp[i+1][0][k];
                        int buy = -1*A.get(i) + dp[i+1][1][k];
                        dp[i][j][k] = Integer.max(notBuy, buy);
                    } else {
                        int notSell = dp[i+1][1][k];
                        int sell = A.get(i) + dp[i+1][0][k-1];
                        dp[i][j][k] = Integer.max(notSell, sell);

                    }
                }
            }
        }
        return dp[0][0][B];
    }
    
    public static void main(String[] args) {
        bestTimeToBuyAnsSellStockBTimes bt = new bestTimeToBuyAnsSellStockBTimes();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 2, 6, 5, 0, 3));
        int B = 2;
        bt.solve(A, B);
    }
}
