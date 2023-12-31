package modul4;
import java.util.Scanner;
import java.util.Random;

public class RandomDataGenerator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("Menu:");
                System.out.println("1. Random Angka");
                System.out.println("2. Random String");
                System.out.println("3. Keluar");
                System.out.print("Pilih opsi (1/2/3): ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        generateRandomNumber(scanner);
                        break;
                    case 2:
                        generateRandomString(scanner);
                        break;
                    case 3:
                        System.out.println("Terima kasih, program berakhir.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
                }

            } while (choice != 3);

            scanner.close();
        }

        private static void generateRandomNumber(Scanner scanner) {
            System.out.print("Masukkan batas bawah angka acak: ");
            int lowerBound = scanner.nextInt();
            System.out.print("Masukkan batas atas angka acak: ");
            int upperBound = scanner.nextInt();

            Random random = new Random();
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

            System.out.println("Angka acak: " + randomNumber + "\n");
        }

        private static void generateRandomString(Scanner scanner) {
            System.out.print("Masukkan panjang string acak: ");
            int length = scanner.nextInt();

            StringBuilder randomString = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < length; i++) {
                char randomChar = (char) (random.nextInt(62) + '0');
                if (randomChar > '9' && randomChar < 'A') {
                    randomChar += 7;
                }
                randomString.append(randomChar);
            }

            System.out.println("String acak: " + randomString.toString() + "\n");
        }

}
