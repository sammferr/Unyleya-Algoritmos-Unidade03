public class AgendaContatos {

    // Classe que representa um contato com DDD e número
    static class Contato {
        int ddd;
        int numero;

        public Contato(int ddd, int numero) {
            this.ddd = ddd;
            this.numero = numero;
        }

        // Método para mostrar o número completo com DDD
        public String getNumeroCompleto() {
            return "(" + ddd + ") " + numero;
        }
    }

    // Método para buscar um número na lista usando busca linear
    public int buscaLinear(Contato[] lista, Contato contatoProcurado) {
        for (int i = 0; i < lista.length; i++) {
            // Compara DDD e número do contato para achar o procurado
            if (lista[i].ddd == contatoProcurado.ddd && lista[i].numero == contatoProcurado.numero) {
                return i; // Retorna a posição onde encontrou
            }
        }
        return -1; // Não encontrado
    }

    public static void main(String[] args) {
        AgendaContatos minhaAgenda = new AgendaContatos();

        // Criando a lista de contatos com DDD e número
        Contato[] contatos = {
            new Contato(11, 987654321),
            new Contato(21, 912345678),
            new Contato(31, 955555555),
            new Contato(41, 999888777)
        };

        // Contato que vamos buscar
        Contato contatoBuscado = new Contato(31, 955555555);

        // Buscando o contato na lista
        int posicao = minhaAgenda.buscaLinear(contatos, contatoBuscado);

        System.out.println("==================================");
        System.out.println("       Busca Linear - Agenda       ");
        System.out.println("==================================");
        System.out.println();

        if (posicao != -1) {
            System.out.println("Contato encontrado!");
            System.out.println("Posição na lista: " + posicao);
            System.out.println("Número: " + contatos[posicao].getNumeroCompleto());
        } else {
            System.out.println("Contato não encontrado na lista.");
        }

        System.out.println();
        System.out.println("==================================");
    }
}


