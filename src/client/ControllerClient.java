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

    public  static void saveNewConfig(ClientObject clientObject, TextField ip, TextField puerto ){
        clientObject.setIp(ip.getText());
        clientObject.setPuerto(Integer.parseInt(puerto.getText()));
    }


}


