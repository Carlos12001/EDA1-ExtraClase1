package client;

import java.io.*;
import java.net.Socket;

public class ClientObject implements Serializable {
    private String nick,ip, text;
    int puerto;

    public ClientObject(String nick, String ip, int puerto) {
        this.nick = nick;
        this.ip = ip;
        this.puerto = puerto;
    }


    public void sendMessageAction(String text){
        this.text = text;
        try {
            Socket socket = new Socket(ip, puerto);

            ObjectOutputStream paquete =  new ObjectOutputStream(socket.getOutputStream());

            paquete.writeObject(this);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getIp() {
        return ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public String getNick() {
        return nick;
    }

    public String getText() {
        String oldtext = this.text;
        //this.text = "";
        return oldtext;
    }
}

