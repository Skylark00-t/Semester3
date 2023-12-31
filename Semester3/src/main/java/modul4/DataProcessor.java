package modul4;
import java.util.Scanner;
import java.util.Arrays;
public class DataProcessor {
        public static void main(String[] args) {
            int[] data = {38, -15, 72, 0, -42, 19, -63, 50, 27, -84, 61, 5};

            Arrays.sort(data);

            System.out.println("Data yang sudah diurutkan:");
            for (int value : data) {
                System.out.print(value + "    ");
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("\nMasukkan nilai yang ingin dicari indexnya: ");
            int searchValue = scanner.nextInt();

            int index = Arrays.binarySearch(data, searchValue);

            if (index >= 0) {
                System.out.println("Nilai ditemukan di index : " + index);
            } else {
                System.out.println("Nilai tidak ditemukan dalam data.");
            }

            int positiveCount = 0, negativeCount = 0, zeroCount = 0;

            for (int value : data) {
                if (value > 0) {
                    positiveCount++;
                } else if (value < 0) {
                    negativeCount++;
                } else {
                    zeroCount++;
                }
            }

            System.out.println("Jumlah elemen dengan nilai positif: " + positiveCount);
            System.out.println("Jumlah elemen dengan nilai negatif: " + negativeCount);
            System.out.println("Jumlah elemen dengan nilai nol: " + zeroCount);

            scanner.close();
        }
}
