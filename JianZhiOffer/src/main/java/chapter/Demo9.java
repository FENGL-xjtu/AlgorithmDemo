package chapter;

/**
 * @Author: Fengl
 * @Date: 2021/10/25-10-25-下午10:34
 * @Description: chapter
 * @version: 1.0
 */
public class Demo9 {
    /**
     * 给定无序的正整数数组nums,正整数k, 找出一共有多少个这样的子数组,要求所有元素的乘积小于k
     * 思路:类似于子数组元素和大于等于k(Demo8)
     * 双指针 left, right
     * 如果积小于k,就向右移动right, 并计数([left,right]符合,那么[left-1,right],[left-2,right]...都符合,一共有right-left+1个)
     * 如果
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k && left <= right) {
                product /= nums[left++];
            }
            if (left <= right) {
                count += (right - left + 1);//[left,right]符合,那么[left-1,right],[left-2,right]...都符合,一共有right-left+1个
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(new Demo9().numSubarrayProductLessThanK(nums, k));
    }
}
