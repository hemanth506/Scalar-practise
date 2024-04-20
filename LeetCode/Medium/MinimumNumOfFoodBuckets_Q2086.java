
//  Got help from leetcode solution
public class MinimumNumOfFoodBuckets_Q2086 {

  public int minimumBuckets(String hamsters) {
    int N = hamsters.length();
    char[] charArr = hamsters.toCharArray();

    for (int i = 0; i < N; i++) {
      if (charArr[i] == 'H') {

        if (i - 1 >= 0 && charArr[i - 1] == 'B') {
          continue;
        }

        if (i + 1 < N && charArr[i + 1] == '.') {
          charArr[i + 1] = 'B';
        } else if (i - 1 >= 0 && charArr[i - 1] == '.') {
          charArr[i - 1] = 'B';
        } else {
          return -1;
        }
      }
    }

    int count = 0;
    for (int i = 0; i < N; i++) {
      if (charArr[i] == 'B') {
        count++;
      }
    }
    System.out.println(count);
    return count;

  }

  public static void main(String[] args) {
    MinimumNumOfFoodBuckets_Q2086 mn = new MinimumNumOfFoodBuckets_Q2086();
    String hamsters = ".H.H.";
    mn.minimumBuckets(hamsters);
  }
}
