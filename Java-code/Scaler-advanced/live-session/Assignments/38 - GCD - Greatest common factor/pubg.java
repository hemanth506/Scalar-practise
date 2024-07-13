import java.util.ArrayList;
import java.util.Arrays;

public class pubg {
    public int gcd(int A, int B) {
        if(B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
    public int solve(ArrayList<Integer> A) {
        int N = A.size();

        int gcdV = 0;
        for(int i = 0; i < N; i++) {
            gcdV = gcd(gcdV, A.get(i));
        }

        System.out.println(gcdV);
        return gcdV;
    }
    public static void main(String[] args) {
        pubg pg = new pubg();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 3, 4));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(6, 4));

        pg.solve(A);
    }
}
