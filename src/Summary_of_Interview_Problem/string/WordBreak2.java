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

        boolean[][] dp = new boolean[s.length()+1][s.length()+1];   //dp[i][j]表示s从i-j的子串是否为单词

        for (int i = 0; i <= s.length(); i++){
            for (int j = i+1; j <= s.length(); j++){
                 if (wordDictSet.contains(s.substring(i, j)))
                     dp[i][j] = true;
                 else
                     dp[i][j] = false;
            }
        }

        List<List<Integer>> indexes = dfs(dp, 0, s);

        for (List<Integer> index : indexes){
            System.out.println(index);
        }

        List<String> sents = new ArrayList<>();


        return sents;
    }

    private List<List<Integer>> dfs(boolean[][] dp, int i, String s){

        List<List<Integer>> indexes = new ArrayList<>();
        for (int j = i+1; j < s.length(); j++){
            if (dp[i][j]){

                List<List<Integer>> next_indexes = dfs(dp, j, s);
                for (List<Integer> next_index : next_indexes){
                    List<Integer> index = new ArrayList<>();

                    index.add(j);
                    index.addAll(next_index);

                    indexes.add(index);
                }

            }
        }

        return indexes;
    }

    public static void main(String[] args) {
        WordBreak2 wb2 = new WordBreak2();

        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("sand");
        wordDict.add("cat");
        wordDict.add("and");
        wordDict.add("dog");

        String str = "catsanddog";

        wb2.wordBreak(str, wordDict);
    }
}
