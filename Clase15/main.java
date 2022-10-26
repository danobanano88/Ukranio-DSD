import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
private String nombre;
Map<Character, Integer> hm  = new HashMap<Character, Integer>(); 

    public Task(String filename) {
       nombre = filename;
    }



    public void run(){
        
         try {
            File file = new File(nombre);  
            BufferedReader br = new BufferedReader(new FileReader(file));
            try{           
                while (br.ready()){
                    String line = br.readLine();
                    for (int i = 0; i < line.length(); i++){
                        char c = line.charAt(i);
                        if (hm.containsKey(c)){
                            hm.put(c, hm.get(c) + 1);
                        } else {
                            hm.put(c, 1);
                        }
                    }
                }
                ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(
                        hm.entrySet());
                for (Map.Entry<Character, Integer> me : hm.entrySet()) {
                    // Usando el arrayList con compare para poder ordernar el mapa

                    Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                        public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                            return (o1.getValue()).compareTo(o2.getValue());
                        }
                    });
                }
                for (Map.Entry<Character, Integer> aa : list) {
                    System.out.println(aa.getKey() + " " + aa.getValue());
                }
            }
            catch (Exception e){
                System.out.println("error 2");
           
            }}
        catch (FileNotFoundException e){
            System.out.println("error no encontro archivo");
        
        }
       
    } 

    
   
}


public class main {
   
    public static void main(String[] args) {
    
        
        try {
            File file = new File("BIBLIA_COMPLETA.txt"); 
            BufferedReader br = new BufferedReader(new FileReader(file));
            try{
                //contar lineas totales en el archivo
                int lineas = 0;
                while (br.readLine() != null){
                    lineas++;
                }
                System.out.println("lineas por archivo: " + lineas/9);
                //crear 5 archivos cada 7037 lineas
                int lineasPorArchivo = lineas/9;
                int contador = 0;
                int contadorArchivos = 0;
                String nombreArchivo = "archivo" + contadorArchivos + ".txt";
                FileWriter fw = new FileWriter(nombreArchivo);
                br = new BufferedReader(new FileReader(file));
                while (br.readLine() != null){   
                    String line = br.readLine();
                    //escribo en el archivo
                    fw.write(line);
                    //si llego a las 7037 lineas, cierro el archivo y creo el siguiente
                    if (contador == lineasPorArchivo){
                        fw.close();
                        contadorArchivos++;
                        nombreArchivo = "archivo" + contadorArchivos + ".txt";
                        fw = new FileWriter(nombreArchivo);
                        contador = 0;
                    }
                    contador++;
                }
            }
            catch (Exception e){
                System.out.println("error 2");
           
            }}
        catch (FileNotFoundException e){
            System.out.println("error no encontro archivo");
        
        }


         
         Runnable r1 = new Task("archivo0.txt");
         Runnable r2 = new Task("archivo1.txt");
         Runnable r3 = new Task("archivo2.txt");     
         Runnable r4 = new Task("archivo3.txt");
         Runnable r5 = new Task("archivo4.txt");
           
    
         ExecutorService pool = Executors.newFixedThreadPool(3);  
          
        
         pool.execute(r1);
         pool.execute(r2);
         pool.execute(r3);
         pool.execute(r4);
         pool.execute(r5);

           
        
         pool.shutdown();

    }
}