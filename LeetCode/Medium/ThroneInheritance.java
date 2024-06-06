import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Do it in a easy way, arraylist.
 * Wrong and long approach
 */

class DLLNode {
  String name;
  DLLNode next;
  DLLNode prev;
  DLLNode lastChild;

  DLLNode(String name) {
    this.name = name;
    this.next = null;
    this.prev = null;
    this.lastChild = null;
  }
}

public class ThroneInheritance {
  HashMap<String, DLLNode> hm;
  DLLNode king;
  List<String> order;

  public ThroneInheritance(String kingName) {
    hm = new HashMap<>();
    DLLNode kingNode = new DLLNode(kingName);
    king = kingNode;
    hm.put(kingName, kingNode);
  }

  public void birth(String parentName, String childName) {
    DLLNode parentNode = hm.get(parentName);
    DLLNode childNode = new DLLNode(childName);
    hm.put(childName, childNode);
    
    if (parentNode.next == null) {
      parentNode.next = childNode;
      childNode.prev = parentNode;
    } else {
      if(parentNode.lastChild != null) {
        DLLNode lastChild = parentNode.lastChild;
        childNode.next = lastChild.next;
        if(lastChild.next != null) {
          lastChild.next.prev = childNode;
        }
        lastChild.next = childNode;
        childNode.prev = lastChild;
      } else {
        childNode.next = parentNode.next;
        parentNode.next.prev = childNode;
        childNode.prev = parentNode;
        parentNode.next = childNode;
      }
    }

    parentNode.lastChild = childNode;
  }

  public void death(String name) {
    DLLNode deadNode = hm.get(name);
    
    if(deadNode == king) {
      king = deadNode.next;
    } else {
      if(deadNode.prev != null) {
        deadNode.prev.next = deadNode.next;
      }

      if(deadNode.next != null) {
        deadNode.next.prev = deadNode.prev;
      }

      deadNode.next = null;
      deadNode.prev = null;
    }


    hm.remove(name);
  }

  public List<String> getInheritanceOrder() {
    DLLNode tempNode = king;
    order = new ArrayList<>();
    while(tempNode != null) {
      order.add(tempNode.name);
      tempNode = tempNode.next;
    }
    return order;
  }
}
