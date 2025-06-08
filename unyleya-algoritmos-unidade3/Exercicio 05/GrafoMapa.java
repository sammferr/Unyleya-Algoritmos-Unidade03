import java.util.ArrayList;
import java.util.List;

public class GrafoMapa {

    static class Vertice {
        String nome;
        public Vertice(String nome) {
            this.nome = nome;
        }
    }

    private List<Vertice> vertices;
    private List<List<Integer>> listaAdjacencias;

    public GrafoMapa() {
        vertices = new ArrayList<>();
        listaAdjacencias = new ArrayList<>();
    }

    public void adicionarVertice(String nome) {
        vertices.add(new Vertice(nome));
        listaAdjacencias.add(new ArrayList<>());
    }

    public void adicionarAresta(int origem, int destino) {
        listaAdjacencias.get(origem).add(destino);
        listaAdjacencias.get(destino).add(origem);
    }

    public void exibirMapaConexoes() {
        System.out.println("============================");
        System.out.println("      Mapa de Conexões      ");
        System.out.println("============================\n");

        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i).nome + " está conectado a: ");
            List<Integer> adjacentes = listaAdjacencias.get(i);
            for (int j = 0; j < adjacentes.size(); j++) {
                System.out.print(vertices.get(adjacentes.get(j)).nome);
                if (j < adjacentes.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("\n----------------------------------");
        }
    }

    public static void main(String[] args) {
        GrafoMapa grafo = new GrafoMapa();

        grafo.adicionarVertice("Casa");
        grafo.adicionarVertice("Supermercado");
        grafo.adicionarVertice("Escola");
        grafo.adicionarVertice("Parque");

        grafo.adicionarAresta(0, 1); // Casa <-> Supermercado
        grafo.adicionarAresta(0, 2); // Casa <-> Escola
        grafo.adicionarAresta(1, 3); // Supermercado <-> Parque

        grafo.exibirMapaConexoes();
    }
}
