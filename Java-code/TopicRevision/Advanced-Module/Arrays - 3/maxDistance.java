import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxDistance {
    public int maximumGap(final List<Integer> A) {
        int N = A.size();
        int minV = Integer.MAX_VALUE;
        int maxV = Integer.MIN_VALUE;
        int minId = 0;
        int maxId = 0;
        int maxDist = 0;
        for(int i = 0; i < N; i++) {
            if(A.get(i) < minV) {
                minV = A.get(i);
                minId = i;
            }

            if (A.get(i) > maxV) {
                maxId = A.get(i);
                maxId = i;
            }

            maxDist = Integer.max(maxDist, maxId - minId);
        }
        System.out.println(maxDist);
        return maxDist;
    }
    public static void main(String[] args) {
        maxDistance md = new maxDistance();
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 5, 4, 2));
        md.maximumGap(A);
    }
}
