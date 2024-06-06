import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};

public class cloneGraphs {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> hs = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        if(hs.containsKey(node)) {
            return hs.get(node);
        }

        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        hs.put(node, cloneNode);
        cloneNode.neighbors = new ArrayList<>();
        for(int i = 0; i < node.neighbors.size(); i++) {
            cloneNode.neighbors.add(cloneGraph(node.neighbors.get(i)));
        }
        return cloneNode;
    }
}
