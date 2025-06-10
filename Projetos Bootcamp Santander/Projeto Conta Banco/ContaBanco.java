/*
PROJETO DE AUTORIA DO:
KADU LOYOLA DE MELO NOGUEIRA
PROJETO ENCONTRADO NO README.MD
 */
import java.util.Scanner;

public class ContaBanco {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        // Limitando o numero da conta para 6 digitos
        
        /*String Nc;
        do{
        System.out.println("Por Favor, Digite o numero da Conta:");
        Nc = scanner.nextLine();
        }while(Nc.length() !=6);
        */
        System.out.println("Por Favor, Digite o numero da Conta:");
        int Nc = scanner.nextInt();
        scanner.nextLine();//Para remover o Enter dado após digitar o numero da conta
        
        System.out.println("Por Favor, Digite o numero da agencia:");
        String Na = scanner.nextLine();
        
        System.out.println("Por Favor, Digite o nome do titular:");
        String Tc = scanner.nextLine();
        
        System.out.println("Por Favor, Digite Quanto e o saldo:");
        double Sd = scanner.nextDouble();
        
        System.out.println("Ola "+Tc+" Obrigado por abrir uma conta em nosso banco"
                + " sua agencia e "+Na
                + " conta "+Nc
                + " e seu saldo R$"+Sd+" ja esta disponivel para saque");
        
    }
}
