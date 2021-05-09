package Summary_of_Interview_Problem.string;

/***
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 */

public class Trie {

    public Trie[] children;
    public boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        // 一共26个字母
        children = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            // 没有下一个节点就新建
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);

        //判断最后一个节点是否存在或者isEnd是否为true
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    // 遍历前缀，返回最后一个节点
    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        boolean result = true;

        trie.insert("apple");
        result = trie.search("apple");   // 返回 True
        System.out.println(result);
        result = trie.search("app");     // 返回 False
        System.out.println(result);
        result = trie.startsWith("app"); // 返回 True
        System.out.println(result);
        trie.insert("app");
        result = trie.search("app");     // 返回 True
        System.out.println(result);

    }
}
