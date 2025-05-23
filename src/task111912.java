import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
class task111912 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) arr2[i] = sc.nextInt();
        arrOut(merge(arr1, arr2, n, m));
    }
    private static int[] merge(int [] arr1, int[] arr2, int n, int m){
        int iA = 0, iB = 0, iC = 0;
        int[] res = new int[n+m];
        while (iA < n && iB < m) {
            if (arr1[iA] < arr2[iB]) res[iC++] = arr1[iA++];
            else res[iC++] = arr2[iB++];
        }
        for (int i = iA; i < n; i++) res[iC++] = arr1[i];
        for (int i = iB; i < m; i++) res[iC++] = arr2[i];
        return res;
    }

    private static void arrOut(int[] A) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("output.txt"));
        for (int i = 0; i < A.length; i++) {
            out.print(A[i] + " ");
        }
        out.close();
    }
}