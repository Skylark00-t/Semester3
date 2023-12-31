package modul2.praktikum;

public class Employee {
    private String en;
    private int empAge;
    private double salary;
    private String jd;
    public Employee(String empName, int age, double empSalary, String jobDescription){
        en = empName;
        empAge = age;
        salary = empSalary;
        jd = jobDescription;
    }
    public void e(){
        System.out.println("Employee Name: "+ en);
        System.out.println("Age: "+ empAge);
        System.out.println("Salary: $"+ salary);
        System.out.println("Job Description: "+ jd);
    }
    public double c(){
        return salary * 12;
    }
    public void  s(double raisePercentage){//applyRaise
        salary += (salary * raisePercentage / 100);
    }
}
