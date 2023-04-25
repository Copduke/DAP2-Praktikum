import java.util.Arrays;

public class Quicksort {

    public static void main(String[] args) {
        int[] test = {5, 8, 1, 4, 4, 9, 2, 3};
        qsort(test);
    }

    // Aufgabe 1 //

    // a //
    public static int partition(int[] data, int l, int r) {
        while (l < r) {
            if(data[l] < data[l+1]){
                int temp = data[l+1];
                data[l+1] = data[r];
                data[r] = temp;
                r--;
            } else if(data[l] > data[l+1]){
                int temp = data[l+1];
                data[l+1] = data[l];
                data[l] = temp;
                l++;
            } else {
                l++;
            }
        }
        return l;
    }

    // b
    public static void qsort(int[] data, int l, int r){
        int pivot = partition(data, l, r);
        partition(data, l, pivot-1);
        partition(data, pivot+1, r);
        System.out.println(Arrays.toString(data));
    }

    // c
    public static void qsort(int[] data) {
        qsort(data, 0, data.length-1);
    }
}
