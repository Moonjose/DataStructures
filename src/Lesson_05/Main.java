package Lesson_05;

public class Main {
    public static void main(String[] args) {
        IntSet set1 = new IntSet();
        IntSet set2 = new IntSet();

        set1.addElem(5);
        set1.addElem(6);
        set1.addElem(9);

        set2.addElem(9);
        set2.addElem(6);
        set2.addElem(5);
        set2.addElem(12);
        set2.addElem(25);

        System.out.println("União: " + set1.union((set2)));
        System.out.println("Interseção: " + set1.intersection(set2));
        System.out.println("Iguais?: " + set1.isEqualTo(set2));

        set2.removeElem(12);
        set2.removeElem((25));
        set2.addElem(9);
        System.out.println("Iguais?: " + set1.isEqualTo(set2));

    }
}