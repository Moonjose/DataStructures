package Lesson_05;

public class IntSet {
    boolean[] set;

    public IntSet() {
        set = new boolean[100];
    }

    public boolean contains(int elem) {
        return elem <= this.set.length && this.set[elem];
    }

    public boolean addElem(int newElem) {
        if(contains(newElem)) {
            System.out.printf("Elemento %d já existe no conjunto!%n", newElem);
            return false;
        } else {
            this.set[newElem] = true;
            return true;
        }
    }

    public boolean removeElem(int elemToRemove) {
        if (contains(elemToRemove)) {
            this.set[elemToRemove] = false;
            return true;
        } else {
            System.out.printf("Elemento %d não existe no conjunto!%n", elemToRemove);
            return false;
        }
    }

    public IntSet union(IntSet otherSet) {
        IntSet result = new IntSet();

        for (int i = 0; i < this.set.length; i++) {
            result.set[i] = this.set[i] || otherSet.set[i];
        }
        return result;
    }

    public IntSet intersection(IntSet otherSet) {
        IntSet result = new IntSet();

        for (int i = 0; i < this.set.length; i++) {
            result.set[i] = this.set[i] && otherSet.set[i];
        }
        return result;
    }

    public boolean isEqualTo(IntSet otherSet) {
        for (int i = 0; i < this.set.length; i++) {
            if (this.set[i] != otherSet.set[i]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String result = "[";
        boolean firstElem = true;

        for (int i = 0 ; i < this.set.length; i++) {
            if (this.set[i]) {
                if(!firstElem) {
                    result += ',';
                }
                result += i;
                firstElem = false;
            }

        }
        result += "]";
        return result;
    }
}
