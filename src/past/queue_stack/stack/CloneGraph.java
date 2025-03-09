package past.queue_stack.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 *
 * 输入：
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 */
public class CloneGraph {

    /**
     * Definition for a Node.
     */
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }

        Node root = new Node(node.val);
        root.neighbors = new ArrayList<>();

        Map<Integer, Node> visited = new HashMap<>();
        visited.put(root.val, root);

        if (node.neighbors != null && node.neighbors.size() != 0){
            process(root, node.neighbors, visited);
        }

        return root;
    }

    private void process(Node root, List<Node> neighbors, Map<Integer, Node> visited){
        for (Node neighbor : neighbors){
            Node newRoot;
            if (!visited.containsKey(neighbor.val)){
                newRoot = new Node(neighbor.val);
                newRoot.neighbors = new ArrayList<>();

                visited.put(newRoot.val, newRoot);
                if (neighbor.neighbors != null && neighbor.neighbors.size() != 0){
                    process(newRoot, neighbor.neighbors, visited);
                }
            }else {
                newRoot = visited.get(neighbor.val);
            }

            root.neighbors.add(newRoot);
        }
    }

}
