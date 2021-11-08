package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 5, 7, 7, 4, 2, 1, 3, 2, 9, 10};
        int[] pos = partition3(nums, 0, nums.length - 1);
    }
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pos = partition(nums, left, right);
        quickSort(nums,left, pos - 1);
        quickSort(nums, pos + 1, right);
    }

    /**三分法
     * 主元(X)+左指针(p1)+右指针(p2)+“等于”指针(e)
     * 这里p1是扫描指针，[left + 1, e)的元素都小于pivot，
     * [e, p1]元素都等于pivot，(p2, right]的元素都大于pivot
     * e和p1初始值为left+1，p2初始值为right
     * 从左往右，若p1所指元素 < X，则p1与e的元素进行交换，均右移；
     * 若p1所指元素 = X，则p1右移；
     * 若p1所指元素 > X，则p1与p2的元素交换，p2左移，p1不动。
     * 边界：当p1 > p2时，e左移，X与e的元素交换。
     */
    private static int[] partition3(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int e = left + 1;
        int j = right;
        while (i <= j) {
            if (nums[i] == pivot) {
                i++;
            } else if (nums[i] < pivot) {
                swap(nums, e, i);
                e++;
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, left, --e);
        return new int[]{e, j};
    }


    /** 双向扫描
     * 选取一个关键字(key)作为枢轴，一般取整组记录的第一个数/最后一个
     * 设置两个变量i = 0;j = N - 1;
     * 从i一直向后走，直到找到一个大于key的值，j从后至前，直至找到一个小于key的值，然后交换这两个数。
     * 重复第三步，一直往后找，直到i和j相遇，这时将key放置i的位置即可。
     */
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (i < j) {
            // 从左向右找到第一个大于pivot的数
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            // 从右向左找到第一个小于等于pivot的数
            while (i < j && nums[j] > pivot) {
                j--;
            }
            // 交换i和j，也可以不判断i<j
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, left, i);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}

