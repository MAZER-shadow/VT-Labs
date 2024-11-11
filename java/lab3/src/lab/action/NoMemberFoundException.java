package lab.action;

public class NoMemberFoundException extends Exception {
    public NoMemberFoundException(String message) {
        super(message);
    }
    //    public String getMessage(){
    //        return "нет участников в оркестре";
    //    }
}
