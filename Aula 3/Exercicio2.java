/*
Exercicio 2 Aula 3
Fazer um carro interativo
 */

import java.util.Scanner;

record Carro(boolean ligado, int velocidade, int marcha, String direcao) {

    public static Carro criarCarro() {
        return new Carro(false, 0, 0, "Frente");
    }

    public Carro ligar() {
        if (!ligado && marcha == 0 && velocidade == 0) {
            return new Carro(true, 0, 0, "Frente");
        }
        System.out.println("Só pode ligar o carro em ponto morto (marcha 0) e velocidade 0");
        return this;
    }

    public Carro desligar() {
        if (ligado && marcha == 0 && velocidade == 0) {
            return new Carro(false, 0, 0, "Frente");
        }
        System.out.println("Só pode desligar o carro em ponto morto (marcha 0) e velocidade 0");
        return this;
    }

    public Carro acelerar() {
        if (!ligado) return this;
        
        if (marcha == 0) {
            System.out.println("Não pode acelerar em ponto morto");
            return this;
        }

        int novaVelocidade = velocidade + 1;

        if ((marcha == 1 && novaVelocidade > 20) ||
            (marcha == 2 && (novaVelocidade < 21 || novaVelocidade > 40)) ||
            (marcha == 3 && (novaVelocidade < 41 || novaVelocidade > 60)) ||
            (marcha == 4 && (novaVelocidade < 61 || novaVelocidade > 80)) ||
            (marcha == 5 && (novaVelocidade < 81 || novaVelocidade > 100)) ||
            (marcha == 6 && (novaVelocidade < 101 || novaVelocidade > 120))) {
            System.out.println("Não pode acelerar além do limite da marcha atual");
            return this;
        }

        if (novaVelocidade > 120) {
            System.out.println("Velocidade máxima atingida (120km/h)");
            return this;
        }

        return new Carro(ligado, novaVelocidade, marcha, direcao);
    }

    public Carro reduzir() {
        if (!ligado) return this;
        
        int novaVelocidade = velocidade - 1;
        
        if (novaVelocidade < 0) {
            System.out.println("Velocidade mínima atingida (0km/h)");
            return this;
        }

        if ((marcha == 1 && novaVelocidade < 0) ||
            (marcha == 2 && novaVelocidade < 21) ||
            (marcha == 3 && novaVelocidade < 41) ||
            (marcha == 4 && novaVelocidade < 61) ||
            (marcha == 5 && novaVelocidade < 81) ||
            (marcha == 6 && novaVelocidade < 101)) {
            System.out.println("Velocidade abaixo do mínimo para a marcha atual. Reduza a marcha.");
            return this;
        }

        return new Carro(ligado, novaVelocidade, marcha, direcao);
    }

    public Carro virar(String novaDirecao) {
        if (!ligado) {
            System.out.println("Carro desligado não pode virar");
            return this;
        }
        
        if (velocidade < 1 || velocidade > 40) {
            System.out.println("Só pode virar entre 1km/h e 40km/h");
            return this;
        }
        
        return new Carro(ligado, velocidade, marcha, novaDirecao);
    }

    public Carro trocarMarcha(int novaMarcha) {
        if (!ligado) {
            System.out.println("Carro desligado não pode trocar marcha");
            return this;
        }
        
        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida (0-6)");
            return this;
        }
        
        if (Math.abs(novaMarcha - marcha) > 1) {
            System.out.println("Não pode pular marcha");
            return this;
        }

        if ((novaMarcha == 1 && (velocidade < 0 || velocidade > 20)) ||
            (novaMarcha == 2 && (velocidade < 21 || velocidade > 40)) ||
            (novaMarcha == 3 && (velocidade < 41 || velocidade > 60)) ||
            (novaMarcha == 4 && (velocidade < 61 || velocidade > 80)) ||
            (novaMarcha == 5 && (velocidade < 81 || velocidade > 100)) ||
            (novaMarcha == 6 && (velocidade < 101 || velocidade > 120))) {
            System.out.println("Velocidade inadequada para esta marcha");
            return this;
        }
        
        return new Carro(ligado, velocidade, novaMarcha, direcao);
    }
}

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carro carro = Carro.criarCarro();
        
        int opcao;
        do {
            System.out.println("\n=== CONTROLE DO CARRO ===");
            System.out.println("Estado: " + (carro.ligado() ? "Ligado" : "Desligado"));
            System.out.println("Marcha: " + carro.marcha());
            System.out.println("Velocidade: " + carro.velocidade() + "km/h");
            System.out.println("Direção: " + carro.direcao());
            System.out.println("1. Ligar");
            System.out.println("2. Desligar");
            System.out.println("3. Acelerar");
            System.out.println("4. Reduzir velocidade");
            System.out.println("5. Virar para esquerda");
            System.out.println("6. Virar para direita");
            System.out.println("7. Trocar marcha");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    carro = carro.ligar();
                    break;
                    
                case 2:
                    carro = carro.desligar();
                    break;
                    
                case 3:
                    carro = carro.acelerar();
                    break;
                    
                case 4:
                    carro = carro.reduzir();
                    break;
                    
                case 5:
                    carro = carro.virar("Esquerda");
                    break;
                    
                case 6:
                    carro = carro.virar("Direita");
                    break;
                    
                case 7:
                    System.out.print("Digite a nova marcha (0-6): ");
                    int novaMarcha = scanner.nextInt();
                    carro = carro.trocarMarcha(novaMarcha);
                    break;
                    
                case 0:
                    System.out.println("Desligando sistema...");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
            
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
                scanner.nextLine();
            }
        } while (opcao != 0);
        
        scanner.close();
    }
}