package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ControllerServer {

    ControllerServer(){
        try {
            Socket socket = new Socket("192.168.100.32", 5000);

            DataOutputStream flujosalida= new DataOutputStream(socket.getOutputStream());

            //flujosalida.writeUTF(c);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Este es el error " + e.getMessage());
        }

    }

}
