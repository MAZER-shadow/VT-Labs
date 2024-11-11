package lab.action;

public class NonExistentRatingException extends RuntimeException {
    public NonExistentRatingException(String message) {
        super(message);
    }
//    public String getMessage(){
//        return "Присвоен рейтинг музыканта не от 0 до 10";
//    }

}
