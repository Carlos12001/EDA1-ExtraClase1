package server;

import client.ClientObject;

import java.io.*;
import java.net.Socket;

public class ClientHandServer extends Thread{

    Socket socket;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    public ClientHandServer(Socket socket, ObjectInputStream dataInput, ObjectOutputStream dataOutput) {
        this.socket = socket;
        this.objectInputStream = dataInput;
        this.objectOutputStream = dataOutput;
    }

    @Override
    public void run() {
        ClientObject recived;
        while (true) {

            try {
                objectOutputStream.writeObject(new PackageServer("Hola estas conectado al servirdor"));

                recived = (ClientObject) objectInputStream.getObjectInputFilter();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
