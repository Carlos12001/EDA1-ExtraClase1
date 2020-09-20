package client;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ClientApp extends Application {


    Label labelTitle = new Label("Client Chat");
    public static TextArea message = new TextArea();
    public static TextField input = new TextField();
    Button buttonSend = new Button("send");


    @Override
    public void start(Stage primaryStage) {
       // Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));

//        Label
        labelTitle.setStyle("-fx-text-fill: #1fdece; -fx-font-size: 36px; -fx-font-family: Arial");


//       TextArea
        message.setPrefHeight(150);
        message.setStyle("-fx-font-family: Arial;-fx-font-size: 14px ");
        message.setDisable(true);


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
