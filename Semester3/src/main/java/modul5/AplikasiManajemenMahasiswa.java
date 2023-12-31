package modul5;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

    class DataMahasiswa {
    String nama;
    String nim;
    String mataKuliah;
    int semester;

    public DataMahasiswa(String nama, String nim, String mataKuliah, int semester) {
        this.nama = nama;
        this.nim = nim;
        this.mataKuliah = mataKuliah;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + "\nNIM: " + nim + "\nMata Kuliah: " + mataKuliah + "\nSemester: " + semester + "\n";
    }
}

public class AplikasiManajemenMahasiswa {
    private static final String FILE_PATH = "data_mahasiswa2.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<DataMahasiswa> mahasiswaList = new ArrayList<>();

        while (true) {
            System.out.println("=====APLIKASI KELOLA DATA MAHASISWA=====");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.println("5. Search Data");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (menu) {
                case 1:
                    tambahData(mahasiswaList);
                    break;
                case 2:
                    tampilkanData(mahasiswaList);
                    break;
                case 3:
                    updateData(mahasiswaList);
                    break;
                case 4:
                    deleteData(mahasiswaList);
                    break;
                case 5:
                    searchData(mahasiswaList);
                    break;
                case 6:
                    simpanKeFile(mahasiswaList);
                    System.out.println("Keluar dari aplikasi.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tambahData(ArrayList<DataMahasiswa> mahasiswaList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Mata Kuliah: ");
        String mataKuliah = scanner.nextLine();
        System.out.print("Masukkan Semester: ");
        int semester = scanner.nextInt();

        DataMahasiswa mahasiswa = new DataMahasiswa(nama, nim, mataKuliah, semester);
        mahasiswaList.add(mahasiswa);

        System.out.println("Data mahasiswa berhasil ditambahkan.\n");
    }

    private static void tampilkanData(ArrayList<DataMahasiswa> mahasiswaList) {
        int counter = 1;
        for (DataMahasiswa mahasiswa : mahasiswaList) {
            System.out.println("Menampilkan Data ke-" + counter + ":");
            System.out.println(mahasiswa);
            counter++;
        }
    }

    private static void updateData(ArrayList<DataMahasiswa> mahasiswaList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NIM dari data yang ingin diubah: ");
        String nimToUpdate = scanner.nextLine();

        for (DataMahasiswa mahasiswa : mahasiswaList) {
            if (mahasiswa.nim.equals(nimToUpdate)) {
                System.out.print("Masukkan Nama Baru: ");
                mahasiswa.nama = scanner.nextLine();
                System.out.print("Masukkan NIM Baru: ");
                mahasiswa.nim = scanner.nextLine();
                System.out.print("Masukkan Mata Kuliah Baru: ");
                mahasiswa.mataKuliah = scanner.nextLine();
                System.out.print("Masukkan Semester Baru: ");
                mahasiswa.semester = scanner.nextInt();

                System.out.println("Data berhasil diupdate.\n");
                return;
            }
        }

        System.out.println("Data dengan NIM " + nimToUpdate + " tidak ditemukan.\n");
    }

    private static void deleteData(ArrayList<DataMahasiswa> mahasiswaList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NIM data yang ingin dihapus: ");
        String nimToDelete = scanner.nextLine();

        for (DataMahasiswa mahasiswa : mahasiswaList) {
            if (mahasiswa.nim.equals(nimToDelete)) {
                mahasiswaList.remove(mahasiswa);
                System.out.println("Data berhasil dihapus.\n");
                return;
            }
        }

        System.out.println("Data dengan NIM " + nimToDelete + " tidak ditemukan.\n");
    }

    private static void searchData(ArrayList<DataMahasiswa> mahasiswaList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NIM dari data yang ingin dicari: ");
        String nimToSearch = scanner.nextLine();

        for (DataMahasiswa mahasiswa : mahasiswaList) {
            if (mahasiswa.nim.equals(nimToSearch)) {
                System.out.println(mahasiswa);
                return;
            }
        }

        System.out.println("Data dengan NIM " + nimToSearch + " tidak ditemukan.\n");
    }

    private static void simpanKeFile(ArrayList<DataMahasiswa> mahasiswaList) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (DataMahasiswa mahasiswa : mahasiswaList) {
                writer.println(mahasiswa.nama);
                writer.println(mahasiswa.nim);
                writer.println(mahasiswa.mataKuliah);
                writer.println(mahasiswa.semester);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
