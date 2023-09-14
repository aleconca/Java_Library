package Concurrency.SyncAdvanced;

public class BufferTest {


    public static void main(String[] args){
        Buffer buffer;
        int value =0;
        int idA = 10;
        int idB = 5;

        buffer = new Buffer(value,true);
        Produttore a = new Produttore(buffer, idA);
        Consumatore b = new Consumatore(buffer,idB);

        System.out.println("starting");

        //ExecutorService exeservice = Executors.newCachedThreadPool();

        //exeservice.execute(a);
        //exeservice.execute(b);


        //exeservice.shutdown();

        Thread aa = new Thread(a);
        Thread bb = new Thread(b);

        aa.start();
        bb.start();


    }
}

