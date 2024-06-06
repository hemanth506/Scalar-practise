import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class maxFrequencyStack {
    HashMap<Integer, Stack<Integer>> stackHm;
    HashMap<Integer, Integer> hm;
    int maxFreq;

    public maxFrequencyStack() {
        stackHm = new HashMap<>();
        hm = new HashMap<>();
        maxFreq = Integer.MIN_VALUE;
    }

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        ArrayList<Integer> output = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int operation = A.get(i).get(0);
            if(operation == 1) {
                output.add(push(A.get(i).get(1)));
            } else if (operation == 2) {
                output.add(pop());
            }
        }
        System.out.println(stackHm);
        System.out.println(output);
        return output;
    }

    public int push(int value) {
        int freq = 1;
        if(hm.containsKey(value)) {
            freq = hm.get(value) + 1;
        }
        maxFreq = Integer.max(maxFreq, freq);
        hm.put(value, freq);

        Stack<Integer> stk;
        if(stackHm.containsKey(freq)) {
            stk = stackHm.get(freq);
        } else {
            stk = new Stack<Integer>();
        }
        stk.add(value);
        stackHm.put(freq, stk);
        return -1;
    }

    public int pop() {
        int returnVal = 0;
        if(stackHm.containsKey(maxFreq)) {
            Stack<Integer> resStk = stackHm.get(maxFreq);
            returnVal = resStk.pop();
            hm.put(returnVal, hm.get(returnVal) - 1);
            if(resStk.isEmpty()) {
                maxFreq -= 1;
            }
        }
        return returnVal;
    }

    public static void main(String[] args) {
        maxFrequencyStack mf = new maxFrequencyStack();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 5)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 7)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 5)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 7)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 4)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 5)));
        // A.add(new ArrayList<Integer>(Arrays.asList(2, 0)));
        // A.add(new ArrayList<Integer>(Arrays.asList(2, 0)));
        // A.add(new ArrayList<Integer>(Arrays.asList(2, 0)));
        // A.add(new ArrayList<Integer>(Arrays.asList(2, 0)));

        A.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 7)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 4)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 7)));

        mf.solve(A);
    }
}
