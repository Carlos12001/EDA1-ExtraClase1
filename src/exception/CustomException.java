package exception;

public class CustomException extends Exception {


    public static final long serialVersionUID = 700l;

    CustomException(String message){
        super(message);
    }
}
