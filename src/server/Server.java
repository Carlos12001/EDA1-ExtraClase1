package server;

import client.ClientObject;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

//    Attributes of the GUI
    private Label labelTitle = new Label("Server Chat");
    private TextArea message = new TextArea();
    private Stage primaryStage = new Stage();


//    Attributes of the Server
    private int puerto = 6000;


    public Server(int puerto) throws IOException {
        this.puerto = puerto;


//        Comandos para crear el servidor
        Socket socket = null;
        ObjectInputStream dataInputStream;
        ObjectOutputStream dataOutputStream;

        try {
            ServerSocket sS = new ServerSocket(this.puerto);
//            Acepta el código entrante
            socket = sS.accept();

            dataInputStream = new ObjectInputStream(socket.getInputStream());
            dataOutputStream = new ObjectOutputStream(socket.getOutputStream());

            Thread thread = new ClientHandServer(socket, dataInputStream, dataOutputStream);
            thread.start();


        } catch (Exception e) {
            socket.close();
            e.printStackTrace();
            System.out.println("Me rompi en el Servidor \n\n\n");
        }

//        display();


    }

    public int getPuerto() {
        return puerto;
    }

//    public void display() {
//
////        Label
//        labelTitle.setStyle("-fx-text-fill: #1fde29; -fx-font-size: 36px; -fx-font-family: Arial");
//
////       TextArea
//        message.setPrefHeight(150);
//        message.setStyle("-fx-font-family: " +
//                "Arial;-fx-font-size: 14px; " +
//                "-fx-control-inner-background:#333b33");
//        message.setEditable(false);
//
////        VBox
//        VBox root = new VBox(20);
//        root.setStyle("-fx-background-color:#282C34");
//        root.setPrefSize(400, 400);
//        root.getChildren().addAll(labelTitle, message);
//        root.setAlignment(Pos.TOP_CENTER);
//
////        Scene
//        primaryStage.setTitle("Server");
//        Scene scene = new Scene(root);
//
////        Stage
//        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);
//        primaryStage.show();
//
//
//    }
}