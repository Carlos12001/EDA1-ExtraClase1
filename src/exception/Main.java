package exception;

public class Main {
    public static void main(String[] args) {

        try {
            Handler.funcion("ARGUMENTOS");
        } catch (CustomException e) {
            e.printStackTrace();
        }

    }
}
