import java.util.ArrayList;
import java.util.Arrays;

public class verticalAndHorizontalSum {
    int N;
    int M;
    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        N = B.size();
        M = B.get(0).size();

        return C;
    }
    
    
    public static void main(String[] args) {
        verticalAndHorizontalSum vh = new verticalAndHorizontalSum();
        int A = 3;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
        int C = 2;
        vh.solve(A, null, C);
    }
}
