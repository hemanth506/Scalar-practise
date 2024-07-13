import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class specialMedian {

    private int calculateSplIndex(ArrayList<Integer> A) {
        int N = A.size();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(A.get(0));
        double median = A.get(0);
        for (int i = 1; i < N; i++) {
            int curVal = A.get(i);
            if (median == curVal) {
                System.out.println("LtoR = 1 " + median + " " + curVal);
                return 1;
            }

            if (maxHeap.peek() >= curVal) {
                maxHeap.add(curVal);
            } else {
                minHeap.add(curVal);
            }

            if (maxHeap.size() - minHeap.size() > 1) {
                int delElt = maxHeap.poll();
                minHeap.add(delElt);
            } 
            if (maxHeap.size() - minHeap.size() < 0) {
                int delElt = minHeap.poll();
                maxHeap.add(delElt);
            }

            int totElt = maxHeap.size() + minHeap.size();
            if (totElt % 2 == 0) {
                median = (maxHeap.peek() + minHeap.peek()) / (2.0);
            } else {
                median = maxHeap.peek();
            }

            System.out.println("maxHeap = " + maxHeap);
            System.out.println("minHeap = " + minHeap);
            System.out.println("i = " + i + " " + median + " " + A.get(i + 1));
        }

        System.out.println("LtoR = " + 0);
        return 0;
    }

    private int calculateSplIndexReverse(ArrayList<Integer> A) {
        int N = A.size();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(A.get(N - 1));
        double median = A.get(N - 1);
        for (int i = N - 2; i >= 0; i--) {
            int curVal = A.get(i);
            if (median == curVal) {
                System.out.println("RtoL = 1 " + median + " " + curVal);
                return 1;
            }

            if (maxHeap.peek() >= curVal) {
                maxHeap.add(curVal);
            } else {
                minHeap.add(curVal);
            }

            if (maxHeap.size() - minHeap.size() > 1) {
                int delElt = maxHeap.poll();
                minHeap.add(delElt);
            } 
            if (maxHeap.size() - minHeap.size() < 0) {
                int delElt = minHeap.poll();
                maxHeap.add(delElt);
            }

            int totElt = maxHeap.size() + minHeap.size();
            if (totElt % 2 == 0) {
                median = (maxHeap.peek() + minHeap.peek()) / (2.0);
            } else {
                median = maxHeap.peek();
            }

            System.out.println("maxHeap = " + maxHeap);
            System.out.println("minHeap = " + minHeap);
            System.out.println("i = " + i + " " + median + " " + A.get(i - 1));

        }
        return 0;
    }

    public int solve(ArrayList<Integer> A) {
        if (calculateSplIndex(A) == 1) {
            return 1;
        }
        return calculateSplIndexReverse(A);
    }

    public static void main(String[] args) {
        specialMedian sm = new specialMedian();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 15, 1, 3, 4, 7));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 6, 8, 4));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2147483647, -2147483648, 0));
        sm.solve(A);
    }
}
