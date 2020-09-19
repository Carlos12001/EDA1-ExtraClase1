package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       // Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));



//       TextField
        TextArea message = new TextArea();
        message.setPrefHeight(200);


//       TextField
        TextField input = new TextField();
        input.setOnAction(event -> ControllerClient.sendMessage( message, input));


//        VBox
        VBox root = new VBox(20, message);
        root.setStyle("-fx-background-color:#282C34");
        root.setPrefSize(400, 400);

//        Scene
        primaryStage.setTitle("Server");
        Scene scene = new Scene(root);

//        Stage
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        primaryStage.setTitle("Client");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
