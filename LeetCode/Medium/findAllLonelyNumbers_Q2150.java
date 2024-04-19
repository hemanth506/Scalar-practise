import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAllLonelyNumbers_Q2150 {
  public List<Integer> findLonely(int[] nums) {
    int N = nums.length;
    HashMap<Integer, Integer> hs = new HashMap<>();

    for (int i = 0; i < N; i++) {
      int val = hs.getOrDefault(nums[i], 0);
      hs.put(nums[i], val+1);
    }

    List<Integer> arr = new ArrayList<Integer>();
    for (int i = 0; i < N; i++) {
      int count = hs.get(nums[i]);
      if (count == 1 && !hs.containsKey(nums[i] + 1) && !hs.containsKey(nums[i] - 1)) {
        arr.add(nums[i]);
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    findAllLonelyNumbers_Q2150 fd = new findAllLonelyNumbers_Q2150();
    int[] nums = { 1,3,5,3 };
    fd.findLonely(nums);
  }
}
