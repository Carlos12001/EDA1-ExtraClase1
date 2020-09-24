package client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ControllerClient {



    public static void sendMessage(){

        String text = ClientApp.input.getText() ;


        try {
            Socket socket = new Socket("127.0.0.1", 6000);
            DataOutputStream out = null;
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(text);


            ClientApp.message.clear();

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String textote = inputStream.readUTF();


            ClientApp.message.setText(textote);
            ClientApp.input.clear();

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}


