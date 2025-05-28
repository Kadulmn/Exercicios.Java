/*
Exercicio 1 Aula 4, Herança e polismorfismo
Enunciado no Readme
 */

abstract class Ingresso {
    protected double valorBase;
    protected String nomeFilme;
    protected boolean isDublado;

    public Ingresso(double valorBase, String nomeFilme, boolean isDublado) {
        this.valorBase = valorBase;
        this.nomeFilme = nomeFilme;
        this.isDublado = isDublado;
    }
    
    public abstract double calcularValor();
    
    public void exibirIngresso() {
        System.out.println("\nFilme: " + nomeFilme);
        System.out.println("Tipo: " + (isDublado ? "Dublado" : "Legendado"));
        System.out.println("Valor base: R$" + valorBase);
    }
}

class IngressoNormal extends Ingresso {
    public IngressoNormal(double valorBase, String nomeFilme, boolean isDublado) {
        super(valorBase, nomeFilme, isDublado);
    }

    @Override
    public double calcularValor() {
        return valorBase;
    }

    @Override
    public void exibirIngresso() {
        super.exibirIngresso();
        System.out.println("Tipo de ingresso: Normal");
        System.out.println("Valor total: R$" + calcularValor());
    }
}

class IngressoMeia extends Ingresso {
    public IngressoMeia(double valorBase, String nomeFilme, boolean isDublado) {
        super(valorBase, nomeFilme, isDublado);
    }

    @Override
    public double calcularValor() {
        return valorBase / 2;
    }

    @Override
    public void exibirIngresso() {
        super.exibirIngresso();
        System.out.println("Tipo de ingresso: Meia");
        System.out.println("Valor total: R$" + calcularValor());
    }
}

class IngressoFamilia extends Ingresso {
    private int quantidadePessoas;

    public IngressoFamilia(double valorBase, String nomeFilme, boolean isDublado, int quantidadePessoas) {
        super(valorBase, nomeFilme, isDublado);
        this.quantidadePessoas = quantidadePessoas;
    }

    @Override
    public double calcularValor() {
        double valorTotal = valorBase * quantidadePessoas;
        if (quantidadePessoas > 3) {
            valorTotal *= 0.95; 
        }
        return valorTotal;
    }

    @Override
    public void exibirIngresso() {
        super.exibirIngresso();
        System.out.println("Tipo de ingresso: Família (" + quantidadePessoas + " pessoas)");
        System.out.println("Valor total: R$" + calcularValor());
    }
}

public class Exercicio1 {
    public static void main(String[] args) {
       
        Ingresso[] ingressos = new Ingresso[3];
        
        ingressos[0] = new IngressoNormal(32.0, "Interestelar", false);
        ingressos[1] = new IngressoMeia(32.0, "O Poderoso Chefão", false);
        ingressos[2] = new IngressoFamilia(32.0, "Clube da Luta", true, 4);
        
        
        for (Ingresso ingresso : ingressos) {
            ingresso.exibirIngresso();
            System.out.println("----------------------");
        }
        
       
        System.out.println("\nDetalhes dos valores:");
        for (Ingresso ingresso : ingressos) {
            System.out.println("Tipo: " + ingresso.getClass().getSimpleName() + 
                             " - Valor calculado: R$" + ingresso.calcularValor());
        }
    }
}