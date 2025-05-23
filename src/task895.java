import java.util.Scanner;
public class task895 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][3];
        int[] v = new int[n];
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            int[] b = new int[3];
            for (int j = 0; j < 3; j++) {
                b[j] = sc.nextInt();
            }
            a[i] = b;
            v[i] = b[0] * b[1] * b[2];
            id[i] = i;
        }
        qSort(v, 0, n-1, id);
        for (int l=0; l < n; l++) {
            for (int k = 0; k < 3; k++) {
                System.out.print(a[id[l]][k] + " ");
            }
            System.out.println();
        }
    }
    private static void qSort(int[] a, int left, int right, int[] id) {
        if (left >= right);
        int i = left;
        int j = right;
        int c = a[(left + right)/2];
        while (i <= j) {
            while (a[i] < c) i++;
            while (a[j] > c) j--;
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                int tmp = id[i];
                id[i] = id[j];
                id[j] = tmp;
                i++;
                j--;
            }
        }
        if (left < j) qSort(a, left, j, id);
        if (i < right) qSort(a, i, right, id);
    }
}