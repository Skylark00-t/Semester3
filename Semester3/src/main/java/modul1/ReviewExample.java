package modul1;

public class ReviewExample {
    public static void main(String[] args) {

        //Testing the add() method
        System.out.println(add(5,3));//expected output: 8
        System.out.println(add(2,-9));//expected output: -7

    }
    public static int add(int a, int b){
        return a + b;
    }
}
