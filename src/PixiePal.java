/*

  JavaFX layouts: https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
  Stroke inside rectangle: https://stackoverflow.com/questions/40451544/javafx-setting-a-border-within-a-rectangle-to-keep-the-width-and-height
  Mouse event for rectangle: https://stackoverflow.com/questions/13359382/creating-a-mouselistner-to-javafx-rectangle
  Colorpicker: https://docs.oracle.com/javafx/2/ui_controls/color-picker.htm
  MouseDrag event: https://stackoverflow.com/questions/40702559/javafx-node-doesnt-recognize-when-mouse-is-being-dragged-over-it
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PixiePal extends Application {
    // Alternate workspace sizes (any multiple of 32 will work)
    // 320, 416, 512, 640, 800
    private final int workSpaceSize = 640;
    private final int toolBarSize = 250;
    private final int padding = 100;
    private final int stageWidth = workSpaceSize + toolBarSize;
    private final int stageHeight = workSpaceSize + padding;
    private int bitStyle = 16;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        initializeApp(stage);
    }

    private void initializeApp(Stage stage) {
        HBox mainPane = new HBox();
        DrawingPane canvas = new DrawingPane(workSpaceSize, bitStyle);
        ToolPane tools = new ToolPane(canvas, toolBarSize);
        Scene scene = new Scene(mainPane);

        mainPane.getChildren().add(canvas);
        mainPane.getChildren().add(tools);

        stage.setMinWidth(stageWidth);
        stage.setMinHeight(stageHeight);
        stage.setScene(scene);
        stage.setTitle("PixiePal");
        stage.show();
    }
}
