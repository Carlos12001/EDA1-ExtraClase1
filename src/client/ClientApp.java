package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientApp extends Application {
    Label labelTitle = new Label("Client Chat");
    public static TextArea message = new TextArea();
    public static TextField input = new TextField();
    Button buttonSend = new Button("send");


    @Override
    public void start(Stage primaryStage) throws Exception{
       // Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
        
//        ControllerClient
        ControllerClient controller = null;

//        Label
        labelTitle.setFont(new Font ("Arial", 34));


//       TextArea
        message.setPrefHeight(150);

//       TextField
        input.setPrefWidth(350);

//        Button
        buttonSend.setPrefWidth(50);
        buttonSend.setOnAction(event -> {ControllerClient.sendMessage();});

//        HBox
        HBox hBox = new HBox();
        hBox.getChildren().addAll(input, buttonSend);


//        VBox
        VBox root = new VBox(20);
        root.setStyle("-fx-background-color:#282C34");
        root.setPrefSize(400, 400);
        root.getChildren().addAll(labelTitle, message, hBox);
        root.setAlignment(Pos.TOP_CENTER);

//        Scene
        primaryStage.setTitle("Client");
        Scene scene = new Scene(root);

//        Stage
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }












}
