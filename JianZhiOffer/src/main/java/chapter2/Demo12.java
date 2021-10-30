package chapter2;

/**
 * @Author: Fengl
 * @Date: 2021/10/30-10-30-下午7:10
 * @Description: chapter2
 * @version: 1.0
 */
public class Demo12 {
    /**
     * 找出一个index,要求nums[0,index)的和,与nums[index+1,-1]的和相等.如果存在多种情况,输出最小的index
     * 思路:累加和
     * 先计算nums所有元素的总和,
     * 再依次遍历每个元素,逐个求累加和, 如果index以左的累加和等于index以右的累加和,就输出
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if ((sum - nums[i]) == (total - sum)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 2, 9};
        System.out.println(new Demo12().pivotIndex(nums));
    }
}
