package Lesson_02;

public class Main {
    public static void main(String[] args) {
        StoreBill storeBill = new StoreBill("1", "Processador Ryzen", 5, 1200.00);
        StoreBill storeBill2 = new StoreBill("2", "Processador Intel", 3, 2199.99);
        System.out.println(storeBill);
        System.out.println(storeBill2);
        storeBill.itemPrice = 3000.00;
        System.out.println(storeBill);
    }
}