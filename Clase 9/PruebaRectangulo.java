import java.util.ArrayList;

public class PruebaRectangulo {
    public static void main (String[] args) {

        Coordenada c1 = new Coordenada(4,7);
        Coordenada c2 = new Coordenada(8, 9);
        Rectangulo r = new Rectangulo(c1, c2);
        //* arraylist de cordenadas para el poligono irregular
        ArrayList<Coordenada> vertices = new ArrayList<Coordenada>();


        //agregar 10 coordenadas positivas y negativas al azar al arraylist usando for
        for (int i = 0; i < 10; i++) {
            //* agregar las coordenada con 3 decimales al arraylist
            vertices.add(new Coordenada(nextLongBetween2(-100, 100), nextLongBetween2(-100, 100)));
        }

        
    
        PoligonoIrreg pol1 = new PoligonoIrreg(vertices);
        System.out.println(pol1);

      

    }

    public static double nextLongBetween2(int min, int max) {
        return (double) (Math.random() * ((max - min) + 1)) + min;
     }
}
