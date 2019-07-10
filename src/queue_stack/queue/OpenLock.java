package queue_stack.queue;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * *********
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 * *********
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 *
 * **********
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 *
 * **********
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 */
public class OpenLock {

    /**
     * BFS算法实现
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {

        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        //保存以访问过的密码
        Set<String> visited = new HashSet<>();
        String start = "0000";
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        //添加起始密码
        queue1.offer(start);

        int step=0;

        if(dead.contains(target) || dead.contains("0000")) {
            return -1;
        }

        while(!queue1.isEmpty()){
            //获得同时移出当前的状态密码
            String cur = queue1.poll();

            //如果当前状态密码就是目标密码
            if(target.equals(cur)){
                return step;
            }

            //获得下一个状态的八种密码
            List<String> nexts = getNexts(cur);

            //将没有尝试过的，并且不在死锁内的密码放入queue2中
            for(String s : nexts){
                if(!dead.contains(s) && !visited.contains(s)){
                    visited.add(s);
                    queue2.offer(s);
                }
            }

            //如果queue1为空，即放入的所有状况都尝试并且行不通，将queue2赋予queue1，进入下一个状态，步数加1
            if(queue1.isEmpty()){
                queue1 = queue2;
                queue2 = new LinkedList<String>();
                step++;
            }

        }

        return -1;
    }

    /**
     *获取邻接的所有节点
     */
    public List<String> getNexts(String cur){
        List<String> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            StringBuilder curSb = new StringBuilder(cur);
            curSb.setCharAt(i, cur.charAt(i)=='0'?'9':(char)(cur.charAt(i)-1));
            list.add(curSb.toString());
            curSb.setCharAt(i, (char)cur.charAt(i)=='9'?'0':(char)(cur.charAt(i)+1));
            list.add(curSb.toString());

        }
        return list;

    }
}
