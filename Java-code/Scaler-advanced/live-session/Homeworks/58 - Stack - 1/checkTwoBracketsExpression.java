import java.util.Arrays;
import java.util.Stack;

public class checkTwoBracketsExpression {

    public int solve(String A, String B) {
        char[] arrA = calculateSign(A);
        char[] arrB = calculateSign(B);

        for(int i = 0; i < arrA.length; i++) {
            if(arrA[i] != arrB[i]) {
                System.out.println(0);
                return 0;
            }
        }

        System.out.println(1);
        return 1;
    }

    private char[] calculateSign(String A) {
        Stack<Character> globalChar = new Stack<Character>();
        char[] signs = new char[26];
        Arrays.fill(signs, '+');
        char localChar = '+';
        int N = A.length();
        for(int i = 0; i < N; i++) {
            char ch = A.charAt(i);

            if(ch == '-' || ch == '+') {
                if(globalChar.isEmpty()) {
                    localChar = ch;
                } else {
                    localChar = getCorrectSign(globalChar.peek(), ch);
                }
                continue;
            }

            if(ch == '(') {
                globalChar.push(localChar);
                continue;
            }

            if(ch == ')') {
                globalChar.pop();
                continue;
            }


            signs[ch - 'a'] = localChar;
        }
        return signs;
    }


    private Character getCorrectSign(char peek, char localChar) {
        if((peek == '-' && localChar == '+') || (peek == '+' && localChar == '-')) {
            return '-';
        }
        return '+';
    }

    public static void main(String[] args) {
        checkTwoBracketsExpression ct = new checkTwoBracketsExpression();
        String A = "-(a+b+c)";
        String B = "-a-b-c";

        ct.solve(A, B);
    }
}
