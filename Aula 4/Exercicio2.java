/*
Exercicio 2 Aula 4
Herança e polimorfismo
 */

abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected boolean isAdministrador;

    public Usuario(String nome, String email, String senha, boolean isAdministrador) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAdministrador = isAdministrador;
    }
    
 public boolean realizarLogin(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public void realizarLogoff() {
        System.out.println("Usuário " + nome + " deslogado com sucesso.");
    }

    public void alterarDados(String novoNome, String novoEmail) {
        this.nome = novoNome;
        this.email = novoEmail;
        System.out.println("Dados atualizados com sucesso.");
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Senha alterada com sucesso.");
    }
    
public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdministrador() {
        return isAdministrador;
    }
    
 public abstract void exibirInformacoes();
}


class Gerente extends Usuario {
    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha, true); 
    }


    public void gerarRelatorioFinanceiro() {
        System.out.println("Relatório financeiro gerado por " + nome);
    }

    public void consultarVendas() {
        System.out.println("Consultando vendas totais...");
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("\n=== GERENTE ===");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Tipo: Administrador");
    }
}


class Vendedor extends Usuario {
    private int quantidadeVendas;

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha, false);
        this.quantidadeVendas = 0;
    }

    
    public void realizarVenda() {
        quantidadeVendas++;
        System.out.println("Venda realizada com sucesso por " + nome);
    }

    public void consultarVendas() {
        System.out.println("Total de vendas: " + quantidadeVendas);
    }

    
    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("\n=== VENDEDOR ===");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Total de vendas: " + quantidadeVendas);
        System.out.println("Tipo: Não administrador");
    }
}


class Atendente extends Usuario {
    private double valorEmCaixa;

    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha, false);
        this.valorEmCaixa = 0.0;
    }


    public void receberPagamento(double valor) {
        valorEmCaixa += valor;
        System.out.println("Pagamento de R$" + valor + " recebido por " + nome);
    }

    public void fecharCaixa() {
        System.out.println("Caixa fechado por " + nome + ". Total: R$" + valorEmCaixa);
        valorEmCaixa = 0.0;
    }

  
    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("\n=== ATENDENTE ===");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Valor em caixa: R$" + valorEmCaixa);
        System.out.println("Tipo: Não administrador");
    }
}

public class Exercicio2 {
    public static void main(String[] args) {
    
        Gerente gerente = new Gerente("Kadu Nogueira", "Kadulmn@hotmail.com", "Senhasenha");
        Vendedor vendedor = new Vendedor("Arthur Corazza", "Arthur@empresa.com", "senhaSenha");
        Atendente atendente = new Atendente("Anilson Nogueira", "Anilson@empresa.com", "SenhaSenha");

        gerente.exibirInformacoes();
        gerente.gerarRelatorioFinanceiro();
        gerente.consultarVendas();

        vendedor.exibirInformacoes();
        vendedor.realizarVenda();
        vendedor.realizarVenda();
        vendedor.consultarVendas();

        atendente.exibirInformacoes();
        atendente.receberPagamento(150.50);
        atendente.receberPagamento(89.90);
        atendente.fecharCaixa();

        Usuario[] usuarios = {gerente, vendedor, atendente};
        System.out.println("\n=== LISTA DE USUÁRIOS ===");
        for (Usuario usuario : usuarios) {
            usuario.exibirInformacoes();
            System.out.println("----------------------");
        }
    }
}