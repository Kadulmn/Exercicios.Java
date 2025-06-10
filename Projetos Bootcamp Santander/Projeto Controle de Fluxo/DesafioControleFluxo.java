/*
PROJETO DE AUTORIA DO:
KADU LOYOLA DE MELO NOGUEIRA
correção do exercicio proposto no Readme
 */

import java.util.Scanner;

public class DesafioControleFluxo {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        
        System.out.println("Digite o primeiro parametro");
        int parametroUm = terminal.nextInt();
        
        System.out.println("Digite o segundo parametro");
        int parametroDois = terminal.nextInt();
        
        try {
            // Chamando o método contendo a lógica de contagem
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException exception) {
            // Imprimir a mensagem de erro
            System.out.println(exception.getMessage());
        } finally {
            terminal.close();
        }
    }
    
    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Validar se parametroUm é MAIOR que parametroDois
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parametro deve ser maior que o primeiro");
        }
        
        int contagem = parametroDois - parametroUm;
        
        // Realizar o for para imprimir os números
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o numero " + i);
        }
    }
}
