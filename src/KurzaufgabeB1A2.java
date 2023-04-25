import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KurzaufgabeB1A2 {

    public static void main(String[] args) {
        //Scanner parameter = new Scanner(System.in);
        kSmallest(/*parameter.nextInt()*/ 3);

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
}
