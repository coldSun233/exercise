package middle;

import java.util.*;

/**
 * 第18题 四数之和
 */
public class FourSum {
    public static List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (nums == null || length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int m = 0; m < length - 3; m++) {
            if (m > 0 && nums[m] == nums[m-1]) {
                continue;
            }
            // 获取当前最小值与target比较，如果大于target则往后越来越大，所以break
            if (nums[m] + nums[m + 1] + nums[m + 2] + nums[m + 3] > target) {
                break;
            }
            // 获取当前的最大值，如果小于target则需要增大m的值，所以continue
            if (nums[m] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }

            // 第二层循环n, 初始值为m+1
            for (int n = m + 1; n < length - 2; n++) {
                if (n > m + 1 && nums[n] == nums[n - 1]) {
                    continue;
                }
                // 获取当前最小值与target比较，如果大于target则往后越来越大，所以break
                if (nums[m] + nums[n] + nums[n + 1] + nums[n + 2] > target) {
                    break;
                }
                // 获取当前的最大值，如果小于target则需要增大n的值，所以continue
                if (nums[m] + nums[n] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }

                int i = n + 1;
                int j = length - 1;
                while (i < j) {
                    int current = nums[m] + nums[n] + nums[i] + nums[j];
                    if (current > target) {
                        j--;
                    } else if (current < target) {
                        i++;
                    } else {
                        result.add(Arrays.asList(nums[m], nums[n], nums[i], nums[j]));
                        while (i < j && nums[i] == nums[i + 1]) {
                            i++;
                        }
                        while (i < j && nums[j] == nums[j - 1]) {
                            j--;
                        }
                        i++;
                        j--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(solution(nums, target));
    }
}
