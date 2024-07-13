import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class allSubarrays {

    // public int solve(int[] A) {
    //     Stack<Integer> st = new Stack<>();
    //     int res = 0;
    //     for (int i = 0; i < A.length; i++) {
    //         while (!st.isEmpty() && A[i] >= st.peek()) {
    //             int popelt = st.pop();
    //             System.out.println("popelt = " + popelt);
    //             res = Math.max(A[i] ^ popelt, res); // Max ^ 2nd max
    //         }

    //         if (!st.isEmpty()) {
    //             int peekelt = st.peek();
    //             System.out.println("peekelt = " + peekelt);
    //             res = Math.max(A[i] ^ st.peek(), res); // Min ^ Max
    //         }
    //         System.out.println("===push===" + A[i]);
    //         st.push(A[i]);
    //     }

    //     return res;
    // }


    // Brute force - N^3
    public int solveN3(ArrayList<Integer> A) {
        int N = A.size();
        int XORMax = Integer.MIN_VALUE; 
        boolean noSecMax = false;
        for(int i = 0; i < N; i++) {
            for(int j = (i+1); j < N; j++) {
                int firstMax = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++) {
                    firstMax = Integer.max(firstMax, A.get(k));
                }
                int secondMax = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++) {
                    if(A.get(k) != firstMax) {
                        secondMax = Integer.max(secondMax, A.get(k));
                        noSecMax = true;
                    }
                }
                System.out.println(firstMax + " " + secondMax);
                XORMax = Integer.max(XORMax, firstMax^secondMax);
            }
        }
        XORMax = !noSecMax ? 0 : XORMax;
        System.out.println(XORMax);
        return XORMax;
    }

    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        Stack<Integer> stk = new Stack<>();
        int maxV = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            while(!stk.isEmpty() && A.get(i) >= stk.peek()) {
                maxV = Integer.max(stk.peek()^A.get(i), maxV);
                stk.pop();
            }

            if(!stk.isEmpty()) {
                maxV = Integer.max(A.get(i) ^ stk.peek(), maxV);
            }

            stk.push(A.get(i));
        }
        System.out.println(maxV);
        return maxV;
    }

    
    public static void main(String[] args) {
        allSubarrays as = new allSubarrays();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 3, 1, 4));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,1));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(7569780, 6509094, 9066928, 9978215, 9990289, 500953, 5829073, 2862108, 2983492, 8356802));

        // int[] A = {2, 3, 1, 4}; 
        as.solve(A);

    }
}
