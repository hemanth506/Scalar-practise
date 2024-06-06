import java.util.HashSet;


public class boringSubstring {
    public int solve(String A) {
        int N = A.length();
        HashSet<Character> hs = new HashSet<Character>();
        for(int i = 0; i < N; i++) {
            hs.add(A.charAt(i));
        } 
        System.out.println(hs);

        for(int i = 0; i < N; i++) {
            boolean found = false;
            char curChar = A.charAt(i);
            if(hs.contains(curChar)) {
                for(int j = (int)'a'; j <= (int)'z'; j++) {
                    char asciiChar = (char)j;
                    char plus1 =  (char)(A.charAt(i) + 1);
                    char minus1 =  (char)(A.charAt(i) - 1);
                    System.out.println("========"+curChar+"========");
                    if(asciiChar != curChar && asciiChar != plus1 && asciiChar != minus1) {
                        if(hs.contains(asciiChar)) {
                            System.out.println(curChar + " " + asciiChar + " " + hs);
                            found = true;
                            break;
                        }
                    }
                }
                if(!found) {
                    System.out.println("No pair");
                    return 0;
                }
            }
         }
        System.out.println("All matches");
        return 1;
    }
    public static void main(String[] args) {
        boringSubstring bs = new boringSubstring();
        // String A = "abcd"; // 1
        String A = "aab"; // 0
        // String A = "gbedggcjac"; // 1
        // String A = "wwuvuw"; // 0
        // String A = "iagaabf"; // 1
        bs.solve(A);
    }
}
