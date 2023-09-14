package Concurrency.SyncAdvanced;

public class Produttore implements Runnable{
    private Buffer buffer;
    private int  id;

    public Produttore(Buffer b, int id){
        buffer=b;
        this.id=id;
    }

    public void run(){
        for (int d = id * 1000 ; d<(id+1)*1000; d++){
            System.out.println("Produttore prodotto: "+d);
            buffer.set(d);
        }
    }

}
