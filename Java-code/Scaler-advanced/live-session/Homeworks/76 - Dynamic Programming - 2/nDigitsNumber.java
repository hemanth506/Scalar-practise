import java.util.HashMap;

public class nDigitsNumber {
    int res = 0;
    int actualA = 0;

    public int getRecursiveCountBruteForce(int A, int B) {
        if (B < 0) {
            return 0;
        }
        if (B == 0) {
            return res += 1;
        }
        if (A == 0) {
            return 0;
        }

        int strt = actualA == A ? 1 : 0;
        for (int i = strt; i <= 9; i++) {
            // System.out.println((A-1) + " " + (B-i));
            getRecursiveCountBruteForce(A - 1, B - i);
        }
        return res;
    }

    public int solveBruteForce(int A, int B) {
        actualA = A;
        getRecursiveCountBruteForce(A, B);
        System.out.println(res);
        return res;
    }

    // ===========================================

    public int getRecursiveCount(int A, int B, HashMap<String, Integer> hm) {
        if (B < 0) {
            return 0;
        }
        if (A == 0 && B == 0) {
            return 1;
        }
        if (A == 0) {
            return 0;
        }

        String st = A + "_" + B;
        if (!hm.containsKey(st)) {
            int val = 0;
            for (int i = 0; i <= 9; i++) {
                val += getRecursiveCount(A - 1, B - i, hm);
                val %= 1000000007;
            }
            hm.put(st, val);
        }
        return hm.get(st);
    }

    public int solve(int A, int B) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int val = 0;
        for (int i = 1; i <= 9; i++) {
            val += getRecursiveCount(A - 1, B - i, hm);
            val %= 1000000007;
        }
        // System.out.println(hm);
        System.out.println(val);
        return val;
    }

    public static void main(String[] args) {
        nDigitsNumber nd = new nDigitsNumber();
        int A = 3;
        int B = 19;
        // int A = 2;
        // int B = 4;
        nd.solve(A, B);
        // nd.solveBruteForce(A, B);

    }

}
