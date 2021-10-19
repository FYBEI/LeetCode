package binary_tree;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    class Node {

        char ch;
        boolean isEnd;
        Map<Character, Node> child;

        public Node (char ch, boolean isEnd){
            this.ch = ch;
            this.isEnd = isEnd;
            child = new HashMap<>();
        }

        public void insertNode(char ch, boolean isEnd){
            Node node = new Node(ch, isEnd);
            child.put(ch, node);
        }

        public Node getChild(char ch){
            return child.getOrDefault(ch, null);
        }
    }

    Node root;
    public Trie() {
        this.root = new Node(' ', false);
    }

    public void insert(String word) {
        Node cur = this.root;

        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            boolean isEnd;
            if (i == word.length()-1){
                isEnd = true;
            }else {
                isEnd = false;
            }

            if (!cur.child.containsKey(ch)){
                cur.insertNode(ch, isEnd);
            }

            cur = cur.getChild(ch);

            if (isEnd){
                cur.isEnd = isEnd;
            }
        }
    }

    public boolean search(String word) {
        Node cur = root;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            Node next = cur.getChild(ch);
            if (next == null){
                return false;
            }else {
                cur = next;
            }
        }

        if (cur.isEnd){
            return true;
        }else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        Node cur = root;

        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);

            Node next = cur.getChild(ch);
            if (next == null){
                return false;
            }else {
                cur = next;
            }
        }

        return true;
    }
}
