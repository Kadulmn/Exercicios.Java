public class Quadrado implements FiguraGeometrica {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public String getTipo() {
        return "Quadrado";
    }

    @Override
    public String toString() {
        return String.format("%s (lado = %.2f) - Area: %.2f", 
               getTipo(), lado, calcularArea());
    }
}
