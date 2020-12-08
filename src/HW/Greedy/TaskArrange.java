package HW.Greedy;

public class TaskArrange {

    /**
     * 贪心算法求活动安排问题，原则：选取结束时间早的活动
     * @param s 开始时间
     * @param f 结束时间，按结束时间的非降序排列
     * @return
     */
    static int greedySelector(int[] s, int[] f) {
        int n = s.length;
        boolean[] a = new boolean[n];
        a[0] = true;

        // 记录安排的前一个活动
        int j=0;
        // 记录活动数量
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (s[i] >= f[j]) {
                //当前活动的开始时间再前一个活动结束时间之后，表面可以加入
                //记录当前活动
                a[i] = true;
                j = i;
                //数量+1
                count++;
            } else
                a[i] = false;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] s = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] f = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        int result = greedySelector(s, f);
        System.out.println(result);
    }

}
