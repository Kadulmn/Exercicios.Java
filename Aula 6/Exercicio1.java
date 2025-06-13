/*
Resolução do Exercicio 1 Aula 6
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Calculadora - Soma e Subtracao");
            System.out.println("Digite os numeros separados por virgula:");
            String entrada = scanner.nextLine();
    
            List<Double> numeros = parseNumeros(entrada);
            
            if (numeros.isEmpty()) {
                System.out.println("Nenhum numero valido foi informado.");
                return;
            }
            
            System.out.println("\n Escolha a operacao:");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtracao");
            System.out.print("Opcao: ");
            int opcao = scanner.nextInt();
            
            double resultado;
            switch (opcao) {
                case 1:
                    resultado = calcularSoma(numeros);
                    System.out.println("\nResultado da soma: " + resultado);
                    break;
                case 2:
                    resultado = calcularSubtracao(numeros);
                    System.out.println("\nResultado da subtracao: " + resultado);
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }
    
    // Método para converter a string de entrada em uma lista de números
    private static List<Double> parseNumeros(String entrada) {
        List<Double> numeros = new ArrayList<>();
        String[] partes = entrada.split(",");
        
        for (String parte : partes) {
            try {
                double numero = Double.parseDouble(parte.trim());
                numeros.add(numero);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido ignorado: " + parte);
            }
        }
        
        return numeros;
    }
    
    private static double calcularSoma(List<Double> numeros) {
        double soma = 0;
        for (double numero : numeros) {
            soma += numero;
        }
        return soma;
    }
    
    private static double calcularSubtracao(List<Double> numeros) {
        if (numeros.isEmpty()) return 0;
        
        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado -= numeros.get(i);
        }
        return resultado;
    }
}
