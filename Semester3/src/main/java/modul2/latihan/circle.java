package modul2.latihan;
//Nama : Wahyu Lukytaningtyas
//NIM : 202210370311413
public class circle {
    public static final double PHI = 3.14;
    private double r;
    public circle(double radius){
        this.r = radius;
    }

    public static void main(String[] args) {
        circle circle = new circle(2.5);
        System.out.println("Radius: " + circle.r);
        System.out.println("Area: " + PHI * circle.r * circle.r);
    }
}

