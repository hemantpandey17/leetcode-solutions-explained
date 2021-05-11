/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0 || lists == null)
            return null;
        return partition(lists,0,lists.length -1); // Partitoning the entire list of ListNodes
    }
    public ListNode partition(ListNode[] lists, int start, int end)  {
        if(start==end)
            return lists[start]; // It will return when there is only one listNode remained in the sublist
        if(start < end) {
            int mid = (start + end)/2;
            ListNode l1 = partition(lists,start,mid); // Partioning first half of the list recursively
            ListNode l2 = partition(lists,mid+1,end); // Partitioning second half of the list recursively
            return merge(l1,l2); // Merging the lists obtained and returning 
        }
        else
            return null;
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2== null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}
        
       /* if(lists.length == 0 || lists == null)
            return null;
        
    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
        public int compare(ListNode l1, ListNode l2){
            return l1.val - l2.val;
        }
    });
        
        for(ListNode l : lists) {
            if(l!= null)
                pq.offer(l);
        }
        
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        while(!pq.isEmpty()) {
            ListNode n = pq.poll();
            p.next = n;
            p = p.next;
            
            if(n.next!=null) {
                pq.offer(n.next);
            }
        }
        
        return head.next;
    }
}*/
