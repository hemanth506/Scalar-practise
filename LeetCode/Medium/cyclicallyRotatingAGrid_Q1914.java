// Todo - correct approach but code mistake

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class cyclicallyRotatingAGrid_Q1914 {
    int N;
    int M;

    public int[][] rotateGrid(int[][] grid, int k) {
        N = grid.length;
        M = grid[0].length;
        System.out.println(Arrays.deepToString(grid));
        int l1 = 0;
        int l2 = 2;

        int i = 0;
        while (l2 <= N) {
            ArrayList<Integer> arr = new ArrayList<>();
            System.out.println("l1 = " + l1 + " l2 = " + l2);
    
            pushInArr(i, i+1, grid, arr);
            System.out.println(arr);
            // int mod = ((N - l1) + (N - l1) + (M - l2) + (M - l2));
            int mod = (2 * (N - l1 + M - l2));

            k = k % mod;
            rotateArray(arr, k);
            System.out.println(arr);
    
            pushInGrid(i, i+1, grid, arr);
            System.out.println(Arrays.deepToString(grid));
            l1+=2;
            l2+=2;
            i++;
        }
        return grid;
    }

    private void rotateArray(ArrayList<Integer> arr, int k) {
        int arrL = arr.size();
        // System.out.println("k = "+ k);
        // System.out.println("actual arr = " + arr);

        Collections.reverse(arr);
        // System.out.println("arr = " + arr);
        swapArrayList(arr, arrL-k, arrL-1);
        // System.out.println("swap arr = " + arr);
        swapArrayList(arr, 0, arrL-k-1);
    }

    private void swapArrayList(ArrayList<Integer> arr, int x, int y) {
        while (x < y) {
            int temp = arr.get(x);
            arr.set(x, arr.get(y));
            arr.set(y, temp);
            x++;
            y--;
        }
    }

    public void pushInArr(int st, int end, int[][] grid, ArrayList<Integer> arr) {
        
        for (int i = st; i < M - end; i++) {
            arr.add(grid[st][i]);
        }
        System.out.println(arr);

        for (int i = st; i < N - end; i++) {
            arr.add(grid[i][M - end]);
        }
        System.out.println(arr);

        for (int i = M - end; i > st; i--) {
            arr.add(grid[N - end][i]);
        }
        System.out.println(arr);

        for (int i = N - end; i > st; i--) {
            arr.add(grid[i][st]);
        }
        System.out.println(arr);
    }

    public void pushInGrid(int st, int end, int[][] grid, ArrayList<Integer> arr) {
        int p = 0;
        for (int i = st; i < M - end; i++) {
            grid[st][i] = arr.get(p);
            p++;
        }
        System.out.println(Arrays.deepToString(grid));

        for (int i = st; i < N - end; i++) {
            grid[i][M - end] = arr.get(p);
            p++;
        }
        System.out.println(Arrays.deepToString(grid));

        for (int i = M - end; i > st; i--) {
            grid[N - end][i] = arr.get(p);
            p++;
        }
        System.out.println(Arrays.deepToString(grid));

        for (int i = N - end; i > st; i--) {
            grid[i][st] = arr.get(p);
            p++;
        }
        // System.out.println(Arrays.deepToString(grid));
    }

    public static void main(String[] args) {
        cyclicallyRotatingAGrid_Q1914 cy = new cyclicallyRotatingAGrid_Q1914();
        // int[][] grid = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        // cy.rotateGrid(grid, 2);

        int[][] grid = { {10,1,4,8},{6,6,3,10},{7,4,7,10},{1,10,6,1},{2,1,1,10},{3,8,9,2},{7,1,10,10},{7,1,4,9},{2,2,4,2},{10,7,5,10} };
        cy.rotateGrid(grid, 1);
    }
}

/*
 * [[14, 13, 9, 5],
 *  [15, 6, 7, 1],
 *  [16, 10, 11, 2],
 *  [12, 8, 4, 3]]  
 * 
 * 
 * [[3, 4, 8, 12],
 *  [2, 11, 10, 16],
 *  [1, 7, 6, 15],
 *  [5, 9, 13, 14]]
 * 
 * [[10, 1, 4, 8],
 *  [6, 6, 3, 10],
 *  [7, 4, 7, 10],
 *  [1, 10, 6, 1],
 *  [2, 1, 1, 10],
 *  [3, 8, 9, 2],
 *  [7, 1, 10, 10],
 *  [7, 1, 4, 9],
 *  [2, 2, 4, 2],
 *  [10, 7, 5, 10]]
 */

/*
 * =========================================
 * int p = 0;
 * for(int i = 0; i < N-1; i++) {
 * grid[0][i] = arr.get(p);
 * p++;
 * }
 * System.out.println(Arrays.deepToString(grid));
 * 
 * for(int i = 0; i < M-1; i++) {
 * grid[i][N-1] = arr.get(p);
 * p++;
 * }
 * System.out.println(Arrays.deepToString(grid));
 * 
 * for(int i = M-1; i > 0; i--) {
 * grid[N-1][i] = arr.get(p);
 * p++;
 * }
 * System.out.println(Arrays.deepToString(grid));
 * 
 * for(int i = N-1; i > 0; i--) {
 * grid[i][0] = arr.get(p);
 * p++;
 * }
 * 
 */
