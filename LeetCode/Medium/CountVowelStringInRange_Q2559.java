import java.util.Arrays;

public class CountVowelStringInRange_Q2559 {

  public boolean isVowel(char letter) {
    if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
      return true;
    }
    return false;
  }
  
  public int[] vowelStrings(String[] words, int[][] queries) {
    int N = words.length;
    int M = queries.length;
    int[] prefix = new int[N];

    for(int i = 0; i < N; i++) {
      String curWord = words[i];
      if(isVowel(curWord.charAt(0)) && isVowel(curWord.charAt(curWord.length() - 1))) {
        prefix[i] = 1;
      }
    }

    System.out.println(Arrays.toString(prefix));

    
    for(int i = 1; i < N; i++) {
      prefix[i] = prefix[i] + prefix[i-1];
    }

    System.out.println(Arrays.toString(prefix));

    int[] result = new int[M];
    for(int i = 0; i < M; i++) {
      int start = queries[i][0];
      int end = queries[i][1];

      if(start == 0) {
        result[i] = prefix[end];
      } else {
        result[i] = prefix[end] - prefix[start - 1];
      }
    }

    System.out.println(Arrays.toString(result));
    return result;
  }

  public static void main(String[] args) {
    CountVowelStringInRange_Q2559 cw = new CountVowelStringInRange_Q2559();
    // String[] words = { "aba", "bcb", "ece", "aa", "e" };
    // int[][] queries = { { 0, 2 }, { 1, 4 }, { 1, 1 } };


    String[] words = { "a","e","i" };
    int[][] queries = { { 0, 2 }, { 0, 1 }, { 2, 2 } };
    cw.vowelStrings(words, queries);
  }
}
