package past.jianzhioffer;

import java.util.*;

public class FirstUniqChar {
    public char firstUniqChar(String s) {
        int len = s.length();
        if (len == 0) {
            return ' ';
        }

        Set<Character> set = new HashSet<>();
        Set<Character> doubleSet = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (!set.contains(ch)) {
                queue.add(ch);
                set.add(ch);
            }else {
                doubleSet.add(ch);
                while (!queue.isEmpty() && doubleSet.contains(queue.peek())) {
                    queue.poll();
                }
            }
        }

        if (queue.isEmpty()) {
            return ' ';
        }else {
            return queue.poll();
        }
    }
}
