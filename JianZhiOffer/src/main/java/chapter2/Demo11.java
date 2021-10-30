package chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Fengl
 * @Date: 2021/10/30-10-30-下午6:48
 * @Description: chapter2
 * @version: 1.0
 */
public class Demo11 {
    /**
     * 给定一个只包含0,1的数组,找出一个连续子数组,要求0,1出现的次数相同,求满足要求的子数组的最大长度
     * 思路: 累加和
     * 遍历数组,依次求累加和,如果当前累加和没出现过,就将sum和index存入map,如果出现过,就说明之前的index到现在的index之间的这段子数组的和为0,这段数组就是0,1个数相同的子数组
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1; // 把0当做-1处理,如果0和1出现的次数相同,则和为0
            if (sumToIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        System.out.println(new Demo11().findMaxLength(nums));
    }
}
