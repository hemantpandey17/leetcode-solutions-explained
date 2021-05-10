/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode curr = prev;
        ListNode ptrL1 = l1;
        ListNode ptrL2 = l2;
        int l1_val = 0;
        int l2_val = 0;
        int carry = 0;
        int sum = 0;
        
        while(ptrL1!=null || ptrL2!=null) {
            if(ptrL1!=null) {
                l1_val = ptrL1.val;
                ptrL1 = ptrL1.next;
            }
            else {
                l1_val = 0;
            }
            
            if(ptrL2!=null) {
                l2_val = ptrL2.val;
                ptrL2 = ptrL2.next;
            }
            else {
                l2_val = 0;
            }
            
            sum = l1_val + l2_val + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
        }
        
        if(carry == 1) {
            curr.next = new ListNode(1);
        }
        
        return prev.next;
    }
}
