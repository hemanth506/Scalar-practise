
// Need to work on this
import java.util.ArrayList;
import java.util.HashMap;

public class MinimumFuelCost {
  ArrayList<ArrayList<Integer>> pathsArr;
  ArrayList<Integer> path;
  boolean[] visited;
  HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

  private HashMap<Integer, ArrayList<Integer>> createAdjList(int[][] roads) {
    int N = roads.length;
    for (int i = 0; i < N; i++) {
      int src = roads[i][0];
      int dest = roads[i][1];

      ArrayList<Integer> arr;
      if (adj.containsKey(src)) {
        arr = adj.get(src);
      } else {
        arr = new ArrayList<>();
      }
      arr.add(dest);
      adj.put(src, arr);

      ArrayList<Integer> arr2;
      if (adj.containsKey(dest)) {
        arr2 = adj.get(dest);
      } else {
        arr2 = new ArrayList<>();
      }
      arr2.add(src);
      adj.put(dest, arr2);
    }

    return adj;
  }

  public long minimumFuelCost(int[][] roads, int seats) {
    int N = roads.length;
    pathsArr = new ArrayList<>();
    path = new ArrayList<>();
    visited = new boolean[N];

    adj = createAdjList(roads);

    path.add(0);
    return 1;
  }

  private void dfs(int node) {

  }

  public static void main(String[] args) {
    MinimumFuelCost mf = new MinimumFuelCost();
    int[][] roads = { { 3, 1 }, { 3, 2 }, { 1, 0 }, { 0, 4 }, { 0, 5 }, { 4, 6 }, { 8, 2 }, { 7, 2 }, { 9, 7 } };
    int seats = 2;
    mf.minimumFuelCost(roads, seats);
  }
}
