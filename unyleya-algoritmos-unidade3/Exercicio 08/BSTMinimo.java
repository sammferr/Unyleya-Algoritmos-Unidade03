public class BSTMinimo {

    // Classe que representa um produto com nome e preço
    static class Produto {
        String nome;      // Nome do produto
        double preco;     // Preço do produto

        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }
    }

    // Nó da árvore binária de busca que armazena um produto
    static class NoBST {
        Produto produto;   // Produto armazenado no nó
        NoBST esquerda;    // Referência para o filho esquerdo
        NoBST direita;     // Referência para o filho direito

        public NoBST(Produto produto) {
            this.produto = produto;
            this.esquerda = null;
            this.direita = null;
        }
    }

    // Insere um novo produto na árvore binária de busca
    // A inserção é feita com base no preço do produto, mantendo a propriedade da BST
    public NoBST inserir(NoBST raiz, Produto produto) {
        if (raiz == null) {
            return new NoBST(produto);
        }
        if (produto.preco < raiz.produto.preco) {
            raiz.esquerda = inserir(raiz.esquerda, produto);
        } else {
            raiz.direita = inserir(raiz.direita, produto);
        }
        return raiz;
    }

    // Encontra o produto com o menor preço na árvore
    // O menor preço está sempre no nó mais à esquerda da BST
    public Produto encontrarMinimo(NoBST raiz) {
        if (raiz == null) {
            return null;
        }
        NoBST atual = raiz;
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual.produto;
    }

    // Método principal para demonstrar a criação da BST e busca do menor preço
    public static void main(String[] args) {
        BSTMinimo arvore = new BSTMinimo();
        NoBST raiz = null;

        // Inserindo produtos na árvore com seus respectivos preços
        raiz = arvore.inserir(raiz, new Produto("Notebook", 3500.00));
        raiz = arvore.inserir(raiz, new Produto("Smartphone", 1200.00));
        raiz = arvore.inserir(raiz, new Produto("Monitor", 800.00));
        raiz = arvore.inserir(raiz, new Produto("Teclado", 150.00));
        raiz = arvore.inserir(raiz, new Produto("Mouse", 100.00));

        // Encontrando o produto mais barato da lista
        Produto maisBarato = arvore.encontrarMinimo(raiz);

        // Exibindo o resultado de forma clara e organizada
        System.out.println("\n-----------------------------");
        System.out.println("Produto com menor preço");
        System.out.println("-----------------------------");
        if (maisBarato != null) {
            System.out.printf("Nome: %s\nPreço: R$ %.2f\n", maisBarato.nome, maisBarato.preco);
        } else {
            System.out.println("A árvore está vazia.");
        }
        System.out.println("-----------------------------\n");
    }
}

