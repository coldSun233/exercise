package middle;

import java.util.*;

/**
 * 第15题 三数之和
 */
public class ThreeSum {
    public static List<List<Integer>> soultion(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] <=0 && nums[nums.length-1] >= 0) {
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                int h = i + 1;
                int t = nums.length - 1;
                while (h < t) {
                    int sum = nums[i] + nums[h] + nums[t];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[h], nums[t]));
                        h++; t--;
                        while (h < t && nums[h] == nums[h-1]) {
                            h++;
                        }
                        while (h < t && nums[t] == nums[t+1]) {
                            t--;
                        }
                    } else if (sum < 0) {
                        h++;
                        //while (h < t && nums[h] == nums[h-1]) {
                        //    h++;
                        //}
                    } else {
                        t--;
                        //while (h < t && nums[t] == nums[t+1]) {
                        //    t--;
                        //}
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(soultion(nums));
    }
}
