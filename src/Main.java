import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();

        long[] C = new long[x + 2]; // Массив для хранения элементов C (с запасом)
        int aIndex = 1; // Индекс для последовательности A (i^2)
        int bIndex = 1; // Индекс для последовательности B (i^3)
        int cIndex = 1; // Индекс для объединенной последовательности C

        while (cIndex <= x) {
            long aValue = (long) aIndex * aIndex;
            long bValue = (long) bIndex * bIndex * bIndex;

            if (aValue < bValue) {
                if (cIndex == 1 || aValue != C[cIndex - 1]) {
                    C[cIndex] = aValue;
                    cIndex++;
                }
                aIndex++;
            } else if (aValue > bValue) {
                if (cIndex == 1 || bValue != C[cIndex - 1]) {
                    C[cIndex] = bValue;
                    cIndex++;
                }
                bIndex++;
            } else {
                // Если aValue == bValue, добавляем один раз
                if (cIndex == 1 || aValue != C[cIndex - 1]) {
                    C[cIndex] = aValue;
                    cIndex++;
                }
                aIndex++;
                bIndex++;
            }
        }

        System.out.println(C[x]);
    }
}