public class PoligonoIrreg {
    private Coordenada[] vertices;
    
    public PoligonoIrreg (Coordenada c) {
        vertices[vertices.length] = c;
    }

    public PoligonoIrreg(Coordenada[] vertices) {
        this.vertices = vertices;
    }

    @Override
    public String toString() {
        System.out.println("Los vertices del poligono irregular son: ");
        String s = "";
        for (int i = 0; i < vertices.length; i++) {
            s += vertices[i] + " ";
        }   
        return s;
    }

}
