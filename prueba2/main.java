public class main {
    public static void main(String[] args) {

        Cuadrado cuadrado = new Cuadrado(5);
        Rectangulo rectangulo = new Rectangulo(7, 9);

        System.out.println("Area del cuadrado: "+cuadrado.area());
        System.out.println("Area del rectangulo: "+ rectangulo.area());
        System.out.println("Perimetro del cuadrado: "+cuadrado.imprimePerimetro());
        System.out.println("Perimetro del rectangulo: "+ rectangulo.imprimePerimetro());
        
    }
    
}
