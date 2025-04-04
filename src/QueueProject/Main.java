package QueueProject;

public class Main {
    public static void main(String[] args) {
        Queue<String> filaNormal = new Queue<>();
        Queue<String> filaEspecial = new Queue<>();

        // Adicionando pessoas nas filas
        filaNormal.inserir("Cliente Normal 1");
        filaNormal.inserir("Cliente Normal 2");
        filaNormal.inserir("Cliente Normal 3");

        filaEspecial.inserir("Cliente Especial 1");
        filaEspecial.inserir("Cliente Especial 2");

        for (int i = 1; i <= 5; i++) {
            String clienteAtendido = null;

            // Posições 1 e 2 priorizam fila especial
            if (i == 1 || i == 2) {
                if (!filaEspecial.isEmpty()) {
                    clienteAtendido = filaEspecial.recuperar();
                    filaEspecial.remover();
                } else if (!filaNormal.isEmpty()) {
                    clienteAtendido = filaNormal.recuperar();
                    filaNormal.remover();
                }
            }

            // Posições 3, 4 e 5 priorizam fila normal
            else {
                if (!filaNormal.isEmpty()) {
                    clienteAtendido = filaNormal.recuperar();
                    filaNormal.remover();
                } else if (!filaEspecial.isEmpty()) {
                    clienteAtendido = filaEspecial.recuperar();
                    filaEspecial.remover();
                }
            }

            if (clienteAtendido != null) {
                System.out.println("Posição [" + i + "] atendeu: " + clienteAtendido);
            } else {
                System.out.println("Posição [" + i + "] não atendeu ninguém. Ambas as filas estão vazias.");
            }
        }
    }
}
