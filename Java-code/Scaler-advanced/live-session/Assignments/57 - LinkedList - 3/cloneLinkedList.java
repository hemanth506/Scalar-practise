
class ListNode {
    int val;
    ListNode next, random;

    ListNode(int x) {
        val = x;
        next = random = null;
    }
}

public class cloneLinkedList {
    ListNode cloneList(ListNode A) {
        ListNode tempA = A;
        while (tempA != null) {
            ListNode t = new ListNode(tempA.val);
            t.next = tempA.next;
            tempA.next = t;
            tempA = t.next;
        }

        ListNode h1 = A;
        ListNode B = A.next;
        ListNode h2 = B;
        while (h1 != null) {
            h2.random = h1.random.next;
            h1 = h2.next;
            if (h1 == null) {
                break;
            }
            h2 = h1.next;
        }

        ListNode t1 = A;
        ListNode t2 = B;
        while (t1 != null) {
            t1.next = t2.next;
            t1 = t1.next;
            if (t1 == null) {
                break;
            }
            t2.next = t1.next;
            t2 = t2.next;
        }
        return B;
    }
}
