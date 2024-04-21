public class Search2DMatrixII_Q240 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int N = matrix.length;
    int M = matrix[0].length;

    int i = 0;
    int j = M - 1;

    while (i < N && j >= 0) {
      System.out.println(i + " " + j);
      if (matrix[i][j] == target) {
        System.out.println("Found");
        return true;
      } else if (matrix[i][j] > target) {
        j--;
      } else if (matrix[i][j] < target) {
        i++;
      }
    }
    System.out.println("Not Found");

    return false;
  }

  public static void main(String[] args) {
    Search2DMatrixII_Q240 sd = new Search2DMatrixII_Q240();
    int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
        { 18, 21, 23, 26, 30 } };
    int target = 13;
    // int[][] matrix = {{-5}};
    // int target = -5;
    sd.searchMatrix(matrix, target);
  }
}
