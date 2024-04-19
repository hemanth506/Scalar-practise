import java.util.Arrays;

public class findThreeConsecutiveIntegers_Q2177 {
    public long[] sumOfThree(long num) {
        boolean found = false;
        long[] arr = {};

        long l = 0;
        long h = num;
        long mid = 0;
        while (l <= h) {
            long m = (l + h) / 2;
            long value = m - 1 + m + m + 1;
            System.out.println(value);
            if (value == num) {
                found = true;
                mid = m;
                break;
            }

            if (value < num) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        if (found) {
            arr = new long[3];
            arr[0] = mid - 1;
            arr[1] = mid;
            arr[2] = mid + 1;
            System.out.println(Arrays.toString(arr));
            return arr;
        }

        return arr;
    }

    public static void main(String[] args) {
        findThreeConsecutiveIntegers_Q2177 ft = new findThreeConsecutiveIntegers_Q2177();
        long num = 0;
        ft.sumOfThree(num);
    }
}