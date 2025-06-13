/*
Resolução do exercicio 2 da aula 6
 */

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Exercicio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Formatador de Numeros de Telefone");
        System.out.println("Digite o numero que deseja formatar:");
        String entrada = scanner.nextLine();
        
        String resultado = formatarNumero(entrada);
        System.out.println("\n" + resultado);
        
        scanner.close();
    }
    
    public static String formatarNumero(String entrada) {

        String digitos = entrada.replaceAll("[^0-9]", "");
        
        if (digitos.matches("^[0-9]{8}$")) {
        
            return formatarFixo(digitos, false);
        } 
        else if (digitos.matches("^[0-9]{10}$")) {
       
            return formatarFixo(digitos, true);
        } 
        else if (digitos.matches("^[0-9]{9}$")) {

            return formatarCelular(digitos, false);
        } 
        else if (digitos.matches("^[0-9]{11}$")) {
            return formatarCelular(digitos, true);
        } 
        else {
          
            if (entrada.matches("^\\(\\d{2}\\)\\d{4,5}-\\d{4}$")) {
                String tipo = entrada.matches(".*\\d{5}-\\d{4}$") ? "Celular" : "Fixo";
                return "Número já formatado (" + tipo + "): " + entrada;
            }
            else if (entrada.matches("^\\d{4,5}-\\d{4}$")) {
                String tipo = entrada.matches("\\d{5}-\\d{4}$") ? "Celular" : "Fixo";
                return "Numero já formatado (" + tipo + " - sem DDD): " + entrada;
            }
            else {
          
                String corrigido = tentarCorrecao(entrada);
                if (!corrigido.equals("")) {
                    return "Numero corrigido: " + corrigido;
                }
                return "Entrada invalida: nao corresponde a nenhum formato de telefone conhecido.";
            }
        }
    }
    
    private static String formatarFixo(String digitos, boolean comDDD) {
        String formato;
        if (comDDD) {
            formato = String.format("(%s)%s-%s", 
                    digitos.substring(0, 2), 
                    digitos.substring(2, 6), 
                    digitos.substring(6));
        } else {
            formato = String.format("%s-%s", 
                    digitos.substring(0, 4), 
                    digitos.substring(4));
        }
        return "Telefone Fixo formatado: " + formato;
    }
    
    private static String formatarCelular(String digitos, boolean comDDD) {
        String formato;
        if (comDDD) {
            formato = String.format("(%s)%s-%s", 
                    digitos.substring(0, 2), 
                    digitos.substring(2, 7), 
                    digitos.substring(7));
        } else {
            formato = String.format("%s-%s", 
                    digitos.substring(0, 5), 
                    digitos.substring(5));
        }
        return "Celular formatado: " + formato;
    }
    
    private static String tentarCorrecao(String entrada) {
        String digitos = entrada.replaceAll("[^0-9]", "");
        
        switch (digitos.length()) {
            case 8: return formatarFixo(digitos, false).replace("Telefone Fixo formatado: ", "");
            case 9: return formatarCelular(digitos, false).replace("Celular formatado: ", "");
            case 10: return formatarFixo(digitos, true).replace("Telefone Fixo formatado: ", "");
            case 11: return formatarCelular(digitos, true).replace("Celular formatado: ", "");
            default: return "";
        }
    }
}