package past.hash.hash_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 */
public class CommonRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }

        int minIndex =  list1.length + list2.length;
        for (int i = 0; i < list2.length; i++){
            if (map.containsKey(list2[i])){
                int index1 = map.get(list2[i]);
                int index = index1 + i;

                if (index < minIndex){
                    minIndex = index;
                    list.clear();
                    list.add(list2[i]);
                }else if (index == minIndex){
                    list.add(list2[i]);
                }
            }
        }

        return list.toArray(new String[0]);
    }
}
