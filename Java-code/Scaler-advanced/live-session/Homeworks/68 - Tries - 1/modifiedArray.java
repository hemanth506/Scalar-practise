import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Used Video hints and understood the concept.
class Node {
    boolean isEnd;
    HashMap<Character, Node> hm = new HashMap<>();
    Node () {
        isEnd = false;
    }
}

public class modifiedArray {
    public String solve(ArrayList<String> A, ArrayList<String> B) {
        int N = A.size();
        Node root = new Node();
        for(int i = 0; i < N; i++) {
            insertNode(root, A.get(i));
        }

        StringBuilder sb = new StringBuilder();
        int Nb = B.size();
        for(int i = 0; i < Nb; i++) {
            char res = wordCheck(root, B.get(i), 0, 0) ? '1' : '0';
            sb.append(res);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public boolean wordCheck(Node root, String word, int ind, int flag) {
        Node t = root;
        boolean ans = false;
        int wordSize = word.length();
        if(ind == wordSize) {
            if(t.isEnd && flag == 1) {
                return true;
            } else {
                return false;
            }
        }

        Character ch = word.charAt(ind);
        if(flag == 0) {
            for(Map.Entry<Character,Node> entry: t.hm.entrySet()) {
                Node curNode = entry.getValue();
                if(entry.getKey() == ch) {
                    ans = ans || wordCheck(curNode, word, ind+1, flag);
                } else {
                    ans = ans || wordCheck(curNode, word, ind+1, 1-flag);
                }
            }
        } else {
            if(t.hm.containsKey(ch)) {
                ans = ans || wordCheck(t.hm.get(ch), word, ind+1, flag);
            }
        }
        
        return ans;
    }

    public void insertNode(Node root, String word) {
        Node t = root;
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if(t.hm.containsKey(ch)) {
                t = t.hm.get(ch);
            } else {
                Node nn = new Node();
                t.hm.put(ch, nn);
                t = nn;
            }
        }
        t.isEnd = true;
    }
    public static void main(String[] args) {
        modifiedArray ma = new modifiedArray();
        ArrayList<String> A = new ArrayList<String>(Arrays.asList("data", "circle", "cricket"));
        ArrayList<String> B = new ArrayList<String>(Arrays.asList("date", "circel", "crikket", "data", "circl"));

        ma.solve(A, B);
    }
}
