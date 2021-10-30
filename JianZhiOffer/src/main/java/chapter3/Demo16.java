package chapter3;

/**
 * @Author: Fengl
 * @Date: 2021/10/30-10-30-下午8:25
 * @Description: chapter3
 * @version: 1.0
 */
public class Demo16 {
    /**
     * 给定一个字符串,求不含重复字符的子串的最大长度
     * 思路: 双指针 left,right, 维护一个int[256],记录对应字符出现的次数
     * 初始位置均指向第一个字符,如果int[256]中存在大于1的数,说明某个字符出现了1次以上,有重复,那么left++,如果都不大于1,说明没有重复,right++
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        int left = 0, right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            counts[s.charAt(right)]++;
            while (hasGreaterThan1(counts)) {
                --counts[s.charAt(left++)];
            }
            right++;
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    /**
     * 上述lengthOfLongestSubstring方法中,需要多次遍历counts数组,效率较低
     * 改进: 出现重复的情况,都是在right处发生,所以只要监控counts[s.charAt(right)]>1即可
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        int left = 0, right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            counts[s.charAt(right)]++;
            while (counts[s.charAt(right)]>1) {
                --counts[s.charAt(left++)];
            }
            right++;
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }


    public boolean hasGreaterThan1(int[] counts) {
        for (int count : counts) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Demo16 d = new Demo16();
        System.out.println(d.lengthOfLongestSubstring("babcca"));
        System.out.println(d.lengthOfLongestSubstring2("babcca"));
    }
}
