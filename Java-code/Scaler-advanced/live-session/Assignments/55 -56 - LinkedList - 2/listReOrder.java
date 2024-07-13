class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class listReOrder {
    public ListNode splitNode(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode A) {
        ListNode head = A;
        ListNode tHead = null;
        ListNode rHead = null;

        while (head != null) {
            tHead = head;
            head = head.next;
            if (rHead == null) {
                tHead.next = null;
                rHead = tHead;
            } else {
                tHead.next = rHead;
                rHead = tHead;
            }
        }
        return rHead;
    }

    void printLL(ListNode rHead) {
        ListNode tempRHead = rHead;
        while (tempRHead != null) {
            System.out.print(tempRHead.val + " ");
            tempRHead = tempRHead.next;
        }
        System.out.println();
    }

    public ListNode reorderList(ListNode A) {
        if (A.next == null) {
            return A;
        }

        ListNode tempA = A;
        ListNode resultList = tempA;
        ListNode mid = splitNode(tempA);
        ListNode nextList = mid.next;
        mid.next = null;
        ListNode temp1 = tempA;
        ListNode temp2 = reverseList(nextList);

        ListNode temp1Next = null, temp2Next = null;
        while (temp1 != null && temp2 != null) {
            temp1Next = temp1.next;
            temp2Next = temp2.next;
            temp1.next = temp2;
            temp2.next = temp1Next;
            temp1 = temp1Next;
            temp2 = temp2Next;
        }
        
        return resultList;
    }
}
