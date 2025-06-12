/*
Resolução Exercicio 2 Aula 5
 */

public class Main {
    public static void main(String[] args) {
        CalculadoraTributos calculadora = new CalculadoraTributos();
        
        calculadora.adicionarProduto(new Alimentacao("Arroz 5kg", 25.90));
        calculadora.adicionarProduto(new Alimentacao("Feijao 1kg", 8.50));
        calculadora.adicionarProduto(new SaudeBemEstar("Vitamina C", 19.90));
        calculadora.adicionarProduto(new Vestuario("Camiseta", 49.90));
        calculadora.adicionarProduto(new Vestuario("Calca Jeans", 129.90));
        calculadora.adicionarProduto(new Cultura("Livro - Java OO", 89.90));
        calculadora.adicionarProduto(new Cultura("Ingresso Cinema", 32.00));
        
        System.out.println("Tributos por Produto:");
        System.out.println("--------------------");
        calculadora.exibirTributosPorProduto();
        
        calculadora.exibirResumoPorCategoria();
    }
}
