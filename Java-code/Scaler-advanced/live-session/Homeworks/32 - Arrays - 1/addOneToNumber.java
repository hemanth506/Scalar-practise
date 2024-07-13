import java.util.ArrayList;
import java.util.Arrays;

public class addOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int N = A.size();
        System.out.println(A);

        // remove the unwanted zeros at the front if the size is not equal to 1
        ArrayList<Integer> B = new ArrayList<Integer>();
        if(N != 1) {
            boolean noZeroLimit = false;
            for(int i = 0; i < N; i++) {
                if(A.get(i) != 0) {
                    B.add(A.get(i));
                    noZeroLimit = true;
                } else {
                    if(noZeroLimit) {
                        B.add(A.get(i));
                    }
                }
            }
            if(!noZeroLimit) {
                B.add(0);
            }
        } else {
            B = A;
        }
        
        N = B.size();
        System.out.println("new length => " + N);
        System.out.println(B);

        int plusOne = 1;
        int divVal = 0;
        int modVal = 0;
        int lastVal = 0;
        for(int i = N - 1; i >= 0; i--) {
            System.out.println(A.get(i));
            divVal = (divVal / 10 ) + B.get(i);
            lastVal = B.get(i);
            if (i == N - 1) {
                divVal += plusOne;
            }
            modVal = divVal % 10;
            B.set(i, modVal);
        }
        System.out.println("modVal => " + modVal + " lastVal => " + lastVal);
        if(modVal == 0 && lastVal == 9) {
            B.add(0,1);
        }
        System.out.println(B);
        return B;
    }

    public static void main(String[] args) {
        addOneToNumber andOne = new addOneToNumber();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 0, 9, 9, 9));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(9, 9, 9));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 3, 7, 6, 4, 0, 5, 5, 5));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 0, 4, 4, 6, 0, 9, 6, 5, 1));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0,0));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(9));

        andOne.plusOne(A);

    }
}
