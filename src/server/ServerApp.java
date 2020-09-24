package server;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ServerApp extends Application implements Runnable{

    private Label labelTitle = new Label("Server Chat");
    static TextArea message = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        // Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));



//        Label
        labelTitle.setStyle("-fx-text-fill: #1fde29; -fx-font-size: 36px; -fx-font-family: Arial");

//       TextArea
        message.setPrefHeight(150);
        message.setDisable(true);

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

        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {

                Socket socket = serverSocket.accept();


                DataInputStream inputStream = new DataInputStream(socket.getInputStream());

                String text = inputStream.readUTF();

                message.appendText(text + "\n");//parte grafica

                DataOutputStream out = null;
                out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(message.getText());
                socket.close();



            } catch (IOException e) {
                //e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
