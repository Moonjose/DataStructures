package SinglyLinkedListLesson;

public class ListaSimples<T> {

    private Celula inicio, fim;
    private int tamanho;

    public ListaSimples() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public ListaSimples(T elemento){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
        this.adicionaInicio(elemento);

    }
    public void adiciona(T elemento, int posicao) {
        if(posicao <= 0) {
            System.out.println("Posição excede os limites da lista, utilize o método 'adicionaInicio'");
            return;
        }
        if(posicao >= this.tamanho) {
            System.out.println("Posição excede os limites da lista, utilize o método 'adicionaFim'");
            return;
        }
        Celula nova = new Celula(elemento);
        if (this.tamanho == 0) {
            inicio = fim = nova;
            this.tamanho += 1;
        } else {
            Iterador it = new Iterador(this.inicio);

            int i = 0;
            while (it.hasNext()) {
                if (i != posicao - 1) {
                    it.next();
                    i++;
                } else {
                    break;
                }
            }
            nova.setProximo(it.getAtual().getProximo());
            it.getAtual().setProximo(nova);
            this.tamanho += 1;
        }
    }

    public void imprimeLista() {
        if (this.tamanho == 0) {
            System.out.println("A lista está vazia");
        }
        Celula temp = inicio;
        while(temp != null) {
            System.out.printf("%s %s", temp.getElemento(), temp.getProximo() != null ? "-> " : "");
            temp = temp.getProximo();
        }
        System.out.println("");
    }

    public void adicionaInicio(T elemento) {
        Celula nova = new Celula(elemento);
        if (this.tamanho == 0) {
            inicio = fim = nova;
            this.tamanho += 1;
        } else {
            nova.setProximo(inicio);
            inicio = nova;
            this.tamanho += 1;
        }
    }

    public void adicionaFim(T elemento) {
        Celula nova = new Celula(elemento);
        if (this.tamanho == 0) {
            inicio = fim = nova;
            this.tamanho += 1;
        } else {
            fim.setProximo(nova);
            fim = nova;
        }
        this.tamanho += 1;
    }

    public boolean existeDado(T elemento) {
        Iterador it = new Iterador(this.inicio);
        while (it.hasNext()) {
            if (it.getAtual().getElemento().equals(elemento)) {
                return true;
            }
            it.next();
        }
        return false;
    }

    public void remove(int posicao) {
        if(posicao <= 0) {
            System.out.println("Posição excede os limites da lista, utilize o método 'removeInicio'");
            return;
        }
        if(posicao >= this.tamanho - 1) {
            System.out.println("Posição excede os limites da lista, utilize o método 'removeFim'");
            return;
        }

        if (this.tamanho == 0) {
            System.out.println("Lista já está vazia");
            return;
        }

        Iterador it = new Iterador(this.inicio);

        int i = 0;
        while (it.hasNext()) {
            if (i != posicao - 1) {
                it.next();
                i++;
            } else {
                break;
            }
        }
        it.getAtual().setProximo(it.getAtual().getProximo().getProximo());
        this.tamanho -= 1;

    }

    public void removeFim() {
        if (this.tamanho == 0) {
            System.out.println("A lista está vazia!");
            return;
        }
        if (inicio == fim) {
            // Apenas um elemento na lista
            inicio = fim = null;
            this.tamanho -= 1;
            return;
        }

        Iterador it = new Iterador(this.inicio);

        while (it.hasNext()) {
            if(it.getAtual().getProximo() != fim) {
                it.next();
            } else {
                break;
            }

        }
        it.getAtual().setProximo(null);
        fim = it.getAtual();
        this.tamanho -= 1;
    }

    public int tamanho() {
       return this.tamanho;
    }

    public void limpa() {
        System.out.println("Limpando lista...");
        this.tamanho = 0;
        this.inicio = this.fim = null;
    }

    public T Recupera(int posicao) {

        if (this.tamanho == 0) {

            System.out.println("A lista está vazia!!");
            return null;

        } else if (posicao < 0 || posicao >= this.tamanho) {

            System.out.println("A Posição " + posicao + " é Inválida!");
            return null;

        } else {

            Iterador it = new Iterador(this.inicio);
            int i = 0;
            while (it.hasNext()) {
                if (i != posicao) {
                    it.next();
                    i++;
                } else {
                    break;
                }
            }

            return (T) it.getAtual().getElemento();
        }
    }

    public void removeInicio() {

        if (this.tamanho == 0) {
            System.out.println("A lista está vazia!");

        } else if (inicio == fim) {

            inicio = fim = null;
            this.tamanho -= 1;

        } else {

            inicio = inicio.getProximo();
            this.tamanho -= 1;
        }
    }

}

