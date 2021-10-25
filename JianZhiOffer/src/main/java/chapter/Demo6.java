package chapter;

/**
 * @Author: Fengl
 * @Date: 2021/10/25-10-25-下午9:18
 * @Description: chapter
 * @version: 1.0
 */
public class Demo6 {
    /**
     * 给定一个有序数组, 一个目标值target, 在数组中找出两个数, 和等于target. 假设一定存在
     * @param nums
     * @param target
     * @return
     * 思路: 双指针法, 时间复杂度O(n),空间复杂度O(1)
     * 维护左指针,右指针, 如果左右指针指向的两数之和大于target,就说明我们要降低和的值,就把右指针左移;如果小于target,就把左指针右移
     */
    public int[] towSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        while (i < j && nums[i] + nums[j] != target) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            }
        }
        return new int[]{i, j};
    }
}
