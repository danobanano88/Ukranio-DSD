import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        File file = new File("BIBLIA_COMPLETA.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try{
                Map<Character, Integer> hm  = new HashMap<Character, Integer>(); 
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
                System.out.println("Error");
            }}
        catch (FileNotFoundException e){
            System.out.println("Error");
        }
    }
}