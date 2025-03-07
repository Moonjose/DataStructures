package Lesson_03;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", "Doe", 1265.00);
        Employee employee2 = new Employee("Mary", "Muller", 4450.00);

        System.out.println(employee1);
        employee1.raiseSalary(10);
        System.out.println(employee1);
    }
}