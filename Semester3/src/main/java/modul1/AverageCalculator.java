package modul1;

import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan daftar angka yang dipisahkan spasi: ");String input = scanner.nextLine();
        try {
            String[] numbersAsString = input.split(" ");
            double sum = 0;

            for (String numStr : numbersAsString){
                double num = Double.parseDouble(numStr);
                sum += num;
            }
            if (numbersAsString.length == 0){
                throw new ArithmeticException("Kesalahan aritmatika: Division by Zero");
            }
            double average = sum / numbersAsString.length;
            System.out.println("Rata-rata: " + average);
        } catch (NumberFormatException e){
            System.out.println("Kesalahan input: Masukkan angka yang valid");
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
