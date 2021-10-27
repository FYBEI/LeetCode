package linklist;

public class RemoveZeroSumSublists {
    public ListNode removeZeroSumSublists(ListNode head) {
        // 记录链表长度，和每一个节点的值
        int n = 0;
        int[] hash = new int[1000];

        ListNode cur = head;
        while (cur != null){
            hash[n++] = cur.val;
            cur = cur.next;
        }

        // dp[i][j] 表示：链表i到j的和
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++){
            dp[i][i] = hash[i];
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i][j-1] + hash[j];
            }
        }
    }
}
