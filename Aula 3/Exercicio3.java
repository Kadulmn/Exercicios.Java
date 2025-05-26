/*
Exercicio 3 Aula 3 
controle de pet shop
 */
import java.util.Scanner;

record MaquinaBanho(boolean petPresente, boolean petLimpo, int nivelAgua, int nivelShampoo) {

    // Constantes do sistema
    private static final int CAPACIDADE_MAX_AGUA = 30;
    private static final int CAPACIDADE_MAX_SHAMPOO = 10;
    private static final int CONSUMO_BANHO_AGUA = 10;
    private static final int CONSUMO_BANHO_SHAMPOO = 2;
    private static final int CONSUMO_LIMPEZA_AGUA = 3;
    private static final int CONSUMO_LIMPEZA_SHAMPOO = 1;
    private static final int ABASTECIMENTO_PASSO = 2;

    public static MaquinaBanho criarMaquina() {
        return new MaquinaBanho(false, true, 0, 0);
    }

    // Operações principais
    public MaquinaBanho colocarPet() {
        if (petPresente) {
            System.out.println("Já há um pet na máquina!");
            return this;
        }
        if (!petLimpo) {
            System.out.println("Máquina precisa ser limpa antes de receber outro pet!");
            return this;
        }
        return new MaquinaBanho(true, false, nivelAgua, nivelShampoo);
    }

    public MaquinaBanho retirarPet() {
        if (!petPresente) {
            System.out.println("Não há pet na máquina!");
            return this;
        }
        if (!petLimpo) {
            System.out.println("Pet retirado sem estar limpo! Máquina ficará suja.");
        }
        return new MaquinaBanho(false, petLimpo, nivelAgua, nivelShampoo);
    }

    public MaquinaBanho darBanho() {
        if (!petPresente) {
            System.out.println("Não há pet na máquina para dar banho!");
            return this;
        }
        if (nivelAgua < CONSUMO_BANHO_AGUA || nivelShampoo < CONSUMO_BANHO_SHAMPOO) {
            System.out.println("Recursos insuficientes para o banho!");
            return this;
        }
        return new MaquinaBanho(petPresente, true, 
                              nivelAgua - CONSUMO_BANHO_AGUA, 
                              nivelShampoo - CONSUMO_BANHO_SHAMPOO);
    }

    public MaquinaBanho limparMaquina() {
        if (petPresente) {
            System.out.println("Não pode limpar com pet na máquina!");
            return this;
        }
        if (nivelAgua < CONSUMO_LIMPEZA_AGUA || nivelShampoo < CONSUMO_LIMPEZA_SHAMPOO) {
            System.out.println("Recursos insuficientes para limpeza!");
            return this;
        }
        return new MaquinaBanho(false, true, 
                              nivelAgua - CONSUMO_LIMPEZA_AGUA, 
                              nivelShampoo - CONSUMO_LIMPEZA_SHAMPOO);
    }

    // Operações de abastecimento
    public MaquinaBanho abastecerAgua() {
        int novoNivel = Math.min(nivelAgua + ABASTECIMENTO_PASSO, CAPACIDADE_MAX_AGUA);
        if (novoNivel == nivelAgua) {
            System.out.println("Tanque de água já está cheio!");
        }
        return new MaquinaBanho(petPresente, petLimpo, novoNivel, nivelShampoo);
    }

    public MaquinaBanho abastecerShampoo() {
        int novoNivel = Math.min(nivelShampoo + ABASTECIMENTO_PASSO, CAPACIDADE_MAX_SHAMPOO);
        if (novoNivel == nivelShampoo) {
            System.out.println("Tanque de shampoo já está cheio!");
        }
        return new MaquinaBanho(petPresente, petLimpo, nivelAgua, novoNivel);
    }

    // Verificações
    public void verificarNiveis() {
        System.out.println("\n=== NÍVEIS ATUAIS ===");
        System.out.println("Água: " + nivelAgua + "/" + CAPACIDADE_MAX_AGUA + " litros");
        System.out.println("Shampoo: " + nivelShampoo + "/" + CAPACIDADE_MAX_SHAMPOO + " litros");
        System.out.println("Estado: " + (petLimpo ? "Limpo" : "Sujo"));
        System.out.println("Pet: " + (petPresente ? "Presente" : "Ausente"));
    }
}

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaquinaBanho maquina = MaquinaBanho.criarMaquina();
        
        int opcao;
        do {
            System.out.println("\n=== MÁQUINA DE BANHO ===");
            System.out.println("1. Colocar pet na máquina");
            System.out.println("2. Retirar pet da máquina");
            System.out.println("3. Dar banho no pet");
            System.out.println("4. Abastecer água");
            System.out.println("5. Abastecer shampoo");
            System.out.println("6. Verificar níveis");
            System.out.println("7. Limpar máquina");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    maquina = maquina.colocarPet();
                    break;
                    
                case 2:
                    maquina = maquina.retirarPet();
                    break;
                    
                case 3:
                    maquina = maquina.darBanho();
                    break;
                    
                case 4:
                    maquina = maquina.abastecerAgua();
                    break;
                    
                case 5:
                    maquina = maquina.abastecerShampoo();
                    break;
                    
                case 6:
                    maquina.verificarNiveis();
                    break;
                    
                case 7:
                    maquina = maquina.limparMaquina();
                    break;
                    
                case 0:
                    System.out.println("Desligando sistema...");
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
