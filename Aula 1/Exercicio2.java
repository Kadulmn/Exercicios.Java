/*exercicio 2
Escreva um código que receba o tamanho do lado de um quadrado
calcule sua área e exiba na tela
fórmula: área=lado X lado
*/
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Calculo de area e perimetro de um quadrado \n" );
        System.out.print("Digite o tamanho do lado do quadrado: \n");
        int lado = scanner.nextInt();
        
        int area = lado * lado;
        int perimetro = lado * 4;
        System.out.printf("A area do quadrado e %d", area);
        System.out.printf("\ne o perimetro do quadrado e " + perimetro + ".");
        
        scanner.close();
    }
}
