import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class greaterThanKInGivenRange {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        // build tree
        int N = A.size();
        HashMap<Integer, ArrayList<Integer>> hmList = new HashMap<>();
        buildTree(0, N-1, A, 1, hmList);

        ArrayList<Integer> resArr = new ArrayList<>();
        for(int i = 0; i < B.size(); i++) {
            int l = B.get(i).get(0);
            int r = B.get(i).get(1);
            int x = B.get(i).get(2);
            int ans = 0;
            int val = countVal(1, 0, N-1, hmList, l, r, x, ans);
            resArr.add(val);
        }
        System.out.println(resArr);
        return A;
    }
    private void buildTree(int l, int r, ArrayList<Integer> A, int i, HashMap<Integer, ArrayList<Integer>> hmList) {
        if(l == r) {
            hmList.put(i, new ArrayList<Integer>(Arrays.asList(A.get(l))));
            return;
        }
        int m = (l + r) / 2;
        // System.out.println("l = " + l + " r = " + r + " m = " + m);
        buildTree(l, m, A, 2*i, hmList);
        buildTree(m+1, r, A, (2*i)+1, hmList);
        hmList.put(i, mergeArray(hmList.get(2*i), hmList.get((2*i)+1)));
    }
    private int countVal(int i, int l, int r, HashMap<Integer, ArrayList<Integer>> hmList, int lq, int rq, int x, int ans) {
        if (lq <= l && r <= rq) {
            return count(hmList.get(i), x);
        } 

        if(rq < l || r < lq) {
            return 0;
        }

        int m = (l+r)/2;
        int a = countVal(2*i, l, m, hmList, lq, rq, x, ans);
        int b = countVal((2*i)+1, m+1, r, hmList, lq, rq, x, ans);
        ans += a + b;
        return ans;
    }
    private int count(ArrayList<Integer> arrList, int x) {
        int N = arrList.size();
        int l = 0;
        int h = N-1;
        int m = 0;
        while (l > h) {
            
            m = (l+h) / 2;
            if(arrList.get(m) > x) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return N-m;
    }
    
    private ArrayList<Integer> mergeArray(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        int N = arr1.size();
        int M = arr2.size();

        ArrayList<Integer> C = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < N && p2 < M) {
            if(arr1.get(p1) > arr2.get(p2)) {
                C.add(arr2.get(p2));
                p2++;
            } else {
                C.add(arr1.get(p1));
                p1++;
            }
        }

        if(p1 < N) {
            C.add(arr1.get(p1));
            p1++;
        } else if (p2 < M) {
            C.add(arr1.get(p2));
            p2++;
        }
        return C;
    }
    public static void main(String[] args) {
        greaterThanKInGivenRange gk = new greaterThanKInGivenRange();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(7, 3, 9, 13, 5, 4));
        // ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        // B.add(new ArrayList<Integer>(Arrays.asList(1, 4, 6)));
        // B.add(new ArrayList<Integer>(Arrays.asList(2, 6, 8)));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 8, 3)));
        B.add(new ArrayList<Integer>(Arrays.asList(5, 7, 10)));

        gk.solve(A, B);
    }
}
