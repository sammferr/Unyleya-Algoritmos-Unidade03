import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GrafoOrdenacao {

    // Classe que representa um vértice (local ou tarefa)
    static class Vertice {
        String nome;
        public Vertice(String nome) {
            this.nome = nome;
        }
    }

    private List<Vertice> vertices;               // Lista dos vértices
    private List<List<Integer>> listaAdjacencias; // Lista de adjacência (arestas dirigidas)

    public GrafoOrdenacao() {
        vertices = new ArrayList<>();
        listaAdjacencias = new ArrayList<>();
    }

    // Adiciona um novo vértice
    public void adicionarVertice(String nome) {
        vertices.add(new Vertice(nome));
        listaAdjacencias.add(new ArrayList<>());
    }

    // Adiciona uma aresta dirigida de origem para destino
    public void adicionarAresta(int origem, int destino) {
        if (origem >= 0 && origem < vertices.size() && destino >= 0 && destino < vertices.size()) {
            listaAdjacencias.get(origem).add(destino);
        } else {
            System.out.println("Erro: Índices inválidos para os vértices.");
        }
    }

    // Método que realiza a ordenação topológica
    public void ordenacaoTopologica() {
        boolean[] visitado = new boolean[vertices.size()];
        Stack<Integer> pilha = new Stack<>();

        for (int i = 0; i < vertices.size(); i++) {
            if (!visitado[i]) {
                dfs(i, visitado, pilha);
            }
        }

        System.out.println("========================================");
        System.out.println("      Ordenação Topológica dos Vértices");
        System.out.println("========================================");

        while (!pilha.isEmpty()) {
            System.out.print(vertices.get(pilha.pop()).nome);
            if (!pilha.isEmpty()) System.out.print(" -> ");
        }
        System.out.println();
    }

    // DFS usado na ordenação topológica
    private void dfs(int atual, boolean[] visitado, Stack<Integer> pilha) {
        visitado[atual] = true;
        for (int adj : listaAdjacencias.get(atual)) {
            if (!visitado[adj]) {
                dfs(adj, visitado, pilha);
            }
        }
        pilha.push(atual); // Empilha após visitar todos os adjacentes
    }

    // Teste do código
    public static void main(String[] args) {
        GrafoOrdenacao grafo = new GrafoOrdenacao();

        // Adicionando vértices (tarefas, por exemplo)
        grafo.adicionarVertice("A");
        grafo.adicionarVertice("B");
        grafo.adicionarVertice("C");
        grafo.adicionarVertice("D");
        grafo.adicionarVertice("E");
        grafo.adicionarVertice("F");

        // Adicionando dependências (arestas dirigidas)
        grafo.adicionarAresta(5, 2); // F -> C
        grafo.adicionarAresta(5, 0); // F -> A
        grafo.adicionarAresta(4, 0); // E -> A
        grafo.adicionarAresta(4, 1); // E -> B
        grafo.adicionarAresta(2, 3); // C -> D
        grafo.adicionarAresta(3, 1); // D -> B

        // Mostrar ordenação topológica
        grafo.ordenacaoTopologica();
    }
}
