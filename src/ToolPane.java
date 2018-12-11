import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class ToolPane extends GridPane {

    private final DrawingPane canvas;
    private final PreviewPane preview;
    private final String labelFontWeight = "-fx-font-weight: 500";

    public ToolPane(DrawingPane canvas, PreviewPane preview, double minWidth) {
        super();
        this.canvas = canvas;
        this.preview = preview;

        setAlignment(Pos.TOP_CENTER);
        setMinWidth(minWidth);
        setPadding(new Insets(10, 10, 10, 10));
        setHgap(10);
        setVgap(10);

        createToolPane();
    }

    private void createToolPane() {
        addPreview();
        addPicker();
        addButtons();
    }

    private void addButtons() {
        GridPane buttonPane = new GridPane();
        IOButton saveButton = new IOButton("Save", "save");
        IOButton loadButton = new IOButton("Load", "load");

        buttonPane.setHgap(5);
        buttonPane.setVgap(5);
        buttonPane.add(saveButton, 0, 0);
        buttonPane.add(loadButton, 1, 0);

        add(buttonPane, 0, 4);
    }

    private void addPicker() {
        ColorPicker picker = new ColorPicker(Color.BLACK);

        Label pickerLabel = new Label("Pick Color");
        pickerLabel.setStyle(labelFontWeight);

        picker.getStyleClass().add("split-button");
        picker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                canvas.setColor(picker.getValue());
            }
        });

        add(pickerLabel, 0, 2);
        add(picker, 0, 3);
    }

    private void addPreview() {
        Label previewLabel = new Label("Preview");
        previewLabel.setStyle(labelFontWeight);
        add(previewLabel, 0, 0);
        add(preview, 0, 1);
    }


}
