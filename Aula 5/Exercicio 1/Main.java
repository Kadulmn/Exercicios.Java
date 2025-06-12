/*
Resolução do exercicio 1 da Aula 5 de Java
 */
public class Main {
    public static void main(String[] args) {
        MarketingMensagem marketing = new MarketingMensagem();
        
        marketing.usarTodosServicos();
        
        String mensagemPromocional = "Promocao especial: 50% de desconto hoje!";
        marketing.enviarParaTodos(mensagemPromocional);
        
        System.out.println("\n--- Envio apenas para redes sociais ---");
        
        MarketingMensagem marketingRedes = new MarketingMensagem();
        marketingRedes.usarApenasRedesSociais();
        marketingRedes.enviarParaTodos("Novo post no blog: Confira nossas dicas!");
    }
}
