package lab.action;

public class NonExistentRatingException extends Exception {
    public NonExistentRatingException(){}
    public String getMessage(){
        return "Присвоен рейтинг музыканта не от 0 до 10";
    }

}
