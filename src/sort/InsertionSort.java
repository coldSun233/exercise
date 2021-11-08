package sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 7, 1, 0};
        insertionSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    //public static void insertionSort(int[] nums) {
    //    int temp;
    //    for (int i = 0; i < nums.length - 1; i++) {
    //        for (int j = i + 1; j > 0; j--) {
    //            if (nums[j] < nums[j - 1]) {
    //                temp = nums[j];
    //                nums[j] = nums[j - 1];
    //                nums[j - 1] = temp;
    //             } else {
    //                break;
    //            }
    //        }
    //    }
    //}
    public static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            int temp = nums[j];
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }
}
