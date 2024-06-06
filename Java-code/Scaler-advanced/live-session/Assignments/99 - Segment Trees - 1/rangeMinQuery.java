import java.util.ArrayList;
import java.util.Arrays;

public class rangeMinQuery {
    int[] tree;

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int N = A.size();
        tree = new int[(4 * N) + 1];
        buildTree(0, N - 1, 1, A);
        ArrayList<Integer> ansArr = new ArrayList<>();
        System.out.println(Arrays.toString(tree));
        for (int i = 0; i < B.size(); i++) {
            int x = B.get(i).get(0);
            int y = B.get(i).get(1);
            int z = B.get(i).get(2);

            if (x == 1) {
                int val = getValue(y-1, z-1, 1, 0, N-1);
                ansArr.add(val);
            } else {
                updateValue(y-1, z, 1, 0, N-1, A);
                System.out.println("Updated = " + Arrays.toString(tree));
            }
        }

        System.out.println(ansArr);
        return A;
    }

    void buildTree(int l, int r, int i, ArrayList<Integer> A) {
        if (l == r) {
            tree[i] = A.get(l);
            return;
        }

        int m = (l+r) / 2;
        buildTree(l, m, 2*i, A);
        buildTree(m+1, r, (2*i)+1, A);
        tree[i] = Integer.min(tree[2*i], tree[(2*i)+1]);
    }

    int getValue(int ql, int qr, int i, int l, int r) {
        // No overlapping
        if (qr < l || r < ql) {
            return Integer.MAX_VALUE;
        }

        // complete overlapping
        if (ql <= l && r <= qr) {
            return tree[i];
        }

        // Partial overlapping
        int m = (l + r) / 2;
        int a = getValue(ql, qr, 2 * i, l, m);
        int b = getValue(ql, qr, (2 * i) + 1, m + 1, r);

        return Integer.min(a, b);
    }

    void updateValue(int y, int z, int i, int l, int r, ArrayList<Integer> A) {
        if(l == r && l == y) {
            tree[i] = z;
            A.set(y, z);
            return;
        }

        if(y < l || r < y) {
            return;
        }

        int m = (l+r)/2;
        updateValue(y, z, 2*i, l, m, A);
        updateValue(y, z, (2*i)+1, m+1, r, A);
        tree[i] = Integer.min(tree[2*i], tree[(2*i) + 1]);
    }

    public static void main(String[] args) {
        rangeMinQuery mq = new rangeMinQuery();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 4, 1));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 1, 3)));
        B.add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 1, 2)));

        mq.solve(A, B);
    }
}
