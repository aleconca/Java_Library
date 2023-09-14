package Concurrency.Sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {
    public static void main(String[] args){
        SimpleArray sharedArray = new SimpleArray(6);

        ArrayWriter writer1 = new ArrayWriter(1,sharedArray);
        ArrayWriter writer2 = new ArrayWriter(11, sharedArray);

        ExecutorService exeservice = Executors.newCachedThreadPool();

        exeservice.execute(writer1);
        exeservice.execute(writer2);

        exeservice.shutdown();

        try{
            boolean taskEnded = exeservice.awaitTermination(1, TimeUnit.MINUTES);

            if (taskEnded){
                System.out.println("%nContent of Shared Array.%n");
                System.out.println(sharedArray);
            }else {
                System.out.println("Time out .");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
