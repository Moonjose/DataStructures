package Lesson_07;

public class Main {
    public static void main(String[] args) {

        // Testar palíndromo
        String word = "a cara rajada da jararaca";
        System.out.println(isPalindrome(word));
        System.out.print("\n");

        // Printar array com espaços
        int[] intArray = {0, 1, 2, 3, 4, 5 ,6 ,7 ,8, 9, 10};
        printArray(intArray, 0);
        System.out.println("\n");

        // Reverter String
        reverseString("Jose");
        System.out.println("\n");

        // Encontrar valor mínimo
        int[] minimumArray = { 356, 34, 536, 3199, 12305, 12, 435, 122, 50053 };
        System.out.println("Valor mínimo: " + findMinimum(minimumArray));
    }
    public static boolean isPalindrome(String word) {
        word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return isPalindromeRecursive(word, 0, word.length() - 1);
    }
    public static boolean isPalindromeRecursive(String word, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return true;
        }
        if (word.charAt(leftIndex) != word.charAt(rightIndex)) {
            return false;
        }
        return isPalindromeRecursive(word, leftIndex + 1, rightIndex -1);
    }

    public static void printArray(int[] intArray, int index) {
        if (index > intArray.length - 1) {
            return;
        }
        System.out.print(intArray[index] + " ");
        printArray(intArray, index + 1);
    }

    public static void reverseString(String str) {
        recursiveReverseString(str, str.length() - 1);
    }
    public static void recursiveReverseString(String str, int index) {
        if (index == 0) {
            System.out.print(str.charAt(index));
            return;
        }
        System.out.print(str.charAt(index));
        recursiveReverseString(str, index - 1);
    }
    public static int findMinimum(int[] intArray) {
        return recursiveMinimum(intArray, intArray[0], 0);
    }
    public static int recursiveMinimum(int[] intArray, int minimumNumber, int index) {
        if (index >= intArray.length - 1) {
            return minimumNumber;
        }
        if (intArray[index] < minimumNumber) {
            minimumNumber = intArray[index];
        }
        return recursiveMinimum(intArray, minimumNumber, index + 1);
    }
}
