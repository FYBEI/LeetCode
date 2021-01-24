package Summary_of_Interview_Problem.string;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false

 */

public class WordBreak {

    static public TreeMap<Character, Pair<Boolean, TreeMap>> getDFA(List<String> wordDict){
        TreeMap<Character, Pair<Boolean, TreeMap>> dfa = new TreeMap<>();
        for (String word : wordDict){
            TreeMap<Character, Pair<Boolean, TreeMap>> cur_tree = dfa;
            for (int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if (!cur_tree.containsKey(ch)){
                    Pair<Boolean, TreeMap> pair = null;
                    if (i != word.length()-1){
                        pair = new Pair<>(false, new TreeMap<Character, Pair<Boolean, TreeMap>>());
                    }else {
                        pair = new Pair<>(true, new TreeMap<Character, Pair<Boolean, TreeMap>>());
                    }

                    cur_tree.put(ch, pair);

                }

                cur_tree = cur_tree.get(ch).getValue();
            }
        }

        return dfa;
    }

    static public boolean wordBreak(String s, List<String> wordDict) {

        TreeMap<Character, Pair<Boolean, TreeMap>> dfa = getDFA(wordDict);
        TreeMap<Character, Pair<Boolean, TreeMap>> cur_tree = dfa;

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (!cur_tree.containsKey(ch)){
                return false;
            }

            Pair<Boolean, TreeMap> pair = cur_tree.get(ch);
            if (pair.getKey()){
                cur_tree = dfa;
            }else {
                cur_tree = pair.getValue();
            }
        }

        return true;
    }

    static public void print_dfa(TreeMap<Character, Pair<Boolean, TreeMap>> dfa){
        if (dfa == null){
            return;
        }

        for (Character ch : dfa.keySet()){
            System.out.print(ch);

            TreeMap<Character, Pair<Boolean, TreeMap>> next_tree = dfa.get(ch).getValue();
            boolean end = dfa.get(ch).getKey();
            System.out.println(end);
            print_dfa(next_tree);
        }
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
//        wordDict.add("sand");
        wordDict.add("cat");
        wordDict.add("and");
        wordDict.add("og");
        String str = "catsandog";

        boolean result = wordBreak(str, wordDict);

        System.out.println(result);
    }
}
