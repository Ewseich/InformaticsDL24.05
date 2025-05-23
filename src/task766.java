import java.util.Scanner;
public class task766 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        mergeSort(a, 0, n - 1);
        for (int l = 0; l < a.length; l++) System.out.print(a[l] + " ");
    }

    private static void mergeSort (int[] a, int l, int r) {
        if (l < r) {
            int c = (l + r) / 2;
            mergeSort(a, l, c);
            mergeSort(a, c + 1, r);
            merge(a, l, c, r);
        }
    }

    private static void merge(int [] arr, int l, int c, int r){
        int n = c - l + 1;
        int m = r - c;
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for (int i = 0; i < n; i++) {
            arr1[i] = arr[l + i];
        }
        for (int j = 0; j < m; j++) {
            arr2[j] = arr[c + 1 + j];
        }

        int iA = 0, iB = 0, iC = l;


        while (iA < n && iB < m) {
            if (arr1[iA] < arr2[iB]) arr[iC++] = arr1[iA++];
            else arr[iC++] = arr2[iB++];
        }

        for (int i = iA; i < n; i++) arr[iC++] = arr1[i];
        for (int i = iB; i < m; i++) arr[iC++] = arr2[i];
    }
}