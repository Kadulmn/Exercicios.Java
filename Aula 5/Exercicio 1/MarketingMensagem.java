import java.util.ArrayList;
import java.util.List;

public class MarketingMensagem {
    private List<ServicoMensagem> servicos;
    
    public MarketingMensagem() {
        this.servicos = new ArrayList<>();
    }
    
    public void adicionarServico(ServicoMensagem servico) {
        this.servicos.add(servico);
    }
    
    public void enviarParaTodos(String mensagem) {
        for (ServicoMensagem servico : servicos) {
            servico.enviarMensagem(mensagem);
        }
    }
    
    // Métodos para adicionar serviços pré-configurados
    public void usarTodosServicos() {
        this.adicionarServico(new ServicoSMS());
        this.adicionarServico(new ServicoEmail());
        this.adicionarServico(new ServicoRedesSociais());
        this.adicionarServico(new ServicoWhatsApp());
    }
    
    public void usarApenasRedesSociais() {
        this.adicionarServico(new ServicoRedesSociais());
        this.adicionarServico(new ServicoWhatsApp());
    }
}
