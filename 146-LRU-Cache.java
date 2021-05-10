/*
The problem can be solved with a hashtable that keeps track of the keys and its values in the double linked list. One interesting property about double linked list is that the node can remove itself without other reference. In addition, it takes constant time to add and remove nodes from the head or tail.

One particularity about the double linked list that I implemented is that I create a pseudo head and tail to mark the boundary, so that we don't need to check the NULL node during the update. This makes the code more concise and clean, and also it is good for the performance.
*/

public class LRUCache {
    DLinkNode head;
    DLinkNode tail;
    HashMap<Integer, DLinkNode> map;
    int count;
    int capacityOfCache;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new DLinkNode(0,0);
        tail = new DLinkNode(0,0);
        count = 0;
        capacityOfCache = capacity;
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(map.get(key) != null) {
            DLinkNode node = map.get(key);
            int res = node.val;
            deleteNode(node);
            addToHead(node);
            return res;
        }
        return -1;
    }
    
    public void addToHead(DLinkNode node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    
    public void deleteNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            DLinkNode node = new DLinkNode(key,value);
            map.put(key,node);
            if(count < capacityOfCache) {
                count++;
                addToHead(node);
            }
            else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
        else {
            DLinkNode node = map.get(key);
            node.val = value;
            deleteNode(node);
            addToHead(node);
        }
    }
}

class DLinkNode {
    int key;
    int val;
    DLinkNode pre;
    DLinkNode next;
    public DLinkNode(int k, int v) {
        key = k;
        val = v;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
