public class iPhone {
    private IReprodutorMusical reprodutor;
    private IAparelhoTelefonico telefone;
    private INavegadorInternet navegador;

    public iPhone() {
        this.reprodutor = new ReprodutorMusicalImpl();
        this.telefone = new AparelhoTelefonicoImpl();
        this.navegador = new NavegadorInternetImpl();
    }

    // Métodos do Reprodutor Musical
    public void tocarMusica() {
        reprodutor.tocar();
    }

    public void pausarMusica() {
        reprodutor.pausar();
    }

    public void selecionarMusica(String musica) {
        reprodutor.selecionarMusica(musica);
    }

    // Métodos do Aparelho Telefônico
    public void fazerLigacao(String numero) {
        telefone.ligar(numero);
    }

    public void atenderLigacao() {
        telefone.atender();
    }

    public void iniciarCorreioVoz() {
        telefone.iniciarCorreioVoz();
    }

    // Métodos do Navegador na Internet
    public void abrirPagina(String url) {
        navegador.exibirPagina(url);
    }

    public void adicionarNovaAba() {
        navegador.adicionarNovaAba();
    }

    public void atualizarPagina() {
        navegador.atualizarPagina();
    }
}
