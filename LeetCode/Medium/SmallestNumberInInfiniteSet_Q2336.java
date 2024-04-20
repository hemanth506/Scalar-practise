import java.util.Collections;
import java.util.HashSet;

public class SmallestNumberInInfiniteSet_Q2336 {
  int curNumber;
  HashSet<Integer> removedHs;

  public SmallestNumberInInfiniteSet_Q2336() {
    curNumber = 1;
    removedHs = new HashSet<>();
  }

  public int popSmallest() {
    if (!removedHs.isEmpty()) {
      int res = Collections.min(removedHs); // This will return the min value
      removedHs.remove(res);
      return res;
    } else {
      curNumber++;
      return curNumber - 1;
    }
  }

  public void addBack(int num) {
    if (curNumber > num) {
      removedHs.add(num);
    }
  }
}
