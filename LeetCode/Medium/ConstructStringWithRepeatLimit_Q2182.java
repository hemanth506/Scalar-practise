import java.util.Arrays;

public class ConstructStringWithRepeatLimit_Q2182 {
  public String repeatLimitedString(String s, int repeatLimit) {
    int N = s.length();
    char[] charArr = s.toCharArray();

    Arrays.sort(charArr);
    String reverse = new StringBuilder(new String(charArr)).reverse().toString();
    char[] reverseCharArr = reverse.toCharArray();
    System.out.println(reverseCharArr);

    int curLimit = 1;
    char prevChar = 'A';
    for (int i = 0; i < N; i++) {
      char curChar = reverseCharArr[i];
      if (prevChar == curChar) {
        if (curLimit == repeatLimit) {
          curLimit = 1;
          System.out.println("Repeat New " + curChar + " " + curLimit);
        } else {
          curLimit++;
        } 
      } else {
        curLimit = 1;
      }
      prevChar = curChar;
    }

    System.out.println(reverseCharArr);
    return s;
  }

  public static void main(String[] args) {
    ConstructStringWithRepeatLimit_Q2182 cs = new ConstructStringWithRepeatLimit_Q2182();
    // String s = "cczazcc";
    // int repeatLimit = 3;

    String s = "aababab";
    int repeatLimit = 2;
    cs.repeatLimitedString(s, repeatLimit);
  }
}