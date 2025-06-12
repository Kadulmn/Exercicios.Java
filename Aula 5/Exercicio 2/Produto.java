public abstract class Produto implements Tributavel {
    protected String nome;
    protected double preco;
    protected String tipo;

    public Produto(String nome, double preco, String tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public abstract double calcularTributo();

    @Override
    public String toString() {
        return String.format("%s - %s: R$%.2f (Tributo: R$%.2f)", 
               tipo, nome, preco, calcularTributo());
    }
}