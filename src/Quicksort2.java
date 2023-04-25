import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Quicksort2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputData = new ArrayList<>();

        while (scanner.hasNextInt()) {
            inputData.add(scanner.nextInt());
        }

        scanner.close();

        int[] data = new int[inputData.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = inputData.get(i);
        }

        if (data.length < 20) {
            System.out.println("Input: " + Arrays.toString(data));
        }

        qSort(data);

        //partition(data, 0, data.length-1);

        System.out.println("Output: " + Arrays.toString(data));

        int min = data[data.length - 1];
        int max = data[0];
        double median = data.length % 2 == 0 ? (data[data.length / 2] + data[data.length / 2 - 1]) / 2.0 : data[data.length / 2];

        System.out.println("Min: " + min + ", Med: " + median + ", Max: " + max);
    }
    // Aufgabe 2 //

    public static int[] partition(int[] data, int l, int r) {
        int m = r-1;

        if (data[l] < data[r]) {
            int temp = data[l];
            data[l] = data[r];
            data[r] = temp;
        }

        while (l < r && l < m) {
            if (data[r] >= data[l+1]) {
                int temp = data[l+1];
                data[l+1] = data[m];
                data[m] = temp;

                int temp2 = data[m];
                data[m] = data[r-1];
                data[r-1] = temp2;

                int temp3 = data[r];
                data[r] = data[r-1];
                data[r-1] = temp3;
                r--;
                m--;

            } else if (data[l] > data[l+1] && data[r] < data[l+1]){
                int temp = data[m];
                data[m] = data[l+1];
                data[l+1] = temp;
                m--;
            } else if (data[l] < data[l+1]) {
                int temp = data[l];
                data[l] = data[l+1];
                data[l+1] = temp;
                l++;
            } else {
                l++;
            }
        }

        int[] result = {l,r};
        return result;
    }

    // b
    public static void qSort(int[] data, int l, int r){
        if (l < r) {
            int pivot[] = partition(data, l, r);
            qSort(data, l, pivot[0] - 1);
            qSort(data, pivot[0] + 1, pivot[1]-1);
            qSort(data, pivot[1] + 1, r);
        }
    }

    // c
    public static void qSort(int[] data) {
        qSort(data, 0, data.length - 1);
    }
}
