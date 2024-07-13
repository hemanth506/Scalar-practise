import java.util.Arrays;

public class CountNumberOfRect_Q2250 {

  public int[] countRectangles(int[][] rectangles, int[][] points) {
    int N = rectangles.length;
    int M = points.length;

    int[] result = new int[M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        int l = rectangles[i][0];
        int h = rectangles[i][1];

        int x = points[j][0];
        int y = points[j][1];

        if (x <= l && y <= h) {
          result[j]++;
        }
      }
    }

    System.out.println(Arrays.toString(result));
    return result;
  }

  public static void main(String[] args) {
    CountNumberOfRect_Q2250 ct = new CountNumberOfRect_Q2250();
    // int[][] rectangles = { { 1, 2 }, { 2, 3 }, { 2, 5 } };
    // int[][] points = { { 2, 1 }, { 1, 4 } };

    int[][] rectangles = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
    int[][] points = { { 1, 3 }, { 1, 1 } };
    ct.countRectangles(rectangles, points);
  }
}
