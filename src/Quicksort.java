import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Quicksort {

    // 1d
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

        System.out.println("Output: " + Arrays.toString(data));

        int min = data[data.length - 1];
        int max = data[0];
        double median = data.length % 2 == 0 ? (data[data.length / 2] + data[data.length / 2 - 1]) / 2.0 : data[data.length / 2];

        System.out.println("Min: " + min + ", Med: " + median + ", Max: " + max);
    }

    // Aufgabe 1 //

    // a //
    public static int partition(int[] data, int l, int r) {
        while (l < r) {
            if(data[l] > data[l+1]){
                int temp = data[l+1];
                data[l+1] = data[r];
                data[r] = temp;
                r--;
            } else if(data[l] < data[l+1]){
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
    public static void qSort(int[] data, int l, int r){
        if (l < r) {
            int pivot = partition(data, l, r);
            qSort(data, l, pivot - 1);
            qSort(data, pivot + 1, r);
        }
    }

    // c
    public static void qSort(int[] data) {
        qSort(data, 0, data.length - 1);
    }
}
