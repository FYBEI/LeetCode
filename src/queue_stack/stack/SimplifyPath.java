package queue_stack.stack;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();

        String[] parts = path.split("/");
        for (int i = 0; i < parts.length; i++){
            String part = parts[i];

            if (part.equals(".") || part.equals("")){
                continue;
            }else if (part.equals("..")){
                if (!queue.isEmpty()){
                    queue.pollLast();
                }
            }else {
                queue.offer(part);
            }
        }

        StringBuilder ans = new StringBuilder("/");
        while (!queue.isEmpty()){
            ans.append(queue.pollFirst());
            if (!queue.isEmpty()){
                ans.append("/");
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();

        String path = "/a//b////c/d//././/..";

        sp.simplifyPath(path);
    }
}
