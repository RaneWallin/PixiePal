/*
 Rane Wallin
 Final Programming Assignment

 IOButton extends the javafx Button class. It handles file input
 and output
 */


import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IOButton extends Button {
    private String ioType;
    private Stage stage;

    public IOButton(String buttonText, String ioType, Stage stage) {
        super(buttonText);
        this.ioType = ioType;
        this.stage = stage;
    }

    private void loadFile(String title) {
        FileChooser chooser = new FileChooser();
        FileInputStream in = null;
        ColorMap colorMap = ColorMap.getInstance();
        chooser.setTitle(title);

        File file = chooser.showOpenDialog(stage);

        if(file != null) {
            try {
                Path input = Paths.get(file.getPath());
                List<String> fileInput = new ArrayList<>();
                fileInput = Files.readAllLines(input);
                colorMap.replaceColorMap((ArrayList) fileInput);
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }

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
                List<String> fileOutput = new ArrayList<>();
                fileOutput.add(ColorMap.getInstance().getPixelSize()+"");
                Set<Pixel> pixels = (TreeSet) ColorMap.getInstance().getPixels();
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
                loadFile(title);
                break;
            default:
                System.out.println("Error");
        }
    }
}
