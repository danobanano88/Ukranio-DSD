public class Cuadrado extends Figura implements Perimetro {

    private float lado;

    public Cuadrado(float lado) {
        this.lado = lado;
    }
    
    @Override
    public float area() {
        return lado * lado;
    }

    @Override
    public float imprimePerimetro() {
        return lado * 4;
    }

}
