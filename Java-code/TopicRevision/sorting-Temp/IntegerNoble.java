import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class IntegerNoble {

  public int solve(ArrayList<Integer> A) {
    int N = A.size();
    Collections.sort(A, Collections.reverseOrder());

    int result = -1;
    for(int i = 0; i < N; i++) {
      if(A.get(i) == i) {
        result = i;
        break;
      }
    }

    System.out.println(result == -1 ? -1 : 1);
    return result == -1 ? -1 : 1;
  }

  public static void main(String[] args) {
    IntegerNoble ni = new IntegerNoble();
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 2, 1, 3));
    ni.solve(A);
  }
}
