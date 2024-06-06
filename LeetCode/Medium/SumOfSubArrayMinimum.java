import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayMinimum {
  public int sumSubarrayMins_Wrong(int[] arr) { // TLE
    int N = arr.length;
    int mod = 1000000007;

    int sumVal = 0;

    for (int i = 0; i < N; i++) {
      int minVal = Integer.MAX_VALUE;
      for (int j = i; j < N; j++) {
        minVal = Integer.min(minVal, arr[j]);
        sumVal = (sumVal % mod + minVal % mod) % mod;
      }
    }

    System.out.println(sumVal);
    return sumVal;
  }

  public int sumSubarrayMins_N2(int[] arr) { // O(N^2)
    int N = arr.length;
    int mod = 1000000007;
    long sumVal = 0;

    for (int i = 0; i < N; i++) {
      int left = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[i] >= arr[j]) {
          break;
        }
        left++;
      }

      int right = 1;
      for (int k = i + 1; k < N; k++) {
        if (arr[i] > arr[k]) {
          break;
        }
        right++;
      }

      System.out.println(left + " " + right);

      long res = (left % mod * right % mod) % mod;
      long val = (res % mod * arr[i] % mod) % mod;
      sumVal = (sumVal % mod + val % mod) % mod;
    }

    System.out.println((int) sumVal % mod);

    return (int) sumVal % mod;
  }

  // Todo approach - largest histogram
  public int sumSubarrayMins(int[] arr) {
    int N = arr.length;
    int mod = 1000000007;

    Stack<Integer> leftStk = new Stack<>();
    int[] leftArr = new int[N];
    Arrays.fill(leftArr, -1);
    for (int i = 0; i < N; i++) {
      while (leftStk.size() > 0 && arr[leftStk.peek()] > arr[i]) {
        int index = leftStk.pop();
        leftArr[index] = i;
      }
      leftStk.add(i);
    }
    System.out.println(Arrays.toString(leftArr));

    Stack<Integer> rightStk = new Stack<>();
    int[] rightArr = new int[N];
    Arrays.fill(rightArr, N);
    for (int i = N - 1; i >= 0; i--) {
      while (rightStk.size() > 0 && arr[rightStk.peek()] > arr[i]) {
        int index = rightStk.pop();
        rightArr[index] = i;
      }
      rightStk.add(i);
    }

    System.out.println(Arrays.toString(rightArr));

    long sumVal = 0;
    for (int i = 0; i < N; i++) {
      int l = leftArr[i];
      int r = rightArr[i];
      int iter = (r - l - 1);
      System.out.println("iter = " + iter);
      long res = iter * arr[i];
      System.out.println(res);
      sumVal = (sumVal % mod + res % mod) % mod;
    }

    System.out.println(sumVal);
    return (int) sumVal % mod;
  }

  public static void main(String[] args) {
    SumOfSubArrayMinimum ss = new SumOfSubArrayMinimum();
    int[] arr = { 3, 1, 2, 4 };
    ss.sumSubarrayMins(arr);
  }
}
