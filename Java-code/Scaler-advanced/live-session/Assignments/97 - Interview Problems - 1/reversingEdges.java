import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
    int node;
    int distance;

    Pair(int x, int y) {
        this.node = x;
        this.distance = y;
    }
}

public class reversingEdges {
    HashMap<Integer, ArrayList<Pair>> adjList;
    int maxNode;
    public HashMap<Integer, ArrayList<Pair>> getAdjList(ArrayList<ArrayList<Integer>> B, int N) {
        adjList = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int src = B.get(i).get(0);
            int dest = B.get(i).get(1);
            maxNode = Integer.max(src, dest);

            // src -> dest
            ArrayList<Pair> arr;
            Pair pr = new Pair(dest, 0);
            if (adjList.containsKey(src)) {
                arr = adjList.get(src);
            } else {
                arr = new ArrayList<>();
            }
            arr.add(pr);
            adjList.put(src, arr);

            // dest -> src
            ArrayList<Pair> arr2;
            Pair pr2 = new Pair(src, 1);
            if (adjList.containsKey(dest)) {
                arr2 = adjList.get(dest);
            } else {
                arr2 = new ArrayList<>();
            }
            arr2.add(pr2);
            adjList.put(dest, arr2);

        }
        return adjList;
    }

    // Used MinHeap approach
    public int reverseEdges(int A, ArrayList<ArrayList<Integer>> B) {
        int N = B.size();
        getAdjList(B, N);

        if(maxNode < A) {
            return -1;
        }

        int[] distArr = new int[maxNode+1];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[1] = 0;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((Pair p1, Pair p2) -> p1.distance - p2.distance);
        Pair pr = new Pair(1, 0);
        minHeap.add(pr);

        while (!minHeap.isEmpty()) {
            Pair minPr = minHeap.poll();
            int node = minPr.node;
            int dist = minPr.distance;
            if(distArr[node] < dist) {
                continue;
            } else {
                if(adjList.containsKey(node)) {
                    int size = adjList.get(node).size();
                    for(int j = 0; j < size; j++) {
                        Pair Cpr = adjList.get(node).get(j);
                        int n = Cpr.node;
                        int t = Cpr.distance;
                        if(distArr[node]+ t < distArr[n]) {
                            distArr[n] = distArr[node] + t;
                            // // System.out.println(distArr[n]);
                            minHeap.add(new Pair(n, distArr[n]));
                        }
                    }
                }
            }
        }
        // System.out.println(distArr[A]);
        return distArr[A] == Integer.MAX_VALUE ? -1 : distArr[A];
    }

    public static void main(String[] args) {
        reversingEdges re = new reversingEdges();
        int A = 5;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        B.add(new ArrayList<Integer>(Arrays.asList(4, 3)));
        B.add(new ArrayList<Integer>(Arrays.asList(4, 5)));

        re.reverseEdges(A, B);
    }
}
