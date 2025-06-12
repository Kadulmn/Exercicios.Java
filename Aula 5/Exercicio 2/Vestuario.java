public class Vestuario extends Produto {
    public Vestuario(String nome, double preco) {
        super(nome, preco, "Vestuario");
    }

    @Override
    public double calcularTributo() {
        return preco * 0.025;
    }
}
