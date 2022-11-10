import java.util.*;

public class ejercicios {
    public static char RandomChar (){
        Random num = new Random();
        char rndChar = (char) (num.nextInt(26) + 'A');
        return rndChar;
    
    }// RandomChar
    public static String RandomWord(){
        String word = new String();
        word = "" + RandomChar()+ RandomChar()+ RandomChar();
        return word;
    }//RandomWord
    public static void main(String args[]){
        String argumentos = args[0];
        String palabra = args[1];
        int n = Integer.parseInt(argumentos);
        String cadena = new String();
        int n_palabras=0;
 
        for(int i=0; i <Math.pow(n, 3); i++){
            String w_ = RandomWord();
            cadena = cadena + " " + w_;
            if(w_.equals(palabra)){
                n_palabras++;
                System.out.println(w_);
            }//if
        }//for
        System.out.println(n_palabras);
    }  //main  
}//class EJ2