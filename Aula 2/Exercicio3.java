/*
Exercicio3 aula2 
 usuário entre com um primeiro número, um segundo número maior que o primeiro
escolhe entre a opção par e impar, com isso o código deve informar todos os números pares ou ímpares
no intervalo de números informados, incluindo os números informados e em ordem decrescente;
*/
import java.util.Scanner;

public class Exercicio3 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro numero: ");
        int numero1 = scanner.nextInt();
        int numero2;
        do {
            System.out.println("Digite o segundo numero (deve ser maior que " + numero1 + "): ");
            numero2 = scanner.nextInt();
        } while (numero2 <= numero1);

        int escolha;
        do {
            System.out.println("Escolha:");
            System.out.println("1 - Numeros impares");
            System.out.println("2 - Numeros pares");
            System.out.print("Opcao: ");
            escolha = scanner.nextInt();
        } while (escolha != 1 && escolha != 2);
        System.out.println("Resultado:");
        for (int i = numero2; i >= numero1; i--) {
            if ((escolha == 1 && i % 2 != 0) || (escolha == 2 && i % 2 == 0)) {
                System.out.println(i + " ");
            }
        }
    }
}

