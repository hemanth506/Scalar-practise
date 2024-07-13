import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Pair{
    int val;
    boolean result;
    Pair(int x, boolean y) {
        this.val = x;
        this.result = y;
    }
}

public class tusharBirthdayParty {
    public int getMinAmountError(int capacity, int i, int N, List<Integer> B, List<Integer> C, HashMap<String, Integer> hm, int curVal) {
        if (i >= N) {
            System.out.println("i >= N => " + i + " " + N);
            return Integer.MAX_VALUE;
        }
        if(capacity < 0) {
            System.out.println("capacity < 0 => " + capacity);
            return Integer.MAX_VALUE;
        }

        String st = capacity+"_"+i;
        if(!hm.containsKey(st)) {
            System.out.println("st = " + st);
            int leaveIt = getMinAmountError(capacity, i+1, N, B, C, hm, curVal);
            int takeIt = 0;
            if(capacity-B.get(i) >= 0) {
                takeIt = getMinAmountError(capacity-B.get(i), i, N, B, C, hm, curVal) ;
                curVal += C.get(i);
            }
            int minVal = Integer.min(leaveIt, takeIt);
            System.out.println("------minVal = " + minVal + "------");
            hm.put(st, minVal);
        }
        return hm.get(st);
    }
    
    public Pair getMinAmountWrong(int capacity, int i, int N, List<Integer> B, List<Integer> C, HashMap<String, Integer> hm, int curVal) {
        if(i >= N || capacity < 0) {
            return new Pair(0, false);
        }
        if(capacity == 0) {
            return new Pair(0, true);
        }

        String st = capacity+"_"+i;
        if(!hm.containsKey(st)) {
            Pair leaveIt = getMinAmountWrong(capacity, i+1, N, B, C, hm, curVal);
            Pair takeIt = getMinAmountWrong(capacity-B.get(i), i, N, B, C, hm, curVal);
            int res = takeIt.val + C.get(i);
            int minVal = Integer.MAX_VALUE;
            if(leaveIt.result && takeIt.result) {
                minVal = Integer.min(leaveIt.val, res);
            }
            System.out.println("i = "+i+" leaveIt = "+leaveIt+" takeIt = "+takeIt+" minVal = "+minVal);
            hm.put(st, minVal);
        }

        return new Pair(hm.get(st), true);
    }

    public int getMinAmount(int capacity, int i, int N, List<Integer> B, List<Integer> C, HashMap<String, Integer> hm) {
        if(i < 0) {
            return 0;
        }

        if(capacity == 0) {
            return 0;
        }

        String st = capacity+"_"+i;
        if(!hm.containsKey(st)) {
            int leaveIt = getMinAmount(capacity, i-1, N, B, C, hm);
            int takeIt = 0;
            if(capacity >= B.get(i)) {
                takeIt = getMinAmount(capacity-B.get(i), i-1, N, B, C, hm) + C.get(i);
            }
            int minVal = Integer.min(leaveIt, takeIt);
            System.out.println("i = "+i+" leaveIt = "+leaveIt+" takeIt = "+takeIt+" minVal = "+minVal);
            hm.put(st, minVal);
        }

        return hm.get(st);
    }    
    
    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int N = A.size();
        int M = B.size();
        int total = 0;
        for(int i = 0; i < A.size(); i++) {
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            System.out.println("=======i = " + i + " ===== A = " + A.get(i) + " =======");
            total += getMinAmount(A.get(i), N-1, M, B, C, hm);
            // total += getMinAmount(A.get(i), 0, M, B, C, hm, curVal).val;

            System.out.println("=======total=======" + total);
        }
        System.out.println("total = " + total);
        return total;
    }
    
    public static void main(String[] args) {
        tusharBirthdayParty tbp = new tusharBirthdayParty();
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 4, 6));
        List<Integer> B = new ArrayList<Integer>(Arrays.asList(2, 1, 3));
        List<Integer> C = new ArrayList<Integer>(Arrays.asList(2, 5, 3));

        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(2));
        // List<Integer> B = new ArrayList<Integer>(Arrays.asList(1));
        // List<Integer> C = new ArrayList<Integer>(Arrays.asList(2));

        tbp.solve(A, B, C);
    }
}
