import java.util.Arrays;

public class longestPalindromicSubsequence {
    int maxLen = Integer.MIN_VALUE;
    public int solveTLE(String A) {
        int N = A.length();
        String st = "";
        helperTLE(A, N, 0, st);
        System.out.println(maxLen);
        return maxLen;
    }

    public boolean isPalindrome(String st) {
        int N = st.length();
        int t1 = 0;
        int t2 = N-1;
        while (t1 < t2) {
            if(st.charAt(t1) != st.charAt(t2)) {
                return false;
            }
            t1++;
            t2--;
        }
        return true;
    }
    
    public void helperTLE(String A, int N, int i, String st) {
        if(N == i) {
            if(isPalindrome(st)) {
                int len = st.length();
                maxLen = Integer.max(maxLen, len);
            }
            return;
        }

        helperTLE(A, N, i+1, st);
        st += A.charAt(i);
        helperTLE(A, N, i+1, st);
    }
    
    public static void main(String[] args) {
        longestPalindromicSubsequence lps = new longestPalindromicSubsequence();
        // String A = "bebeeed";
        String A = "abaaddaabbedeedeacbcdcaaed";

        lps.solve(A);
    }

    // working code
    int[][] dp;
    public int solve(String A) {
        int N = A.length();
        dp = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        // System.out.println(Arrays.deepToString(dp));

        helper(A, 0, N-1);
        System.out.println(Arrays.deepToString(dp));
        System.out.println(maxLen);
        return maxLen;
    }

    public int helper(String A, int i, int j) {
        if(i > j) {
            return 0;
        }
        if(i == j) {
            return 1;
        }

        if(dp[i][j] == -1) {
            int val = 0;
            if(A.charAt(i) == A.charAt(j)) {
                val = helper(A, i+1, j-1) + 2;
            } else {
                val = Integer.max(helper(A, i, j-1), helper(A, i+1, j));
            }
            maxLen = Integer.max(val, maxLen);
            dp[i][j] = val;
        }
        return dp[i][j];
    }   

}
