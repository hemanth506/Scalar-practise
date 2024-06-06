import java.util.Arrays;
import java.util.HashMap;

public class wayToDecode {
    // working Iterative code
    public int numDecodingsRecursion(String A) {
        int N = A.length();
        if(N == 0) {
            return 0;
        }
        if(A.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < N; i++) {
            if(A.charAt(i) >= '1' && A.charAt(i-1) <= '9') {
                dp[i] = dp[i-1];
            }
            if (A.charAt(i-2) == '1') {
                dp[i] += dp[i-2];
            } else if (A.charAt(i-2) == '2' && A.charAt(i-1) >= '0' && A.charAt(i-1) <= '6') {
                dp[i] += dp[i-2];
            }
        }
        System.out.println(dp[N]);
        return dp[N];
    }

    // ==================================================
    
    // wrong Recursive code
    public int numDecodingsWrong(String A) {
        int N = A.length();
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        int val = getWaysWrong(A, 0, N, dp) + 1;
        System.out.println(Arrays.toString(dp));
        System.out.println(val);
        return val;
    }

    public int getWaysWrong(String A, int i, int N, int[] dp) {
        System.out.println(i + " " + N);
        if(i == N) {
            return 0;
        }

        if(dp[i] == -1) {
            int oneChar = Integer.parseInt(A.substring(i, i+1));
            int one = 0;
            if(oneChar >= 1) {
                one += 1;
            }
            int two = 0;
            if(i != 0) {
                int twoChar = Integer.parseInt(A.substring(i-1, i+1));
                System.out.println(i + " " + oneChar + " " + twoChar);
                if(twoChar >= 10 && twoChar <= 26) {
                    two += 1;
                }

            }
    
            dp[i] = getWaysWrong(A, i+1, N, dp) + two + one;
        }
        return dp[i];
    }

    // ==================================================

    // working Recursive code [Refered discussion code]
    int mod = 1000000007;
    public int numDecodings(String A) {
        int N = A.length();
        HashMap<String, Long> dp = new HashMap<String, Long>();
        int val = (int) (getWays(A, 0, N, dp) % mod);
        return val;
    }
    
    private long getWays(String A, int i, int N, HashMap<String, Long> dp) {
        if(A.charAt(i) == '0') {
            return 0;
        }
        if(i == (N-1)) { // Last character
            return 1;
        }

        int twoChar = Integer.parseInt(A.substring(i, i+2));
        if(i == (N-2)) { // last second character
            if(twoChar == 10 || twoChar == 20) {
                return 1;
            }
            return (twoChar > 10 && twoChar <= 26) ? 2 : 1;
        }

        String subStr = A.substring(i, N);
        if(!dp.containsKey(subStr)) {
            long two = (twoChar >= 10 && twoChar <= 26) ? getWays(A, i + 2, N, dp) : 0;
            long ans = (getWays(A, i + 1, N, dp) + two) % mod;
            dp.put(subStr, ans);
        }
        return dp.get(subStr)%mod;
    }

    public static void main(String[] args) {
        wayToDecode wd = new wayToDecode();
        String A = "1215";
        wd.numDecodings(A);
    }
}
