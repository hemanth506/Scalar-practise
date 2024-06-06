
public class binaryStrings {
    public int solve(String A, int B) {
        int N = A.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(A.charAt(i));
        }

        int j = 0;
        int ct = 0;
        while (j < N) {
            if(sb.charAt(j) == '0' && (j+B) <= N) {
                for(int k = j; k < (j+B); k++) {
                    if(sb.charAt(k) == '1') {
                        sb.setCharAt(k, '0');
                    } else {
                        sb.setCharAt(k, '1');
                    }
                }
                ct += 1;
            }
            j+=1;
        }

        for(int p = 0; p < N; p++) {
            if(sb.charAt(p) == '0') {
                return -1;
            }
        }

        return ct;
    }
    public static void main(String[] args) {
        binaryStrings bs = new binaryStrings();
        // String A = "1000101101";
        // int B = 3;

        // String A = "011";
        // int B = 3;

        String A = "00010110";
        int B = 3;
        bs.solve(A, B);
    }
}
