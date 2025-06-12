import java.util.ArrayList;
import java.util.List;

public class CalculadoraArea {
    private List<FiguraGeometrica> figuras;

    public CalculadoraArea() {
        this.figuras = new ArrayList<>();
    }

    public void adicionarFigura(FiguraGeometrica figura) {
        figuras.add(figura);
    }

    public double calcularAreaTotal() {
        double total = 0;
        for (FiguraGeometrica figura : figuras) {
            total += figura.calcularArea();
        }
        return total;
    }

    public void exibirAreas() {
        System.out.println("Areas das Figuras Geometricas:");
        System.out.println("------------------------------");
        for (FiguraGeometrica figura : figuras) {
            System.out.println(figura.toString());
        }
        System.out.println("------------------------------");
        System.out.printf("Area Total: %.2f\n", calcularAreaTotal());
    }
}
