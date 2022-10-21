public class main { 
    static int n = 0;
    public static void main(String[] args)
    {
        System.out.println("Main thread is- "
                        + Thread.currentThread().getName());

        Thread t1 = new Thread(new main().new decrement(5));
        Thread t2 = new Thread(new main().new decrement(5));
        t1.start();
        t2.start();
        // verificar que ambos hilos terminaron
        try {
            t1.join();
            t2.join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(n);
    }
 
    private class decrement implements Runnable {
        int a;
  

        public decrement(int i) {
            a = i;
        }

        public void run()
        {  

           for(int i=0;i<a;i++){  
                modifica();
            }     
        }

  
    }

    public void modifica(){
        if (Thread.currentThread().getId() == 13){
            n ++;    
            System.out.println(n);
        }
        else{
            n --;
            System.out.println(n);
        }
    }
}
