import java.util.HashMap;

public class decodeStringAtIndex_Q880 {
    
    // problem misunderstood
    public String decodeAtIndex_X(String s, int k) {
        int N = s.length();
        int i = 0;

        StringBuilder sb = new StringBuilder();
        StringBuilder tempSb = new StringBuilder();
        int ct = 0;
        boolean hasDigits = false;
        while (ct < k && i < N) {
            System.out.println("=== i = " + i + " ===");
            char curChar = s.charAt(i);
            if(Character.isDigit(curChar)) {
                hasDigits = true;
                int sbLen = sb.length();
                ct += sbLen;
                System.out.println("out ct = " + ct);
                tempSb = sb;
                if(k <= ct) {
                    System.out.println("ct = " + ct);
                    break;
                }
                int tempCt = sbLen * (Integer.parseInt(curChar+"") - 1);
                System.out.println("tempCt = " + tempCt);
                ct += tempCt;
                System.out.println("second ct = " + ct + " " + sb.toString());
                // if(i+1 < N && !Character.isDigit(s.charAt(i+1))) {
                //     sb = new StringBuilder();
                // }
                
            } else {
                sb.append(curChar);
            }
            i++;
        }

        // int index = tempSb.length() - curSbLen;
        // System.out.println(index);
        System.out.println(ct + " " + tempSb);
        System.out.println("k = " + k);
        if(!hasDigits) {
            System.out.println(s.charAt(k-1));
            return s.charAt(k-1)+"";
        }

        int index = ct == k ? ct - k : ct - k - 1;
        System.out.println("index = " + index);
        System.out.println("character = " + tempSb.charAt(index));
        return tempSb.charAt(index)+"";   
    }
    
    public String decodeAtIndex(String s, int k) {
        return s;
    }
    
    public static void main(String[] args) {
        decodeStringAtIndex_Q880 ds = new decodeStringAtIndex_Q880();
        // String s = "leet2code3";
        // int k = 10;

        // String s = "a2345678999999999999999";
        // int k = 1;

        // String s = "ha22";
        // int k = 5;

        // String s = "abc";
        // int k = 1;

        String s = "a23";
        int k = 6;
        
        ds.decodeAtIndex(s, k);
    }
}
