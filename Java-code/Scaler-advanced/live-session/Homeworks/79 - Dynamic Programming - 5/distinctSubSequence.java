import java.util.Arrays;

public class distinctSubSequence {
    String tempB;
    int totCount, totLen;

    public int numDistinctTLE(String A, String B) {
        totLen = A.length();
        totCount = 0;
        if (A.equals(B)) {
            System.out.println(1);
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totLen; i++) {
            sb.append(A.charAt(i));
        }
        System.out.println(sb);
        tempB = B;

        getDistinctSubseq(sb, totLen - 1);
        System.out.println(totCount);
        return totCount;
    }

    private void getDistinctSubseq(StringBuilder sb, int charInd) {
        if (charInd < 0) {
            return;
        }
        System.out.println("charInd = " + charInd);

        getDistinctSubseq(sb, charInd - 1);
        // incrementPlusOne(sb, charInd);

        char delChar = sb.charAt(charInd);
        sb.deleteCharAt(charInd);
        incrementPlusOne(sb, charInd);

        getDistinctSubseq(sb, charInd - 1);
        sb.insert(charInd, delChar);

    }

    private void incrementPlusOne(StringBuilder sb, int charInd) {
        if (sb.toString().equals(tempB)) {
            System.out.println(sb.toString() + " " + tempB + " " + charInd);
            totCount += 1;
        }
    }

    // ===============================================================================

    // Bottom up approach
    int[][] dp;
    public int numDistinct(String A, String B) {
        int N = A.length();
        int M = B.length();
        dp = new int[N][M];
        for (int rows[] : dp) {
            Arrays.fill(rows, -1);
        }
        int val = helper(A, N-1, M-1, B);
        System.out.println(Arrays.deepToString(dp));
        System.out.println(val);
        return val;
    }

    private int helper(String A, int posI, int posJ, String B) {

        if (posJ < 0) {
            System.out.println(posI);
            return 1;
        }

        if (posI < 0) {
            return 0;
        }

        if (dp[posI][posJ] == -1) {
            int ct = helper(A, posI - 1, posJ, B); // not take
            if (A.charAt(posI) == B.charAt(posJ)) { // if char are same
                ct += helper(A, posI - 1, posJ - 1, B); // take
            }

            dp[posI][posJ] = ct;
        }

        return dp[posI][posJ];
    }

    public static void main(String[] args) {
        distinctSubSequence ds = new distinctSubSequence();
        String A = "rabbbit";
        String B = "rabbit";

        // String A = "abc";
        // String B = "abc";

        ds.numDistinct(A, B);
    }
}
