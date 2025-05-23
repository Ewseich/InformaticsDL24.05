import java.util.Scanner;
public class task766quick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        qSort(a, 0, n-1);
        for (int l=0; l < a.length; l++) System.out.print(a[l] + " ");
    }
    private static void qSort(int[] a, int left, int right) {
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
                i++;
                j--;
            }
        }
        if (left < j) qSort(a, left, j);
        if (i < right) qSort(a, i, right);
    }
}
