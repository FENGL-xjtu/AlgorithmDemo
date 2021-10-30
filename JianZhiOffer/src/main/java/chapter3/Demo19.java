package chapter3;

/**
 * @Author: Fengl
 * @Date: 2021/10/30-10-30-下午9:47
 * @Description: chapter3
 * @version: 1.0
 */
public class Demo19 {
    /**
     * 给定字符串s,判断s是否是回文,或者删除一个字符后可构成回文
     * 思路: 判断是否是回文,在s[left]!=s[right]处跳出循环,
     * 再分别判断: (1) 删除左边一个字符,即left+1后,是不是回文
     *           (2) 删除右边一个字符,即right-1后,是不是回文
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                char l = Character.toLowerCase(s.charAt(left));
                char r = Character.toLowerCase(s.charAt(right));
                if (l != r) {
                    break;
                }
                left++;
                right--;
            }
        }
        return left >= right || isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (start < end) {
                char l = Character.toLowerCase(s.charAt(start));
                char r = Character.toLowerCase(s.charAt(end));
                if (l != r) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Demo19 d = new Demo19();
        System.out.println(d.validPalindrome("abca"));
        System.out.println(d.validPalindrome("abcad"));
    }
}
