public class ValidadorBST {

    // Classe interna representando uma categoria de produto
    static class Categoria {
        String nome;

        public Categoria(String nome) {
            this.nome = nome;
        }
    }

    // Classe interna representando um nó da árvore binária
    static class NoBST {
        Categoria categoria;
        NoBST esquerda;
        NoBST direita;

        public NoBST(Categoria categoria) {
            this.categoria = categoria;
            this.esquerda = null;
            this.direita = null;
        }
    }

    // Método que verifica se a árvore é uma BST válida
    public boolean arvoreEstaEmOrdem(NoBST raiz) {
        return validarBST(raiz, null, null);
    }

    // Método recursivo que verifica a validade da BST comparando os nomes das categorias
    private boolean validarBST(NoBST no, String minimo, String maximo) {
        if (no == null) {
            return true; // árvore vazia é BST
        }

        // Verifica se o nome da categoria viola as regras de uma BST
        if ((minimo != null && no.categoria.nome.compareTo(minimo) <= 0) ||
            (maximo != null && no.categoria.nome.compareTo(maximo) >= 0)) {
            return false;
        }

        // Verifica recursivamente as subárvores esquerda e direita
        return validarBST(no.esquerda, minimo, no.categoria.nome) &&
               validarBST(no.direita, no.categoria.nome, maximo);
    }

    // Método main para testar a validação da árvore
    public static void main(String[] args) {
    ValidadorBST validador = new ValidadorBST();

    // Criando árvore válida
    NoBST raiz = new NoBST(new Categoria("Eletrônicos"));
    raiz.esquerda = new NoBST(new Categoria("Acessórios"));
    raiz.direita = new NoBST(new Categoria("Informática"));

    System.out.println("Teste 1 - Árvore válida:");
    System.out.println("A árvore está organizada como BST? " + (validador.arvoreEstaEmOrdem(raiz) ? "Sim" : "Não"));
    System.out.println();

    // Modificando a árvore para ficar inválida
    raiz.direita.esquerda = new NoBST(new Categoria("Câmeras"));

    System.out.println("Teste 2 - Árvore modificada (inválida):");
    System.out.println("A árvore está organizada como BST? " + (validador.arvoreEstaEmOrdem(raiz) ? "Sim" : "Não"));
    }
}

