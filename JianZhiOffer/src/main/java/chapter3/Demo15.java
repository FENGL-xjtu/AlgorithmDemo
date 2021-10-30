package chapter3;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Fengl
 * @Date: 2021/10/30-10-30-下午8:09
 * @Description: chapter3
 * @version: 1.0
 */
public class Demo15 {
    public List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> indices = new LinkedList<>();
        if (s1.length() < s2.length()) {
            return indices;
        }
        int[] counts = new int[26];
        int i;
        for (i = 0; i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']++;
            counts[s1.charAt(i) - 'a']--;
        }
        if (areAllZero(counts)) {
            indices.add(0);
        }
        for (int j=0; i < s1.length(); i++, j++) {
            counts[s1.charAt(i) - 'a']--;
            counts[s1.charAt(j) - 'a']++;
            if (areAllZero(counts)) {
                indices.add(j+1);
            }
        }
        return indices;
    }

    public boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Demo15 d = new Demo15();
        System.out.println(d.findAnagrams("cbadabacg","abc"));
    }
}
