package sample1;

import client.ClientApp;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class Controller1 {

    public void openClient(ActionEvent event) {
       new ClientApp().start(new Stage());
    }
}
