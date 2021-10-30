package chapter3;

/**
 * @Author: Fengl
 * @Date: 2021/10/30-10-30-下午7:49
 * @Description: chapter3
 * @version: 1.0
 */
public class Demo14 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)-'a']--;
            count[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Demo14 d = new Demo14();
        System.out.println(d.checkInclusion("ac", "dgcaf"));
        System.out.println(d.checkInclusion("ab", "dgcaf"));
    }
}
