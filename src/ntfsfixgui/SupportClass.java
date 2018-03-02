package ntfsfixgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SupportClass {

    public static ArrayList<String> getDrives() throws IOException {

        ArrayList<String> drives = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader("/proc/partitions"));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            String text = line;
            String drivePath;

            if (text.contains("sd") && text.endsWith("0") || text.endsWith("1") || text.endsWith("2") || text.endsWith("3") || text.endsWith("4") || text.endsWith("5") || text.endsWith("6") || text.endsWith("7") || text.endsWith("8") || text.endsWith("9")) {

                int position = text.indexOf("sd");
                drivePath = "/dev/" + text.substring(position);
                File drive = new File(drivePath);
                drives.add(drive.getAbsolutePath());
                //System.out.println(drive.getAbsolutePath());
            }

            line = br.readLine();

        }

        return drives;
    }

    public static void refreshDisksComboBox(ComboBox disksComboBox, Button refreshButton ) throws IOException {

        refreshButton.setDisable( true );
        ArrayList<String> disksList = SupportClass.getDrives();
        ObservableList<String> disksObservableList = FXCollections.observableArrayList(disksList);
        disksComboBox.setItems(disksObservableList);
        refreshButton.setDisable( false );
    }
}
