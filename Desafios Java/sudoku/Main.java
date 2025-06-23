/*
Desafio Sudoku 
 */

package sudoku;

import sudoku.service.JogoSudoku;
import sudoku.exception.MovimentoInvalidoException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JogoSudoku jogo = new JogoSudoku();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bem-vindo ao Sudoku!");
        System.out.println("Comandos disponíveis:");
        System.out.println("- preencher <linha> <coluna> <valor>");
        System.out.println("- limpar <linha> <coluna>");
        System.out.println("- sair");
        
        while (jogo.isJogoAtivo()) {
            jogo.exibirTabuleiro();
            System.out.print("> ");
            String comando = scanner.nextLine();
            
            try {
                jogo.processarComando(comando);
                
                if (jogo.verificarVitoria()) {
                    jogo.exibirTabuleiro();
                    System.out.println("Parabéns! Você completou o Sudoku!");
                    jogo.processarComando("sair");
                }
            } catch (MovimentoInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Valores devem ser números inteiros");
            }
        }
        
        System.out.println("Obrigado por jogar!");
        scanner.close();
    }
}