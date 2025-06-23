package sudoku.service;

import sudoku.model.Tabuleiro;
import sudoku.exception.MovimentoInvalidoException;

public class RegrasSudoku {
    public static boolean isMovimentoValido(Tabuleiro tabuleiro, int linha, int coluna, int valor) {
        if (tabuleiro.getValorCelula(linha, coluna) != 0) {
            return false;
        }

        for (int c = 0; c < 9; c++) {
            if (tabuleiro.getValorCelula(linha, c) == valor) {
                return false;
            }
        }

        for (int l = 0; l < 9; l++) {
            if (tabuleiro.getValorCelula(l, coluna) == valor) {
                return false;
            }
        }

        int blocoLinha = linha - linha % 3;
        int blocoColuna = coluna - coluna % 3;
        
        for (int l = blocoLinha; l < blocoLinha + 3; l++) {
            for (int c = blocoColuna; c < blocoColuna + 3; c++) {
                if (tabuleiro.getValorCelula(l, c) == valor) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isTabuleiroCompleto(Tabuleiro tabuleiro) {
        for (int linha = 0; linha < 9; linha++) {
            for (int coluna = 0; coluna < 9; coluna++) {
                if (tabuleiro.getValorCelula(linha, coluna) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}