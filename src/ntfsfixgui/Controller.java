package ntfsfixgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.io.InputStream;

public class Controller {

    @FXML
    public ComboBox disksComboBox;
    public Button refreshButton;
    public Button repairButton;
    public TextArea logTextArea;
    public CheckBox clearBadSectorsCheckBox;
    public CheckBox clearVolumeDirtyFlagCheckBox;

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
        String params = new String();
        String diskPath = disksComboBox.getSelectionModel().getSelectedItem().toString();

        repairButton.setDisable( true );
        refreshButton.setDisable( true );

        if( clearBadSectorsCheckBox.isSelected() ) params += "-b ";
        if( clearVolumeDirtyFlagCheckBox.isSelected() ) params += "-d ";

        String command = "ntfsfix " + params + diskPath;

        Process ntfsfix = Runtime.getRuntime().exec( command );

        logTextArea.setText("Running " + command + "\n");

        InputStream out = ntfsfix.getInputStream();

        toLogTextArea = logTextArea.getText();
        int c;
        while ((c = out.read()) != -1) {
            toLogTextArea += (char)c;
            logTextArea.setText(toLogTextArea);
        }
        out.close();

        repairButton.setDisable( false );
        refreshButton.setDisable( false );
    }

}

