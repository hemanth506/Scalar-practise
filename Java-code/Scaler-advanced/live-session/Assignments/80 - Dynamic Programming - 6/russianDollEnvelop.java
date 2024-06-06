import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class russianDollEnvelop {
    public int solveWrong(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        HashMap<String, Integer> hs = new HashMap<>();
        int N = A.size();
        for (int i = 0; i < N; i++) {
            arr.add(A.get(i));
        }

        int maxV = getMaxCountWrong(A, arr, hs, N, 0) + 1;
        System.out.println(maxV);
        return maxV;
    }

    public int getMaxCountWrong(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> arr,
            HashMap<String, Integer> hs, int N, int i) {
        if (i == N) {
            return 0;
        }

        System.out.println("Hemanth = " + i);
        int height = arr.get(i).get(0);
        int width = arr.get(i).get(1);
        String st = height + "_" + width;
        if (!hs.containsKey(st)) {
            int ct = 0;
            System.out.println("initial = " + A.size());
            for (int k = 0; k < A.size(); k++) {
                System.out.println("check = " + k + " " + i);
                if (arr.get(i).get(0) > A.get(k).get(0) && arr.get(i).get(1) > A.get(k).get(1)) {
                    System.out.println(A + " " + arr);
                    A.remove(k);
                    System.out.println(A);
                    System.out.println("iterative = " + A.size() + " " + k);
                    ct += 1;
                }
            }
            System.out.println("====================");
            int val = getMaxCountWrong(A, arr, hs, N, i + 1) + ct;
            hs.put(st, val);
            // getMaxCount(A, arr, hs, N, i+1);
        }

        return hs.get(st);
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        System.out.println(A);

        Collections.sort(A, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.get(0) < o2.get(0)) {
                    return -1;
                } else if (o1.get(0) > o2.get(0)) {
                    return 1;
                }
                return 0;
            }
        });
        System.out.println(A);

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int maxV = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int h1 = A.get(i).get(0);
            int w1 = A.get(i).get(1);
            for (int j = 0; j < i; j++) {
                System.out.println(A.get(i).get(0) + " " + A.get(j).get(0));

                int h2 = A.get(j).get(0);
                int w2 = A.get(j).get(1);
                if (h1 > h2 && w1 > w2 && (dp[i] < dp[j] + 1)) {
                    System.out.println("Hemanth");
                    dp[i] = dp[j] + 1;
                    maxV = Integer.max(maxV, dp[i]);
                }
            }
            System.out.println("+++++++++++++++++++++");
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(maxV);
        return maxV;
    }

    public static void main(String[] args) {
        russianDollEnvelop rd = new russianDollEnvelop();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        // A.add(new ArrayList<Integer>(Arrays.asList(5, 4)));
        // A.add(new ArrayList<Integer>(Arrays.asList(6, 4)));
        // A.add(new ArrayList<Integer>(Arrays.asList(6, 7)));
        // A.add(new ArrayList<Integer>(Arrays.asList(2, 3)));

        // A.add(new ArrayList<Integer>(Arrays.asList(8, 9)));
        // A.add(new ArrayList<Integer>(Arrays.asList(8, 18)));

        A.add(new ArrayList<Integer>(Arrays.asList(6, 18)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, 14)));
        A.add(new ArrayList<Integer>(Arrays.asList(5, 6)));
        A.add(new ArrayList<Integer>(Arrays.asList(4, 15)));
        A.add(new ArrayList<Integer>(Arrays.asList(8, 11)));
        A.add(new ArrayList<Integer>(Arrays.asList(3, 11)));
        A.add(new ArrayList<Integer>(Arrays.asList(11, 10)));
        A.add(new ArrayList<Integer>(Arrays.asList(5, 11)));

        rd.solve(A);
    }
}
