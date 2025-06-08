import java.util.*;

public class GrafoBFS {

    // Representa um vértice (local)
    static class Vertice {
        String nome;

        public Vertice(String nome) {
            this.nome = nome;
        }
    }

    private List<Vertice> vertices;                 // Lista de vértices (locais)
    private List<List<Integer>> listaAdjacencias;   // Lista de adjacências: conexões entre os locais

    public GrafoBFS() {
        vertices = new ArrayList<>();
        listaAdjacencias = new ArrayList<>();
    }

    // Adiciona um novo vértice (local) ao grafo
    public void adicionarVertice(String nome) {
        vertices.add(new Vertice(nome));
        listaAdjacencias.add(new ArrayList<>());
    }

    // Adiciona uma conexão (aresta bidirecional) entre dois locais
    public void adicionarAresta(int origem, int destino) {
        if (origem >= 0 && origem < vertices.size() && destino >= 0 && destino < vertices.size()) {
            listaAdjacencias.get(origem).add(destino);
            listaAdjacencias.get(destino).add(origem);
        }
    }

    // Algoritmo BFS para encontrar o caminho mais curto entre dois locais
    public void buscarCaminhoMaisCurto(int inicio, int destino) {
        boolean[] visitado = new boolean[vertices.size()];
        int[] anterior = new int[vertices.size()];
        Arrays.fill(anterior, -1);

        Queue<Integer> fila = new LinkedList<>();
        fila.offer(inicio);
        visitado[inicio] = true;

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            if (atual == destino) break;

            for (int vizinho : listaAdjacencias.get(atual)) {
                if (!visitado[vizinho]) {
                    fila.offer(vizinho);
                    visitado[vizinho] = true;
                    anterior[vizinho] = atual;
                }
            }
        }

        // Reconstruindo o caminho
        List<Integer> caminho = new ArrayList<>();
        for (int at = destino; at != -1; at = anterior[at]) {
            caminho.add(0, at);
        }

        System.out.println("============================");
        System.out.println("  Caminho mais curto (BFS)  ");
        System.out.println("============================\n");

        if (caminho.size() == 1 && caminho.get(0) != inicio) {
            System.out.println("Não há caminho entre os locais.");
        } else {
            for (int i = 0; i < caminho.size(); i++) {
                System.out.print(vertices.get(caminho.get(i)).nome);
                if (i < caminho.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }

        System.out.println("\n============================");
    }

    // Método principal para testar
    public static void main(String[] args) {
        GrafoBFS grafo = new GrafoBFS();

        // Adicionando vértices (locais)
        grafo.adicionarVertice("Casa");
        grafo.adicionarVertice("Supermercado");
        grafo.adicionarVertice("Escola");
        grafo.adicionarVertice("Parque");
        grafo.adicionarVertice("Hospital");

        // Adicionando conexões
        grafo.adicionarAresta(0, 1); // Casa <-> Supermercado
        grafo.adicionarAresta(1, 2); // Supermercado <-> Escola
        grafo.adicionarAresta(2, 3); // Escola <-> Parque
        grafo.adicionarAresta(1, 4); // Supermercado <-> Hospital

        // Buscar caminho de Casa até Parque
        grafo.buscarCaminhoMaisCurto(0, 3);
    }
}


