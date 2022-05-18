package MeiTuanPratice;

import java.util.*;

public class Stream {

    public int waste(String s, String a) {
        if (a.length() == 1){
            return 25;
        }

        int waste = 0;
        Map<Character, List<Integer>> charIndex = new HashMap<>();

        // 记录s中每个元素的位置
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charIndex.containsKey(ch)) {
                charIndex.get(ch).add(i);
            }else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                charIndex.put(ch, indexes);
            }
        }

        // 前一位字符在s中的位置
        int preIndex = 0;
        int count = 0;
        for (int i = 0; i < a.length(); i++){
            char ch = a.charAt(i);
            List<Integer> indexes = charIndex.get(ch);

            // 记录当前字符在s中出现在前一个字符后的最前的位置
            int j = 0;
            for (; j < indexes.size(); j++) {
                if (indexes.get(j) > preIndex) {
                    break;
                }
            }

            // 如果当前字符位置在前一个字符之后，则记录新的位置，记录一个s中出现的a的字符的个数；
            if (j != indexes.size()) {
                count += 1;
                preIndex = indexes.get(j);
            }else {
                waste += (26-count);
                count = 1;
                preIndex = indexes.get(0);
            }
        }

        if (count > 0) {
            waste += (26 - count);
        }

        return waste;
    }

    public static void main(String[] args) {
        Stream stream = new Stream();
        String s = "bcdfgtujklmeanipqrstuvwxyz";
        String a = "meituan";

        int waste = stream.waste(s, a);
        System.out.println(waste);
    }
}
