package QuickSortProject;

import java.io.*;
import java.util.*;

class Order {
    int id;
    String orderDate;
    String customerName;
    double totalValue;
    String status;
    int itemCount;
    String paymentMethod;
    String deliveryDate;
    String city;
    String mainCategory;

    public Order(String[] parts) {
        try {
            this.id = Integer.parseInt(parts[0].trim());
            this.orderDate = parts[1].trim();
            this.customerName = parts[2].trim();
            this.totalValue = Double.parseDouble(parts[3].trim().replace(",", "."));
            this.status = parts[4].trim();
            this.itemCount = Integer.parseInt(parts[5].trim());
            this.paymentMethod = parts[6].trim();
            this.deliveryDate = parts[7].trim();
            this.city = parts[8].trim();
            this.mainCategory = parts[9].trim();
        } catch (Exception e) {
            System.out.println("Erro ao processar a linha: " + Arrays.toString(parts));
        }
    }

    public String format() {
        return id + " | " + orderDate + " | " + customerName + " | " + totalValue + " | " + status + " | " + itemCount
                + " | " + paymentMethod + " | " + deliveryDate + " | " + city + " | " + mainCategory;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Order> orders = loadOrders("pedidos_quicksort.txt");
        System.out.println("Total de pedidos carregados: " + orders.size());

        // Menu de escolha
        System.out.println("\nEscolha o critério de ordenação:");
        System.out.println("1 - Valor Total (decrescente)");
        System.out.println("2 - Data do Pedido (crescente)");
        System.out.println("3 - Cidade do Cliente (A-Z)");
        System.out.println("4 - Status do Pedido (A-Z)");
        System.out.println("5 - Quantidade de Itens (decrescente)");
        System.out.print("Opção: ");
        int option = scanner.nextInt();

        quickSort(orders, 0, orders.size() - 1, option);

        saveOrders(orders, "pedidos_ordenados_quicksort.txt");
    }

    public static List<Order> loadOrders(String filePath) {
        List<Order> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s*\\|\\s*");
                if (parts.length == 10) {
                    list.add(new Order(parts));
                } else {
                    System.out.println("Linha ignorada (colunas incorretas): " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return list;
    }

    public static void saveOrders(List<Order> list, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Order order : list) {
                writer.write(order.format());
                writer.newLine();
            }
            System.out.println("Arquivo salvo com sucesso: " + filePath);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    // Quick Sort com critério dinâmico
    public static void quickSort(List<Order> list, int low, int high, int criterion) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, criterion);
            quickSort(list, low, pivotIndex - 1, criterion);
            quickSort(list, pivotIndex + 1, high, criterion);
        }
    }

    public static int partition(List<Order> list, int low, int high, int criterion) {
        int middle = low + (high - low) / 2;
        Order pivot = list.get(middle);
        swap(list, middle, high);

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(list.get(j), pivot, criterion)) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }

    // Comparação de acordo com o critério
    public static boolean compare(Order a, Order b, int criterion) {
        switch (criterion) {
            case 1: return a.totalValue > b.totalValue; // decrescente
            case 2: return a.orderDate.compareTo(b.orderDate) < 0; // crescente
            case 3: return a.city.compareToIgnoreCase(b.city) < 0;
            case 4: return a.status.compareToIgnoreCase(b.status) < 0;
            case 5: return a.itemCount > b.itemCount; // decrescente
            default: return false;
        }
    }

    public static void swap(List<Order> list, int a, int b) {
        if (a != b) {
            Order temp = list.get(a);
            list.set(a, list.get(b));
            list.set(b, temp);
        }
    }
}
