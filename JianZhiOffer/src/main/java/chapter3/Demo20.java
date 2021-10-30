package chapter3;

/**
 * @Author: Fengl
 * @Date: 2021/10/30-10-30-下午10:00
 * @Description: chapter3
 * @version: 1.0
 */
public class Demo20 {
    /**
     * 统计字符串s中的回文子串(连续)的个数
     * 回文有两种情况,奇数个或者偶数个字符,须分别考虑.
     * 思路:
     * 假设从第i个字符开始向左右扩张,
     * (1) start=i,end=i, 是回文,就继续向左右扩张,start--, end++, 直到超出界限
     * (2) start=i,end=i+1,
     * @param s
     * @return
     */
    public int countSubString(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);  //回文有两种形式,一种是中心只有一个字符(奇数个),一种是中心有两个字符(偶数个)
        }
        return count;
    }

    public int countPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        Demo20 d = new Demo20();
        System.out.println(d.countSubString("abc"));
        System.out.println(d.countSubString("aaa"));
    }
}
