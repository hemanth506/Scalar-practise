import java.util.Arrays;

public class period {
    public int[] LPS(String A, int N) {
        int[] arr = new int[N];
        arr[0] = 0;
        for(int i = 1; i < N; i++) {
            int x = arr[i-1];
            while(A.charAt(x) != A.charAt(i)) {
                if(x == 0) {
                    x = -1; break;
                }
                x = arr[x - 1];
            }
            arr[i] = x + 1;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public int solve(String A) {
        // int N = A.length();
        // int[] lpsArr = LPS(A, N);
        return 0;
    }
    public static void main(String[] args) {
        period pd = new period();
        // String A = "abababab";
        String A = "abacabacaba";

        pd.solve(A);
    }
}
