package sudoku.model;

public class Tabuleiro {
    private Celula[][] celulas;
    private static final int TAMANHO = 9;

    public Tabuleiro() {
        celulas = new Celula[TAMANHO][TAMANHO];
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int linha = 0; linha < TAMANHO; linha++) {
            for (int coluna = 0; coluna < TAMANHO; coluna++) {
                celulas[linha][coluna] = new Celula(linha, coluna);
            }
        }
    }

    public void preencherCelula(int linha, int coluna, int valor) {
        if (linha >= 0 && linha < TAMANHO && coluna >= 0 && coluna < TAMANHO) {
            celulas[linha][coluna].setValor(valor);
        }
    }

    public int getValorCelula(int linha, int coluna) {
        return celulas[linha][coluna].getValor();
    }

    public void limparCelula(int linha, int coluna) {
        celulas[linha][coluna].setValor(0);
    }

    public void exibirTabuleiro() {
        System.out.println(" -----------------------");
        for (int linha = 0; linha < TAMANHO; linha++) {
            System.out.print("| ");
            for (int coluna = 0; coluna < TAMANHO; coluna++) {
                int valor = celulas[linha][coluna].getValor();
                System.out.print(valor == 0 ? " " : valor);
                System.out.print(" ");
                if ((coluna + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((linha + 1) % 3 == 0) {
                System.out.println(" -----------------------");
            }
        }
    }
}