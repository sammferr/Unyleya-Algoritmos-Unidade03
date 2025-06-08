public class BuscaBinaria {

    // Método para realizar busca binária em array ordenado
    public static int buscaBinaria(int[] lista, int alvo) {
        int inicio = 0;
        int fim = lista.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (lista[meio] == alvo) {
                return meio;  // elemento encontrado
            } 
            else if (lista[meio] < alvo) {
                inicio = meio + 1;  // procura na metade direita
            } 
            else {
                fim = meio - 1;  // procura na metade esquerda
            }
        }

        return -1;  // elemento não encontrado
    }

    public static void main(String[] args) {
        int[] numeros = {3, 7, 15, 20, 26, 31, 42, 55, 60};

        int numeroBuscado = 26;
        int resultado = buscaBinaria(numeros, numeroBuscado);

        System.out.println("==================================");
        System.out.println("      Busca Binária - Resultado    ");
        System.out.println("==================================");

        if (resultado != -1) {
            System.out.println("Número " + numeroBuscado + " encontrado na posição: " + resultado);
        } else {
            System.out.println("Número " + numeroBuscado + " não encontrado na lista.");
        }

        System.out.println("==================================");
    }
}
