import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void abrirConta(Conta conta) {
        contas.add(conta);
        System.out.println("Conta aberta com sucesso!");
    }

    public void listarContas() {
        System.out.println("\n=== Lista de Contas do Banco " + nome + " ===");
        for (Conta conta : contas) {
            conta.imprimirInfosComuns();
            conta.imprimirInfosEspecificas();
            System.out.println();
        }
    }

    // Demonstração de polimorfismo
    public void realizarOperacoes() {
        System.out.println("\n=== Operacoes Bancarias ===");
        for (Conta conta : contas) {
            conta.imprimirInfosEspecificas();
            
            if (conta instanceof ContaPoupanca) {
                ((ContaPoupanca) conta).aplicarRendimento();
            }
        }
    }
}
