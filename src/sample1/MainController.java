package sample1;

import client.Client;
import client.ClientObject;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import server.Server;

import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MainController {


    //Server ATTRIBUTES

    @FXML
    private TextField textFieldPuerto;

    public Server THESERVER;

    public ArrayList<ClientObject> ListClients = new ArrayList<ClientObject>();

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
        try {
            textFieldIpC.setText(InetAddress.getLocalHost().getHostAddress());
                textFieldIpC.setEditable(false);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            int puertoServer = Integer.parseInt(textFieldPuerto.getText());
            if (puertoServer >= 5000) {
               
                try {
                    this.THESERVER = new Server(puertoServer);
                    
                    
//                    The new Root
                    Parent root = FXMLLoader.load(getClass().getResource("MainView2.fxml"));
                    MainApp.primaryStage.setTitle("Chat Sockets");
                    MainApp.primaryStage.setScene(new Scene(root));
                    MainApp.primaryStage.show();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de puerto digita otro");
        }
    }

    //    Create the Client
    @FXML
    void createClient(ActionEvent event) {

        System.out.println("cliente creado\n\n\n");

//
        try {
            int puertoClient = Integer.parseInt(textFieldPuertoC.getText());

            boolean equalOtherPorts = false;



            if (puertoClient >= 5000 && !equalOtherPorts ) {
                new Client(textFieldNickNameC.getText(), textFieldIpC.getText(), puertoClient);
            }

        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("Error de numero");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


