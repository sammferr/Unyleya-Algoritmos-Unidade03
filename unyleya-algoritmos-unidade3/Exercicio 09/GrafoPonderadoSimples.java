import java.util.ArrayList;
import java.util.List;

public class GrafoPonderadoSimples {

    // Classe que representa um local (vértice)
    static class Vertice {
        String nome;
        public Vertice(String nome) {
            this.nome = nome;
        }
    }

    // Classe que representa uma conexão entre locais com distância (peso)
    static class Aresta {
        int destino;
        int peso;
        public Aresta(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    private List<Vertice> vertices;                 // Lista dos locais
    private List<List<Aresta>> listaAdjacencias;   // Conexões com distâncias

    public GrafoPonderadoSimples() {
        vertices = new ArrayList<>();
        listaAdjacencias = new ArrayList<>();
    }

    // Adiciona um novo local
    public void adicionarVertice(String nome) {
        vertices.add(new Vertice(nome));
        listaAdjacencias.add(new ArrayList<>());
    }

    // Adiciona uma conexão (aresta) bidirecional com distância
    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem >= 0 && origem < vertices.size() && destino >= 0 && destino < vertices.size()) {
            listaAdjacencias.get(origem).add(new Aresta(destino, peso));
            listaAdjacencias.get(destino).add(new Aresta(origem, peso));
        } else {
            System.out.println("Erro: Índices inválidos.");
        }
    }

    // Encontra o caminho mais curto entre dois locais
    public void encontrarCaminhoMaisCurto(int inicio, int destino) {
        int n = vertices.size();

        int[] dist = new int[n];        // Distância mínima conhecida até cada vértice
        boolean[] visitado = new boolean[n]; // Marca se o vértice já foi visitado
        int[] anterior = new int[n];    // Guarda o caminho anterior para reconstruir rota

        // Inicializa distâncias com valor grande (infinito)
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            anterior[i] = -1;
        }
        dist[inicio] = 0;

        // Loop para visitar todos os vértices
        for (int i = 0; i < n; i++) {
            // Encontra o vértice não visitado com menor distância
            int u = -1;
            int menorDist = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visitado[j] && dist[j] < menorDist) {
                    menorDist = dist[j];
                    u = j;
                }
            }

            if (u == -1) break; // Sem mais vértices alcançáveis

            visitado[u] = true;

            // Atualiza as distâncias dos vizinhos
            for (Aresta a : listaAdjacencias.get(u)) {
                int v = a.destino;
                int peso = a.peso;
                if (!visitado[v] && dist[u] + peso < dist[v]) {
                    dist[v] = dist[u] + peso;
                    anterior[v] = u;
                }
            }
        }

        // Reconstruir e mostrar o caminho
        if (dist[destino] == Integer.MAX_VALUE) {
            System.out.println("Não existe caminho entre " + vertices.get(inicio).nome + " e " + vertices.get(destino).nome);
        } else {
            List<String> caminho = new ArrayList<>();
            for (int at = destino; at != -1; at = anterior[at]) {
                caminho.add(0, vertices.get(at).nome); // Adiciona no começo para ficar na ordem correta
            }
            System.out.println("===========================");
            System.out.println("Caminho mais curto encontrado");
            System.out.println("===========================");
            System.out.println(String.join(" -> ", caminho));
            System.out.println("Distância total: " + dist[destino]);
        }
    }

    // Método para testar o código
    public static void main(String[] args) {
        GrafoPonderadoSimples grafo = new GrafoPonderadoSimples();

        // Criar locais
        grafo.adicionarVertice("Casa");
        grafo.adicionarVertice("Supermercado");
        grafo.adicionarVertice("Escola");
        grafo.adicionarVertice("Parque");
        grafo.adicionarVertice("Biblioteca");

        // Criar conexões com distâncias
        grafo.adicionarAresta(0, 1, 5);  // Casa <-> Supermercado (5)
        grafo.adicionarAresta(0, 2, 10); // Casa <-> Escola (10)
        grafo.adicionarAresta(1, 3, 3);  // Supermercado <-> Parque (3)
        grafo.adicionarAresta(2, 4, 1);  // Escola <-> Biblioteca (1)
        grafo.adicionarAresta(3, 4, 2);  // Parque <-> Biblioteca (2)

        // Procurar caminho mais curto entre Casa e Biblioteca
        grafo.encontrarCaminhoMaisCurto(0, 4);
    }
}

