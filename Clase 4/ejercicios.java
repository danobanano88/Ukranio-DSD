import java.util.Scanner;

class ejercicios{
    public static void main(String[] args) {
        System.out.println("Ejercicio 1");
        int num =  26*26*26;
        int contador=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el valor de n");
        int n = sc.nextInt();
        char[] cadenota = new char[n*4]; 
        //generate random 3 letter word
        for(int a = 0; a<num ; a++){
            for(int b = 0; b<4; b++){
                int random = (int)(Math.random()*26)+97;
                char letra = (char)random;
                cadenota[a*4+b] = letra;
                cadenota[a*4+b] = Character.toUpperCase(cadenota[a*4+b]);
                if(b==3){
                    cadenota[a*4+b] = ' ';
                }

                  
            }
        }
        for(int a = 0; a<num ; a++){
          
            for(int b = 0; b<4; b++){
                if(cadenota[a*4+b]=='I'){
                    if(cadenota[a*4+b+1]=='P'){
                        if(cadenota[a*4+b+2]=='N'){
                            if(cadenota[a*4+b+3]==' '){
                                for(int c = 0; c<4; c++){
                                    contador ++;
                                }
                               
                            }
                        }
                    }
                 
                }
            }
     
        }
        System.out.println(contador/3);

    }
}