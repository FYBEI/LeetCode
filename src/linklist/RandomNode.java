package linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNode {

    int len;
    List<Integer> values;

    public RandomNode(ListNode head) {
        len = 0;
        values = new ArrayList<Integer>();

        ListNode cur = head;
        while (cur != null){
            values.add(cur.val);
            len++;
            cur = cur.next;
        }
    }

    public int getRandom() {
        int index = new Random().nextInt(len);
        return values.get(index);
    }
}
