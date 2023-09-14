package Concurrency.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Taskexecutor {

    public static void main(String[] args){
        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("task3");
        PrintTask task4 = new PrintTask("task4");

        System.out.println("starting");

        ExecutorService exeservice = Executors.newCachedThreadPool();

        exeservice.execute(task1);
        exeservice.execute(task2);
        exeservice.execute(task3);

        exeservice.shutdown();
        exeservice.execute(task4);

        System.out.println("Tasks started , main ends .%n%n");
    }


}
