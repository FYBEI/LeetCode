package Summary_of_Interview_Problem.string;

import java.util.*;


/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *      "cats and dog",
 *      "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *      "pine apple pen apple",
 *      "pineapple pen apple",
 *      "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 */
public class WordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet(wordDict);

        //dp[i][j]表示s从i-j的子串是否为单词
        boolean[][] dp = new boolean[s.length()+1][s.length()+1];

        for (int i = 0; i <= s.length(); i++){
            for (int j = i+1; j <= s.length(); j++){
                 if (wordDictSet.contains(s.substring(i, j))){
                     dp[i][j] = true;
                 } else {
                     dp[i][j] = false;
                 }
            }
        }

        for (int i = 0; i <= s.length(); i++){
            for (int j = 0; j <= s.length(); j++){
                System.out.print(dp[i][j]);
                System.out.printf(" ");
            }
            System.out.println();
        }

        // 获得所有单词排列情况
        List<List<Integer>> indexes = dfs(dp, 0, s);

        for (List<Integer> index : indexes){
            System.out.println(index);
        }

        List<String> sents = new ArrayList<>();

        for (List<Integer> index : indexes){
            // 如果拆分的最后一位不是字符串长度，说明字符串未完全拆分
            if (index.get(index.size()-1) != s.length()){
                continue;
            }

            //起始拆分位置为0
            int begin = 0;

            StringBuilder sent = new StringBuilder();
            for (int i : index){

                // 起始位置不为开头的话需要用空格隔开
                if (begin != 0){
                    sent.append(" ");
                }

                //拆分截至位置
                int end = i;

                String word = s.substring(begin, end);
                sent.append(word);

                // 下一个词的起始位置为当前的拆分截至位置
                begin = i;
            }

            sents.add(sent.toString());
        }

        return sents;
    }

    // 利用递归，获得全部的可拆分位置
    private List<List<Integer>> dfs(boolean[][] dp, int i, String s){

        // 记录所有单词排列情况
        List<List<Integer>> indexes = new ArrayList<>();
        for (int j = i+1; j <= s.length(); j++){
            if (dp[i][j]){
                List<Integer> index = new ArrayList<>();
                index.add(j);

                List<List<Integer>> next_indexes = dfs(dp, j, s);

                if (next_indexes.size() == 0){
                    //说明下一项已经没有单词排列
                    indexes.add(index);
                }else if (next_indexes.size() == 1){
                    //下一项只有一种单词排列情况
                    index.addAll(next_indexes.get(0));
                    indexes.add(index);
                }else {
                    //下一项有多种单词排列情况
                    for (List<Integer> next_index : next_indexes){
                        List<Integer> new_index = new ArrayList<>(index);
                        new_index.addAll(next_index);
                        indexes.add(new_index);
                    }
                }

            }
        }

        return indexes;
    }

    public static void main(String[] args) {
        WordBreak2 wb2 = new WordBreak2();

        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        String str = "catsanddog";

        List<String> result = wb2.wordBreak(str, wordDict);

        System.out.print(result);
    }
}
