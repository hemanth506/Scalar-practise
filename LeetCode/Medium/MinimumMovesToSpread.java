import java.util.ArrayList;
import java.util.Arrays;

/*
 * Q2850
 * Incorrect logic
 */

public class MinimumMovesToSpread {
  public int minimumMoves(int[][] grid) {
    int N = grid.length;
    int M = grid[0].length;

    ArrayList<int[]> zeros = new ArrayList<int[]>();
    ArrayList<int[]> nonOnes = new ArrayList<int[]>();

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(grid[i][j] == 0) {
          int[] zero = new int[2];
          zero[0] = i;
          zero[1] = j;
          zeros.add(zero);
        } else if(grid[i][j] != 1) {
          int[] nonOne = new int[3];
          nonOne[0] = i;
          nonOne[1] = j;
          nonOne[2] = grid[i][j];
          nonOnes.add(nonOne);
        }
      }
    }

    print(zeros, nonOnes);
    
    int totalSteps = 0;
    for(int i = 0; i < zeros.size(); i++) {
      int minSteps = Integer.MAX_VALUE;
      int toRedIndex = i;
      int[] zero = zeros.get(i);
      for(int j = 0; j < nonOnes.size(); j++) {
        if(nonOnes.get(j)[2] == 1) {
          continue;
        }
        int[] nonOne = nonOnes.get(j);

        int curSteps = Math.abs(zero[0] - nonOne[0]) + Math.abs(zero[1] - nonOne[1]);

        if(minSteps > curSteps) {
          minSteps = curSteps;
          toRedIndex = j;
        }
      }
      System.out.println("minSteps "+ minSteps);
      totalSteps += minSteps;
      nonOnes.get(toRedIndex)[2]--;
    }

    System.out.println(totalSteps);
    print(zeros, nonOnes);

    return totalSteps;
  }

  private void print(ArrayList<int[]> zeros, ArrayList<int[]> nonOnes) {
    for(int i = 0; i < zeros.size(); i++) {
      System.out.println(Arrays.toString(zeros.get(i)));
    }

    for(int i = 0; i < nonOnes.size(); i++) {
      System.out.println(Arrays.toString(nonOnes.get(i)));
    }
  }
  
  public static void main(String[] args) {
    MinimumMovesToSpread mv = new MinimumMovesToSpread();
    int[][] grid = {{1,3,0},{1,0,0},{1,0,3}};
    mv.minimumMoves(grid);
  }
}
