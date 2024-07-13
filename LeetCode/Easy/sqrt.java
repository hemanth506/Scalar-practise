public class sqrt {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        int i = 1;
        int val = 1;
        while (i*i <= x) {
            val = i;
            i += 1;
        }
        System.out.println(val);
        return val;
    }
    public static void main(String[] args) {
        sqrt sq = new sqrt();
        sq.mySqrt(8);
    }
}
