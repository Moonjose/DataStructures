package BubbleSortCompany;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Company {
    public String name;
    public String stateId;
    public double marketValue;

    public Company(String name, String stateId, double marketValue) {
        this.name = name;
        this.stateId = stateId;
        this.marketValue = marketValue;
    }

    public String format() {
        return name + " | " + stateId + " | " + marketValue;
    }
}

public class Main {

    public static void main(String[] args) {
        String inputFilePath = "Empresas_BubbleSort.txt";
        String outputFilePath = "Empresas_Ordenadas.txt";

        List<Company> companies = loadCompaniesFromFile(inputFilePath);

        if (companies.isEmpty()) {
            System.out.println("Nenhum dado foi carregado.");
            return;
        }

        System.out.println("Iniciando ordenação (isso pode levar um tempo com muitos registros)...");
        bubbleSortDescending(companies);
        System.out.println("Ordenação concluída.");

        saveCompaniesToFile(companies, outputFilePath);
    }

    public static List<Company> loadCompaniesFromFile(String inputFilePath) {
        List<Company> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String stateId = parts[1].trim();
                    double value = Double.parseDouble(parts[2].trim());

                    list.add(new Company(name, stateId, value));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return list;
    }

    public static void saveCompaniesToFile(List<Company> list, String outputFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (Company company : list) {
                writer.write(company.format());
                writer.newLine();
            }
            System.out.println("Arquivo salvo com sucesso: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo: " + e.getMessage());
        }
    }

    public static void bubbleSortDescending(List<Company> list) {
        int n = list.size();
        boolean changed;

        for (int i = 0; i < n - 1; i++) {
            changed = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).marketValue < list.get(j + 1).marketValue) {
                    Company temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    changed = true;
                }
            }

            if (!changed) {
                break;
            }

            if (i % 100 == 0) {
                System.out.println("Progresso: " + i + " / " + (n - 1));
            }
        }
    }
}
