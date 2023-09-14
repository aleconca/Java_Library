package Project.ingsw.Exceptions;

public class CannotSwitchLevelsException extends Exception {
    public CannotSwitchLevelsException() {
        super("Cannot switch levels");
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
    //public void printMessages() {
    //    if(getCause().toString().equals())
    //}

}
