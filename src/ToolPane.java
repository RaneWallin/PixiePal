import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ToolPane extends VBox {

    private final DrawingPane canvas;

    public ToolPane(DrawingPane canvas, double minWidth) {
        super();
        this.canvas = canvas;
        setMinWidth(minWidth);
        setAlignment(Pos.TOP_CENTER);

        createToolPane();
    }

    private void createToolPane() {
        ColorPicker picker = new ColorPicker(Color.BLACK);
        picker.getStyleClass().add("split-button");
        picker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                canvas.setColor(picker.getValue());
            }
        });

        getChildren().add(picker);
    }


}
