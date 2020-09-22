package client;


import javafx.scene.control.*;

class ControllerClient {

    public static void sendMessage(ClientObject clientObject, TextField input, TextArea message ){

        String text = input.getText() ;

        clientObject.sendMessageAction(text);

        message.appendText("You: "+ text + "\n");

        input.clear();
        System.out.println();
    }


}


