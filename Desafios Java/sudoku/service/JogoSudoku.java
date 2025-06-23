package sudoku.service;

import sudoku.model.Tabuleiro;
import sudoku.exception.MovimentoInvalidoException;

public class JogoSudoku {
    private Tabuleiro tabuleiro;
    private boolean jogoAtivo;

    public JogoSudoku() {
        this.tabuleiro = new Tabuleiro();
        this.jogoAtivo = true;
        inicializarJogo();
    }

    private void inicializarJogo() {
          int[][] exemplo = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        for (int linha = 0; linha < 9; linha++) {
            for (int coluna = 0; coluna < 9; coluna++) {
                if (exemplo[linha][coluna] != 0) {
                    tabuleiro.preencherCelula(linha, coluna, exemplo[linha][coluna]);
                }
            }
        }
    }

    public void processarComando(String comando) throws MovimentoInvalidoException {
        String[] partes = comando.split(" ");
        if (partes.length == 0) {
            throw new MovimentoInvalidoException("Comando inválido");
        }

        switch (partes[0].toLowerCase()) {
            case "preencher":
                if (partes.length != 4) {
                    throw new MovimentoInvalidoException("Uso: preencher <linha> <coluna> <valor>");
                }
                int linha = Integer.parseInt(partes[1]) - 1;
                int coluna = Integer.parseInt(partes[2]) - 1;
                int valor = Integer.parseInt(partes[3]);
                
                if (!RegrasSudoku.isMovimentoValido(tabuleiro, linha, coluna, valor)) {
                    throw new MovimentoInvalidoException("Movimento inválido!");
                }
                
                tabuleiro.preencherCelula(linha, coluna, valor);
                break;
                
            case "limpar":
                if (partes.length != 3) {
                    throw new MovimentoInvalidoException("Uso: limpar <linha> <coluna>");
                }
                linha = Integer.parseInt(partes[1]) - 1;
                coluna = Integer.parseInt(partes[2]) - 1;
                tabuleiro.limparCelula(linha, coluna);
                break;
                
            case "sair":
                jogoAtivo = false;
                break;
                
            default:
                throw new MovimentoInvalidoException("Comando desconhecido: " + partes[0]);
        }
    }

    public boolean isJogoAtivo() {
        return jogoAtivo;
    }

    public void exibirTabuleiro() {
        tabuleiro.exibirTabuleiro();
    }

    public boolean verificarVitoria() {
        return RegrasSudoku.isTabuleiroCompleto(tabuleiro);
    }
}