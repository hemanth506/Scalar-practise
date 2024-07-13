import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxProductSubarray {

    public int maxProduct(final List<Integer> A) {
        int N = A.size();
        int maxV = A.get(N-1);
        int minV = A.get(N-1);
        int res = maxV;

        for(int i = N-2; i >= 0; i--) {
            int fp = maxV * A.get(i);
            int sp = minV * A.get(i);
            maxV = Math.max(fp, Math.max(A.get(i), sp));
            minV = Math.min(fp, Math.min(A.get(i), sp));
            res = Math.max(maxV, res);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        maxProductSubarray mp = new maxProductSubarray();
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 2, -5, 1));
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(-3, 0, -5, 0));

        List<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 0, 0, -3, -2, 0, 1, 0, 0, 0, 0, 0, -2, 0, 0, 0, 3, 3, 0, 0, 0, 0, 3));

        mp.maxProduct(A);
    }
}
