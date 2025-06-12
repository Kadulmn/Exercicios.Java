public class SaudeBemEstar extends Produto {
    public SaudeBemEstar(String nome, double preco) {
        super(nome, preco, "Saude e Bem Estar");
    }

    @Override
    public double calcularTributo() {
        return preco * 0.015;
    }
}
