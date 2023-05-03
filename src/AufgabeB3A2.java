import java.util.Arrays;

public class AufgabeB3A2 {

    private int[] data;

    public AufgabeB3A2(int[] data) {
        this.data = data;
    }

    public int[] choosePermutation(int kSmallest) {

        int n = data.length;
        int[] perm = new int[n];

        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }

        for (int j = 1; j < kSmallest; j++) {
            int i = n - 2;
            while (i >= 0 && perm[i] >= perm[i + 1]) {
                i--;
            }
            if (i < 0) {
                break;
            }
            int k = n - 1;
            while (perm[i] >= perm[k]) {
                k--;
            }
            swap(perm, i, k);
            reverse(perm, i + 1, n - 1);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = data[perm[i]];
        }

        return result;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void reverse(int[] a, int i, int j) {
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4 };
        AufgabeB3A2 obj = new AufgabeB3A2(data);
        System.out.println(Arrays.toString(obj.choosePermutation( 17)));
    }
}
