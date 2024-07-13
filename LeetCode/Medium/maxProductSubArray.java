public class maxProductSubArray {
    public int maxProduct(int[] nums) {
        int N = nums.length;

        boolean allNegative = true;
        int maxNeg = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            if(nums[i] >= 0) {
                allNegative = false;
            }
            maxNeg = Integer.max(maxNeg, nums[i]);
        }

        if(allNegative) {
            System.out.println(maxNeg);
            return maxNeg;
        }


        int maxVal = nums[0];
        int subMax = 1;
        for(int i = 1; i < N; i++) {
            subMax = Integer.max(subMax * nums[i], nums[i]);
            maxVal = Integer.max(maxVal, subMax);
        }

        int maxValB = nums[N-1];
        int subMaxB = 1; 
        for(int i = N-2; i >= 0; i--) {
            subMaxB = Integer.max(subMaxB * nums[i], nums[i]);
            maxValB = Integer.max(maxValB, subMaxB);
        }

        System.out.println(Integer.max(maxVal, maxValB));
        return Integer.max(maxVal, maxValB);
    }

    public static void main(String[] args) {
        maxProductSubArray mx = new maxProductSubArray();
        // int[] nums = {2,3,-2,4};
        // int[] nums = {-2,3,-4};
        // int[] nums = {-4,-3};

        int[] nums = {-2,-3,-4};



        mx.maxProduct(nums);
    }
}
