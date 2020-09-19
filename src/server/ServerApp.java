package server;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class ServerApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

//        Button
        Button button1 = new Button("Start");

//       TextField
        TextArea message = new TextArea();

//        VBox
        VBox root = new VBox(20, button1, message);
        root.setStyle("-fx-background-color:#282C34");
        root.setPrefSize(400, 400);

//        Scene
        primaryStage.setTitle("Server");
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
