import java.util.ArrayList;
import java.util.Collections;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class mergedSortedKLists23 {
    // with extra space
    public ListNode mergeKListsWithSpace(ListNode[] lists) {
        int N = lists.length;
        int ctElt = 0;
        ArrayList<Integer> listVal = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            ListNode curListHead = lists[i];
            while (curListHead != null) {
                ctElt += 1;
                listVal.add(curListHead.val);
                curListHead = curListHead.next;
            }
        }
        System.out.println(ctElt);
        Collections.sort(listVal);
        System.out.println(listVal);

        ListNode finalNode = null;
        ListNode resultNode = null;
        for(int i = 0; i < listVal.size(); i++) {
            ListNode newNode = new ListNode(listVal.get(i));
            if(finalNode == null) {
                finalNode = newNode;
                resultNode = newNode;
            } else {
                finalNode.next = newNode;
                finalNode = finalNode.next;
            }
        }
        
        return resultNode;
    }

    // withOut Extra space
    public ListNode mergeKLists(ListNode[] lists) {
        int N = lists.length;
        ListNode rHead = null;
        boolean valueExists = true;
        while (valueExists) {
            valueExists = false;
            ListNode minValNode = null;
            int minVal = Integer.MIN_VALUE;
            for(int i = 0; i < N; i++) {
                if(lists[i] != null) {
                    System.out.println(lists[i].val);
                    // get the minimum value and node
                    if(minVal > lists[i].val) {
                        minVal = lists[i].val;
                        minValNode = lists[i];
                    }
                    valueExists = true;
                }
            }
            if(valueExists) {
                if(rHead == null) {
                    rHead = minValNode;
                } else {
                    rHead.next = minValNode;
                    rHead = rHead.next;
                }
            }
        }
        return rHead;
    }

}
