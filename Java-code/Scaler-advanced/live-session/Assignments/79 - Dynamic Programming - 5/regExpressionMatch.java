import java.util.Arrays;

public class regExpressionMatch {
    public int isMatch(final String A, final String B) {
        int N = A.length();
        int M = B.length();
        StringBuilder sb = new StringBuilder();
        sb.append(B.charAt(0));
        for (int i = 1; i < M; i++) {
            if (B.charAt(i - 1) != '*' || B.charAt(i) != '*') {
                sb.append(B.charAt(i));
            }
        }
        String C = sb.toString();
        System.out.println(C);
        M = C.length();
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        int val = isEqual(A, C, N - 1, M - 1, dp);
        System.out.println(Arrays.deepToString(dp));
        System.out.println(val);
        return 0;
    }

    public int isEqual(String A, String C, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) {
            return 1;
        }

        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (C.charAt(k) != '*') {
                    return 0;
                }
            }
            return 1;
        }

        if (j < 0) {
            // A is empty but C has some character left
            return 0;
        }

        if (dp[i][j] == -1) {
            if (A.charAt(i) == C.charAt(j) || C.charAt(j) == '?') {
                dp[i][j] = isEqual(A, C, i - 1, j - 1, dp);
            } else if (C.charAt(j) == '*') {
                int leaveIt = isEqual(A, C, i, j - 1, dp);
                int pickAndStay = isEqual(A, C, i - 1, j, dp);
                dp[i][j] = leaveIt | pickAndStay;
            } else {
                // char are not equal
                return 0;
            }
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        regExpressionMatch rem = new regExpressionMatch();
        // String B = "a***sdvse**v*sv**";

        // String A = "aaa";
        // String B = "a*";

        // String A = "acz";
        // String B = "a?a";

        String A = "bcaccbabaa";
        String B = "bb*c?c*?";

        rem.isMatch(A, B);
    }
}
