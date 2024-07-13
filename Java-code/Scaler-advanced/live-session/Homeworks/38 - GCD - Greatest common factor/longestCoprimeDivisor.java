// Instead of iterating for 1 to A, check from 1 to square root of A.
public class longestCoprimeDivisor {
    public int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A%B);
    }

    // TC: O(N)
    public int cpFactBruteForce(int A, int B) {
        int N = A;
        int maxV = 1;
        for(int i = 1; i <= N; i++) {
            if(A%i == 0 && gcd(i, B) == 1) {
                maxV = i;
            }
        }
        // System.out.println(maxV);
        return maxV;
    }

    // TC: O(logN)
    public int cpFact(int A, int B) {
        int N = A;
        int maxV = 1;
        for(int i = 1; i <= N/i; i++) {
            if(A%i == 0 && gcd(i, B) == 1) {
                maxV = i;
            }

            if(N % i == 0 && (A%(N/i) == 0 && gcd(N/i, B) == 1)) {
                maxV = N/i;
                break;
            }
        }
        return maxV;
    }
    
    public static void main(String[] args) {
        longestCoprimeDivisor cop = new longestCoprimeDivisor();
        int A = 30;
        int B = 12;

        // int A = 2;
        // int B = 3;

        // int A = 90;
        // int B = 47;
        cop.cpFact(A, B);
    }
}
