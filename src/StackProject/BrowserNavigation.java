package StackProject;
import java.util.Scanner;

public class BrowserNavigation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Browser browser = new Browser();
        int option;

        // Loop principal do menu
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Visitar nova página");
            System.out.println("2 - Voltar");
            System.out.println("3 - Avançar");
            System.out.println("4 - Mostrar histórico");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (option) {
                case 1:
                    System.out.print("Escreva uma URL: ");
                    String url = scanner.nextLine();
                    browser.visitPage(url);
                    break;
                case 2:
                    browser.goBack();
                    break;
                case 3:
                    browser.goForward();
                    break;
                case 4:
                    browser.showHistory();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida.");
            }
        } while (option != 0);

        scanner.close();
    }
}

// Classe genérica para representar um nó da pilha
class Node<T> {
    T value;
    Node<T> next;

    // Construtor do nó
    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}

// Classe genérica que implementa uma pilha dinâmica
class Stack<T> {
    private Node<T> top;

    // Adiciona um elemento no topo da pilha
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
    }

    // Remove e retorna o elemento do topo da pilha
    public T pop() {
        if (isEmpty()) return null;
        T value = top.value;
        top = top.next;
        return value;
    }

    // Retorna o elemento do topo sem removê-lo
    public T peek() {
        return isEmpty() ? null : top.value;
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return top == null;
    }

    // Exibe todos os elementos da pilha
    public void display() {
        Node<T> current = top;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}

// Classe principal que simula um navegador com histórico de navegação
class Browser {
    private Stack<String> backHistory = new Stack<>();
    private Stack<String> forwardHistory = new Stack<>();
    private String currentPage = null;

    // Visita uma nova página e atualiza os históricos
    public void visitPage(String url) {
        if (currentPage != null) {
            backHistory.push(currentPage);
        }
        currentPage = url;
        forwardHistory = new Stack<>(); // Limpa o histórico de avanço
        System.out.println("Visitando: " + currentPage);
    }

    // Volta para a página anterior, se possível
    public void goBack() {
        if (backHistory.isEmpty()) {
            System.out.println("Sem páginas para voltar.");
            return;
        }
        forwardHistory.push(currentPage);
        currentPage = backHistory.pop();
        System.out.println("Voltando para: " + currentPage);
    }

    // Avança para a próxima página, se possível
    public void goForward() {
        if (forwardHistory.isEmpty()) {
            System.out.println("Sem páginas para avançar.");
            return;
        }
        backHistory.push(currentPage);
        currentPage = forwardHistory.pop();
        System.out.println("Avançando para: " + currentPage);
    }

    // Exibe o histórico atual de navegação
    public void showHistory() {
        System.out.println("\n--- Página Atual ---");
        System.out.println(currentPage);

        System.out.println("\n--- Histórico Anterior ---");
        backHistory.display();

        System.out.println("\n--- Histórico Seguinte ---");
        forwardHistory.display();
    }
}
