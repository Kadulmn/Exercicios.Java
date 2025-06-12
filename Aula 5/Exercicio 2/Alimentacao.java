public class Alimentacao extends Produto {
    public Alimentacao(String nome, double preco) {
        super(nome, preco, "Alimentacao");
    }

    @Override
    public double calcularTributo() {
        return preco * 0.01;
    }
}