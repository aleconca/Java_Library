package Concurrency.SyncAdvanced;

public class Consumatore implements Runnable{
    private Buffer buffer;
    private int id;

    public Consumatore(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }


    public void run() {
        int d;

        while (true){
            d = buffer.get();
            System.out.println("Consumtore "+id+ "letto: "+ id);
        }
    }
}
