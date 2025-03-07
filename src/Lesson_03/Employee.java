package Lesson_03;

public class Employee {
    String name, lastName;
    double salary;

    public Employee(String name, String lastName, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(int percent) {
        this.salary = this.salary + (this.salary * ((float)percent/100));
    }

    public String toString() {
        return String.format("%s: - %.2f", (getName()+ " "+ getLastName()), getSalary());
    }
}
