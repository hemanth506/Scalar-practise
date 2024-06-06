import java.util.ArrayList;
import java.util.HashMap;

public class windowString {
    // TLE = O(N^2)
    public String minWindowN2(String A, String B) {
        int N = A.length();
        int M = B.length();

        HashMap<Character, Integer> hmCharFreqB = new HashMap<>();
        for (int i = 0; i < M; i++) {
            if (hmCharFreqB.containsKey(B.charAt(i))) {
                int existFreq = hmCharFreqB.get(B.charAt(i)) + 1;
                hmCharFreqB.put(B.charAt(i), existFreq);
            } else {
                hmCharFreqB.put(B.charAt(i), 1);
            }
        }
        System.out.println("hmCharFreqB = " + hmCharFreqB);

        int minLength = Integer.MAX_VALUE;
        int strId = -1;
        int endId = -1;
        int length = N;
        boolean evenOnce = false;
        for (int i = 0; i < N; i++) {
            if (hmCharFreqB.containsKey(A.charAt(i))) {
                HashMap<Character, Integer> tempFreq = new HashMap<>(hmCharFreqB);
                System.out.println(A.charAt(i) + " " + i);
                for (int k = i; k < N; k++) {
                    if (tempFreq.containsKey(A.charAt(k))) {
                        if (tempFreq.get(A.charAt(k)) > 1) {
                            int val = tempFreq.get(A.charAt(k)) - 1;
                            tempFreq.put(A.charAt(k), val);
                        } else {
                            tempFreq.remove(A.charAt(k));
                        }
                    }
                    System.out.println("tempFreq = " + tempFreq);
                    if (tempFreq.isEmpty()) {
                        // b - a + 1
                        length = k - i + 1;
                        System.out.println(length);
                        if (minLength > length) {
                            minLength = length;
                            strId = i;
                            endId = k;
                            evenOnce = true;
                        }
                        break;
                    }
                    int tempLength = k - i;
                    if (tempLength > length) {
                        break;
                    }
                }
            }
        }

        System.out.println(strId + " " + endId);
        String outputString = "";
        if (evenOnce) {
            outputString = A.substring(strId, endId + 1);
        }
        System.out.println(outputString);
        return outputString;
    }

    public String minWindowInComplete(String A, String B) {
        int N = A.length();
        int M = B.length();

        HashMap<Character, Integer> hmCharFreqB = new HashMap<>();
        for (int i = 0; i < M; i++) {
            if (hmCharFreqB.containsKey(B.charAt(i))) {
                int existFreq = hmCharFreqB.get(B.charAt(i)) + 1;
                hmCharFreqB.put(B.charAt(i), existFreq);
            } else {
                hmCharFreqB.put(B.charAt(i), 1);
            }
        }
        System.out.println("hmCharFreqB = " + hmCharFreqB);

        HashMap<Character, ArrayList<Integer>> hmCharIdA = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (hmCharFreqB.containsKey(A.charAt(i))) {
                if (hmCharIdA.containsKey(A.charAt(i))) {
                    ArrayList<Integer> existCharId = hmCharIdA.get(A.charAt(i));
                    existCharId.add(i);
                    hmCharIdA.put(A.charAt(i), existCharId);
                } else {
                    ArrayList<Integer> charFreq = new ArrayList<>();
                    charFreq.add(i);
                    hmCharIdA.put(A.charAt(i), charFreq);
                }
            }
        }
        System.out.println(hmCharIdA);
        return B;
    }

    public String minWindow(String A, String B) {
        int N = A.length();
        int M = B.length();

        HashMap<Character, ArrayList<Integer>> hmCharFreqB = new HashMap<>();
        HashMap<Character, Integer> hmFreqB = new HashMap<>();
        for (int i = 0; i < M; i++) {
            if (hmCharFreqB.containsKey(B.charAt(i))) {
                ArrayList<Integer> existCharId = hmCharFreqB.get(B.charAt(i));
                existCharId.add(-1);
                hmCharFreqB.put(B.charAt(i), existCharId);
                int freq = hmFreqB.get(B.charAt(i)) + 1;
                hmFreqB.put(B.charAt(i), freq);
            } else {
                ArrayList<Integer> charFreq = new ArrayList<>();
                charFreq.add(-1);
                hmCharFreqB.put(B.charAt(i), charFreq);
                hmFreqB.put(B.charAt(i), 1);
            }
        }
        System.out.println("hmFreqB = " + hmFreqB);
        System.out.println("hmCharFreqB = " + hmCharFreqB);
        
        HashMap<Character, Integer> tempFreq = new HashMap<>(hmFreqB);
        for(int i = 0; i < N; i++) {
            if(hmFreqB.containsKey(A.charAt(i))) {
                if(tempFreq.isEmpty()) {
                    tempFreq = new HashMap<>(hmFreqB);
                }
            }
        }
        return B;
    }

    public static void main(String[] args) {
        windowString ws = new windowString();
        // String A = "ADOBECODEBANC";
        // String B = "ABC";

        // String A = "Aa91b";
        // String B = "ab";

        // String A = "w";
        // String B = "o";
        // String A = "A";
        // String B = "A";

        String A = "AMERICAAIRBASE";
        String B = "ABCA";

        ws.minWindow(A, B);
    }
}
