/*
Exercicio 3 Aula 4
Herança e polimorfismo
 */

abstract class Relogio {
    protected int hora;
    protected int minuto;
    protected int segundo;

    public Relogio(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("Hora inválida (0-23)");
        }
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException("Minuto inválido (0-59)");
        }
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (segundo < 0 || segundo > 59) {
            throw new IllegalArgumentException("Segundo inválido (0-59)");
        }
        this.segundo = segundo;
    }

    public String getHoraFormatada() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    public abstract String getHoraLocal();

    public final void sincronizar(Relogio outroRelogio) {
        this.hora = converterHora(outroRelogio.getHora());
        this.minuto = outroRelogio.getMinuto();
        this.segundo = outroRelogio.getSegundo();
    }

    protected abstract int converterHora(int hora);
}

class RelogioBrasileiro extends Relogio {
    public RelogioBrasileiro(int hora, int minuto, int segundo) {
        super(hora, minuto, segundo);
    }

    @Override
    public String getHoraLocal() {
        return "Horário no Brasil: " + getHoraFormatada();
    }

    @Override
    protected int converterHora(int hora) {

        return hora;
    }
}

class RelogioAmericano extends Relogio {
    public RelogioAmericano(int hora, int minuto, int segundo) {
        super(hora < 13 ? hora : hora - 12, minuto, segundo);
    }

    @Override
    public String getHoraLocal() {
        String periodo = hora < 12 ? "PM" : "AM";
        int hora12 = hora == 0 ? 12 : (hora > 12 ? hora - 12 : hora);
        return String.format("Horário nos EUA: %02d:%02d:%02d %s", hora12, minuto, segundo, periodo);
    }

    @Override
    protected int converterHora(int hora) {

        return hora < 13 ? hora : hora - 12;
    }

    @Override
    public void setHora(int hora) {
        if (hora < 0 || hora > 12) {
            throw new IllegalArgumentException("Hora inválida para formato americano (1-12)");
        }
        this.hora = hora;
    }
}

public class Exercicio3 {
    public static void main(String[] args) {
        Relogio relogioBr = new RelogioBrasileiro(15, 30, 45);
        Relogio relogioEUA = new RelogioAmericano(15, 30, 45);

        System.out.println(relogioBr.getHoraLocal());
        System.out.println(relogioEUA.getHoraLocal());

        System.out.println("\nSincronizando relógio brasileiro com o americano:");
        relogioBr.sincronizar(relogioEUA);
        System.out.println(relogioBr.getHoraLocal());

        System.out.println("\nSincronizando relógio americano com o brasileiro:");
        relogioEUA.sincronizar(relogioBr);
        System.out.println(relogioEUA.getHoraLocal());

        System.out.println("\nFormato 24h (Brasil): " + relogioBr.getHoraFormatada());
        System.out.println("Formato 12h (EUA): " + relogioEUA.getHoraLocal());
    }
}