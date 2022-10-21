package Clase10;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args)

    {       
    
         //* Almacenar 10 curps en un arraylist con Iterator
        ArrayList<String> curp = new ArrayList<String>();   
     
        String sexoAQuitar = args[1];
        int i = Integer.parseInt(args[0]);

        //* Ordenar curps en orden alfabetico con Iterator

        String abcd = "ABCDE";
        
        for(int n =0; n<i;n++ ){
            curp.add(getCURP());
        }
       
        System.out.println("Curps sin filtrar "+curp);

        //* Con iterator eliminar los curps que sean de hombres
        Iterator<String> itr = curp.iterator();
        while(itr.hasNext()){
            String curp1 = itr.next();
            if(curp1.charAt(10) == sexoAQuitar.charAt(0)){
                itr.remove();
            }
        }
        System.out.println("Curps filtrados: "+curp);

        Iterator itr2 = curp.iterator();
        while(itr2.hasNext()){
            String curp2 = itr.next();
            for(int c = 0 ; c<i;c++){
                if(abcd.compareTo(curp2)> 0){

                }
            }
        }

    }

 

    // Función para generar una CURP aleatoria

    static String getCURP()

    {

        String Letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String Numero = "0123456789";

        String Sexo = "HM";

        String Entidad[] = {"AS", "BC", "BS", "CC", "CS", "CH", "CL", "CM", "DF", "DG", "GT", "GR", "HG", "JC", "MC", "MN", "MS", "NT", "NL", "OC", "PL", "QT", "QR", "SP", "SL", "SR", "TC", "TL", "TS", "VZ", "YN", "ZS"};

        int indice;

        

        StringBuilder sb = new StringBuilder(18);

        

        for (int i = 1; i < 5; i++) {  //* En el 10 indica el sexo de la persona */

            indice = (int) (Letra.length()* Math.random());

            sb.append(Letra.charAt(indice));        

        }

        

        for (int i = 5; i < 11; i++) {

            indice = (int) (Numero.length()* Math.random());

            sb.append(Numero.charAt(indice));        

        }

 

        indice = (int) (Sexo.length()* Math.random());

        sb.append(Sexo.charAt(indice));        

        

        sb.append(Entidad[(int)(Math.random()*32)]);

 

        for (int i = 14; i < 17; i++) {

            indice = (int) (Letra.length()* Math.random());

            sb.append(Letra.charAt(indice));        

        }

 

        for (int i = 17; i < 19; i++) {

            indice = (int) (Numero.length()* Math.random());

            sb.append(Numero.charAt(indice));        

        }

        

        return sb.toString();
    }      
    
    
}
