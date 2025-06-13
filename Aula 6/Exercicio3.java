/*
resolução do Exercicio 3 Aula 6
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Exercicio3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Map<String, Object>> registros = new ArrayList<>();

        System.out.println("Conversor de Dados para JSON/XML/YAML");
        System.out.println("Formato: NOME_CAMPO;VALOR;TIPO");
        System.out.println("Tipos suportados: texto, data, data_hora, inteiro, decimal, booleano");
        System.out.println("Digite 'sair' para terminar a entrada de dados\n");

        while (true) {
            System.out.print("Informe os dados (NOME;VALOR;TIPO): ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            String[] partes = entrada.split(";");
            if (partes.length != 3) {
                System.out.println("Formato invalido! Use: NOME;VALOR;TIPO");
                continue;
            }

            String campo = partes[0].trim();
            String valorStr = partes[1].trim();
            String tipo = partes[2].trim().toLowerCase();

            try {
                Object valor = parseValor(valorStr, tipo);
                Map<String, Object> registro = new HashMap<>();
                registro.put("campo", campo);
                registro.put("valor", valor);
                registro.put("tipo", tipo);
                registros.add(registro);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        if (!registros.isEmpty()) {
            System.out.println("\n=== Resultados ===");
            System.out.println("JSON:\n" + gerarJSON(registros));
            System.out.println("\nXML:\n" + gerarXML(registros));
            System.out.println("\nYAML:\n" + gerarYAML(registros));
        } else {
            System.out.println("Nenhum dado foi informado.");
        }

        scanner.close();
    }

    private static Object parseValor(String valorStr, String tipo) {
        switch (tipo) {
            case "texto":
                return valorStr;
            case "data":
                try {
                    return LocalDate.parse(valorStr, DateTimeFormatter.ISO_LOCAL_DATE);
                } catch (DateTimeParseException e) {
                    throw new IllegalArgumentException("Formato de data inválido. Use YYYY-MM-DD");
                }
            case "data_hora":
                try {
                    return LocalDateTime.parse(valorStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                } catch (DateTimeParseException e) {
                    throw new IllegalArgumentException("Formato de data/hora inválido. Use YYYY-MM-DDTHH:MM:SS");
                }
            case "inteiro":
                try {
                    return Integer.parseInt(valorStr);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Valor inteiro inválido");
                }
            case "decimal":
                try {
                    return Double.parseDouble(valorStr);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Valor decimal inválido");
                }
            case "booleano":
                if (valorStr.equalsIgnoreCase("true")) return true;
                if (valorStr.equalsIgnoreCase("false")) return false;
                throw new IllegalArgumentException("Valor booleano inválido. Use 'true' ou 'false'");
            default:
                throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
        }
    }

    private static String gerarJSON(List<Map<String, Object>> registros) {
        StringBuilder json = new StringBuilder("{\n");
        for (Map<String, Object> reg : registros) {
            String campo = (String) reg.get("campo");
            Object valor = reg.get("valor");
            String tipo = (String) reg.get("tipo");

            json.append("  \"").append(campo).append("\": ");
            
            if (valor instanceof String) {
                json.append("\"").append(valor).append("\"");
            } else if (valor instanceof LocalDate) {
                json.append("\"").append(((LocalDate) valor).format(DateTimeFormatter.ISO_LOCAL_DATE)).append("\"");
            } else if (valor instanceof LocalDateTime) {
                json.append("\"").append(((LocalDateTime) valor).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)).append("\"");
            } else {
                json.append(valor);
            }
            
            json.append(", // ").append(tipo).append("\n");
        }
        json.deleteCharAt(json.lastIndexOf(",")); // Remove última vírgula
        json.append("}");
        return json.toString();
    }

    private static String gerarXML(List<Map<String, Object>> registros) {
        StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<dados>\n");
        for (Map<String, Object> reg : registros) {
            String campo = (String) reg.get("campo");
            Object valor = reg.get("valor");
            String tipo = (String) reg.get("tipo");

            xml.append("  <").append(campo).append(" tipo=\"").append(tipo).append("\">");
            
            if (valor instanceof LocalDate) {
                xml.append(((LocalDate) valor).format(DateTimeFormatter.ISO_LOCAL_DATE));
            } else if (valor instanceof LocalDateTime) {
                xml.append(((LocalDateTime) valor).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            } else {
                xml.append(valor);
            }
            
            xml.append("</").append(campo).append(">\n");
        }
        xml.append("</dados>");
        return xml.toString();
    }

    private static String gerarYAML(List<Map<String, Object>> registros) {
        StringBuilder yaml = new StringBuilder("---\n");
        for (Map<String, Object> reg : registros) {
            String campo = (String) reg.get("campo");
            Object valor = reg.get("valor");
            String tipo = (String) reg.get("tipo");

            yaml.append(campo).append(":\n");
            yaml.append("  valor: ");
            
            if (valor instanceof String) {
                yaml.append("\"").append(valor).append("\"\n");
            } else if (valor instanceof LocalDate) {
                yaml.append("\"").append(((LocalDate) valor).format(DateTimeFormatter.ISO_LOCAL_DATE)).append("\"\n");
            } else if (valor instanceof LocalDateTime) {
                yaml.append("\"").append(((LocalDateTime) valor).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)).append("\"\n");
            } else {
                yaml.append(valor).append("\n");
            }
            
            yaml.append("  tipo: ").append(tipo).append("\n");
        }
        return yaml.toString();
    }
}
