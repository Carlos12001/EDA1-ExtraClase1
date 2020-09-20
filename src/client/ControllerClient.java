package client;


class ControllerClient {

    public static void sendMessage(){

        String text = ClientApp.input.getText() ;

        new Client(text);

        ClientApp.message.appendText(text+"\n");

        ClientApp.input.clear();
        System.out.println();
    }


}


