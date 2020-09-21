package sample1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private AnchorPane anchorPaneServer;

    @FXML
    private Label labelTittle1;

    @FXML
    private Label labelTittle2;

    @FXML
    private Label labelIp;

    @FXML
    private Label labelPuerto;

    @FXML
    private TextField textFieldIp;

    @FXML
    private TextField textFieldPuerto;

    @FXML
    private Button buttonSaveServer;

    @FXML
    void saveServer(ActionEvent event) {
        System.out.println(textFieldIp.getText());
    }

}
