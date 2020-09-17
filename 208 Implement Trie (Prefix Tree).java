class Trie {
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node n = root;
        for(char x : word.toCharArray()) {
            if(n.arr[x-'a']==null) {
                n.arr[x-'a']=new Node();
            }
            n=n.arr[x-'a'];
        }
        n.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node n = prefix(word);
        return  n!=null && n.getEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String pre) {
        Node n = prefix(pre);
        return n!=null;
    }
    
    public Node prefix(String word) {
        Node n=root;
        for(char x : word.toCharArray()) {
            if(n.arr[x-'a']!=null) n=n.arr[x-'a'];
            else return null;
        }
        return n;
    }
}

class Node {
    Node arr[];
    boolean end;
    Node() {
        arr = new Node[26];
    }
    void setEnd() {
        end=true;
    }
    boolean getEnd() {
        return end;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */