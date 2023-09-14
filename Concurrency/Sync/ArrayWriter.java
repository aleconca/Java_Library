package Concurrency.Sync;

public class ArrayWriter implements Runnable{
    private final SimpleArray sharedArray;
    private final int startValue;

    public ArrayWriter(int value, SimpleArray array){
        startValue=value;
        sharedArray=array;
    }

    @Override
    public void run(){
        for (int i = startValue; i< startValue + 3; i++ ){
            sharedArray.add(i);
        }
    }

}
