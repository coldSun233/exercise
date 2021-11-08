package sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 5, 1, 6};
        selectSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
}
