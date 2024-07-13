import java.util.ArrayList;

public class flipBinary {
    public ArrayList<Integer> flipN2(String A) {
        int N = A.length();
        ArrayList<Integer> al = new ArrayList<>();

        int ones = 0;
        for(int j = 0; j < N; j++) {
            if(A.charAt(j) == '1') {
                ones += 1;
            }
        }
        System.out.println(ones);
        if (ones == N) {
            return al;
        }

        int ans = 0;
        int stId = 0;
        int endId = 0;
        boolean noMax = false;
        for(int i = 0; i < N; i++) {
            int ct0 = 0;
            int ct1 = 0;
            for(int j = i; j < N; j++) {
                if(A.charAt(j) == '1') {
                    ct1 += 1;
                } else {
                    ct0 += 1;
                }

                int curVal = ones - ct1 + ct0;
                if (curVal > ans) {
                    stId = i;
                    endId = j;
                    ans = curVal;
                }
                System.out.println("Index => " + A.substring(i, j+1) + "  count => " + curVal + " " + ans);
                noMax = true;
            }
        }
        System.out.println(stId + " " + endId);
        if (noMax) {
            al.add(stId+1);
            al.add(endId+1);
        }
        System.out.println(al);
        return al;
    }

    // working code
    public ArrayList<Integer> flip(String A) {
        int N = A.length();
        ArrayList<Integer> al = new ArrayList<Integer>();

        int ones = 0;
        for(int j = 0; j < N; j++) {
            if(A.charAt(j) == '1') {
                ones += 1;
            }
        }

        if (ones == N) {
            return al;
        }

        int maxV = 0;
        int sumV = 0;
        int startInd = 0;
        int endInd = -1;
        int index = 0;
        for(int i = 0; i < N; i++) {
            if (A.charAt(i) == '1') {
                sumV -= 1;
            } else {
                sumV += 1;
            }
            if (sumV < 0) {
                sumV = 0;
                index = i + 1;
            }
            if(sumV > maxV) {
                maxV = sumV;
                startInd = index;
                endInd = i;
            }
            // System.out.println(i + " " + sumV + " " + maxV);
        }
        System.out.println(startInd + " " + endInd + " " + maxV);
        if (endInd != -1) {
            al.add(startInd + 1);
            al.add(endInd + 1);
        }
        System.out.println(al);
        return al;
    }
    
    public static void main(String[] args) {
        flipBinary fp = new flipBinary();
        String A = "010";
        // String A = "111";
        // String A = "101";

        // String A = "1001000101101";
        // String A = "100010000101101";

        fp.flip(A);
    }
}
