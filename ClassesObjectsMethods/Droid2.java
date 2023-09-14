package ClassesObjectsMethods;

public class Droid2 {
    private String name ;
    private int batteryLevel;

    public Droid2(String name){
        this.name=name;
        this.batteryLevel=100;
    }

    public void performTask(String task){
        String string = this.name+" is performing "+task+ ".\n";
        System.out.println(string);
        this.batteryLevel=10;
    }

    public void energyReport(){
        System.out.println(this.batteryLevel);
    }

    public String energyTransfer(int battery, Droid2 droid){
        droid.batteryLevel= droid.batteryLevel-battery;
        if(droid.batteryLevel<=0 ){
            return "Energy transfer failed";
        }else {
            this.batteryLevel = this.batteryLevel + battery;
            return "Energy transefer from "+ droid.name +" to "+this.name +" successfull.";
        }


    }

    @Override
    public String toString() {
        return "Droid2{" +
                "name='" + name + '\'' +
                ", batteryLevel=" + batteryLevel +
                '}';
    }

    public static  void main(String[] args){

        Droid2 droid1=new Droid2("Pippo");
        Droid2 droid2=new Droid2("Pluto");
        System.out.println(droid1);//toString chiamato in automatico

        droid1.performTask("fly");

        droid1.energyReport();
        droid2.energyReport();

        String message=droid1.energyTransfer(10,droid2);
        System.out.println(message);

        System.out.println("Droid1 energy level is:");
        droid1.energyReport();
        System.out.println("Droid2 energy level is:");
        droid2.energyReport();
    }
}
