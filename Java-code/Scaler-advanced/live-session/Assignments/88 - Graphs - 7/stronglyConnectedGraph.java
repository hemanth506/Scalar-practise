import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class stronglyConnectedGraph {
    boolean[] visited;
    HashMap<Integer, ArrayList<Integer>> adjList;
    Stack<Integer> stk = new Stack<>();

    public void getAdjList (ArrayList<ArrayList<Integer>> B, boolean isRev, int N) {
        for (int i = 0; i < N; i++) {
            int src = B.get(i).get(0);
            int dest = B.get(i).get(1);

            ArrayList<Integer> arr;
            if(!isRev) {
                if (adjList.containsKey(src)) {
                    arr = adjList.get(src);
                } else {
                    arr = new ArrayList<>();
                }
                arr.add(dest);
                adjList.put(src, arr);
            } else {
                if (adjList.containsKey(dest)) {
                    arr = adjList.get(dest);
                } else {
                    arr = new ArrayList<>();
                }
                arr.add(src);
                adjList.put(dest, arr);
            }
        }
    }

    public void dfs(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;

        if (adjList.containsKey(node)) {
            for (int i = 0; i < adjList.get(node).size(); i++) {
                int child = adjList.get(node).get(i);
                if (!visited[child]) {
                    dfs(child);
                }
            }
        }
        stk.add(node);
    }

    public void dfs2(int node, ArrayList<Integer> temp) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        temp.add(node);

        if (adjList.containsKey(node)) {
            for (int i = 0; i < adjList.get(node).size(); i++) {
                int child = adjList.get(node).get(i);
                if (!visited[child]) {
                    dfs2(child, temp);
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int N = B.size();
        adjList = new HashMap<>();
        getAdjList(B, false, N);
        // System.out.println(adjList);

        visited = new boolean[A + 1];
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        // System.out.println(stk);

        adjList = new HashMap<Integer, ArrayList<Integer>>();
        getAdjList(B, true, N);
        // System.out.println(adjList);
        
        visited = new boolean[A + 1];
        Arrays.fill(visited, false);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!stk.isEmpty()) {
            int val = stk.pop();
            ArrayList<Integer> temp = new ArrayList<>();
            dfs2(val, temp);
            Collections.sort(temp);
            if (!temp.isEmpty()) {
                result.add(temp);
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        stronglyConnectedGraph scg = new stronglyConnectedGraph();
        // int A = 6;
        // ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        // B.add(new ArrayList<Integer>(Arrays.asList(5, 3)));
        // B.add(new ArrayList<Integer>(Arrays.asList(3, 5)));
        // B.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        // B.add(new ArrayList<Integer>(Arrays.asList(4, 1)));
        // B.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
        // B.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        // B.add(new ArrayList<Integer>(Arrays.asList(5, 2)));
        // B.add(new ArrayList<Integer>(Arrays.asList(3, 1)));

        int A = 5;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        B.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        B.add(new ArrayList<Integer>(Arrays.asList(4, 5)));

        scg.solve(A, B);
    }
}


/*
 * public ArrayList<ArrayList<Integer>> solveOLD(int A, ArrayList<ArrayList<Integer>> B) {
        int N = B.size();
        adjList = new HashMap<>();
        getAdjList(B, false, N);
        System.out.println(adjList);

        visited = new boolean[A + 1];
        for (int i = 1; i < A; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        System.out.println(stk);

        adjList = new HashMap<Integer, ArrayList<Integer>>();
        getAdjList(B, true, N);
        System.out.println(adjList);
        
        visited = new boolean[A + 1];
        Arrays.fill(visited, false);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        while (!stk.isEmpty()) {
            int val = stk.pop();
            ArrayList<Integer> temp = new ArrayList<>();
            if (!visited[val]) {
                que.add(val);
                while (!que.isEmpty()) {
                    int queVal = que.poll();
                    if (adjList.containsKey(queVal)) {
                        ArrayList<Integer> arr = adjList.get(queVal);
                        int QN = arr.size();
                        for (int i = 0; i < QN; i++) {
                            int cur = arr.get(i);
                            if (!visited[cur]) {
                                que.add(cur);
                                visited[cur] = true;
                                temp.add(cur);
                            }
                        }
                    } else {
                        visited[queVal] = true;
                        temp.add(queVal);
                    }
                }
            }
            if (!temp.isEmpty()) {
                result.add(temp);
            }
        }
        System.out.println(result);
        for(int i = 0; i < result.size(); i++) {
            Collections.sort(result.get(i));
        }
        System.out.println(result);
        return result;
    }
 */