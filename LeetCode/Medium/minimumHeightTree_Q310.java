
// TO-DO

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Medium.Pair;

public class minimumHeightTree_Q310 {
    // Give TLE
    public List<Integer> findMinHeightTreesTLE(int n, int[][] edges) {
        int Ed = edges.length;
        if (Ed == 0) {
            return new ArrayList<>(Arrays.asList(0));
        }
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for (int i = 0; i < Ed; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];

            ArrayList<Integer> arr;
            if (hm.containsKey(src)) {
                arr = hm.get(src);
                arr.add(dest);
            } else {
                arr = new ArrayList<>();
                arr.add(dest);
                hm.put(src, arr);
            }

            ArrayList<Integer> arr2;
            if (hm.containsKey(dest)) {
                arr2 = hm.get(dest);
                arr2.add(src);
            } else {
                arr2 = new ArrayList<>();
                arr2.add(src);
                hm.put(dest, arr2);
            }
        }
        // System.out.println(hm);

        List<Integer> finalRes = new ArrayList<>();
        boolean visited[] = new boolean[n];
        Queue<Pair> que = new LinkedList<>();
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Pair pr = new Pair(i, 0);
            que.add(pr);
            visited = new boolean[n];
            int height = 0;
            while (!que.isEmpty()) {
                Pair cPr = que.poll();
                int cPrH = cPr.value;
                int cPrN = cPr.key;
                int size = hm.get(cPrN).size();
                visited[cPrN] = true;
                height = cPrH;
                for (int k = 0; k < size; k++) {
                    if (!visited[hm.get(cPrN).get(k)]) {
                        Pair newPr = new Pair(hm.get(cPrN).get(k), cPrH + 1);
                        que.add(newPr);
                    }
                }
            }

            if(minVal > height) {
                finalRes = new ArrayList<>();
                finalRes.add(i);
                minVal = height;
            } else if(minVal == height) {
                finalRes.add(i);
            }
        }

        System.out.println(finalRes);
        return finalRes;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int Ed = edges.length;
        List<Integer> finalList = new ArrayList<>();
        if (Ed == 0) {
            finalList.add(0);
            return finalList;
        }

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] degree = new int[n];
        for(int i = 0; i < Ed; i++) {
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
            adjList.get(edges[i][1]).add(edges[i][0]);
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        System.out.println(Arrays.toString(degree));
        System.out.println(adjList);



        // HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        // for (int i = 0; i < Ed; i++) {
        //     int src = edges[i][0];
        //     int dest = edges[i][1];

        //     ArrayList<Integer> arr;
        //     if (hm.containsKey(src)) {
        //         arr = hm.get(src);
        //         arr.add(dest);
        //     } else {
        //         arr = new ArrayList<>();
        //         arr.add(dest);
        //         hm.put(src, arr);
        //     }

        //     ArrayList<Integer> arr2;
        //     if (hm.containsKey(dest)) {
        //         arr2 = hm.get(dest);
        //         arr2.add(src);
        //     } else {
        //         arr2 = new ArrayList<>();
        //         arr2.add(src);
        //         hm.put(dest, arr2);
        //     }
        // }
        // System.out.println(hm);

        return null;
    }

    public static void main(String[] args) {
        minimumHeightTree_Q310 mh = new minimumHeightTree_Q310();
        // int N = 6;
        // int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };

        int N = 4;
        int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
        mh.findMinHeightTrees(N, edges);
    }
}
