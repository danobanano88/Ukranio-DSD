public class Coordenada {

    private double x, y;
    private double magnitud;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
        this.magnitud = Math.sqrt(x*x + y*y);
    }

    public double abcisa( ) { return x; }



    public double ordenada( ) { return y; }

    @Override

    public String toString( ) {

        return "[" + x + "," + y + "]";

    }

    public double getMagnitud() {
        return magnitud;
    }

}