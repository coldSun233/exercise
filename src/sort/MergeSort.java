package sort;

/**
 * @author coldsun
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{4, 2, 7, 1, 8, 3, 8, 3, 0, 9};
        mergeSort(a, 0, a.length-1, new int[a.length]);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] a, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(a, start, mid, temp);
        mergeSort(a, mid + 1, end, temp);
        mergeArray(a, start, mid, end, temp);
    }

    public static void mergeArray(int[] a, int start, int middle, int end, int[] temp) {
        int i = start;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= end) {
            if (a[i] < a[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            temp[k++] = a[i++];
        }
        while (j <= end) {
            temp[k++] = a[j++];
        }

        for (int ii = 0; ii < k; ii++) {
            a[start + ii] = temp[ii];
        }
    }
}
