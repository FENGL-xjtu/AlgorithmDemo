package chapter2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Fengl
 * @Date: 2021/10/25-10-25-下午9:30
 * @Description: chapter
 * @version: 1.0
 */
public class Demo7 {
    /**
     * Demo6中两数之和的升级版:
     * 在数组中找出三数之和为0的所有情况,不能有重复.
     * 思路:
     * (1)先把数组排序
     * (2)维护三个指针,i, left, right; i指向第一个数, left和right分别指向i右边的两个数
     * 确定i后, 就是一个两数之和为target的问题.
     * (3)i从左到右依次遍历num中的数
     * (4)添加结果时,注意去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            twoSum(nums, i, res);
            int temp = nums[i];
            while (i + 1 < nums.length && nums[i + 1] == temp) {
                i++; // 去重, 保证第一个数不重复
            }
        }
        return res;
    }

    public void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[i] + nums[left] + nums[right] == 0) {
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                int temp = nums[left];
                while (left < right && nums[left] == temp) {
                    left++; // 去重, 保证第二个数不重复
                }
            } else if (nums[i] + nums[left] + nums[right] < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List res = new Demo7().threeSum(nums);
        System.out.println(res);
    }
}
