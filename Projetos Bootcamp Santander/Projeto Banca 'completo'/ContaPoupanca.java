public class ContaPoupanca extends Conta {
    private double rendimento;

    public ContaPoupanca(Cliente cliente, double rendimento) {
        super(cliente);
        this.rendimento = rendimento;
    }

    public void aplicarRendimento() {
        double rendimentoValor = saldo * rendimento;
        saldo += rendimentoValor;
        extrato.add("Rendimento: +" + rendimentoValor);
    }

    @Override
    public void imprimirInfosEspecificas() {
        System.out.println("=== Conta Poupanca ===");
        System.out.println(String.format("Taxa de Rendimento: %.2f%%", this.rendimento * 100));
    }
}
