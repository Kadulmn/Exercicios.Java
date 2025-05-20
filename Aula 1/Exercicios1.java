import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite seu ano de nascimento: ");
        int anoNascimento = scanner.nextInt();

        int idade = 2025 - anoNascimento; // substituir pelo ano atual
        System.out.println("Olá " + nome + ", você tem " + idade + " anos.");
    }
}