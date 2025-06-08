public class Biblioteca {

    // Classe interna que representa um livro com título
    static class Livro {
        String titulo;

        public Livro(String titulo) {
            this.titulo = titulo;
        }
    }

    // Classe interna que representa um nó da árvore binária
    static class NoArvoreBinaria {
        Livro livro;
        NoArvoreBinaria esquerda;
        NoArvoreBinaria direita;

        public NoArvoreBinaria(Livro livro) {
            this.livro = livro;
            this.esquerda = null;
            this.direita = null;
        }
    }

    // Raiz da árvore
    private NoArvoreBinaria raiz;

    // Construtor inicializa árvore vazia
    public Biblioteca() {
        raiz = null;
    }

    // Método para inserir um livro na árvore
    public void inserir(Livro livro) {
        raiz = inserirRecursivo(raiz, livro);
    }

    // Método recursivo que insere o livro na posição correta da árvore
    private NoArvoreBinaria inserirRecursivo(NoArvoreBinaria atual, Livro livro) {
        if (atual == null) {
            // Se chegou num ponto vazio, cria novo nó com o livro
            return new NoArvoreBinaria(livro);
        }

        // Compara título para decidir se vai para esquerda ou direita
        if (livro.titulo.compareToIgnoreCase(atual.livro.titulo) < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, livro);
        } else {
            atual.direita = inserirRecursivo(atual.direita, livro);
        }
        return atual;
    }

    // Percurso pré-ordem: nó atual, esquerda, direita
    public void preOrdem() {
        System.out.println("============================");
        System.out.println("   Percurso Pré-Ordem:");
        System.out.println("============================");
        preOrdemRecursivo(raiz);
        System.out.println();
    }

    private void preOrdemRecursivo(NoArvoreBinaria atual) {
        if (atual != null) {
            System.out.println("- " + atual.livro.titulo);
            preOrdemRecursivo(atual.esquerda);
            preOrdemRecursivo(atual.direita);
        }
    }

    // Percurso em ordem: esquerda, nó atual, direita
    public void emOrdem() {
        System.out.println("============================");
        System.out.println("    Percurso Em Ordem:");
        System.out.println("============================");
        emOrdemRecursivo(raiz);
        System.out.println();
    }

    private void emOrdemRecursivo(NoArvoreBinaria atual) {
        if (atual != null) {
            emOrdemRecursivo(atual.esquerda);
            System.out.println("- " + atual.livro.titulo);
            emOrdemRecursivo(atual.direita);
        }
    }

    // Percurso pós-ordem: esquerda, direita, nó atual
    public void posOrdem() {
        System.out.println("============================");
        System.out.println("   Percurso Pós-Ordem:");
        System.out.println("============================");
        posOrdemRecursivo(raiz);
        System.out.println();
    }

    private void posOrdemRecursivo(NoArvoreBinaria atual) {
        if (atual != null) {
            posOrdemRecursivo(atual.esquerda);
            posOrdemRecursivo(atual.direita);
            System.out.println("- " + atual.livro.titulo);
        }
    }

    // Método main para testar a árvore
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Inserindo alguns livros na árvore
        biblioteca.inserir(new Livro("O Senhor dos Anéis"));
        biblioteca.inserir(new Livro("A Guerra dos Tronos"));
        biblioteca.inserir(new Livro("O Pequeno Príncipe"));
        biblioteca.inserir(new Livro("1984"));
        biblioteca.inserir(new Livro("A Arte da Guerra"));

        // Mostrando os livros em cada percurso
        biblioteca.preOrdem();
        biblioteca.emOrdem();
        biblioteca.posOrdem();
    }
}

