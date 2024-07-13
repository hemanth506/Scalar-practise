import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class kosarajuAlgo {
    Stack<Integer> stk = new Stack<>();
    HashMap<Integer, ArrayList<Integer>> adjList;
    boolean[] visited;

    public void getStack(int index) {
        // System.out.println("index = " + index);
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        if(adjList.containsKey(index)) {
            int QN = adjList.get(index).size();
            ArrayList<Integer> arr = adjList.get(index);
            for (int i = 0; i < QN; i++) {
                if (!visited[arr.get(i)]) {
                    getStack(arr.get(i));
                }
            }
        }
        stk.add(index);
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int E = B.size();
        adjList = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < E; i++) {
            int src = B.get(i).get(0);
            int dest = B.get(i).get(1);

            ArrayList<Integer> arr;
            if (adjList.containsKey(src)) {
                arr = adjList.get(src);
                arr.add(dest);
            } else {
                arr = new ArrayList<>();
                arr.add(dest);
            }
            adjList.put(src, arr);
        }
        System.out.println(adjList);
        visited = new boolean[A + 1];
        Arrays.fill(visited, false);

        for(int i = 1; i <= A; i++) {
            if(!visited[i]) {
                getStack(i);
            }
        }
        System.out.println(stk);


        visited = new boolean[A + 1];
        Arrays.fill(visited, false);
        adjList = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < E; i++) {
            int src = B.get(i).get(0);
            int dest = B.get(i).get(1);

            ArrayList<Integer> arr;
            if (adjList.containsKey(dest)) {
                arr = adjList.get(dest);
                arr.add(src);
            } else {
                arr = new ArrayList<>();
                arr.add(src);
            }
            adjList.put(dest, arr);
        }
        System.out.println(adjList);

        // que.add(popVal);
        Queue<Integer> que = new LinkedList<Integer>();
        int ct = 0;
        while(!stk.isEmpty()) {
            int popVal = stk.pop();
            if(!visited[popVal]) {
                que.add(popVal);
                ct += 1;
                while(!que.isEmpty()) {
                    int curVal = que.poll();
                    if (adjList.containsKey(curVal)) {
                        ArrayList<Integer> arr = adjList.get(curVal);
                        int QA = arr.size();
                        for(int i = 0; i < QA; i++) {
                            int cur = arr.get(i);
                            if(!visited[cur]) {
                                que.add(cur);
                                visited[cur] = true;
                            }
                        }
                    } else {
                        visited[popVal] = true;
                    }
                }
                
            }
        }
        System.out.println(ct);
        return ct;
    }

    public static void main(String[] args) {
        kosarajuAlgo ka = new kosarajuAlgo();
        // int A = 3;
        // ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        // B.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        // B.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        // B.add(new ArrayList<Integer>(Arrays.asList(3, 1)));

        int A = 11;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        B.add(new ArrayList<Integer>(Arrays.asList(3, 1)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
        B.add(new ArrayList<Integer>(Arrays.asList(4, 5)));
        B.add(new ArrayList<Integer>(Arrays.asList(5, 6)));
        B.add(new ArrayList<Integer>(Arrays.asList(6, 4)));
        B.add(new ArrayList<Integer>(Arrays.asList(7, 6)));
        B.add(new ArrayList<Integer>(Arrays.asList(7, 8)));
        B.add(new ArrayList<Integer>(Arrays.asList(8, 9)));
        B.add(new ArrayList<Integer>(Arrays.asList(10, 7)));
        B.add(new ArrayList<Integer>(Arrays.asList(9, 10)));
        B.add(new ArrayList<Integer>(Arrays.asList(10, 11)));

        ka.solve(A, B);
    }
}
