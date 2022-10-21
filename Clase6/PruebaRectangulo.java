public class PruebaRectangulo {
    public static void main (String[] args) {

        Coordenada c1 = new Coordenada(4,7);
        Coordenada c2 = new Coordenada(8, 9);
        Rectangulo r = new Rectangulo(c1, c2);
        


        //crear 10 coordenadas aleatorias
        Coordenada[] vertices2 = new Coordenada[10];
        for (int i = 0; i < 10; i++) {
           vertices2[i] = new Coordenada((int)(Math.random()*10), (int)(Math.random()*10));
           System.out.println(vertices2[i]);
        }

        Rectangulo rect1 = new Rectangulo(c1, c2);
        PoligonoIrreg pol1 = new PoligonoIrreg(vertices2);

        double ancho, alto;

        System.out.println(pol1);

        System.out.println("Calculando el area de un rectangulo dadas sus coordenadas en un plano cartesiano:");

        System.out.println(rect1);

        alto = rect1.superiorIzquierda().ordenada() - rect1.inferiorDerecha().ordenada();

        ancho = rect1.inferiorDerecha().abcisa() - rect1.superiorIzquierda().abcisa();

        System.out.println("El area del rectangulo es = " + ancho*alto);

    }
}
