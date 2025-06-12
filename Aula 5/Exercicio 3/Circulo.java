public class Circulo implements FiguraGeometrica {
    private double raio;
    private static final double PI = 3.141592653589793;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return PI * raio * raio;
    }

    @Override
    public String getTipo() {
        return "Circulo";
    }

    @Override
    public String toString() {
        return String.format("%s (raio = %.2f) - Area: %.2f", 
               getTipo(), raio, calcularArea());
    }
}