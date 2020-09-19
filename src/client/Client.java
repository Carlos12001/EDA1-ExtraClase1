package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Client {
    Client(){
        try {
            Socket socket = new Socket("192.168.100.32", 6000);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(ClientApp.input.getAccessibleText());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("El error es :" + e.getMessage());
        }
    }
}