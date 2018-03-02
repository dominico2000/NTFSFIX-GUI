package sample;

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
}
