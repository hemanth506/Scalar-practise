
public class AthMagicNumber {
    public int GCD(int A, int B) {
        if (B == 0) {
            return A;
        }
        return GCD(B, A % B);
    }
    public int solve(int A, int B, int C) {
        long l = Integer.min(B, C);
        long h = Integer.min(B, C) * A;
        int mod = 1000000007;
        long gcdVal = GCD(B, C);
        long lcmVal = ((B*C)% mod) / gcdVal;
        System.out.println("lcmVal => " + lcmVal);
        long ans = -1;
        while (l <= h) {
            long m = (l + h)/2; // normal test
            // long m = l + (h - l)/2; // normal test

            long num = (m / B) + (m / C) - (m / lcmVal);
            System.out.println(m +"======"+ (m / B) +"======"+ (m / C) +"======"+(m / lcmVal));
            if (num == A) {
                System.out.println(num + " == " + A + " " + m);
                h = m - 1;
                ans = m;
            } else 
            if (num < A) {
                System.out.println(num + " < " + A);
                l = m + 1;
            } else if (num > A) {
                System.out.println(num + " > " + A);
                h = m - 1;
            }
        }
        System.out.println(ans);
        return (int)ans % mod;
    }
    public static void main(String[] args) {
        AthMagicNumber ath = new AthMagicNumber();
        // int A = 8;
        // int B = 2;
        // int C = 3;

        int A = 19;
        int B = 11;
        int C = 13;

        // int A = 11;
        // int B = 12;
        // int C = 13;
        ath.solve(A, B, C);
        // System.out.println(ath.GCD(A, B));
    }
}
