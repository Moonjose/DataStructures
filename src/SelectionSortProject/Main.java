package SelectionSortProject;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Student {
    public String registerID;
    public Date registeredAt;
    public String name;
    public Date birthday;
    public String course;

    public Student(String registerID, Date registeredAt, String name, Date birthday, String course) {
        this.registerID = registerID;
        this.registeredAt = registeredAt;
        this.name = name;
        this.birthday = birthday;
        this.course = course;
    }

    public String format() {
        return registerID + " | " + registeredAt + " | " + name + '|' + birthday + '|' + course;
    }
}

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "UEDT_SelectionSort.txt";
        String outputFilePath = "UEDT_Sorted.txt";
        List<Student> students = loadStudentsFromFile(inputFilePath);

        if (students.isEmpty()) {
            System.out.println("Nenhum dado foi carregado.");
            return;
        }

        System.out.println("Iniciando ordenação por matrícula...");
        selectionSortByRegisterID(students);
        System.out.println("Ordenação concluída.");

        saveStudentsToFile(students, outputFilePath);
    }

    public static List<Student> loadStudentsFromFile(String inputFilePath) {
        List<Student> list = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // ou outro formato conforme seu arquivo

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 5) {
                    String registerId = parts[0].trim();
                    String registeredAtStr = parts[1].trim();
                    String name = parts[2].trim();
                    String birthdayStr = parts[3].trim();
                    String course = parts[4].trim();

                    try {
                        Date registeredAt = dateFormat.parse(registeredAtStr);
                        Date birthday = dateFormat.parse(birthdayStr);

                        list.add(new Student(registerId, registeredAt, name, birthday, course));
                    } catch (ParseException e) {
                        System.out.println("Erro ao converter datas: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return list;
    }
    public static void saveStudentsToFile(List<Student> list, String outputFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (Student student : list) {
                writer.write(student.format());
                writer.newLine();
            }
            System.out.println("Arquivo salvo com sucesso: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo: " + e.getMessage());
        }
    }

    // Ex: [ 3, 1, 4, 8, 2, 5, 9, 11 ]
    public static void selectionSortByRegisterID(List<Student> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;

            for (int j = i + 1; j < list.size(); j++) {
                long idJ = Long.parseLong(list.get(j).registerID);
                long idMin = Long.parseLong(list.get(min).registerID);

                if (idJ < idMin) {
                    min = j;
                }
            }

            if (min != i) {
                Student temp = list.get(i);
                list.set(i, list.get(min));
                list.set(min, temp);
            }
        }
    }
}
