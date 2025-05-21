/*
exercicio 4 aula 2
Escreva um código onde o usuário informa um número inicial,
posteriormente irá informar outros N números,
a execução do código irá continuar até que o número informado 
dividido pelo primeiro número tenha resto diferente de 0 na divisão,
números menores que o primeiro número devem ser ignorados
 */
import java.util.Scanner;

public class exercicio4 {

    public static void main(String args[]) {
    Scanner scanner= new Scanner(System.in);
    
    System.out.println("informe um numero:");
    int N = scanner.nextInt();
    
    int N2;
    do{
    do{
        System.out.println("escreva outro numero:");
        N2 = scanner.nextInt();
    }while(N > N2);
    }while(N2 % N ==0);
    System.out.println("numero informado nao da resultado inteiro quando divido");
    }
}
