package DoubleLinkedListLesson;

import java.util.Iterator;

public class Iterador<T> implements Iterator {

    private Celula atual;

    public Iterador(Celula atual) {
        this.atual = atual;
    }

    public boolean hasNext() {
        return atual != null;
    }

    public Object next() {
        T elemento = (T) atual.getElemento();
        atual = atual.getProximo();
        return elemento;
    }

    public Celula getAtual() {
        return atual;
    }
}