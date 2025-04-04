package DoubleLinkedListLesson;

import DoubleLinkedListLesson.Iterador;

public class DoubleLinkedList<T> {
    private Celula inicio, fim;
    private int tamanho;

    public DoubleLinkedList() {
    }

    public DoubleLinkedList(T elemento) {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void adicionaInicio(T elemento) {
        Celula nova = new Celula(elemento);
        if (inicio == null) {
            inicio = fim = nova;
        } else {
            nova.setProximo(inicio);
            inicio.setAnterior(nova);
            inicio = nova;
        }
        tamanho++;
    }

    public void adicionaFim(T elemento) {
        Celula nova = new Celula(elemento);
        if (fim == null) {
            inicio = fim = nova;
        } else {
            fim.setProximo(nova);
            nova.setAnterior(fim);
            fim = nova;
        }
        tamanho++;
    }

    public void adiciona(T elemento, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida!");
        }

        if (posicao == 0) {
            adicionaInicio(elemento);
            return;
        }

        if (posicao == tamanho) {
            adicionaFim(elemento);
            return;
        }

        Celula nova = new Celula(elemento);
        Iterador it = new Iterador(inicio);
        int i = 0;

        while (it.hasNext() && i < posicao) {
            it.next();
            i++;
        }

        Celula atual = it.getAtual();
        Celula anterior = atual.getAnterior();

        nova.setAnterior(anterior);
        nova.setProximo(atual);

        if (anterior != null) anterior.setProximo(nova);
        atual.setAnterior(nova);

        tamanho++;
    }

    public void removeInicio() {
        if (inicio == null) {
            throw new IllegalStateException("A lista está vazia!");
        }

        if (inicio == fim) {
            // Lista com apenas um elemento
            inicio = fim = null;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }

        tamanho--;
    }

    public void removeFim() {
        if (fim == null) {
            throw new IllegalStateException("A lista está vazia!");
        }

        if (inicio == fim) {
            // Lista com apenas um elemento
            inicio = fim = null;
        } else {
            fim = fim.getAnterior();
            fim.setProximo(null);
        }

        tamanho--;
    }

    public void remove(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida!");
        }

        if (posicao == 0) {
            removeInicio();
            return;
        }

        if (posicao == tamanho - 1) {
            removeFim();
            return;
        }

        Celula atual = inicio;
        int contador = 0;

        while (contador < posicao) {
            atual = atual.getProximo();
            contador++;
        }

        Celula anterior = atual.getAnterior();
        Celula proximo = atual.getProximo();

        anterior.setProximo(proximo);
        proximo.setAnterior(anterior);

        tamanho--;
    }

    public boolean existeDado(T elemento) {
        Celula atual = inicio;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }

        return false;
    }

    public T Recupera(int pos) {
        if (pos < 0 || pos >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida!");
        }

        Celula atual = inicio;
        int contador = 0;

        while (contador < pos) {
            atual = atual.getProximo();
            contador++;
        }

        return (T) atual.getElemento();
    }

    public int tamanho() {
        return tamanho;
    }

    public void limpa() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public void imprimeLista() {
        Celula atual = inicio;
        System.out.print("Início -> ");

        while (atual != null) {
            System.out.print(atual.getElemento());
            if (atual.getProximo() != null) {
                System.out.print(" -> ");
            }
            atual = atual.getProximo();
        }

        System.out.println(" -> Fim");
    }

    public void imprimeReverso() {
        Celula atual = fim;
        System.out.print("Fim <- ");

        while (atual != null) {
            System.out.print(atual.getElemento());
            if (atual.getAnterior() != null) {
                System.out.print(" <- ");
            }
            atual = atual.getAnterior();
        }

        System.out.println(" <- Início");
    }
}
