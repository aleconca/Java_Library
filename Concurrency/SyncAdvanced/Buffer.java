package Concurrency.SyncAdvanced;

public class Buffer {
    private int data ;
    private boolean empty;

    public Buffer(int data, boolean empty) {
        this.data = 0;
        this.empty = true;
    }

    public synchronized void set(int d) {
        while (!empty)try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.notifyAll();
        data=d;
        empty=false;

    }

    public synchronized int get(){
        while (empty)try{
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.notifyAll();
        empty=true;
        return data;
    }


}
