package SinglyLinkedListProject;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------------------------------");
            System.out.println("1. Adicionar Tarefa\n2. Listar Tarefas\n3. Remover Tarefa\n4. Editar Tarefa\n5. Buscar Tarefa\n6. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Para consumir a quebra de linha do nextInt

            switch (option) {
                case 1:
                    System.out.print("Descrição da tarefa: ");
                    String description = scanner.nextLine();
                    todoList.addTask(description);
                    break;
                case 2:
                    todoList.listTasks();
                    break;
                case 3:
                    System.out.print("ID da tarefa: ");
                    int removeId = scanner.nextInt();
                    todoList.removeTask(removeId);
                    break;
                case 4:
                    System.out.print("ID da tarefa: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nova descrição da tarefa: ");
                    String newDescription = scanner.nextLine();

                    todoList.editTask(editId, newDescription);
                    break;
                case 5:
                    System.out.print("ID da tarefa: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    todoList.searchByID(searchId);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

class Task {
    int id;
    String description;
    Task next;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.next = null;
    }
}

class TodoList {
    Task head;
    int current_id = 0;

    public void addTask(String description) {
        Task newTask = new Task(current_id++, description);

        if (head == null) { // Se não há head, a nova head será essa task
            head = newTask;
        } else {
            // Cria uma variável temporária para representar o começo da lista, e percorrer até o fim através de um while, procurando
            // o ultimo elemento para adicionar a nova task ao fim.
            Task currentTask = head;
            while (currentTask.next != null) {
                currentTask = currentTask.next;
            }
            currentTask.next = newTask;
        }
        System.out.println("Tarefa adicionada ao fim da lista");
    }

    public void listTasks() {
        if (head == null) {
            System.out.println("Não há tarefas na lista");
            return;
        } else {
            Task currentTask = head;
            System.out.println("---------------------------------");
            while (currentTask != null) {
                System.out.printf("Tarefa {%d} - %s%n", currentTask.id, currentTask.description);
                currentTask = currentTask.next;
            }
        }
    }

    public void editTask(int id, String newDescription){
        if (head == null) {
            System.out.println("Não há tarefas na lista");
            return;
        } else {
            Task currentTask = head;
            while (currentTask != null) {
                if(currentTask.id == id) {
                    currentTask.description = newDescription;
                    System.out.println("Tarefa editada com sucesso!");
                    return;
                }
                currentTask = currentTask.next;
            }
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void removeTask(int id) {
        // Verifica se a lista está vazia
        if (head == null) {
            System.out.println("Não há tarefas na lista");
            return;
        }

        // Verifica se o id é o primeiro item da lista
        if (id == head.id) {
            head = head.next;
            System.out.println("Tarefa removida com sucesso!");
            return;
        }

        Task currentTask = head;
        Task previousTask = null;

        // Percorre a linkedList até encontrar a task com o id informado, armazenando também a task anterior à ela
        while (currentTask != null && currentTask.id != id) {
            previousTask = currentTask;
            currentTask = currentTask.next;
        }

        // Verificação para não tomar nullptr exception quando não houver o ID informado
        if (currentTask == null) {
           System.out.println("Tarefa não encontrada!");
            return;
        }

        // Aponta a anterior da task encontrada, para a próxima dela
        previousTask.next = currentTask.next;
        System.out.println("Tarefa removida com sucesso!");
    }

    public void searchByID(int id) {
        // Verifica se a lista está vazia
        if (head == null) {
            System.out.println("Não há tarefas na lista");
            return;
        }
        Task currentTask = head;

        // Percorre a lista para encontrar a task do ID informado
        while(currentTask != null && currentTask.id != id) {
            currentTask = currentTask.next;
        }

        // Printa a task
        if(currentTask != null) {
            System.out.printf("Tarefa {%d} - %s%n", currentTask.id, currentTask.description);
        } else {
            System.out.println("Tarefa não encontrada!");
        }

    }
}
