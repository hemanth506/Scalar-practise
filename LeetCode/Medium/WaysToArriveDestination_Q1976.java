
// todo - use dijstra

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
  int node;
  int time;

  Pair(int n, int t) {
    this.node = n;
    this.time = t;
  }
}

public class WaysToArriveDestination_Q1976 {

  HashMap<Integer, ArrayList<Pair>> adjList = new HashMap<>();
  int[] timeArr;

  private void getAdjList(int[][] roads) {
    int N = roads.length;

    for (int i = 0; i < N; i++) {
      int[] arr = roads[i];
      int src = arr[0];
      int dest = arr[1];
      int time = arr[2];

      ArrayList<Pair> prArrSrc;
      if (adjList.containsKey(src)) {
        prArrSrc = adjList.get(src);
      } else {
        prArrSrc = new ArrayList<>();
      }
      prArrSrc.add(new Pair(dest, time));
      adjList.put(src, prArrSrc);

      ArrayList<Pair> prArrDest;
      if (adjList.containsKey(dest)) {
        prArrDest = adjList.get(dest);
      } else {
        prArrDest = new ArrayList<>();
      }
      prArrDest.add(new Pair(src, time));
      adjList.put(dest, prArrDest);

    }
  }

  public int countPaths(int N, int[][] roads) {
    timeArr = new int[N];
    Arrays.fill(timeArr, Integer.MAX_VALUE);
    getAdjList(roads);

    PriorityQueue<Pair> minHeap = new PriorityQueue<>((Pair p1, Pair p2) -> p1.time - p2.time);
    timeArr[0] = 0;
    minHeap.add(new Pair(0, 0));

    while (!minHeap.isEmpty()) {
      Pair minPr = minHeap.poll();
      int node = minPr.node;
      int time = minPr.time;
      if (timeArr[node] < time) {
        continue;
      } else {
        ArrayList<Pair> destArr = adjList.get(node);
        for (int i = 0; i < destArr.size(); i++) {
          Pair pr = destArr.get(i);
          int n = pr.node;
          int t = pr.time;
          if (timeArr[n] > timeArr[node] + t) {
            timeArr[n] = timeArr[node] + t;
            minHeap.add(new Pair(n, timeArr[n]));
          }
        }
      }
    }

    return N;
  }

  public static void main(String[] args) {
    WaysToArriveDestination_Q1976 wt = new WaysToArriveDestination_Q1976();
    int n = 7;
    int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
        { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
    wt.countPaths(n, roads);
  }
}
