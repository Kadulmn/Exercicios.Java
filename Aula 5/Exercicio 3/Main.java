/*
Resolução do Exercicio 3 Aula 5 
 */

public class Main {
    public static void main(String[] args) {
        CalculadoraArea calculadora = new CalculadoraArea();
        
        // Adicionando figuras geométricas
        calculadora.adicionarFigura(new Quadrado(5.0));
        calculadora.adicionarFigura(new Retangulo(4.0, 6.0));
        calculadora.adicionarFigura(new Circulo(3.0));
        calculadora.adicionarFigura(new Quadrado(2.5));
        calculadora.adicionarFigura(new Retangulo(3.0, 7.0));
        calculadora.adicionarFigura(new Circulo(4.5));
        
        // Exibindo resultados
        calculadora.exibirAreas();
    }
}