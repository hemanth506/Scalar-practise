public class SmoothDescentPeriods {
  public long getDescentPeriods(int[] prices) {
    int N = prices.length;

    long totalPeriods = 0;
    long count = 0;
    boolean isSeq = false;
    for (int i = 1; i < N; i++) {
      System.out.println("ind = " + i);
      if (prices[i - 1] - prices[i] == 1) {
        count += 1;
        isSeq = true;
      } else {
        if (isSeq) {
          count += 1;
          System.out.println("End of seq = " + count);
        } else {
          count = 1;
          System.out.println("start of seq = " + count);
        }
        long val = count * (count + 1) / 2;
        totalPeriods += val;
        isSeq = false;
        count = 0;
      }
    }

    if (isSeq) {
      count += 1;
    } else {
      count = 1;
    }
    System.out.println(count);
    long val = count * (count + 1) / 2;
    totalPeriods += val;

    System.out.println("totalPeriods = " + totalPeriods);

    return totalPeriods;
  }

  public static void main(String[] args) {
    SmoothDescentPeriods sd = new SmoothDescentPeriods();
    int[] prices = new int[] { 3, 2, 1, 4 };
    // int[] prices = new int[] { 8, 6, 7, 7 };
    // int[] prices = new int[] { 1 };
    // int[] prices = new int[] { 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 4, 3, 10, 9, 8, 7
    // };

    sd.getDescentPeriods(prices);
  }
}
