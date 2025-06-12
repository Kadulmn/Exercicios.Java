public class Cultura extends Produto {
    public Cultura(String nome, double preco) {
        super(nome, preco, "Cultura");
    }

    @Override
    public double calcularTributo() {
        return preco * 0.04;
    }
}
