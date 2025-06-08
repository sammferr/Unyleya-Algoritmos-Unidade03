import java.util.ArrayList;
import java.util.List;

public class Grafo {

    // Classe que representa um vértice (local)
    static class Vertice {
        String nome;

        public Vertice(String nome) {
            this.nome = nome;
        }
    }

    private List<Vertice> vertices;                // Lista de vértices (locais)
    private List<List<Integer>> listaAdjacencias; // Lista de adjacências: conexões entre os locais

    public Grafo() {
        vertices = new ArrayList<>();
        listaAdjacencias = new ArrayList<>();
    }

    // Adiciona um novo vértice ao grafo
    public void adicionarVertice(String nome) {
        vertices.add(new Vertice(nome));
        listaAdjacencias.add(new ArrayList<>());
    }

    // Adiciona uma aresta (conexão bidirecional) entre dois vértices
    public void adicionarAresta(int origem, int destino) {
        if (origem >= 0 && origem < vertices.size() && destino >= 0 && destino < vertices.size()) {
            listaAdjacencias.get(origem).add(destino);
            listaAdjacencias.get(destino).add(origem);
        } else {
            System.out.println("Erro: Índices inválidos para os vértices.");
        }
    }

    // Método para iniciar a busca em profundidade (DFS)
    public void buscaProfundidade(int inicio) {
        boolean[] visitados = new boolean[vertices.size()]; // Marca quais vértices já foram visitados
        System.out.println("==========================");
        System.out.println("Busca em Profundidade (DFS)");
        System.out.println("==========================");
        dfs(inicio, visitados);
        System.out.println("\nBusca finalizada.");
    }

    // Método recursivo que visita vértices em profundidade
    private void dfs(int atual, boolean[] visitados) {
        visitados[atual] = true;
        System.out.println("- " + vertices.get(atual).nome);

        for (int adj : listaAdjacencias.get(atual)) {
            if (!visitados[adj]) {
                dfs(adj, visitados);
            }
        }
    }

    // Método principal para testar o DFS
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Adicionando vértices (locais)
        grafo.adicionarVertice("Casa");
        grafo.adicionarVertice("Supermercado");
        grafo.adicionarVertice("Escola");
        grafo.adicionarVertice("Parque");
        grafo.adicionarVertice("Biblioteca");

        // Adicionando conexões (arestas)
        grafo.adicionarAresta(0, 1); // Casa <-> Supermercado
        grafo.adicionarAresta(0, 2); // Casa <-> Escola
        grafo.adicionarAresta(1, 3); // Supermercado <-> Parque
        grafo.adicionarAresta(2, 4); // Escola <-> Biblioteca

        // Executar busca em profundidade a partir de "Casa"
        grafo.buscaProfundidade(0);
    }
}

