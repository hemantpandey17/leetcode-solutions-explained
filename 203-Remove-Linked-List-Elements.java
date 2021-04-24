/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        // This while loop takes care of cases like head = [7,7,7,7].
        // Here it will directly remove all repeated occurences of val.
        while(head !=null && head.val == val) {
            head = head.next;
        }
        
        ListNode temp = head;
        while(temp != null && temp.next!= null) {
            if(temp.next.val == val) {
                temp.next = temp.next.next;
            }
            else
            temp = temp.next;
        }
        return head;
    }
}
