import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 
 */

public class pointOnSameLine {
    // used Video explanation to understand the approach
    public int GCD(int A, int B) {
        if (B == 0) {
            return A;
        }
        return GCD(B, A % B);
    }

    public int sameLine(ArrayList<Integer> A, ArrayList<Integer> B, int fixedId, int j, int N) {
        int X1 = A.get(fixedId);
        int Y1 = B.get(fixedId);

        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        int count = 1;
        int cur_max = 0;
        for (int id = 0; id < N; id++) {
            if (id != fixedId) {
                int X2 = A.get(id);
                int Y2 = B.get(id);
                if (X1 == X2 && Y1 == Y2) {
                    count += 1;
                } else {
                    int x = X1 - X2;
                    int y = Y1 - Y2;

                    int gcd = GCD(x, y);
                    x = x / gcd;
                    y = y / gcd;
                    String str = "" + x + "|" + y;

                    hs.put(str, hs.getOrDefault(str, 0) + 1);
                    cur_max = Math.max(cur_max, count);
                    if (hs.containsKey(str)) {
                        cur_max = Math.max(cur_max, count + hs.get(str));
                    }
                }
            }
        }

        return cur_max;
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        if (N < 3) {
            return N;
        }
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            maxCount = Integer.max(maxCount, sameLine(A, B, i, i + 1, N));
        }
        // System.out.println(maxCount);
        return maxCount;
    }

    public static void main(String[] args) {
        pointOnSameLine ps = new pointOnSameLine();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-1, 0, 1, 2, 3,
        // 3));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 0, 1, 2, 3,
        // 4));
        // ans = 4

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 1, 4, 5, 7,
        // -9, -8, 6));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(4, -8, -3, -2,
        // -1, 5, 7, -4));
        // ans = 2

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(6, -7, 5, 9, -9,
        // -7));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(7, 5, 5, 9, -8,
        // 2));
        // ans = 2

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-10, 7, 4, -5,
        // 4));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(-6, -4, -6, 0,
        // -8));
        // ans = 2

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(6, -5, 3, -6, 3, -9, -8, -7));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(5, 0, -8, 1, -1, 6, 3, -3));
        // ans = 3

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 1, -7, 4, 1,
        // -2, -7, 5));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(-6, -7, 3, -10,
        // 7, -10, 1, 2));
        // ans = 3

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-5, -10, -5, -5,
        // 4, 0, -2, 5));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(-1, -4, 5, 1, 6,
        // 3, -10, -1));
        // ans = 3
        ps.solve(A, B);
    }
}

/* 
 * public int solve(int[] A, int[] B) {

        int res = 0;
        for(int i=0; i<A.length; i++) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int count = 1;
            String str = "";
            int cur_max = 0;
            for(int j=0; j<A.length; j++) {
                if(i != j) {
                    if(A[i] == A[j] && B[j] == B[i]) { 
                        count++; 
                    } else {
                        int numerator = B[i]-B[j];
                        int denominator = A[i]-A[j];
                        int gcd = findGCD(numerator, denominator);
                        str = ""+(numerator/gcd)+"-"+(denominator/gcd);
                        map.put(str, map.getOrDefault(str, 0) + 1);                
                        cur_max = Math.max(cur_max, count);
                        if(map.containsKey(str)) {
                            cur_max = Math.max(cur_max, count + map.get(str));
                        }
                    }
                }
            }
            res = Math.max(res, cur_max);
        }
        return res;
    }
    int findGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return findGCD(b, a%b);
    }
 */