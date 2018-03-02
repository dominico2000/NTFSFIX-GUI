package ntfsfixgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.io.InputStream;

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
    public void onRefreshButtonClick(ActionEvent actionEvent) throws IOException {

        SupportClass.refreshDisksComboBox( disksComboBox, refreshButton);
    }

    @FXML
    private void onRepairButtonClick(ActionEvent actionEvent) throws  IOException{

        logTextArea.clear();
        String toLogTextArea = new String();
        String diskPath = disksComboBox.getSelectionModel().getSelectedItem().toString();

        repairButton.setDisable( true );
        refreshButton.setDisable( true );

        Process ntfsfix = Runtime.getRuntime().exec( "ntfsfix " + diskPath);
        logTextArea.setText("Repairing...");

        InputStream out = ntfsfix.getInputStream();

        int c;
        while ((c = out.read()) != -1) {
            toLogTextArea = toLogTextArea + (char)c;
            logTextArea.setText(toLogTextArea);
        }
        out.close();

        repairButton.setDisable( false );
        refreshButton.setDisable( false );
    }

}

