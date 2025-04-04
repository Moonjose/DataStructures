package DoubleLinkedListLesson;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList lista = new DoubleLinkedList();

        // FLUXO FUNCIONAL ---------------------------------------------------------
        // Criando alguns alunos com nome, matrícula e idade
        Aluno a1 = new Aluno("João", 20);
        Aluno a2 = new Aluno("Maria",  22);
        Aluno a3 = new Aluno("Carlos", 19);
        Aluno a4 = new Aluno("Ana",  21);

        // Testando inserções
        lista.adicionaInicio(a1);
        lista.adicionaFim(a2);
        lista.adiciona(a3, 1); // Inserindo no meio
        lista.adicionaFim(a4);

        System.out.println("Impressão direta:");
        lista.imprimeLista();

        System.out.println("Impressão reversa:");
        lista.imprimeReverso();

        // Testando tamanho
        System.out.println("\nTamanho da lista: " + lista.tamanho());

        // Testando existeDado
        System.out.println("Existe João? " + lista.existeDado(a1));
        System.out.println("Existe Aluno não inserido? " + lista.existeDado(new Aluno("Fake", 222)));

        // Testando recupera
        System.out.println("\nRecuperando posição 2: " + lista.Recupera(2));

        // Remoções
        lista.removeInicio();
        System.out.println("\nApós remover início:");
        lista.imprimeLista();

        lista.removeFim();
        System.out.println("\nApós remover fim:");
        lista.imprimeLista();

        lista.remove(1);
        System.out.println("\nApós remover na posição 1:");
        lista.imprimeLista();

        //Teste de limpar
        lista.limpa();
        System.out.println("\nApós limpar:");
        lista.imprimeLista();
        System.out.println("Tamanho após limpar: " + lista.tamanho());

        // FLUXO COM ERRO PROPOSITAL ---------------------------------------------------------
//        Aluno a10 = new Aluno("João", 123);
//
//        // 1. Tentar remover início de lista vazia
//        try {
//            lista.removeInicio();
//        } catch (IllegalStateException e) {
//            System.out.println("Erro esperado: " + e.getMessage());
//        }
//
//        // 2. Tentar remover fim de lista vazia
//        try {
//            lista.removeFim();
//        } catch (IllegalStateException e) {
//            System.out.println("Erro esperado: " + e.getMessage());
//        }
//
//        // 3. Tentar remover de posição inválida
//        try {
//            lista.remove(0);
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Erro esperado: " + e.getMessage());
//        }
//
//        // 4. Tentar recuperar posição inválida negativa
//        try {
//            lista.Recupera(-1);
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Erro esperado: " + e.getMessage());
//        }
//
//        // 5. Tentar recuperar posição inválida acima do tamanho
//        try {
//            lista.Recupera(100);
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Erro esperado: " + e.getMessage());
//        }
//
//        // 6. Tentar adicionar em posição inválida
//        try {
//            lista.adiciona(a10, -1);
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Erro esperado: " + e.getMessage());
//        }
//
//        try {
//            lista.adiciona(a10, 1); // Lista ainda vazia, só pode na posição 0
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Erro esperado: " + e.getMessage());
//        }
    }
}
