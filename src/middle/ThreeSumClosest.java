package middle;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * 第16题 最接近三数之和
 */
public class ThreeSumClosest {
    public static int solution(int[] nums, int target) {
        Arrays.sort(nums);
        //if (nums.length < 3) {
        //    throw new Exception("数组元素过少");
        //}
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currrent = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - currrent) < Math.abs(target - ans)) {
                    ans = currrent;
                }
                if (currrent > target) {
                    right--;
                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if (currrent < target) {
                    left++;
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else {
                    return currrent;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(solution(nums, 1));
    }
}
