import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KurzaufgabeB1A1 {

    public static void main(String[] args) {
        printPermutations(KurzaufgabeB1A2.inputToArray(), 0);
    }

    public static int printPermutations(int[] array, int d) {
        // Überprüft ob man am Ende des Arrays angelangt ist
        // Gibt Permutation aus
        if (d == array.length - 1) {
            System.out.println(Arrays.toString(array));
            return 1;
        }

        int count = 0;
        for (int i = d; i < array.length; i++) {
            // Tauscht die Elemente an den Positionen d und i
            int temp = array[d];
            array[d] = array[i];
            array[i] = temp;

            count += printPermutations(array, d + 1);
            // Setzt das Array zurück in den ursprünglichen Zustand
            temp = array[d];
            array[d] = array[i];
            array[i] = temp;
        }

        return count;
    }
}
