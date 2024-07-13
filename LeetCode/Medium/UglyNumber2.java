import java.util.ArrayList;

public class UglyNumber2 {

  public int nthUglyNumber(int N) {
    int limit = N * N * N;
    ArrayList<Integer> primes = getAllPrimes(limit);
    System.out.println(primes);

    boolean[] seiveArr = new boolean[limit+1];
    seiveArr[1] = true;
    int ct = 0;
    for (int i = 0; i < primes.size(); i++) {
      if(ct == 3) {
        break;
      }
      int prime = primes.get(i);
      for (int j = prime; j < limit; j += prime) {
        seiveArr[j] = true;
      }
      ct++;
    }

    for(int i = 3; i < primes.size(); i++) {
      int prime = primes.get(i);
      for (int j = prime; j < limit; j += prime) {
        if(seiveArr[j]) {
          seiveArr[j] = false;
        }
      }
    }

    ArrayList<Integer> arr = new ArrayList<>();
    for(int i = 0; i <= limit; i++) {
      if(seiveArr[i]) {
        arr.add(i);
      }
    }
    System.out.println(arr);
    System.out.println(arr.get(N-1));
    return arr.get(N-1);
  }

  private ArrayList<Integer> getAllPrimes(int limit) {
    boolean[] seiveArr = new boolean[limit + 1];

    for (int i = 2; i * i < limit; i++) {
      for (int j = i * 2; j < limit; j += i) {
        seiveArr[j] = true;
      }
    }

    ArrayList<Integer> prime = new ArrayList<>();
    for (int i = 2; i < limit; i++) {
      if (!seiveArr[i]) {
        prime.add(i);
      }
    }

    return prime;
  }

  public static void main(String[] args) {
    UglyNumber2 ug = new UglyNumber2();
    int N = 22;
    ug.nthUglyNumber(N);
  }
}
