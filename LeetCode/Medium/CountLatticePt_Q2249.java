import java.util.HashSet;

public class CountLatticePt_Q2249 {
  public int countLatticePoints(int[][] circles) {
    int N = circles.length;

    HashSet<String> hs = new HashSet<>();
    for (int circle[]: circles) {
      int x = circle[0];
      int y = circle[1];
      int r = circle[2];

      for(int i = x - r; i <= x + r; i++) {
        // for(j = )
      }
    }
    // System.out.println(hs);
    return hs.size();
  }

  public static void main(String[] args) {
    CountLatticePt_Q2249 ct = new CountLatticePt_Q2249();
    int[][] circles = { { 2,2,2 }, {3,4,1} };
    ct.countLatticePoints(circles);
  }
}
