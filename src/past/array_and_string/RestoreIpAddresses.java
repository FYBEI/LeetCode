package past.array_and_string;

import java.util.*;

public class RestoreIpAddresses {

    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();

        List<String> tmp = new ArrayList<>();
        back(s, 0, tmp);

        return ans;
    }

    // 回溯函数
    private void back(String s, int start, List<String> tmp){

        // 遍历完所有数字，并且刚好组合成四位ip，则保存
        if (start == s.length() && tmp.size() == 4){
            ans.add(String.join(".", tmp));
            return;
        }

        // 没有遍历完，但是剩余数字数量太多，无法组成合法ip
        if (s.length()-start > (4 - tmp.size()) * 3) {
            return;
        }

        // sb记录一段ip，范围从start开始最多三位数字
        StringBuffer sb = new StringBuffer();
        int i = start;
        for (; i < start+3 && i < s.length(); i++){
            sb.append(s.charAt(i));

            // 如果满足ip规则，添加后继续下一段ip；不满足ip规则直接回溯
            if (isIP(sb.toString())){
                tmp.add(sb.toString());
                back(s, i+1, tmp);
                // 回溯
                tmp.remove(tmp.size()-1);
            }else {
                return;
            }
        }
    }

    // 判断一段ip是否合法
    private boolean isIP(String s) {
        // IP长度满足 1 至 3
        if (s.length() < 1 || s.length() > 3){
            return false;
        }
        // ip长度大于1时不可以0开头
        if (s.length() > 1 && s.startsWith("0")){
            return false;
        }

        int v = Integer.valueOf(s);

        // ip范围从 0 至 255
        if (0 > v || v > 255){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        RestoreIpAddresses ripA = new RestoreIpAddresses();

        String s = "101023";
        List<String> ans = ripA.restoreIpAddresses(s);

        System.out.println(ans);
    }
}
