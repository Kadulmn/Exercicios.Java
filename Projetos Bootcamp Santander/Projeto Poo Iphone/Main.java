/*
Projeto de Desafio POO

Modelando o iPhone com UML: Funções de Músicas, Chamadas e Internet

Autor: Kadulmn@hotmail.com
*/

public class Main {
    public static void main(String[] args) {
        iPhone meuIphone = new iPhone();

        // Testando Reprodutor Musical
        System.out.println("--- TESTANDO REPRODUTOR MUSICAL ---");
        meuIphone.selecionarMusica("Bohemian Rhapsody");
        meuIphone.tocarMusica();
        meuIphone.pausarMusica();

        // Testando Aparelho Telefônico
        System.out.println("\n--- TESTANDO APARELHO TELEFÔNICO ---");
        meuIphone.fazerLigacao("987654321");
        meuIphone.atenderLigacao();
        meuIphone.iniciarCorreioVoz();

        // Testando Navegador na Internet
        System.out.println("\n--- TESTANDO NAVEGADOR NA INTERNET ---");
        meuIphone.abrirPagina("https://www.dio.me");
        meuIphone.adicionarNovaAba();
        meuIphone.atualizarPagina();
    }
}