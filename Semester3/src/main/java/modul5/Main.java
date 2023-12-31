package modul5;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Mahasiswa> mahasiswaList = new ArrayList<>();

        inputMahasiswaData(mahasiswaList);
        saveToFile(mahasiswaList, "data_mahasiswa.txt");
        removeDuplicateData(mahasiswaList);
        System.out.println("Data setelah menghapus duplikat:");
        for (Mahasiswa mahasiswa : mahasiswaList) {
            System.out.println(mahasiswa);
        }
    }

    private static void inputMahasiswaData(List<Mahasiswa> mahasiswaList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan data mahasiswa (Nama NIM Semester), ketik 'selesai' untuk selesai:");

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("selesai")) {
                break;
            }

            String[] data = input.split(" ");
            if (data.length == 3) {
                Mahasiswa mahasiswa = new Mahasiswa(data[0], data[1], Integer.parseInt(data[2]));
                mahasiswaList.add(mahasiswa);
            } else {
                System.out.println("Format input salah. Masukkan data dengan format (Nama NIM Semester).");
            }
        }
    }

    private static void saveToFile(List<Mahasiswa> mahasiswaList, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Nama NIM Semester");

            for (Mahasiswa mahasiswa : mahasiswaList) {
                writer.println(mahasiswa);
            }

            System.out.println("Data berhasil disimpan ke dalam file " + fileName);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data ke dalam file.");
            e.printStackTrace();
        }
    }

    private static void removeDuplicateData(List<Mahasiswa> mahasiswaList) {
        List<Mahasiswa> uniqueList = new ArrayList<>();
        for (Mahasiswa mahasiswa : mahasiswaList) {
            if (!uniqueList.contains(mahasiswa)) {
                uniqueList.add(mahasiswa);
            }
        }
        mahasiswaList.clear();
        mahasiswaList.addAll(uniqueList);
    }
}

    class Mahasiswa {
    private String nama;
    private String nim;
    private int semester;

    public Mahasiswa(String nama, String nim, int semester) {
        this.nama = nama;
        this.nim = nim;
        this.semester = semester;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mahasiswa mahasiswa = (Mahasiswa) obj;
        return nim.equals(mahasiswa.nim);
    }

    @Override
    public int hashCode() {
        return nim.hashCode();
    }

    @Override
    public String toString() {
        return nama + " " + nim + " " + semester;
    }

}

