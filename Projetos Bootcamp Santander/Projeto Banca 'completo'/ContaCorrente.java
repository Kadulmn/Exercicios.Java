public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, double chequeEspecial) {
        super(cliente);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        double saldoDisponivel = saldo + chequeEspecial;
        if (saldoDisponivel >= valor) {
            saldo -= valor;
            extrato.add("Saque: -" + valor);
        } else {
            System.out.println("Saldo + cheque especial insuficiente!");
        }
    }

    @Override
    public void imprimirInfosEspecificas() {
        System.out.println("=== Conta Corrente ===");
        System.out.println(String.format("Cheque Especial: %.2f", this.chequeEspecial));
    }
}
