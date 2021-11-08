package sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 6, 1, 9, 0};
        minHeapSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void minHeapSort(int[] nums) {
        buildMinHeap(nums);
        int size = nums.length;
        for (int i = size - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapAdjust(nums, 0, i);
        }
    }

    public static void buildMinHeap(int[] nums) {
        int size = nums.length;
        for (int i = (size - 1) / 2; i >= 0; i--) {
            heapAdjust(nums, i, size);
        }
    }

    //public static void heapAdjust(int[] nums, int root, int size) {
    //    int i = root * 2 + 1;
    //    if (i >= size) {
    //        return;
    //    }
    //    if (i < (size - 1) && nums[i] > nums[i+1]) {
    //        i++;
    //    }
    //    if (nums[i] < nums[root]) {
    //        swap(nums, root, i);
    //        heapAdjust(nums, i, size);
    //    }
    //}

    public static void heapAdjust(int[] nums, int root, int size) {
        int temp = nums[root];
        int i = root * 2 + 1;
        while (i < size) {
            if (i + 1 < size && nums[i + 1] < nums[i]) {
                i++;
            }
            if (temp <= nums[i]) {
                break;
            }
            nums[root] = nums[i];
            root = i;
            i = 2 * root + 1;
        }
        nums[root] = temp;
    }

    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
