package HashTableProject;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

class User {
    String name;
    String password;

    User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

class UserTable {
    private final int capacity = 31;
    private LinkedList<User>[] table;

    public UserTable() {
        table = new LinkedList[capacity];
    }

    private int computeHash(String key) {
        int hash = 7;
        int prime = 31;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * prime + key.charAt(i)) % capacity;
        }
        return Math.abs(hash);
    }

    public void addUser(String name, String password) {
        int index = computeHash(name);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (User user : table[index]) {
            if (user.name.equals(name)) {
                System.out.println("Erro: usuário já cadastrado.");
                return;
            }
        }

        table[index].add(new User(name, password));
        System.out.println("Usuário cadastrado com sucesso.");
    }

    public boolean authenticate(String name, String password) {
        int index = computeHash(name);
        if (table[index] != null) {
            for (User user : table[index]) {
                if (user.name.equals(name) && user.password.equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exists(String name) {
        int index = computeHash(name);
        if (table[index] != null) {
            for (User user : table[index]) {
                if (user.name.equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeUser(String name) {
        int index = computeHash(name);
        if (table[index] != null) {
            Iterator<User> it = table[index].iterator();
            while (it.hasNext()) {
                if (it.next().name.equals(name)) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

    public int getIndexForName(String name) {
        return computeHash(name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserTable system = new UserTable();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Login");
            System.out.println("3 - Buscar usuário");
            System.out.println("4 - Remover usuário");
            System.out.println("5 - Ver índice de um nome");
            System.out.println("6 - Sair");
            System.out.print("Escolha: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nome de usuário: ");
                    String regName = scanner.nextLine();
                    System.out.print("Senha: ");
                    String regPass = scanner.nextLine();
                    system.addUser(regName, regPass);
                    break;

                case 2:
                    System.out.print("Nome de usuário: ");
                    String loginName = scanner.nextLine();
                    System.out.print("Senha: ");
                    String loginPass = scanner.nextLine();
                    if (system.authenticate(loginName, loginPass)) {
                        System.out.println("Login realizado com sucesso.");
                    } else {
                        System.out.println("Nome de usuário ou senha incorretos.");
                    }
                    break;

                case 3:
                    System.out.print("Nome do usuário para buscar: ");
                    String searchName = scanner.nextLine();
                    if (system.exists(searchName)) {
                        System.out.println("Usuário encontrado.");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Nome do usuário para remover: ");
                    String removeName = scanner.nextLine();
                    if (system.removeUser(removeName)) {
                        System.out.println("Usuário removido com sucesso.");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o nome para ver o índice hash: ");
                    String nameIndex = scanner.nextLine();
                    int index = system.getIndexForName(nameIndex);
                    System.out.println("O índice hash para \"" + nameIndex + "\" é: " + index);
                    break;

                case 6:
                    System.out.println("Sistema encerrado.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
