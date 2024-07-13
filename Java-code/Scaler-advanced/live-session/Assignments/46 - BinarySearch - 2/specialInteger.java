import java.util.ArrayList;
import java.util.Arrays;

// Faced datatype issue for large inputs - So for that used the validation in one function and solved this. 
public class specialInteger {
    public boolean findMaxVal(ArrayList<Integer> A, int k, int B) {
        System.out.println("size => " + k);

        int N = A.size();
        long sumVal = 0;
        for (int i = 0; i < k; i++) {
            sumVal += A.get(i);
        }
        System.out.println("Initial sum => " + sumVal);
        if (sumVal > B) {
            return false;
        }
        // int maxVal = sumVal;
        for (int i = k; i < N; i++) {
            sumVal = sumVal - A.get(i - k) + A.get(i);
            // maxVal = Integer.max(maxVal, sumVal);
            if (sumVal > B) {
                return false;
            }
        }
        // System.out.println("maxVal => " + maxVal);
        return true;
    }

    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int l = 1;
        int r = N;
        int maxSize = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            System.out.println("m => " + m);
            boolean maxVal = findMaxVal(A, m, B);
            if (maxVal) {
                maxSize = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
            System.out.println("================================");

        }
        System.out.println("maxSize => " + maxSize);
        return maxSize;
    }

    public static void main(String[] args) {
        specialInteger si = new specialInteger();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 17, 100, 11));
        // int B = 130;
        // si.solve(A, B); // ans = 3

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        int B = 10;
        si.solve(A, B); // ans = 2

        // si.findMaxVal(A, 3);

        // ArrayList<Integer> C = new
        // ArrayList<Integer>(Arrays.asList(1,2,3,4,5,17,100,11));
        // int D = 3;
    }
}
