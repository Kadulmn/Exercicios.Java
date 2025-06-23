package sudoku.model;

public class Celula {
    private int linha;
    private int coluna;
    private int valor;
    private boolean fixo; // Para células pré-definidas (não podem ser alteradas)

    public Celula(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.valor = 0;
        this.fixo = false;
    }

    // Getters e Setters
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if (!this.fixo) {
            this.valor = valor;
        }
    }

    public boolean isFixo() {
        return fixo;
    }

    public void setFixo(boolean fixo) {
        this.fixo = fixo;
    }
}