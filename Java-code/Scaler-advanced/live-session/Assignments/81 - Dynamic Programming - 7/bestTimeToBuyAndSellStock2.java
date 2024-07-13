import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bestTimeToBuyAndSellStock2 {
    public int maxProfit(final List<Integer> A) {
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
    public static void main(String[] args) {
        bestTimeToBuyAndSellStock2 bst2 = new bestTimeToBuyAndSellStock2();
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 2, 4));
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2));

        bst2.maxProfit(A);
    }
}
