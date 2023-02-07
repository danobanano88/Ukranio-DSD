/*
 *  MIT License
 *
 *  Copyright (c) 2019 Michael Pogrebinsky - Distributed Systems & Cloud Computing with Java
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Aggregator {
    private WebClient webClient;

    public Aggregator() {
        this.webClient = new WebClient();
    }

    public List<String> sendTasksToWorkers(List<String> workersAddresses, List<String> tasks) {
        CompletableFuture<String>[] futures = new CompletableFuture[tasks.size()];
        System.out.println("tareas: "+tasks);

  
        for (int i = 0; i < workersAddresses.size(); i++) {
            String workerAddress = workersAddresses.get(i);
            String task = tasks.get(i);
            byte[] requestPayload = task.getBytes();
            futures[i] = webClient.sendTask(workerAddress, requestPayload);
            System.out.println("\nServidor: " + workerAddress + "-> "+" tarea: " + task);
        }
        
        boolean bandera = true;
        while(bandera){
            for(int j = 0; j < workersAddresses.size(); j++){
                if (true == futures[j].isDone()){
                System.out.println("\nEl primer servidor en terminar fue: " + workersAddresses.get(j) + " y se le asigna la tarea: " + tasks.get(j+2));
                String finishedWorker = workersAddresses.get(j);
                String task = tasks.get(2); ;    
                byte[] requestPayload = task.getBytes();
                futures[j+2] = webClient.sendTask(finishedWorker, requestPayload);  
                bandera = false;
                }

            }

        }

        //get results from workers
        List<String> results = new ArrayList<>();
        // System.out.println(futures[0].join());
        // System.out.println(futures[1].join());
        // System.out.println(futures[2].join());
   
        results.add(futures[0].join());
        results.add(futures[1].join());
        results.add(futures[2].join());

        return results;

    }

}
