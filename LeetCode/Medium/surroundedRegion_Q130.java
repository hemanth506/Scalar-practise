import java.util.Arrays;

public class surroundedRegion_Q130 {
    int N, M;

    public boolean modifyMatrix(String direction, int i, int j, char[][] board) {
        if (i >= N || j >= M || i < 0 || j < 0) {
            return false;
        }

        if (board[i][j] == 'X') {
            return true;
        }

        if (direction == "Right") {
            return modifyMatrix("Right", i, j + 1, board);
        } else if (direction == "Left") {
            return modifyMatrix("Left", i, j - 1, board);
        } else if (direction == "Up") {
            return modifyMatrix("Up", i - 1, j, board);
        } else if (direction == "Down") {
            return modifyMatrix("Down", i + 1, j, board);
        }

        boolean surrounded = true;
        surrounded ^= modifyMatrix("Right", i, j + 1, board);
        surrounded ^= modifyMatrix("Left", i, j - 1, board);
        surrounded ^= modifyMatrix("Up", i - 1, j, board);
        surrounded ^= modifyMatrix("Down", i + 1, j, board);
        if (surrounded == true) {
            board[i][j] = 'X';
        }
        return true;
    }

    public void solveOLD(char[][] board) {
        N = board.length;
        M = board[0].length;
        if (N == 1 || M == 1) {
            if (N == 1) {
                modifyMatrix("Right", 0, 0, board);
            } else if (M == 1) {
                modifyMatrix("Down", 0, 0, board);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'O') {
                    modifyMatrix("null", i, j, board);
                }
            }
        }

        System.out.println(Arrays.deepToString(board));
    }

    
    /*
    Different solution for a different question:
        Will satisfy the below:
            Notice that an 'O' should not be flipped if: It is on the border.
    */ 
    public void solve(char[][] board) {
        N = board.length;
        M = board[0].length;
        boolean[][] temp = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'O') {
                    temp[i][j] = false;
                } else {
                    temp[i][j] = true;
                }
            }
        }

        System.out.println(Arrays.deepToString(temp));

        boolean[][] LTR = leftToRight(temp);
        System.out.println(Arrays.deepToString(LTR));

        boolean[][] RTL = rightToLeft(temp);
        System.out.println(Arrays.deepToString(RTL));

        boolean[][] TTB = topToBottom(temp);
        System.out.println(Arrays.deepToString(TTB));

        boolean[][] BTT = bottomToTop(temp);
        System.out.println(Arrays.deepToString(BTT));

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == 'O') {
                    if (LTR[i][j] && RTL[i][j] && TTB[i][j] && BTT[i][j]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(board));
    }

    public boolean[][] bottomToTop(boolean[][] temp) {
        boolean[][] BTT = new boolean[N][M];
        for(int i = 0; i < M; i++) {
            BTT[N-1][i] = temp[N-1][i];
            for(int j = N-2; j >= 0; j--) {
                BTT[j][i] = BTT[j+1][i] || temp[j][i];
            }
        }
        return BTT;
    }

    public boolean[][] topToBottom(boolean[][] temp) {
        boolean[][] TTB = new boolean[N][M];
        for(int i = 0; i < M; i++) {
            TTB[0][i] = temp[0][i];
            for(int j = 1; j < N; j++) {
                TTB[j][i] = TTB[j-1][i] || temp[j][i];
            }
        }
        return TTB;
    }

    private boolean[][] leftToRight(boolean[][] temp) {
        boolean[][] LTR = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            LTR[i][0] = temp[i][0];
            for(int j = 1; j < M; j++) {
                LTR[i][j] = LTR[i][j-1] || temp[i][j];
            }
        }
        return LTR;
    }

    private boolean[][] rightToLeft(boolean[][] temp) {
        boolean[][] RTL = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            RTL[i][M-1] = temp[i][M-1];
            for(int j = M-2; j >= 0; j--) {
                RTL[i][j] = RTL[i][j+1] || temp[i][j];
            }
        }
        return RTL;
    }

    public static void main(String[] args) {
        surroundedRegion_Q130 sr = new surroundedRegion_Q130();
        // char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};

        sr.solve(board);

    }
}
