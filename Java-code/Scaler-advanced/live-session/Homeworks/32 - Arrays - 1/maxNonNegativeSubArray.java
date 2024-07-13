import java.util.ArrayList;
import java.util.Arrays;

public class maxNonNegativeSubArray {
    // Using Split and iterate tech - TC = O(N) SC = O(Range)
    public ArrayList<Integer> maxsetOLD(ArrayList<Integer> A) {
        int N = A.size();
        System.out.println(A);
        System.out.println("===================================");

        // split to the left when you find the negative value and find the sum
        long total;
        int arrLength;
        long maxTotal = 0;
        int maxArrLength = 0;
        int startingIndex = -1;
        int endingIndex = -1;
        for (int i = 1; i < N; i++) {
            if (A.get(i) < 0) {
                total = 0;
                arrLength = 0;
                int j;
                innerLoop: for (j = i - 1; j >= 0; j--) {
                    if (A.get(j) < 0) {
                        break innerLoop;
                    }
                    total += A.get(j);
                    arrLength += 1;
                }

                if (total > maxTotal) {
                    maxTotal = total;
                    maxArrLength = arrLength;
                    startingIndex = j + 1;
                    endingIndex = i - 1;
                } else if (total == maxTotal) {
                    maxTotal = total;
                    if (arrLength > maxArrLength) {
                        maxArrLength = arrLength;
                        startingIndex = j + 1;
                        endingIndex = i - 1;
                    }
                }
                // System.out.println("total => " + total + " " + maxTotal);
                // System.out.println("length => " + arrLength + " " + maxArrLength);
                // System.out.println("===================================");
            }
        }

        total = 0;
        arrLength = 0;
        int i;
        for (i = N - 1; i >= 0; i--) {
            if (A.get(i) < 0) {
                break;
            } else {
                total += A.get(i);
            }
            arrLength += 1;
        }

        if (total > maxTotal) {
            maxTotal = total;
            maxArrLength = arrLength;
            startingIndex = i + 1;
            endingIndex = N - 1;

        } else if (total == maxTotal) {
            maxTotal = total;
            if (arrLength > maxArrLength) {
                maxArrLength = arrLength;
                startingIndex = i + 1;
                endingIndex = N - 1;
            }
        }

        ArrayList<Integer> subArray = new ArrayList<Integer>();
        if (startingIndex != -1 && endingIndex != -1) {
            for (int k = startingIndex; k <= endingIndex; k++) {
                subArray.add(A.get(k));
            }
        }
        System.out.println(subArray);
        return subArray;
    }

    // Using prefixSum - TC = O(N) SC = O(N + Range)
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int N = A.size();
        ArrayList<Long> B = new ArrayList<Long>();
        int ctNeg = 0;
        for(int i = 0; i < N; i++) {
            B.add((long)A.get(i));
            if (A.get(i) < 0) {
                ctNeg += 1;
            }
        }
        if (ctNeg == N) {
            return new ArrayList<Integer>();
        }

        long sumV = 0;
        for (int i = 1; i < N; i++) {
            if (B.get(i) > 0) {
                sumV = B.get(i);
                if (B.get(i - 1) > 0) {
                    sumV += B.get(i - 1);
                }
                B.set(i, sumV);
            }
        }
        B.add(1L*-1);
        System.out.println(B);
        // System.out.println(startInd + " " + endInd);
        N = B.size();
        int endInd = 0;
        long maxV = Long.MIN_VALUE;
        for (int i = 1; i < N; i++) {
            if (B.get(i) < 0) {
                System.out.println(B.get(i - 1));
                if (B.get(i - 1) > maxV) {
                    endInd = i-1;
                    maxV = B.get(i-1);
                }
            }
        }
        
        int startInd = 0;
        for(int i = 0; i < endInd; i++) {
            if(B.get(i) < 0) {
                startInd = i + 1;
            }
        }
        System.out.println("startInd = " + startInd + " endInd = " + endInd);

        ArrayList<Integer> C = new ArrayList<Integer>();
        for(int i = startInd; i <= endInd; i++) {
            C.add(A.get(i));
        }
        System.out.println(C);
        return C;
    }

    public static void main(String[] args) {
        maxNonNegativeSubArray mn = new maxNonNegativeSubArray();

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 5, -7, 2, 3, -1, 1, -3, -2, 1, 4, 1, 1, 1, -5, 1, 1, 4, 1, 1));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 5, -7, 2,3));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(10, -1, 2, 3, -4, 100));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1967513926,1540383426, -1303455736, -521595368));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1));

        mn.maxset(A);
    }
}
