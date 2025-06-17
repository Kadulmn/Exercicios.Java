import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<String> extrato;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.extrato = new ArrayList<>();
        this.extrato.add("Conta criada com sucesso");
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            extrato.add("Saque: -" + valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
        extrato.add("Deposito: +" + valor);
    }

    public void transferir(double valor, Conta contaDestino) {
        if (saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            extrato.add("Transferencia para conta " + contaDestino.numero + ": -" + valor);
        } else {
            System.out.println("Saldo insuficiente para transferencia!");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public void imprimirExtrato() {
        System.out.println("\n=== Extrato da Conta ===");
        imprimirInfosComuns();
        System.out.println("\nTransacoes:");
        extrato.forEach(System.out::println);
    }

    // Método abstrato 
    public abstract void imprimirInfosEspecificas();
}