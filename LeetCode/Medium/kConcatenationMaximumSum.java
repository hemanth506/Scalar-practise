// todo

public class kConcatenationMaximumSum {
    int mod = 1000000007;

    public int kadanesAlgo (int[] nums) {
        int N = nums.length;

        long currMax = nums[0];
        long overAllMax = nums[0];
        for (int i = 1; i < N; i++) {
            currMax = Long.max(((currMax % mod + nums[i] % mod) % mod), nums[i]);
            overAllMax = Long.max(overAllMax, currMax);
        }
        System.out.println(overAllMax);
        return (int) overAllMax;
    }

    public int kConcatenationMaxSum(int[] arr, int k) {
        int N = arr.length;

        boolean allPositive = true;
        boolean allNegative = true;
        long sumVal = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] >= 0) {
                allNegative = false;
            }
            if (arr[i] < 0) {
                allPositive = false;
            }
            sumVal = (sumVal % mod + arr[i] % mod) % mod;
        }

        if (allPositive) {
            return ((int) sumVal % mod * k % mod) % mod;
        }

        if (allNegative) {
            return 0;
        }

        // wrong approach for below case
        if (arr[0] < 0 && arr[N - 1] < 0) {
            // apply kadane's
            return kadanesAlgo(arr);
        }

        return k;
    }

    public static void main(String[] args) {
        kConcatenationMaximumSum kc = new kConcatenationMaximumSum();
        int[] arr = { 1, 2 };
        int k = 3;
        kc.kConcatenationMaxSum(arr, k);
    }
}