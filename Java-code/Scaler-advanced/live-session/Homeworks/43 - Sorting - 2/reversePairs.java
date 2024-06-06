import java.util.ArrayList;
import java.util.Arrays;

public class reversePairs {
    // Brute force which returns error
    public int solvebrute(ArrayList<Integer> A) {
        int N = A.size();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                long curVal = A.get(i);
                long nextVal = A.get(j);
                if (curVal != nextVal) {
                    System.out.println(A.get(i) + " || " + A.get(j));
                    if (curVal > (nextVal * 2)) {
                        System.out.println(i + " " + j);
                        count += 1;
                    }
                }
            }
        }
        System.out.println(count);
        return count;
    }

    long count = 0;
    public void merge(ArrayList<Integer> A, int start, int mid, int end) {
        System.out.println("================");
        System.out.println(start + " " + mid + " " + end);
        ArrayList<Integer> C = new ArrayList<Integer>();
        int p1 = start;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= end) {
            if ((long) A.get(p1) > 2 * (long) A.get(p2)) {
                count += mid - p1 + 1;
                System.out.println(count);
                p2++;
            } else {
                p1++;
            }
        }

        p1 = start;
        p2 = mid + 1;
        while (p1 <= mid && p2 <= end) {
            System.out.println(A.get(p1) + " " + A.get(p2) + " || " + (2 * A.get(p2)));
            if (A.get(p1) <= A.get(p2)) {
                C.add(A.get(p1));
                p1++;
            } else {
                C.add(A.get(p2));
                p2++;
            }
        }

        while (p1 <= mid) {
            System.out.println("p1 => " + A.get(p1));
            C.add(A.get(p1));
            p1++;
        }

        while (p2 <= end) {
            System.out.println("p2 => " + A.get(p2));
            C.add(A.get(p2));
            p2++;
        }

        int j = 0;
        for (int i = start; i <= end; i++) {
            A.set(i, C.get(j));
            j++;
        }
        System.out.println(A);

    }

    public void mergeSort(ArrayList<Integer> A, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);
        merge(A, start, mid, end);
    }

    public int solve(ArrayList<Integer> A) {
        int start = 0;
        int end = A.size() - 1;
        mergeSort(A, start, end);
        System.out.println(A);
        System.out.println(count);
        return (int) count;
    }

    public static void main(String[] args) {
        reversePairs rps = new reversePairs();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 3, 2, 3, 1));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4,1,2));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(14046, 57239,
        // 78362, 99387, 27609, 55100, 65536, 62099, 40820, 33056, 88380, 78549, 57512,
        // 33137, 81212, 32365, 42276, 65368, 52459, 74924, 25355, 76044, 78056, 45190,
        // 94365, 58869, 20611));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2000000000,
        // 2000000000, -2000000000));

        rps.solve(A);

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 1, 3));
        // rps.merge(A, 0, 2, 4);

    }
}
