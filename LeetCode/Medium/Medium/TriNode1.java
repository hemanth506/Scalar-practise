package Medium;

import java.util.HashMap;

public class TriNode1 {
    public HashMap<Character, TriNode1> hm;
    public boolean isLast;
    public TriNode1() {
        isLast = false;
        hm = new HashMap<>();
    }
}
