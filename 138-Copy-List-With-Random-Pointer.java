/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        
        while(curr!= null) {
            map.put(curr,new Node(curr.val));
            curr = curr.next;
        }
        
        for(Node n : map.keySet()) {
            Node newNode = map.get(n);
            newNode.next = map.get(n.next);
            newNode.random = map.get(n.random);
        }
        return map.get(head);
    }
}
