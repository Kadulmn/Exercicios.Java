public class ServicoRedesSociais implements ServicoMensagem {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Postando em Redes Sociais: " + mensagem);
    }
}
