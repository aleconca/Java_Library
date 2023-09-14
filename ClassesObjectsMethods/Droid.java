package ClassesObjectsMethods;

public class Droid {

    private String name;
    private int batteryLevel;

    public Droid(String droidName){
        name=droidName;
        batteryLevel=100;
    }

    public String toString(){
        return "the droid's name is "+name;
    }

    public void performTask(String task){
        System.out.println(name + "is performing task" + task);
        batteryLevel=10;
    }

    public void energyReport(){
        System.out.println("The battery is now"+ batteryLevel);
    }

    public void energyTransfer(int level){
        batteryLevel=batteryLevel+level;
    }

    public static void main(String[] args){
        Droid droid= new Droid("Codey");

        System.out.println(droid);

        droid.performTask("fly high");

        droid.energyReport();

        droid.energyTransfer(10);

    }
}
