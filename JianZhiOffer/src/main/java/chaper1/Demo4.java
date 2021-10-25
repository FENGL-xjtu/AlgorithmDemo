package chaper1;

/**
 * @Author: Fengl
 * @Date: 2021/10/25-10-25-下午8:03
 * @Description: chaper1
 * @version: 1.0
 */
public class Demo4 {
    /**
     * 找出数组中只出现一次的数
     * @param nums  数组中有一个数只出现一次,其余数都出现三次
     * @return 找出这个数
     * 思路: 将所有数按位求和,出现三次的数,每一位的和对3取余,结果都是出现一次的数的对应位的值
     */
    public int singleNumber(int[] nums) {
        int[] bitSums = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += bitSums[i] % 3;
        }
        return res;
    }

    /**
     * 数组中只有一个元素出现了m次,其余元素都出现了n次,且m不能被n整除
     * @param nums
     * @return 找出这个数
     */
    public int singleMNum(int[] nums, int n) {
        int[] bitSum = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSum[i] += (num >> (31 - i)) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += bitSum[i] % n;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 100};
        System.out.println(new Demo4().singleNumber(nums));
    }
}