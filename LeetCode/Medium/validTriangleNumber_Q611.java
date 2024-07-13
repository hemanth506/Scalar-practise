import java.util.Arrays;
import java.util.HashMap;
import java.util.HashMap;

public class validTriangleNumber_Q611 {
    public int triangleNumber(int[] nums) {
        int N = nums.length;
        if(N <= 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        HashMap<Integer, Integer> hm = new HashMap<>();
        if(nums[0] == nums[N-1]) {
            if(nums[0] == 0) {
                return 0;
            }
            return 1;
        }

        int count = 0;
        for (int i = 1; i < N - 1; i++) {
            int j = i - 1;
            if(!hm.containsKey(nums[i])) {
                while (j >= 0) {
                    int k = i + 1;
                    while (k < N) {
                        boolean valid = isValidTriangle(j, i, k, nums);
                        if (valid) {
                            count += 1;
                        } else {
                            break;
                        }
                        k++;
                    }
                    j--;
                }
                hm.put(nums[i], count);
            } else {
                count += hm.get(nums[i]);
            }
        }
        return count;
    }

    private boolean isValidTriangle(int a, int b, int c, int[] nums) {
        boolean valid = false;
        if(nums[a] + nums[b] > nums[c]) {
            valid = true;
        } 
        return valid;
    }

    public static void main(String[] args) {
        validTriangleNumber_Q611 vd = new validTriangleNumber_Q611();
        int[] nums = {4,2,3,4};
        // int[] nums = { 2, 2, 3, 4 };

        vd.triangleNumber(nums);
    }
}
