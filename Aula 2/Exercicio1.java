/*
Exercicio 1 Aula 2
Escreva um código onde o usuário entra com um número
e seja gerada a tabuada de 1 até 10 desse número;
 */
import java.util.Scanner;
        
public class Exercicio1 {

    public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite um numero para gerar uma tabuada:");
    int N = scanner.nextInt();
    System.out.println("Digite o numero da ultima multiplicacao da tabuada:");
    int z = scanner.nextInt();
    
    System.out.println(" Tabuada do "+N);
    System.out.println("----------------");
        for(int i=1; i<=z; i++){
        int resultado = N*i;
        
        System.out.println(N+"x"+i+"="+resultado);
    } 
    }
}
