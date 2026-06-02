/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
1,4,5.  1,3,5.  3,6

1,4,5 and 1,3,  1,1,3,4,5,54
3,6

1,1,3,3,4,5,5,6


*/


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length ==0) {
            return null;
        }

        while(lists.length>1) {
            int newSize = (lists.length + 1) /2;
            ListNode[] merged = new ListNode[newSize];

            int index=0;
            for (int i =0; i<lists.length; i+=2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i+1<lists.length) ? lists[i+1] : null;
                merged[index++] = mergeTwoLists(l1,l2);
            }
            lists=merged;
        }

        return lists[0];


    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(list1!=null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if(list1!=null) {
            tail.next = list1;
        } else {
            tail.next=list2;
        }

        return dummy.next;
    }

}

/*
        if(lists==null) {
            return null;
        }
        if(lists.length==0) {
            return null;
        }

        ListNode result = null;

        for(int i = 0; i<lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }

        return result;


           private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);

        ListNode tail = dummy;

        while(list1!=null && list2 != null) {
            if(list1.val <= list2.val) {
                            tail.next=list1;

            list1=list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail=tail.next;

        }
        if(list1 != null) {
            tail.next=list1;
        } else {
            tail.next=list2;
        }

        return dummy.next;

    }

*/
