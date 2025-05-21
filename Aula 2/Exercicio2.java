/*
Exercicio 2 aula 2
Escreva um código onde o usuário entra com sua altura e peso,
seja feito o calculo do seu IMC(IMC = peso/(altura * altura))
e seja exibida a mensagem de acordo com o resultado:
*/
import java.util.Scanner;

public class Exercicio2 {

    public static void main(String args[]) {
    Scanner scanner=new Scanner(System.in);
    
    System.out.println("Calculadora de IMC");
    System.out.println("digite o seu peso em kg:");
    float P = scanner.nextFloat();
    
    System.out.println("digite a sua altura em M:");
    float A  = scanner.nextFloat();
    
    float IMC ;
    IMC = P/(A*A);
    System.out.printf("Seu IMC é: %.2f%n", IMC); 
        
        if(IMC < 18.5) {
            System.out.println("Abaixo do peso");
        } else if(IMC >= 18.5 && IMC <= 24.9) {
            System.out.println("Peso ideal");
        } else if(IMC > 24.9 && IMC <= 29.9) {
            System.out.println("Levemente acima do peso");
        } else if(IMC > 29.9 && IMC <= 34.9) {
            System.out.println("Obesidade grau 1");
        } else if(IMC > 34.9 && IMC <= 39.9) {
            System.out.println("Obesidade grau 2");
        } else {
            System.out.println("Obesidade grau 3");
        }
    }
}
