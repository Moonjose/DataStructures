package Lesson_01;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String name = scanner.next();

        System.out.println("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.println("Digite seu dia de nascimento: ");
        int birthDay = scanner.nextInt();

        System.out.println("Digite seu mês de nascimento: ");
        int birthMonth = scanner.nextInt();

        System.out.println("Digite seu ano de nascimento: ");
        int birthYear = scanner.nextInt();

        HeartRates heartRate = new HeartRates(name, lastName, birthDay, birthMonth, birthYear);

        System.out.printf("Nome: %s%n", heartRate.getName());
        System.out.printf("Sobrenome: %s%n", heartRate.getLastName());
        System.out.printf("Nascimento: %d/%d/%d%n", heartRate.getBirthDay(), heartRate.getBirthMonth(), heartRate.getBirthYear());
        System.out.printf("Idade: %d%n", heartRate.calculateAge());
        System.out.printf("Frequência Máxima: %d%n", heartRate.calculateMaxHeartRate());
        System.out.printf("Intervalo de Frequência:  %.2f ~  %.2f%n", heartRate.calculateTargetHeartRate()[0], heartRate.calculateTargetHeartRate()[1]);
    }
}