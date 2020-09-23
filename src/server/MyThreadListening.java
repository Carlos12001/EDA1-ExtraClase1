package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyThreadListening extends Thread{
    Socket socket = null;
    String serverMessage = "";
    int socketsN = 0;


    public MyThreadListening(Socket s){
        socket = s;
    }

    public void run(){
        while(true){

            try {

                DataInputStream in = new DataInputStream(socket.getInputStream());
                String text = in.readUTF();
                serverMessage = serverMessage  + text + "\n";
                System.out.println(serverMessage);
                ServerApp.message.appendText(text + "\n");

                System.out.println("Lenght socket" + ServerApp.socketlist.length);

                for(int i = 0; i < socketsN+1 ; i++){
                    DataOutputStream out = new DataOutputStream(ServerApp.socketlist[i].getOutputStream());
                    out.writeUTF("Client["+(i+1)+"] :  "+text);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public void plusNum(){
        this.socketsN++;
    }

}
