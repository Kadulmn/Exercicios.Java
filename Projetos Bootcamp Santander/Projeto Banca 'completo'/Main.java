/*
Resolução do Desafio de criação de um "banco"
usando a Resolução presente no Readme
"Criação do Banco"
 */

public class Main {
    public static void main(String[] args) {
        
        Banco banco = new Banco("Kadu Bank");

        Cliente cliente1 = new Cliente("Kadu Loyola", "123.456.789-00");
        Cliente cliente2 = new Cliente("Yuri Alberto", "987.654.321-00");

        Conta cc = new ContaCorrente(cliente1, 1000);
        Conta cp = new ContaPoupanca(cliente2, 0.005); 

        banco.abrirConta(cc);
        banco.abrirConta(cp);

        cc.depositar(500);
        cc.sacar(200);
        cc.transferir(100, cp);

        cp.depositar(1000);
        cp.sacar(100);

        banco.listarContas();

        cc.imprimirExtrato();
        cp.imprimirExtrato();

        ((ContaPoupanca) cp).aplicarRendimento();

        banco.realizarOperacoes();
    }
}
