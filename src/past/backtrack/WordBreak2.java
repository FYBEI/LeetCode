package past.backtrack;

import java.util.*;

public class WordBreak2 {
    List<String> result;
    int min;
    int max;

    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        min = Integer.MAX_VALUE;
        max = 0;

        Set<String> wordDictSet = new HashSet();
        for (String w : wordDict) {
            if (w.length() > max) {
                max = w.length();
            }
            if (w.length() < min) {
                min = w.length();
            }

            wordDictSet.add(w);
        }

        backTrack(s, wordDictSet, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(String s, Set<String> wordDictSet, int begin, List<String> arr) {
        if (begin == s.length()) {
            result.add(String.join(" ", arr));
            return;
        }

        for (int i = begin+min; i<= begin+max && i <= s.length(); i++) {

            if (wordDictSet.contains(s.substring(begin, i))) {
                arr.add(s.substring(begin, i));

                backTrack(s, wordDictSet, i, arr);
                arr.remove(arr.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        WordBreak2 wb2 = new WordBreak2();
        wb2.wordBreak(s, wordDict);
    }
}
