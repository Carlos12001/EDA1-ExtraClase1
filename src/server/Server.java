package server;

import client.ClientObject;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Runnable {

    private Label labelTitle = new Label("Server Chat");
    private TextArea message = new TextArea();
    private Stage primaryStage = new Stage();
    private int puerto = 6000;

    public Server(int puerto){
        this.puerto = puerto;
        display();
        Thread hilo = new Thread(this);
        hilo.start();
    }


    public void display() {

//        Label
        labelTitle.setStyle("-fx-text-fill: #1fde29; -fx-font-size: 36px; -fx-font-family: Arial");

//       TextArea
        message.setPrefHeight(150);
        message.setStyle("-fx-font-family: " +
                "Arial;-fx-font-size: 14px; " +
                "-fx-control-inner-background:#333b33");
        message.setEditable(false);

//        VBox
        VBox root = new VBox(20);
        root.setStyle("-fx-background-color:#282C34");
        root.setPrefSize(400, 400);
        root.getChildren().addAll(labelTitle, message);
        root.setAlignment(Pos.TOP_CENTER);

//        Scene
        primaryStage.setTitle("Server");
        Scene scene = new Scene(root);

//        Stage
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    @Override
    public void run() {

        try {

            ServerSocket serverSocket = new ServerSocket(this.puerto);

            String nickC, ipC, text;
            int puertoC;

            ClientObject clientObject;
            while (true) {
//                Listening
                Socket socket1 = serverSocket.accept();

                ObjectInputStream objectInputStream = new ObjectInputStream(socket1.getInputStream());

                clientObject = (ClientObject) objectInputStream.readObject();

                nickC = clientObject.getNick();
                ipC = clientObject.getIp();
                puertoC = clientObject.getPuerto();
                text = clientObject.getText();

                message.appendText(nickC + ": " + text + " \n");

                socket1.close();

//                Wrintting

                Socket socket2 = new Socket(ipC, puertoC);

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket2.getOutputStream());

                objectOutputStream.writeObject(objectInputStream);

                socket2.close();

            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}