package modul3;

import java.util.Scanner;

public class uts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bonus;
        System.out.print("Masukkan gaji: ");int gaji = scanner.nextInt();
        if (gaji >= 70){
            System.out.print("Masukkan jam kerja: ");int jamkerja = scanner.nextInt();
            if (jamkerja >= 7) {
                bonus = gaji;
                System.out.println("bonus = " + bonus);
            }
        } else if (gaji < 60) {
            bonus = (int) (0.5 * gaji);
            gaji = gaji + bonus;
            System.out.println("bonus = "+gaji);
        } else {
            System.out.println();
        }
    }
}
