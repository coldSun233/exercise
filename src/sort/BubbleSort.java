package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 1};
        bubbleSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }

    }

    public static void bubbleSort(int[] nums) {
        int temp;
        boolean flag;
        for (int i = 0; i < nums.length - 1; i++) {
            flag = false;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j- 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
}
