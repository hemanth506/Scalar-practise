public class maxLenOfSubarrPositiveProd_Q1567 {
    public int getMaxLenBS(int[] nums) {
        int N = nums.length;

        int l = 1;
        int h = N;
        int length = 0;
        while (l <= h) {
            int m = (l + h) / 2;
            System.out.println("l = " + l + " h = " + h + " m = " + m);
            if (checkSubArray(m, nums, N)) {
                System.out.println("true");
                length = m;
                l = m + 1;
            } else {
                System.out.println("false");
                h = m - 1;
            }
        }
        System.out.println(length);
        return length;
    }

    private boolean checkSubArray(int m, int[] nums, int N) {
        System.out.println("N-m = " + (N-m) + " N = " + N);
        for (int i = 0; i <= N-m; i++) {
            System.out.println("====== i = " + i + " ===========");
            if(nums[i] == 0) {
                continue;
            }

            int p = i;
            int ctNeg = 0;
            boolean valid = true;
            innerloop:
            for(int k = 0; k < m; k++) {
                System.out.println("p = " + p);
                if(nums[p] < 0) {
                    ctNeg += 1;
                } 
                else if (nums[p] == 0) {
                    System.out.println("break inner");
                    valid = false;
                    i = p;
                    break innerloop;
                }
                p++;
            }

            if(ctNeg % 2 == 0 && valid) {
                return true;
            }
            
            
        }
        return false;
    }

    public int getMaxLen(int[] nums) {
        return 0;
        
    }
    
    public static void main(String[] args) {
        maxLenOfSubarrPositiveProd_Q1567 ma = new maxLenOfSubarrPositiveProd_Q1567();
        // int[] nums = { 0,1,-2,-3,-4 };
        // int[] nums = { 1,-2,-3,4 };
        // int[] nums = { -1,-2,-3,0,1 };
        // int[] nums = { -1000000000,-1000000000 };

        int[] nums = { 9,10,1,0,19,20,-28,30,-12,20,11,-8,7,21,-26 };

        ma.getMaxLen(nums);
    }
}
