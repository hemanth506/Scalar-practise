import java.util.ArrayList;
import java.util.Arrays;

public class validPath {
    boolean flag = false;

    public void dfs(int i, int j, int a, int b, int[][] layout) {
        if (i < 0 || j < 0 || i >= layout.length || j >= layout[0].length || layout[i][j] == 1) {
            return;
        }
        if (i == a && j == b) {
            flag = true;
            return;
        }
        layout[i][j] = 1;

        dfs(i - 1, j - 1, a, b, layout);
        dfs(i - 1, j + 1, a, b, layout);

        dfs(i + 1, j - 1, a, b, layout);
        dfs(i + 1, j + 1, a, b, layout);

        dfs(i - 1, j, a, b, layout);
        dfs(i + 1, j, a, b, layout);

        dfs(i, j - 1, a, b, layout);
        dfs(i, j + 1, a, b, layout);

    }

    public int[][] getLayout(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        int[][] surface = new int[A + 1][B + 1];

        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int k = 0; k < C; k++) {
                    int dist = ((i - E.get(k)) * (i - E.get(k))) + ((j - F.get(k)) * (j - F.get(k)));
                    if (dist <= (D * D)) {
                        surface[i][j] = 1;
                    }

                }
            }
        }
        return surface;
    }

    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        int[][] layout = getLayout(A, B, C, D, E, F);
        if (layout[0][0] == 1 || layout[A][B] == 1) {
            return "NO";
        }
        dfs(0, 0, A, B, layout);
        System.out.println(flag);
        return flag ? "YES" : "NO";
    }

    public static void main(String[] args) {
        validPath vp = new validPath();
        int A = 2;
        int B = 3;
        int C = 1;
        int D = 1;
        ArrayList<Integer> E = new ArrayList<Integer>(Arrays.asList(2));
        ArrayList<Integer> F = new ArrayList<Integer>(Arrays.asList(3));
        vp.solve(A, B, C, D, E, F);
    }
}
