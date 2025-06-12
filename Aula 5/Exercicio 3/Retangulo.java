public class Retangulo implements FiguraGeometrica {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public String getTipo() {
        return "Retangulo";
    }

    @Override
    public String toString() {
        return String.format("%s (base = %.2f, altura = %.2f) - Area: %.2f", 
               getTipo(), base, altura, calcularArea());
    }
}
