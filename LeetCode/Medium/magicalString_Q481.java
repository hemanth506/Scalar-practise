// wrong one - understand thhe question properly.
public class magicalString_Q481 {
    public int magicalString(int n) {
        int N = n;

        int countOfOnes = 0;
        int iteration = 1;
        while (N > 0 && iteration != 0) {
            iteration = 0;
            for(int i = 1; i < 32; i++) {
                if((1 << i) > N) {
                    break;
                }
                System.out.println(((1 << i)) + " " + i);
                iteration = 1 << i;
            }
            countOfOnes += iteration / 2;
            N = N - iteration;
            System.out.println(iteration);
            System.out.println("========= " + N);
        }

        System.out.println(countOfOnes);
        int value = N == 1 ? countOfOnes + 1: countOfOnes;
        System.out.println(value);
        return value;
    }
    public static void main(String[] args) {
        magicalString_Q481 ms = new magicalString_Q481();
        // int n = 25;
        // int n = 3;
        int n = 9;


        ms.magicalString(n);
    }
}
