import java.util.ArrayList;
import java.util.Arrays;

public class shortestDistanceInMaze {

    /*
    int N, M;
    int[][] distArr;

    public void getShortestDistance(int dist, int i, int j, ArrayList<ArrayList<Integer>> A) {
        if(i < 0 || j < 0 || i >= N || j >= M) {
            return;
        }

        if(A.get(i).get(j) == 1) {
            return;
        }

        distArr[i][j] = Integer.min(distArr[i][j], dist);

        // System.out.println("left = " + i + " " + j);
        // getShortestDistance(dist+1, i, j-1, A);
        // System.out.println("top = " + i + " " + j);
        // getShortestDistance(dist+1, i-1, j, A);
        System.out.println("right = " + i + " " + j);
        getShortestDistance(dist+1, i, j+1, A);
        System.out.println("bottom = " + i + " " + j);
        getShortestDistance(dist+1, i+1, j, A);
    }

    public int solveWrong(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        destX = C.get(0);
        destY = C.get(1);
        N = A.size();
        M = A.get(0).size();
        int i = B.get(0);
        int j = B.get(1);

        
        if(destX > i) {

        }

        distArr = new int[N][M];
        for(int k = 0; k < N; k++) {
            Arrays.fill(distArr[k], Integer.MAX_VALUE);
        }

        System.out.println(Arrays.deepToString(distArr));
        getShortestDistance(0, i, j, A);
        System.out.println(Arrays.deepToString(distArr));

        System.out.println(distArr[destX][destY]);
        return distArr[destX][destY];
    }

    */

    int srcX, srcY;
    int destX, destY;
    int minDist = Integer.MAX_VALUE;
    int N, M;
    public int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        N = A.size();
        M = A.get(0).size();
        srcX = B.get(0);
        srcY = B.get(1);

        destX = C.get(0);
        destY = C.get(1);


        boolean[][][] path = new boolean[N][M][4];
        helper(path, A, srcX, srcY, 0);
        return M;
    }

    private void helper(boolean[][][] path, ArrayList<ArrayList<Integer>> A, int i, int j, int dist) {
        if(i < 0 || j < 0 || i >= N || j >= M) {
            return;
        }

        


    }

    public static void main(String[] args) {
        shortestDistanceInMaze sd = new shortestDistanceInMaze();

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(0, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 0)));


        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(0, 0));
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(0, 1));

        sd.solve(A, B, C);
    }
}
