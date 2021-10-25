package chaper1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Fengl
 * @Date: 2021/10/25-10-25-下午8:29
 * @Description: chaper1
 * @version: 1.0
 */
public class Demo5 {
    /**
     * 给定一个字符串数组,找出两个字符串,要求这两个字符串中各自包含的字符的集合不相交,返回两个字符串长度乘积的最大值
     * @param words
     * @return 返回两个字符串长度乘积的最大值
     * 思路: 给每个字符串维护一个flag数组,flag每一位记录一个字母是否出现过, 例如:flag[0]记录字符'a'是否出现过
     */
    public int maxProduct(String[] words) {
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int temp = words[i].charAt(j) - 'a';
                flags[i][temp] = true;
            }
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                int k;
                for (k = 0; k < 26; k++) {
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }
                if (k == 26) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;

    }

    /**
     * @param words
     * @return
     * 思路: 一个int值为32位,而字母只有26种,所以可以用一个int整数的0-25位去记录每个字母是否出现过
     */
    public int maxProduct2(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                int temp = c - 'a';   // 用int的第temp位记录出现过的字母
                flags[i] |= (1 << temp);  // 出现过,则为1
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((flags[i] & flags[j]) == 0) {  // 按位与,如果某一位上都为1,则&运算后该位就是1,表示都出现过
                    //如果&运算后所有位都是0,则表示两个字符串没有相同的字符
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "foo", "bar", "fxyz", "abcdef"};
        System.out.println(new Demo5().maxProduct(words));
        System.out.println(new Demo5().maxProduct2(words));
    }
}
