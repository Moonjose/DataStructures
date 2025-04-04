package SinglyLinkedListLesson;

public class Main {
    public static void main(String[] args) {

        Aluno a1 = new Aluno("Anderson", 42);
        Aluno a2 = new Aluno("Ana", 31);
        Aluno a3 = new Aluno("José", 23);
        Aluno a4 = new Aluno("Mary", 53);
        Aluno a5 = new Aluno("John", 22);
        Aluno a6 = new Aluno("Doe", 32);

        ListaSimples lista = new ListaSimples();

        lista.adicionaInicio(a1);  //funcionando
        lista.adicionaInicio(a2);  //funcionando
        lista.adicionaInicio(a3);  //funcionando
        lista.imprimeLista();

        lista.adicionaFim(a4);
        lista.adicionaFim(a5);
        lista.adicionaFim(a6);
        lista.imprimeLista();

        lista.removeFim();
        lista.imprimeLista();

        lista.removeFim();
        lista.imprimeLista();

        System.out.printf("A lista tem tamanho: %d\n", lista.tamanho());

        lista.limpa();
        lista.imprimeLista();

        //lista.removeInicio();  //funcionando
        //a1 = (Aluno) lista.Recupera(0);
        //a2 = (Aluno) lista.Recupera(1);
        //System.out.println(a1.getNome() + " - " + a1.getIdade());  //funcionando
        //System.out.println(a2.getNome() + " - " + a2.getIdade());  //funcionando
        //lista.imprimeLista();

        //lista.imprimeLista();

        //lista.adiciona(a4, 2);
        //lista.imprimeLista();

            }
}

