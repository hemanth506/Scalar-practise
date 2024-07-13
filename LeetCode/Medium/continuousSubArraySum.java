import java.util.Arrays;

public class continuousSubArraySum {
    // TLE
    public boolean checkSubarraySum(int[] nums, int k) {
        int N = nums.length;

        int[] prefixSum = new int[N];
        prefixSum[0] = nums[0];
        for(int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        } 
        System.out.println(Arrays.toString(prefixSum));
        
        for(int i = N-1; i >= 1; i--) {
            if(prefixSum[i] % k == 0) {
                System.out.println("true - condition 1");
                return true;
            }
            for(int j = i-2; j>=0; j--) {
                int value = prefixSum[i] - prefixSum[j];
                if(value % k == 0) {
                    System.out.println("true - condition 2 = " + value + " " + prefixSum[i] + " " + prefixSum[j] + " " + i + " " + j);
                    return true;
                }
            }
        }
        System.out.println("false");
        return false;
    }


    public boolean checkSubarraySumNew(int[] nums, int k) {
        return false;
    }
    public static void main(String[] args) {
        continuousSubArraySum cs = new continuousSubArraySum();
        int[] nums = {23,2,4,6,7};
        int k = 6;

        // int[] nums = {23,2,6,4,7};
        // int k = 6;

        // int[] nums = {23,2,6,4,7};
        // int k = 13;

        // int[] nums = {2,4,3};
        // int k = 6;
        cs.checkSubarraySum(nums, k);
    }
}
