package client;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Client implements Runnable {

    static private int  clientNumber = 1;
    private Stage primaryStage = new Stage();
    private Label labelTitle = new Label();
    private TextArea message = new TextArea();
    private TextField input = new TextField();
    private Button buttonSave = new Button("Save");
    private Button buttonSend = new Button("send");
    private TextField textFieldIp;
    private TextField textFieldPuerto;
    private ClientObject theClientObject = new ClientObject("Nickname","127.0.0.1", 6000);

    public Client(String name, String ip, int puerto){
        this.theClientObject = new ClientObject(name, ip, puerto);
        display();
        this.clientNumber ++;
        Thread t =new Thread(this);
        t.start();

    }

    public void display() {
       // Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));

//        Label
        labelTitle.setText("Client " + this.clientNumber);
        labelTitle.setStyle("-fx-text-fill: #1fdece; -fx-font-size: 36px; -fx-font-family: Arial");


//       TextArea
        message.setPrefHeight(150);
        message.setStyle("-fx-font-family: Arial;" +
                "-fx-font-size: 14px; " + "-fx-control-inner-background:#373737");
        message.setEditable(false);


//       TextField
        input.setPrefWidth(350);

        TextField textFieldNick = new TextField(theClientObject.getNick());
        message.setEditable(false);

        textFieldIp = new TextField(theClientObject.getIp());
        message.setEditable(false);

        textFieldPuerto = new TextField(String.valueOf(theClientObject.getPuerto()));
        message.setEditable(false);

//        Button
        buttonSend.setPrefWidth(50);
        buttonSend.setOnAction(event -> {
            ControllerClient.sendMessage(theClientObject, input, message);
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
        primaryStage.setTitle("Client " + this.clientNumber);
        Scene scene = new Scene(root);

//        Stage
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket =  new ServerSocket( theClientObject.getPuerto() );
            Socket socket;
            while (true){
                socket = serverSocket.accept();

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                ClientObject clientObjectWriter = (ClientObject) objectInputStream.getObjectInputFilter();

                this.message.appendText(clientObjectWriter.getNick() + ": " + clientObjectWriter.getText() + "\n" );

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Aqui mame en run del cliente " + clientNumber);
            System.out.println("\n\n\n");
        }

    }
}
