/*
Exercicio 1 Aula 3
Criar um banco interativo para os clientes com algumas regras e opções.
enunciado no Github no Readme
 */
import java.util.Scanner;

record ContaBancaria(double saldo, double chequeEspecial, double chequeEspecialUsado) {

    public static ContaBancaria criarConta(double depositoInicial) {
        double chequeEspecial = depositoInicial <= 500 ? 50 : depositoInicial * 0.5;
        return new ContaBancaria(depositoInicial, chequeEspecial, 0);
    }

    public ContaBancaria depositar(double valor) {
        double novoSaldo = saldo + valor;
        double novoChequeUsado = chequeEspecialUsado;
        
        if (chequeEspecialUsado > 0) {
            double valorParaAbater = Math.min(valor, chequeEspecialUsado);
            novoChequeUsado -= valorParaAbater;
            novoSaldo -= valorParaAbater * 0.2;
        }
        
        return new ContaBancaria(novoSaldo, chequeEspecial, novoChequeUsado);
    }

    public ContaBancaria sacar(double valor) {
        if (valor <= saldo) {
            return new ContaBancaria(saldo - valor, chequeEspecial, chequeEspecialUsado);
        } else {
            double valorRestante = valor - saldo;
            if (valorRestante <= (chequeEspecial - chequeEspecialUsado)) {
                return new ContaBancaria(0, chequeEspecial, chequeEspecialUsado + valorRestante);
            } else {
                throw new IllegalArgumentException("Saldo e cheque especial insuficientes");
            }
        }
    }

    public ContaBancaria pagarBoleto(double valor) {
        return sacar(valor);
    }

    public boolean estaUsandoChequeEspecial() {
        return saldo < 0 || chequeEspecialUsado > 0;
    }
}

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Banco Digital!");
        
        System.out.print("Digite o valor do depósito inicial: ");
        double depositoInicial = scanner.nextDouble();
        ContaBancaria conta = ContaBancaria.criarConta(depositoInicial);
        
        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consultar cheque especial");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Pagar boleto");
            System.out.println("6. Verificar uso do cheque especial");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.printf("Saldo atual: R$%.2f%n", conta.saldo());
                    break;
                    
                case 2:
                    System.out.printf("Cheque especial disponível: R$%.2f%n", 
                                    conta.chequeEspecial() - conta.chequeEspecialUsado());
                    break;
                    
                case 3:
                    System.out.println("Digite o valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta = conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                    
                case 4:
                    System.out.println("Digite o valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    try {
                        conta = conta.sacar(valorSaque);
                        System.out.println("Saque realizado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                    
                case 5:
                    System.out.println("Digite o valor do boleto: ");
                    double valorBoleto = scanner.nextDouble();
                    try {
                        conta = conta.pagarBoleto(valorBoleto);
                        System.out.println("Boleto pago com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                    
                case 6:
                    if (conta.estaUsandoChequeEspecial()) {
                        System.out.println("A conta está usando cheque especial");
                        System.out.printf("Valor utilizado: R$%.2f%n", conta.chequeEspecialUsado());
                    } else {
                        System.out.println("A conta não está usando cheque especial");
                    }
                    break;
                    
                case 0:
                    System.out.println("Obrigado por usar nossos serviços!");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
            
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
                scanner.nextLine();
            }
        } while (opcao != 0);
        
        scanner.close();
    }
}
