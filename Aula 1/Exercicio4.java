/*
Exercicio 4
Escreva um código que receba o nome e a idade de 2 pessoas
imprima a diferença de idade entre elas
 */
import java.util.Scanner;
        
public class Exercicio4 {


    public static void main(String args[]) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("calculo de diferenca de idade");
        System.out.println("quem e a primeira pessoa:");
        String P1 = scanner.nextLine();
        System.out.println("qual a idade da primeira pessoa:");
        int I1 = scanner.nextInt();
        scanner.nextLine(); /* Usei deepseker para entender que nextInt
        não consome o enter, sobrando para o proximo scanner ler ele,
        por isso sem essa linha o codigo apresentará erro no "cadastro" da nova
        pessoa
        */
        System.out.println("quem e a segunda pessoa:");
        String P2 = scanner.nextLine();
        System.out.println("qual a idade da segunda pessoa:");
        int I2 = scanner.nextInt();
        
        if(I1>I2){
            System.out.print(P1+" e mais velha que que "+P2);
        }else if(I2==I1){
            System.out.print(P1+" e "+P2+" tem a mesma idade.");
        }else{
            System.out.print(P2+" e mais velha que "+P1);
        }
    }
}
