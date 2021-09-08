package Summary_of_Interview_Problem.graph;

import java.util.*;

/**
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的最短转换序列中的单词数目 。如果不存在这样的转换序列，返回 0。
 *
 * 示例 1：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 *
 * 示例 2：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 */
public class LadderLength {
    // 建立词语和id的映射
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    // 构建图（树）状结构
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    // 节点数量
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }

        // 记录起始方向已访问的词语所在路径的长度
        int[] disBegin = new int[nodeNum];
        Arrays.fill(disBegin, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord);
        disBegin[beginId] = 0;

        // 存储起始词语的id
        Queue<Integer> queBegin = new LinkedList<Integer>();
        queBegin.offer(beginId);

        // 记录末尾方向已访问的词语所在路径的长度
        int[] disEnd = new int[nodeNum];
        Arrays.fill(disEnd, Integer.MAX_VALUE);
        int endId = wordId.get(endWord);
        disEnd[endId] = 0;

        // 存储末尾词语的id
        Queue<Integer> queEnd = new LinkedList<Integer>();
        queEnd.offer(endId);

        // 双向广度优先遍历
        while (!queBegin.isEmpty() && !queEnd.isEmpty()) {

            // 起始方向访问
            int queBeginSize = queBegin.size();
            for (int i = 0; i < queBeginSize; ++i) {
                int nodeBegin = queBegin.poll();

                // 末尾方向上已经访问过该词语
                if (disEnd[nodeBegin] != Integer.MAX_VALUE) {
                    return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1;
                }

                // 下一个词在当前词的路径长度上+1
                for (int it : edge.get(nodeBegin)) {
                    if (disBegin[it] == Integer.MAX_VALUE) {
                        disBegin[it] = disBegin[nodeBegin] + 1;
                        queBegin.offer(it);
                    }
                }
            }

            // 末尾方向访问
            int queEndSize = queEnd.size();
            for (int i = 0; i < queEndSize; ++i) {
                int nodeEnd = queEnd.poll();

                // 起始方向已经访问过该词语
                if (disBegin[nodeEnd] != Integer.MAX_VALUE) {
                    return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1;
                }

                // 下一个词在当前词的路径长度上+1
                for (int it : edge.get(nodeEnd)) {
                    if (disEnd[it] == Integer.MAX_VALUE) {
                        disEnd[it] = disEnd[nodeEnd] + 1;
                        queEnd.offer(it);
                    }
                }
            }
        }
        return 0;
    }

    // 添加一个词语及其只有一个字符不同的词的相关关系
    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;

        // 将词语每个字符依次变化为*，并添加到edge中，建立联系
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    // 添加词语
    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }


    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();

        String beginWord = "lost";
        String endWord = "miss";
        List wordList = new LinkedList();
        String[] words = {"most", "mist", "miss", "lost", "fist", "fish"};
        for (String word:words){
            wordList.add(word);
        }

        int path = ladderLength.ladderLength(beginWord, endWord, wordList);
        System.out.print(path);
    }
}
