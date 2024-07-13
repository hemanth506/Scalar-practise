class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class longestPalindromicString {

    public int solveOLD(ListNode A) {
        ListNode tempA = A;
        ListNode rHead = null;
        ListNode tHead = null;
        int maxLen = Integer.MIN_VALUE;
        while(tempA != null) {
            tHead = tempA;
            if(rHead == null) {
                tHead.next = null;
                rHead = tHead;
            } else {
                // odd palindrome
                ListNode tempTempA1 = tempA.next;
                ListNode temprHead1 = rHead;
                boolean isPalin1 = true;
                int ct1 = 0;
                while (temprHead1 != null) {
                    if(temprHead1.val != tempTempA1.val) {
                        isPalin1 = false;
                        break;
                    }
                    ct1 += 1;
                }
                if(isPalin1) {
                    ct1 += 1;
                    maxLen = Integer.max(maxLen, ct1);
                }
                
                // even palindrome
                ListNode tempTempA2 = tempA.next;
                ListNode temprHead2 = rHead;
                boolean isPalin2 = true;
                int ct2 = 0;
                while (temprHead2 != null) {
                    if(temprHead2.val != tempTempA2.val) {
                        isPalin2 = false;
                        break;
                    }
                    ct2 += 1;
                }
                if(isPalin2) {
                    ct2 += 1;
                    maxLen = Integer.max(maxLen, ct2);
                }


                // add the next node to the reverse list
                tHead.next = rHead;
                rHead = tHead;
            }

            tempA = tempA.next;
        }
        System.out.println(maxLen);
        return maxLen;
    }


    void printLL(ListNode rHead) {
        ListNode tempRHead = rHead;
        while (tempRHead != null) {
            System.out.print(tempRHead.val + " ");
            tempRHead = tempRHead.next;
        }
        System.out.println();
    }

    public ListNode addToReverse(ListNode A, ListNode rHead) {
        ListNode helper = A;
        if(rHead == null) {
            helper.next = null;
            rHead = helper;
        } else {
            helper.next = rHead;
            rHead = helper;
        }
        return rHead;
    }

    public int solve(ListNode A) {
        ListNode tempA = A;
        ListNode rHead = null;
        ListNode helper = null;
        ListNode iNode = null;

        ListNode tempANext = null;
        
        int maxLen = Integer.MIN_VALUE;
        while(tempA != null) {
            helper = tempA;
            iNode = tempA.next;
            tempANext = tempA.next;
            boolean isPalin1 = true;
            if(rHead != null) {
                int ct1 = 0;
                while (rHead != null) {
                    if(iNode.val != rHead.val) {
                        isPalin1 = false;
                        break;
                    }
                    rHead = rHead.next;
                    iNode = iNode.next;
                }
                if(isPalin1) {
                    ct1 += 1;
                    maxLen = Integer.max(maxLen, ct1);
                }
            }
            helper.next = null;
            rHead = addToReverse(helper, rHead);
            tempA.next = tempANext;
            tempA = tempA.next;
        }
        System.out.println(maxLen);
        return maxLen;
    }
}
