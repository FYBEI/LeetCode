package past.random_problem;

/**
 * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
 * 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。
 *
 * 示例 1：
 * 输入：edges = [[1,2],[2,3],[4,2]]
 * 输出：2
 * 解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
 *
 * 示例 2：
 * 输入：edges = [[1,2],[5,1],[1,3],[1,4]]
 * 输出：1
 */
public class StarCenter {
    public int findCenter(int[][] edges) {

        int node1 = edges[0][0];
        int node2 = edges[0][1];
        int node3 = edges[1][0];
        int node4 = edges[1][1];

        if (node1 == node3 || node1 == node4){
            return node1;
        }else {
            return node2;
        }
    }

    public static void main(String[] args) {
        StarCenter starCenter = new StarCenter();

        int[][] edges = {{5,1}, {1,2}, {1,3}, {1,4}};
        int node = starCenter.findCenter(edges);
        System.out.println(node);
    }
}
