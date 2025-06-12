import java.util.ArrayList;
import java.util.List;

public class CalculadoraTributos {
    private List<Tributavel> produtos;

    public CalculadoraTributos() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Tributavel produto) {
        produtos.add(produto);
    }

    public double calcularTotalTributos() {
        double total = 0;
        for (Tributavel produto : produtos) {
            total += produto.calcularTributo();
        }
        return total;
    }

    public void exibirTributosPorProduto() {
        for (Tributavel produto : produtos) {
            System.out.println(produto.toString());
        }
    }

    public void exibirResumoPorCategoria() {
        System.out.println("\nResumo de Tributos por Categoria:");
        System.out.println("--------------------------------");
        
        double totalAlimentacao = 0;
        double totalSaude = 0;
        double totalVestuario = 0;
        double totalCultura = 0;
        
        for (Tributavel produto : produtos) {
            switch (produto.getTipo()) {
                case "Alimentacao":
                    totalAlimentacao += produto.calcularTributo();
                    break;
                case "Saude e Bem Estar":
                    totalSaude += produto.calcularTributo();
                    break;
                case "Vestuario":
                    totalVestuario += produto.calcularTributo();
                    break;
                case "Cultura":
                    totalCultura += produto.calcularTributo();
                    break;
            }
        }
        
        System.out.printf("Alimentacao: R$%.2f\n", totalAlimentacao);
        System.out.printf("Saude e Bem Estar: R$%.2f\n", totalSaude);
        System.out.printf("Vestuario: R$%.2f\n", totalVestuario);
        System.out.printf("Cultura: R$%.2f\n", totalCultura);
        System.out.printf("TOTAL GERAL: R$%.2f\n", 
            totalAlimentacao + totalSaude + totalVestuario + totalCultura);
    }
}
