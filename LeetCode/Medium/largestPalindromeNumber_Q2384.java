import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
  int num;
  int freq;

  Pair(int num, int freq) {
    this.num = num;
    this.freq = freq;
  }
}

public class largestPalindromeNumber_Q2384 {
  public String largestPalindromic(String num) {
    int N = num.length();
    int[] n = new int[10];
    for(int i = 0; i < 10; i++) {
      n[num.charAt(i) - '0']++;
    }

    boolean only = false;
    
    return "";
  }

  public String largestPalindromicWrong(String num) {
    int N = num.length();

    int limit = '0';
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < N; i++) {
      int freq = hm.getOrDefault(num.charAt(i) - limit, 0);
      hm.put(num.charAt(i) - limit, freq + 1);
    }
    System.out.println(hm);

    PriorityQueue<Pair> minHeap = new PriorityQueue<>((Pair p1, Pair p2) -> p1.num - p2.num);

    int oddMaxFreq = -1;
    int oddmaxInt = -1;
    for (Integer key : hm.keySet()) {
      if (hm.get(key) % 2 == 1) {
        if (oddMaxFreq < hm.get(key) || (oddMaxFreq == hm.get(key) && oddmaxInt < key)) {
          oddmaxInt = key;
          oddMaxFreq = hm.get(key);
        }
      } else {
        Pair pr = new Pair(key, hm.get(key));
        minHeap.add(pr);
      }
    }
    System.out.println(oddmaxInt + " === " + oddMaxFreq);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < oddMaxFreq; i++) {
      if(oddmaxInt == 0 && minHeap.isEmpty()) {
        break;
      }
      sb.append(oddmaxInt);
    }

    System.out.println(sb);
    if(minHeap.size() == 1) {
      Pair zeropr = minHeap.peek();
      if (zeropr.num == 0) {
        System.out.println(sb);
        return sb.toString();
      }
    }

    System.out.println(sb);

    while (!minHeap.isEmpty()) {
      Pair pr = minHeap.poll();
      System.out.println(pr.num + " " + pr.freq);
      int half = pr.freq / 2;
      StringBuilder sbFront = new StringBuilder();
      for (int j = 0; j < half; j++) {
        sb.append(pr.num);
        sbFront.append(pr.num);
      }
      sbFront.append(sb);
      sb = sbFront;
    }

    System.out.println(sb);
    return sb.toString();
  }

  
  public static void main(String[] args) {
    largestPalindromeNumber_Q2384 lp = new largestPalindromeNumber_Q2384();
    // String nums = "444947137";
    // String nums = "001";
        String nums = "3339444411";


    lp.largestPalindromic(nums);
  }
}
