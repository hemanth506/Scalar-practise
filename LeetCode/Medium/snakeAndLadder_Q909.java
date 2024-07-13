import java.util.Arrays;
import java.util.HashSet;

public class snakeAndLadder_Q909 {
    
    public void getMinDistance_OLD(int[][] board, int[][] dp, int N, HashSet<String> hs, int grid, int step) {
        System.out.println("top msg = " + grid + " " + endGrid);
        if (grid == endGrid) {
            System.out.println("============= grid matching ===========");
            minSteps = Integer.min(grid, step);
            return;
        }
        System.out.println("=====");
        grid++;
        for (int dice = 0; dice < 6; dice++) {
            System.out.println("grid = " + grid);
            int i = grid / N;
            int j = grid % N;
            if (i % 2 != 0) {
                j = (N - 1) - j;
            }
            System.out.println("i = " + i + " j = " + j);
            // System.out.println("board[i][j] = " + board[i][j]);

            String str = i + "-" + j;
            System.out.println(str);
            if (i >= N || j >= N) {
                return;
            }
            if (!hs.contains(str) && board[i][j] != -1) {
                System.out.println("inside grid = " + grid);
                hs.add(str);
                getMinDistance(board, dp, N, hs, board[i][j], step + 1);
                hs.remove(str);
            } else if (grid == endGrid) {
                minSteps = Integer.min(grid, step);
                return;
            }
            grid++;
        }
    }

    
    int minSteps = Integer.MAX_VALUE;
    int endGrid;
    
    public void getMinDistance(int[][] board, int[][] dp, int N, HashSet<String> hs, int grid, int step) {
        System.out.println("top msg = " + grid + " " + endGrid);
        if (grid == endGrid) {
            System.out.println("============= grid matching ===========");
            minSteps = Integer.min(grid, step);
            return;
        }
        grid++;
        int dice = 0;
        System.out.println("grid check = " + grid);
        if (grid == endGrid) {
            System.out.println("=============equals============");
            minSteps = Integer.min(grid, step);
            return;
        }
        while (dice < 6 && grid < endGrid) {
            int i = grid / N;
            int j = grid % N;
            if (i % 2 != 0) {
                j = (N - 1) - j;
            }

            String str = i + "-" + j;
            System.out.println(str + " " + grid);

            if (grid == endGrid) {
                System.out.println("=============equals============");
                minSteps = Integer.min(grid, step);
                return;
            }

            if (!hs.contains(str) && board[i][j] != -1) {
                System.out.println("inside condition");
                hs.add(str);
                getMinDistance(board, dp, N, hs, board[i][j], step + 1);
                hs.remove(str);
            }
            grid++;
            dice++;
        }
    }

    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        endGrid = ((N * N) - 1);
        System.out.println(endGrid);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != -1) {
                    board[i][j] = board[i][j] - 1;
                }
            }
        }
        swapBoard(board, N);
        System.out.println(Arrays.deepToString(board));
        int dp[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        HashSet<String> hs = new HashSet<String>();
        getMinDistance(board, dp, N, hs, 0, 1);
        System.out.println(minSteps);
        return minSteps;
    }

    private void swapBoard(int[][] board, int N) {
        int i = 0;
        int j = N - 1;
        while (i <= j) {
            int[] tempArr = board[i];
            board[i] = board[j];
            board[j] = tempArr;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        snakeAndLadder_Q909 sk = new snakeAndLadder_Q909();
        // int board[][] = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, {
        //         -1, -1, -1, -1, -1, -1 }, { -1, 35, -1, -1, 13, -1 },
        //         { -1, -1, -1, -1, -1,
        //                 -1 },
        //         { -1, 15, -1, -1, -1, -1 } };

        // int board[][] = { { -1, 4 }, { -1, 3 } };

        int board[][] = { { -1, -1 }, { -1, 3 } };

        sk.snakesAndLadders(board);
    }
}

/*
 * [[-1, 14, -1, -1, -1, -1],
 * [-1, -1, -1, -1, -1, -1],
 * [-1, 34, -1, -1, 12, -1],
 * [-1, -1, -1, -1, -1, -1],
 * [-1, -1, -1, -1, -1, -1],
 * [-1, -1, -1, -1, -1, -1]]
 */