import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] test = { 23, 22, 21, 8, 7, 6, 5 };
        System.out.print(Arrays.toString(mSort(test, 0, test.length - 1)));
    }

    public static int[] merge(int[] data, int l, int r, int m) {

        if (l >= r || data[0] > data[m + 1]) {
            return data;
        } else {
            int[] left = new int[m - l + 1];
            int[] right = new int[r - m];

            for (int i = 0; i < left.length; i++) {
                left[i] = data[l + i];
            }
            for (int i = 0; i < right.length; i++) {
                right[i] = data[m + 1 + i];
            }

            int i = 0;
            int j = 0;
            int k = l;

            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    data[k++] = left[i++];
                } else {
                    data[k++] = right[j++];
                }
            }

            while (i < left.length) {
                data[k++] = left[i++];
            }

            while (j < right.length) {
                data[k++] = right[j++];
            }

            return data;
        }
    }

    public static int[] mSort(int[] data, int l, int r) {

        if (l < r) {
            
        }

        return data;
    }
}
