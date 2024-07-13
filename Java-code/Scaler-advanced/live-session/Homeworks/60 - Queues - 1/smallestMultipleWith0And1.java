import java.util.Deque;
import java.util.LinkedList;

public class smallestMultipleWith0And1 {
    public boolean checkChar(StringBuilder strA, int strLen) {
        boolean foundValue = true;
        for(int i = 0; i < strLen; i++) {
            if(strA.charAt(i) != '0' && strA.charAt(i) != '1') {
                System.out.println("strA.charAt(i) = " + strA.charAt(i));
                foundValue = false;
                break;
            }
        }
        return foundValue;
    }
    
    public String multipleBruteForce(int A) {
        StringBuilder strA = new StringBuilder();
        strA.append(A);
        System.out.println(strA);

        int strLen = strA.length();
        char lastChar = strA.charAt(strLen - 1);
        if(lastChar == '1' || lastChar == '0') {
            boolean resVal = checkChar(strA, strLen);
            if(resVal) {
                return strA.toString();
            }
        }
        
        boolean iterativeVal = true;
        long tempA = A;
        StringBuilder finalStr = new StringBuilder();
        while (iterativeVal) {
            tempA += A;
            StringBuilder tempStrA = new StringBuilder();
            tempStrA.append(tempA);
            System.out.println(tempStrA);

            int tempStrLen = tempStrA.length();
            char tempLastChar = tempStrA.charAt(tempStrLen - 1);
            if(tempLastChar == '1' || tempLastChar == '0') {
                boolean resVal = checkChar(tempStrA, tempStrLen);
                if(resVal) {
                    finalStr.append(tempStrA);
                    iterativeVal = false;
                    break;
                }
            }
        }
        System.out.println(" result = " + finalStr.toString());
        return finalStr.toString();
    }

    public String multiple(int A) {
        boolean iterativeVal = true;
        StringBuilder i = new StringBuilder();
        i.append("1");
        Deque<StringBuilder> deqSb = new LinkedList<>();
        deqSb.add(i);
        String finalVal = "";
        while (iterativeVal) {
            String str = deqSb.peek().toString();
            long longInt = Long.parseLong(str);
            System.out.println("longInt = " + longInt);
            if(longInt%A == 0) {
                iterativeVal = false;
                finalVal = str;
                break;
            }

            StringBuilder curSb = deqSb.peek();

            StringBuilder curSb0 = new StringBuilder();
            curSb0.append(curSb);
            curSb0.append("0");
            // System.out.println("curSb0 = " + curSb0);
            deqSb.add(curSb0);

            StringBuilder curSb1 = new StringBuilder();
            curSb1.append(curSb);
            curSb1.append("1");
            // System.out.println("curSb1 = " + curSb1);
            deqSb.add(curSb1);
            deqSb.pop();
        }
        System.out.println("finalVal = " + finalVal);
        return finalVal;
    }
    public static void main(String[] args) {
        smallestMultipleWith0And1 sm = new smallestMultipleWith0And1();
        int A = 10;
        // int A = 91377;

        sm.multiple(A);
    }
}
