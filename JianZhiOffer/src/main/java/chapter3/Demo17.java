package chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Fengl
 * @Date: 2021/10/30-10-30-下午8:45
 * @Description: chapter3
 * @version: 1.0
 */
public class Demo17 {
    /**
     * 给定两个字符串,s,t,求s中包含t所有字符的最短子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> charToCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            charToCount.put(c, charToCount.getOrDefault(c, 0) + 1);
        }
        int match = charToCount.size();

        int left = 0, right = 0;
        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE;
        while ((right < s.length()) || (right == s.length() && match == 0)) {
            if (match > 0) {
                char temp = s.charAt(right);
                if (charToCount.containsKey(temp)) {
                    charToCount.put(temp, charToCount.get(temp) - 1);
                    if (charToCount.get(temp) == 0) {
                        match--;
                    }
                }
                right++;
            } else {
                if (right - left < minLength) {
                    start = left;
                    end = right;
                    minLength = right - left;
                }
                char temp = s.charAt(left);
                if (charToCount.containsKey(temp)) {
                    charToCount.put(temp, charToCount.get(temp) + 1);
                    if (charToCount.get(temp) == 1) {
                        match++;
                    }
                }
                left++;
            }
        }
        return minLength != Integer.MAX_VALUE ? s.substring(start, end) : "";
    }

    public static void main(String[] args) {
        Demo17 d = new Demo17();
        System.out.println(d.minWindow("ADDBABCAD", "ABC"));
    }
}
