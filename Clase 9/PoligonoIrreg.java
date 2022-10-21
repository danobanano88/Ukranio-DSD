import java.util.ArrayList;
import java.util.Comparator;

public class PoligonoIrreg {
    private Coordenada[] vertices;
    //* almacenar los vertices en un arrayList
    private ArrayList<Coordenada> vertices2;
    

    public PoligonoIrreg(ArrayList<Coordenada> vertices3) {
        this.vertices2 = vertices3;
    }

    //* funcion ordena vertice para ordenar los vertices de menor a mayor usando Comparator
    public void ordenaVertices() {
        //* ordenar los vertices de menor a mayor usando magnitud
        vertices2.sort(Comparator.comparing(Coordenada::getMagnitud));
    }




    @Override
    public String toString() {
        System.out.println("Los vertices del poligono irregular son: ");
        //* for each para imprimir los vertices
        for (Coordenada c : vertices2) {
            System.out.printf("%.3f\n",c.getMagnitud());
            System.out.printf("[%.3f,%.3f] \n",c.abcisa(), c.ordenada());

        }
        //llamar a la funcion ordenaVertices
        System.out.println("Los vertices ordenados son: ");
        ordenaVertices();
        for (Coordenada c : vertices2) {
            //System.out.println(c );
            System.out.printf("%.3f\n",c.getMagnitud());
            System.out.printf(" [%.3f,%.3f]  \n",c.abcisa(), c.ordenada());

        }
        return "";
    }

}
