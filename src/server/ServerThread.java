package server;

import javafx.scene.control.TextArea;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread {

    private Socket socketlist[] = new Socket[10000];
    private int num = 0;
    private String message;
    private TextArea printa;

    public ServerThread(TextArea printa) {
        this.printa = printa;
    }

    public void addSocket(Socket s){
        socketlist[num] = s;
        num++;
    }


    public void setMessage(String texting){
        this.message = texting;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void run() {
        while (true){
            int c = 0;
            while (c!=num){


                DataInputStream inputStream = null;
                String text = null;




                DataOutputStream out = null;
                try {
                    inputStream = new DataInputStream(socketlist[c].getInputStream());

                    text = inputStream.readUTF();

                    printa.appendText(text + "\n");//parte grafica

                    this.setMessage(text);

                    out = new DataOutputStream(socketlist[c].getOutputStream());

                    out.writeUTF(this.message);




                } catch (IOException e) {
                    e.printStackTrace();
                }

//                socket.close();


                c++;
            }
        }

    }
}
