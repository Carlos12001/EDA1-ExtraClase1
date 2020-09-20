package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Client {
    Client(String text){
        try {
            Socket socket = new Socket("127.0.0.1", 6000);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(text);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}