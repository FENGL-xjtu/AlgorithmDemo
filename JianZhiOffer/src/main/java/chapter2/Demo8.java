package chapter2;

/**
 * @Author: Fengl
 * @Date: 2021/10/25-10-25-下午10:15
 * @Description: chapter
 * @version: 1.0
 */
public class Demo8 {
    /**
     * 给定一个正整数k,一个无序正整数组nums, 求出和大于等于k的连续子数组的最短长度
     * 思路: 双指针 left, right
     * 初始位置: left和right都指向索引0
     * 如果[left,right]子数组和小于k,就将right向右移动,加长子数组
     * 如果大于等于k,就将left向右移动,缩短子数组
     * @param k
     * @param nums
     * @return
     */
    public int minSubArrayLen(int k, int[] nums) {
        int left = 0, right = 0;
        int sum = -k;
        int minLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= 0 && left <= right) {
                minLength = Math.min(minLength, right - left + 1);
                if (left == right) {
                    break;
                }
                sum -= nums[left++];  // 缩短子数组
            }
            right++; // 加长子数组
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 4, 3};
        System.out.println(new Demo8().minSubArrayLen(7, nums));
    }

}
