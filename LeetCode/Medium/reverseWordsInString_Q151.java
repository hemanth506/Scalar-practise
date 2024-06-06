public class reverseWordsInString_Q151 {
    StringBuilder finalSb;
    public StringBuilder swapString(StringBuilder sb) {
        int N = sb.length();
        StringBuilder resSb = new StringBuilder();
        for(int i = N-1; i >= 0; i--) {
            resSb.append(sb.charAt(i));
        }
        return resSb;
    }
    public String reverseWords(String s) {
        int N = s.length();
        finalSb = new StringBuilder();

        int started = -1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if (s.charAt(i) != ' ') {
                if (started == -1) {
                    sb = new StringBuilder();
                    sb.append(s.charAt(i));
                    started = i;
                } else {
                    sb.append(s.charAt(i));
                }
            }

            if(s.charAt(i) == ' ' && started != -1) {
                StringBuilder ssb = swapString(sb);
                ssb.append(" ");
                finalSb.append(ssb);
                started = -1;
            }
        }
        if (started != -1) {
            StringBuilder ssb = swapString(sb);
            ssb.append(" ");
            finalSb.append(ssb);
        }
        finalSb.deleteCharAt(finalSb.length()-1);
        String str = swapString(finalSb).toString();
        System.out.println(str);
        return str;
    }
    public static void main(String[] args) {
        reverseWordsInString_Q151 rv = new reverseWordsInString_Q151();
        String S = "  hello world  ";
        rv.reverseWords(S);
    }
}