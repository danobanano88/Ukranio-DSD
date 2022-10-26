import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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
                
                while (br.readLine() != null){
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
                for (Map.Entry<Character, Integer> me : 
                hm.entrySet()) { 
               System.out.print(me.getKey() + ":"); 
               System.out.println(me.getValue());
           
            }
            }
            catch (Exception e){
                System.out.println("error 2");
           
            }}
        catch (FileNotFoundException e){
            System.out.println("error no encontro archivo");
        
        }
       
    }}


public class main {
    public static void main(String[] args) {
        File file = new File("BIBLIA_COMPLETA.txt");
        //divide el archivo en 5 partes
        long size = file.length();
        long partSize = size / 5;
        long start = 0;
        long end = partSize;
        for (int i = 0; i < 5; i++) {
            try{
                File part = new File("part" + i + ".txt");
                part.createNewFile();
                FileWriter fw = new FileWriter(part);
                BufferedReader br = new BufferedReader(new FileReader(file));
                br.skip(start);
                String line = br.readLine();
                while (line != null && br.ready()){
                    fw.write(line);
                    fw.write(System.lineSeparator());
                    line = br.readLine();
                }
                fw.close();
                br.close();
                start = end;
                end += partSize;   
            }
            catch (Exception e){
                
            }
          

        }

         // creates five tasks
         Runnable r1 = new Task("part0.txt");
         Runnable r2 = new Task("part1.txt");
         Runnable r3 = new Task("part2.txt");
         Runnable r4 = new Task("part3.txt");
         Runnable r5 = new Task("part4.txt");      
           
         // creates a thread pool with MAX_T no. of 
         // threads as the fixed pool size(Step 2)
         ExecutorService pool = Executors.newFixedThreadPool(3);  
          
         // passes the Task objects to the pool to execute (Step 3)
         pool.execute(r1);
         pool.execute(r2);
         pool.execute(r3);
         pool.execute(r4);
         pool.execute(r5); 
           
         // pool shutdown ( Step 4)
         pool.shutdown();
    }
}

     
        

      
