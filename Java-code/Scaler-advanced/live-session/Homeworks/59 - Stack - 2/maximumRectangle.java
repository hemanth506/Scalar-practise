import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class maximumRectangle {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        int resultV = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i != 0 && A.get(i).get(j) == 1) {
                    int curVal = A.get(i).get(j) + A.get(i - 1).get(j);
                    A.get(i).set(j, curVal);
                }
            }
            System.out.println(A);
            int maxV = getMaxVal(A, i);
            resultV = Integer.max(maxV, resultV);
        }

        System.out.println(resultV);
        return resultV;
    }

    public int getMaxVal(ArrayList<ArrayList<Integer>> A, int r) {
        int col = A.get(r).size();
        int maxVal = Integer.MIN_VALUE;
        int[] left = nearestMinLtoR(A.get(r));
        int[] right = nearestMinRtoL(A.get(r));
        for (int c = 0; c < col; c++) {
            int width = right[c] - left[c] - 1;
            int height = A.get(r).get(c);
            int area = width * height;
            System.out.println(width +" " + height + " " + area);
            maxVal = Integer.max(area, maxVal);
        }
        return maxVal;
    }

    public int[] nearestMinLtoR(ArrayList<Integer> B) {
        int col = B.size();
        Stack<Integer> stk = new Stack<>();
        // the edge index is -1
        int[] arr = new int[col];
        Arrays.fill(arr, -1);
        for (int c = 0; c < col; c++) {
            while (!stk.isEmpty() && B.get(c) <= B.get(stk.peek())) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                arr[c] = stk.peek();
            }
            stk.push(c);
        }
        return arr;
    }

    // the edge index is colun size
    public int[] nearestMinRtoL(ArrayList<Integer> B) {
        int col = B.size();
        Stack<Integer> stk = new Stack<>();
        int[] arr = new int[col];
        Arrays.fill(arr, col);
        for (int c = col - 1; c >= 0; c--) {
            while (!stk.isEmpty() && B.get(c) <= B.get(stk.peek())) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                arr[c] = stk.peek();
            }
            stk.push(c);
        }
        return arr;
    }

    public static void main(String[] args) {
        maximumRectangle maxR = new maximumRectangle();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));

        /*
         * [[0, 0, 1],
         * [0, 1, 2], [1, 2, 3]]
         */

        // A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1, 0, 1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 0, 0)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1, 1, 1, 1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 0, 0, 1)));

        // A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 1, 0, 1, 0, 0)));
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 1, 1, 0, 0, 0)));
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 1, 0, 1, 0, 1)));

        // A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0)));

        A.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 0)));

        maxR.solve(A);
    }
}
