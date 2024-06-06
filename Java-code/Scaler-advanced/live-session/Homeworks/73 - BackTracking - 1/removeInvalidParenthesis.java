import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class removeInvalidParenthesis {
    Stack<Character> stk = new Stack<>();
    HashSet<String> hs = new HashSet<>();
    ArrayList<String> arr = new ArrayList<>();

    public void removeParenthesis(String A, int i, StringBuilder sb, int N) {
        if(i == N) {
            String str = sb.toString();
            if(!hs.contains(str)) {
                arr.add(str);
                hs.add(str);
            }
            System.out.println("exist");
            return;
        }

        
        char curChar = A.charAt(i);
        System.out.println(curChar + " i = " + i);
        if(curChar == '(' || curChar == ')') {
            
            if(curChar == '(') {
                stk.add(curChar);
                sb.append(curChar);
            } else if (curChar == ')') {
                System.out.println(stk);
                if(!stk.isEmpty() && stk.peek() == '(') {
                    stk.pop();
                    sb.append(curChar);
                }
            }
            
            removeParenthesis(A, i+1, sb, N);
            System.out.println("===check1=====" + sb.toString());
            // System.out.println("===before remove=====" + sb.toString());
            // sb.deleteCharAt(sb.length()-1);
            // System.out.println("===after remove=====" + sb.toString());
            // removeParenthesis(A, i+1, sb, N);
            // System.out.println("===check2=====" + sb.toString());

        } else {
            sb.append(curChar);
        }
        
    }
    public ArrayList<String> solve(String A) {
        int N = A.length();
        StringBuilder sb = new StringBuilder();
        removeParenthesis(A, 0, sb, N);
        System.out.println(arr);
        return null;
    }
    public static void main(String[] args) {
        removeInvalidParenthesis rip = new removeInvalidParenthesis();
        String A = "()())()";
        rip.solve(A);
    }
}
