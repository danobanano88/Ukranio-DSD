public class Rectangulo extends Figura implements Perimetro {
    private float base;
    private float altura;
    
    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    
    @Override
    public float area() {
        return base * altura;
    }


    @Override
    public float imprimePerimetro() {
        return (base + altura) * 2;
    }
    
}
    

