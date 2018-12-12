import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class IOButton extends Button {
    private String ioType;
    private Stage stage;

    public IOButton(String buttonText, String ioType, Stage stage) {
        super(buttonText);
        this.ioType = ioType;
        this.stage = stage;
    }

    private File openFile(String title) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle(title);
        return chooser.showOpenDialog(stage);
    }

    private void saveFile(String title) {
        FileChooser chooser = new FileChooser();
        FileOutputStream out = null;
        ColorMap colorMap = ColorMap.getInstance();
        chooser.setTitle(title);

        File file = chooser.showSaveDialog(stage);

        if(file != null) {
            try {
                Path output = Paths.get(file.getPath());
                ArrayList<String> fileOutput = new ArrayList<>();
                ArrayList<Pixel> pixels = (ArrayList) ColorMap.getInstance().getPixels();
                for(Pixel pixel: pixels) {
                    fileOutput.add(pixel.getPixID()+":"+ColorMap.getInstance().getColor(pixel));
                }
                Files.write(output, fileOutput, Charset.forName("UTF-8"));
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void fire() {
        String title = ioType.replace(ioType.substring(0, 1),
                ioType.substring(0, 1).toUpperCase()) + " a File";

        switch(ioType) {
            case "save":
                saveFile(title);
                break;
            case "load":
                break;
            default:
                System.out.println("Error");
        }
    }
}
