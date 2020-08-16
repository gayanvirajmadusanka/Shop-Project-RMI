package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardController {
    public void openCustomerForm(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("../view/CustomerForm.fxml"));
        Scene scene= new Scene(load);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
