/*
Exercicio 3
Escreva um código que receba a base e a alturade um retângulo
calcule sua área e exiba na tela  fórmula: área=base X altura
 */
import java.util.Scanner;

public class Exercicio3 {

    public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("calculo de area e perimetro de retangulo \n");
    System.out.println("digite a altura do retangulo: \n");
    int Altura = scanner.nextInt ();
    System.out.println("\ndigite a largura do retangulo: \n");
    int Largura = scanner.nextInt () ; 
    
    int Area = Altura * Largura;
    int Perimetro = (Altura*2) + (Largura*2);
    
    System.out.printf("a area do retangulo e %d", Area);
    System.out.printf("\no perimetro do retangulo e "+Perimetro);
    }
}
