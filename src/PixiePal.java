/*
  Rane Wallin
  Final Programming Project
  PixiePal is a simple pixel art style drawing tool for drawing tiles for RPG games

  JavaFX layouts: https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
  Stroke inside rectangle: https://stackoverflow.com/questions/40451544/javafx-setting-a-border-within-a-rectangle-to-keep-the-width-and-height
  Mouse event for rectangle: https://stackoverflow.com/questions/13359382/creating-a-mouselistner-to-javafx-rectangle
  Colorpicker: https://docs.oracle.com/javafx/2/ui_controls/color-picker.htm
  MouseDrag event: https://stackoverflow.com/questions/40702559/javafx-node-doesnt-recognize-when-mouse-is-being-dragged-over-it
  Singleton: https://www.geeksforgeeks.org/singleton-class-java/
  File handling: https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
  File IO: https://www.tutorialspoint.com/java/java_files_io.htm
  File IO: https://docs.oracle.com/javase/7/docs/api/index.html?java/nio/file/Files.html
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PixiePal extends Application {
    // Alternate workspace sizes (any multiple of 32 will work)
    // 320, 416, 512, 640, 800
    private final int workSpaceSize = 640;
    private final int toolBarSize = 250;
    private final int padding = 100;
    private final int stageWidth = workSpaceSize + toolBarSize;
    private final int stageHeight = workSpaceSize + padding;
    private int bitStyle = 32;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        initializeApp(stage);
    }

    private void initializeApp(Stage stage) {
        GridPane mainPane = new GridPane();

        DrawingPane canvas = DrawingPane.getInstance();
        PreviewPane.getInstance().setBitStyle(bitStyle);

        canvas.setBitStyle(bitStyle);
        canvas.setWorkspaceSize(workSpaceSize);




        ToolPane tools = new ToolPane(toolBarSize, stage);
        Scene scene = new Scene(mainPane);

        mainPane.setHgap(10);
        mainPane.setVgap(10);
        mainPane.setPadding(new Insets(10, 10, 10, 10));

        mainPane.add(canvas, 0, 0);
        mainPane.add(tools, 1, 0);
        mainPane.setStyle("-fx-background-color: lightgray");

        stage.setMinWidth(stageWidth);
        stage.setMinHeight(stageHeight);
        stage.setScene(scene);
        stage.setTitle("PixiePal");
        stage.show();
    }
}
