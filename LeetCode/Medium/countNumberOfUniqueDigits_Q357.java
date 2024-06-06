public class countNumberOfUniqueDigits_Q357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }

        // int uk = n-1;
        int range = 10;
        n--;
        while (n > 0) {
            range = range * 10;
            n--;
        }
        System.out.println(range);
        int notunique = 9 << 1;

        System.out.println(range + " " + notunique);
        return 1;
    }
    public static void main(String[] args) {
        countNumberOfUniqueDigits_Q357 cn = new countNumberOfUniqueDigits_Q357();
        int n = 2;
        cn.countNumbersWithUniqueDigits(n);
    }
}
