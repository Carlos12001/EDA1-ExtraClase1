package client;


import javafx.scene.control.*;

class ControllerClient {

    public static void sendMessage(Client client, TextField input, TextArea message ){

        String text = input.getText() ;

        client.sendMessageAction(text);

        message.appendText("You: "+ text + "\n");

        input.clear();
        System.out.println();
    }

    public  static void saveNewConfig(Client client, TextField ip, TextField puerto ){
        client.setIp(ip.getText());
        client.setPuerto(Integer.parseInt(puerto.getText()));
    }


}


