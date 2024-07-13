import java.util.ArrayList;
import java.util.HashMap;

public class integerToRoman {
    public ArrayList<String> convertRoman(ArrayList<String> al, int currVal, int m) {
        
        // System.out.println(hm);

        System.out.println(currVal);
        return al;

    }
    
    public String intToRoman(int num) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "I");
        hm.put(5, "V");
        hm.put(10, "X");
        hm.put(50, "L");
        hm.put(100, "C");
        hm.put(500, "D");
        hm.put(1000, "M");
        

        ArrayList<Integer> splitNumber = new ArrayList<Integer>();
        int i = 1;
        while (num > 0) {
            int modVal = num % 10;
            splitNumber.add(modVal*i);
            num /= 10;
            i *= 10;
        }
        System.out.println(splitNumber);

        ArrayList<String> roman = new ArrayList<String>();
        int N = splitNumber.size();
        int m = 1;
        for(int k = 0; k < N; k++) {
            int currVal = splitNumber.get(k);
            m = m * 10;
            int sub = m - currVal;
            if (sub > m/2) {
                System.out.println(currVal + " lesser than half of " + m);
                if (currVal == 4) {
                    roman.add(hm.get(m/2));
                    roman.add(hm.get(m/2 - currVal));
                } else {
                    if(currVal < 10) {
                        for(int pt = 0; pt < (m/2 - currVal); pt++) {
                            roman.add(hm.get(1));
                        }
                    }
                }
            } else {
                if (sub == m/2) {
                    System.out.println(currVal + " equal than half of " + m);
                    roman.add(hm.get(currVal));
                } else {
                    System.out.println(currVal + " greaater than half of " + m);
                }
            }
        }
        System.out.println(roman);
        return "";
    }
    public static void main(String[] args) {
        integerToRoman itr = new integerToRoman();
        int num = 1994;
        itr.intToRoman(num);
    }
}
