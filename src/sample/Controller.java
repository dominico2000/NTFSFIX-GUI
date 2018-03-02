package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class Controller {

    @FXML
    public ComboBox disksComboBox;
    public Button refreshButton;
    public Button repairButton;
    public TextArea logTextArea;

    @FXML
    public void initialize() throws IOException {

        SupportClass.refreshDisksComboBox( disksComboBox, refreshButton );

    }

    @FXML
    public void refreshButtonClick(ActionEvent actionEvent) throws IOException {

        SupportClass.refreshDisksComboBox( disksComboBox, refreshButton);
    }
    

}

