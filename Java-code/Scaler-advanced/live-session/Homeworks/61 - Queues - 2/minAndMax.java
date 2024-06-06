import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class minAndMax {
    public ArrayList<Integer> maxArray(ArrayList<Integer> A, int B) {
        int N = A.size();
        ArrayList<Integer> maxL = new ArrayList<>();
        Deque<Integer> deqMax = new LinkedList<>();
        for(int i = 0; i < B; i++) {
            while(!deqMax.isEmpty() && deqMax.peekFirst() < A.get(i)) {
                deqMax.pollFirst();
            }
            deqMax.addLast(A.get(i));
        }
        maxL.add(deqMax.peekFirst());

        for(int i = B, j = 0; i < N; i++, j++) {
            int curVal = A.get(i);
            int remVal = A.get(j);
            while(!deqMax.isEmpty() && deqMax.peekLast() < curVal) {
                deqMax.pollLast();
            }
            deqMax.addLast(curVal);
            if(deqMax.peekFirst() == remVal) {
                deqMax.pollFirst();
            }
            maxL.add(deqMax.peekFirst());
        }
        System.out.println(maxL);
        return maxL;
    }

    public ArrayList<Integer> minArray(ArrayList<Integer> A, int B) {
        int N = A.size();
        ArrayList<Integer> minL = new ArrayList<>();
        Deque<Integer> deqMin = new LinkedList<>();
        for(int i = 0; i < B; i++) {
            while(!deqMin.isEmpty() && deqMin.peekFirst() > A.get(i)) {
                deqMin.pollFirst();
            }
            deqMin.addLast(A.get(i));
        }
        minL.add(deqMin.peekFirst());

        for(int i = B, j = 0; i < N; i++, j++) {
            int curVal = A.get(i);
            int remVal = A.get(j);
            while(!deqMin.isEmpty() && deqMin.peekLast() > curVal) {
                deqMin.pollLast();
            }
            deqMin.addLast(curVal);
            if(deqMin.peekFirst() == remVal) {
                deqMin.pollFirst();
            }
            minL.add(deqMin.peekFirst());
        }
        System.out.println(minL);
        return minL;
    }
    
    public int solve(ArrayList<Integer> A, int B) {
        int mod = 1000000007;
        
        ArrayList<Integer> minVArr = minArray(A, B);
        ArrayList<Integer> maxVArr = maxArray(A, B);

        int result = 0;
        for(int i = 0; i < minVArr.size(); i++) {
            result = (result + minVArr.get(i) + maxVArr.get(i))%mod;
            result %= mod; 
        }
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        minAndMax mm = new minAndMax();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 5, -1, 7, -3, -1, -2));
        int B = 4;
        mm.solve(A, B);
    }
}
