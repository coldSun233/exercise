package sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 1, 6, 3, 7, 9, 10, 5};
        shellSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void shellSort(int[] nums) {
        int j;
        int temp;
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                temp = nums[i];
                for (j = i; j >= gap && temp < nums[j - gap]; j -= gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = temp;
            }
        }
    }
}
