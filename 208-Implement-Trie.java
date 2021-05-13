 class TrieNode {
    public char val; // value of the node i.e. character which the node contains
    public TrieNode[] children = new TrieNode[26]; // Each node will have 26 children nodes for each character
    public boolean isLeaf; // bolean flag which marks the end of the string
    public TrieNode(){};
    public TrieNode(char x) {
        TrieNode node = new TrieNode();
        node.val = x;
    }
}

public class Trie {
 /** Initialize your data structure here. */
     
        TrieNode root;
        public Trie() {
             root = new TrieNode();
             root.val = ' ';
        }
        
    
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp =  root;
        
        //For every character in word, we check if the children node corresponding to it is null, if it is, we create a new trienode
        // and update the temp to the children node corresponding to the character.
        for(int i=0; i<word.length();i++) {
            char c = word.charAt(i);
            if(temp.children[c - 'a']==null) {
                temp.children[c - 'a']= new TrieNode(c);
            }
            temp = temp.children[c - 'a'];
        }
        temp.isLeaf = true; // when the end of word is reached
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tempNode = root;
        for(int i=0; i<word.length();i++) {
            char c = word.charAt(i);
            if(tempNode.children[c - 'a']==null) { // if no node exist for the character, it means word does not exist
                return false;
            }
            tempNode = tempNode.children[c - 'a'];
        }
        return tempNode.isLeaf; // if it reaches till the end, it means isLeaf is true.
        
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tempNode = root;
        for(int i=0 ; i<prefix.length();i++) {
            char ch = prefix.charAt(i);
             if(tempNode.children[ch - 'a']==null) {
                return false;
            }
            tempNode = tempNode.children[ch - 'a'];
        }
        return true;
    }

}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
