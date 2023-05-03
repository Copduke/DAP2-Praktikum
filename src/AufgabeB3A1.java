import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AufgabeB3A1 {

    public int subsetSize;

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Bitte geben sie nur einen Parameter als k an!");
        } else {
            AufgabeB3A1 test = null;
            try {
                test = new AufgabeB3A1(Integer.parseInt(args[0]));
            } catch (NumberFormatException e) {
                System.err.println("Expection");
            }

            int[] data = test.removeDuplicates(readStandardIn());

            if(data.length < test.subsetSize || test.subsetSize <= 0){
                System.err.println("k ist nicht zulässig!");
            } else {
                System.out.println("jio");
                int[][] result = test.createSubsets(data);
                for(int i = 0; i < result.length; i++){
                    System.out.println(Arrays.toString(result[i]));
                }
            }
        }
    }
    public static int[] readStandardIn() throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputData = new ArrayList<>();


        while(scanner.hasNext()){
            if(!scanner.hasNextInt()){
                //System.err.println("Not an int in input!");
                throw new NumberFormatException("Not an int as an input");
            } else {
                inputData.add(scanner.nextInt());
            }
        }

        scanner.close();

        int[] data = new int[inputData.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = inputData.get(i);
        }

        return data;
    }

    public AufgabeB3A1(int subsetSize){
        this.subsetSize = subsetSize;
    }

    public int[][] createSubsets(int[] data){
        int bin = (int) (factorial(data.length)/(factorial(subsetSize)*factorial(data.length-subsetSize)));
        int[][] result = new int[bin][subsetSize];
        int count = 0;
        int move = 0;
        int[] var = new int[subsetSize];

        for (int i = 0; i < subsetSize; i++) {
            var[i] = i;
        }

        while (var[0] < data.length-subsetSize) {

            for(int i = 0; i < var.length; i++){
                result[count][i] = data[var[i]];
            }

            if (var[var.length - 1] < data.length - 1) {
                var[var.length - 1]++;
            } else {
                for (int i = var.length - 1; i > 0; i--) {
                    if (var[i] - var[i - 1] < 2) {
                        move++;
                    } else {
                        break;
                    }
                }

                var[var.length - 2 - move]++;
                for (int i = 0; i <= move; i++) {
                    var[var.length - 1 - move + i] = var[var.length - 2 - move] + i + 1;
                }
                move = 0;

            }
            count++;
        }
        for(int i = 0; i < var.length; i++){
            result[count][i] = data[var[i]];
        }
        System.out.println(bin);
        return result;
    }

    public double factorial(int length){
        double faq = 1;
        for(double i = 1; i <= length; i++){
            faq *= i;
        }
        return faq;
    }

    public int[] removeDuplicates(int[] data){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            if(!list.contains(data[i])){
                list.add(data[i]);
            }
        }
        int[] newdata = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            newdata[i] = list.get(i);
        }

        return newdata;
    }
}