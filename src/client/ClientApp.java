package client;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class ClientApp extends Application {


    private Label labelTitle = new Label("Client Chat");
    private TextArea message = new TextArea();
    private TextField input = new TextField();
    private Button buttonSave = new Button("Save");
    private Button buttonSend = new Button("send");
    private TextField textFieldNick, textFieldIp, textFieldPuerto;
    public Client theClient = new Client("Nickname","127.0.0.1", 6000);


    @Override
    public void start(Stage primaryStage) {
       // Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));

//        Label
        labelTitle.setStyle("-fx-text-fill: #1fdece; -fx-font-size: 36px; -fx-font-family: Arial");


//       TextArea
        message.setPrefHeight(150);
        message.setStyle("-fx-font-family: Arial;" +
                "-fx-font-size: 14px; " + "-fx-control-inner-background:#373737");
        message.setEditable(false);


//       TextField
        input.setPrefWidth(350);

        textFieldNick = new TextField(theClient.getNick());
        textFieldNick.setPromptText("nickname");
        textFieldNick.setDisable(true);

        textFieldIp = new TextField(theClient.getIp());
        textFieldIp.setPromptText("your ip");

        textFieldPuerto = new TextField(String.valueOf(theClient.getPuerto()));
        textFieldPuerto.setPromptText("puerto");

//        Button
        buttonSend.setPrefWidth(50);
        buttonSend.setOnAction(event -> {
            ControllerClient.sendMessage(theClient, input, message);
        });

        buttonSave.setOnAction(event -> {
            ControllerClient.saveNewConfig(theClient, textFieldIp, textFieldPuerto);
        });

//        HBox
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(textFieldNick, textFieldIp, textFieldPuerto);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(input, buttonSend);



//        VBox
        VBox root = new VBox(40);
        root.setStyle("-fx-background-color:#282C34");
        root.setPrefSize(400, 400);
        root.getChildren().addAll(labelTitle, hBox1, buttonSave, message, hBox2);
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
