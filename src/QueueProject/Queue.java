package QueueProject;

public class Queue<T> {
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public boolean existeDado(T elemento) {
        if (isEmpty()) return false;
        return front.getElement().equals(elemento);
    }

    public int tamanho() {
        return size;
    }

    public void inserir(T elemento) {
        Node newNode = new Node(elemento);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
    }

    public T recuperar() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila está vazia.");
        }
        return (T) front.getElement();
    }

    public void alterar(T elemento) {
        if (isEmpty()) {
            throw new IllegalStateException("Fila está vazia.");
        }
        front.setElement(elemento);
    }

    public void remover() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila está vazia.");
        }
        front = front.getNext();
        size--;
        if (front == null) {
            rear = null; // fila ficou vazia após remoção
        }
    }

    public void limpa() {
        front = null;
        rear = null;
        size = 0;
    }

}
