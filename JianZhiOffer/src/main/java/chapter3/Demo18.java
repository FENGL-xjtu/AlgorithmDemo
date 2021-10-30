package chapter3;

/**
 * @Author: Fengl
 * @Date: 2021/10/30-10-30-下午9:39
 * @Description: chapter3
 * @version: 1.0
 */
public class Demo18 {
    /**
     * 判断字符串是否是回文
     * 思路: 双指针
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
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
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Demo18 d = new Demo18();
        System.out.println(d.isPalindrome("Was it a cat I saw?"));
        System.out.println(d.isPalindrome("Was a it a cat I saw?"));
    }
}
