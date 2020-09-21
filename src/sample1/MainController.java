package sample1;

import client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import server.Server;

import java.io.IOException;

public class MainController {



    //Server ATTRIBUTES

    @FXML
    private TextField textFieldPuerto;

    //Client ATTRIBUTES

    @FXML
    private TextField textFieldPuertoC;

    @FXML
    private TextField textFieldIpC;

    @FXML
    private TextField textFieldNickNameC;





//    Create the Server
    @FXML
    void saveServer(ActionEvent event) {

        try{
            int puertoServer = Integer.parseInt(textFieldPuerto.getText());
            if (puertoServer >= 5000) {
                try {
                    new Server(puertoServer);
                    Parent root = FXMLLoader.load(getClass().getResource("MainView2.fxml"));
                    MainApp.primaryStage.setTitle("Chat Sockets");
                    MainApp.primaryStage.setScene(new Scene(root));
                    MainApp.primaryStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (NumberFormatException ex){
            System.out.println("Digita numero enteros");
        }
    }

//    Create the Client
    @FXML
    void createClient(ActionEvent event) {

        System.out.println("cliente creado");

//
//        try {
            int puertoClient = Integer.parseInt(textFieldPuertoC.getText());
            if (puertoClient >= 5000) {
                System.out.println(textFieldNickNameC.getText());
                System.out.println(textFieldIpC.getText());
                System.out.println(puertoClient);

                new Client(textFieldNickNameC.getText(), textFieldIpC.getText(), puertoClient);
            }
//        }catch (NumberFormatException ex){
//            System.out.println("Digita numero enteros en el puerto");
//        }catch (Exception ex){
//            System.out.println("algo hiciste mal");
//        }
    }

}
