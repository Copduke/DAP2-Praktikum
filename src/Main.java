import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printPermutations(arr, 0);
    }

    public static int[] inputToArray() {
        ArrayList<Integer> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte drücken sie nach jeder Eingabe die ENTER-Taste." +
                "\nWenn sie fertig sind, drücken sie einen beliebigen Buchstaben.");

        // Überprüft ob nächter Input ein Integer ist
        // Wenn nicht schließt die Eingabe und das Programm fährt fort
        while (scanner.hasNextInt()) {
            input.add(scanner.nextInt());
        }

        // Umwandlung der ArrayList in ein Array
        int[] array = new int[input.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.get(i);
        }

        return array;
    }

    public static void kSmallest(int k) {
        // Überprüft ob k ein valider Wert ist
        if (k > 0) {
            int[] array = inputToArray();
            Arrays.sort(array);

            // Fängt ArrayIndexOutOfBoundsException ab falls vorhanden
            try {
                System.out.println("Der " + k + "-kleinste Wert des Arrays ist " + array[k-1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Das Argument 'k' darf nicht größer als die Länge des Arrays sein!");
            }

        } else {
            System.err.println("Das Argument 'k' muss größer 0 sein!");
        }
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
