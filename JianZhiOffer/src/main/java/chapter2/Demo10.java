package chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Fengl
 * @Date: 2021/10/25-10-25-下午11:11
 * @Description: chapter
 * @version: 1.0
 */
public class Demo10 {
    /**
     * 给定有正有负的数组, 一个目标值k, 找出符合要求的连续子数组个数, 要求为数组中元素和为k
     * 思路:
     * (1)不能用双指针, 因为数组值有负数, 右移right,不一定增加和,左移left不一定减小和
     * (2)可将[0,i]的和存起来, [i,j]的和 = [0,j]的和 - [0,i]的和
     * (3)用hashMap存储
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            int temp = sum - k;
            count += sumToCount.getOrDefault(temp, 0); //查找Map中是否有sum-k
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);//如果Map中有sum,就将值+1,如果没有,就存入1
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new Demo10().subarraySum(nums, k));
    }
}
