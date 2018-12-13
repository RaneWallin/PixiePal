/*
  Rane Wallin
  Final Programming Project

  ToolPane extends the GridPane. It holds the drawing tools for the PixiePal drawing program
 */
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ToolPane extends GridPane {
    private final String PICKER_STYLE = "split-button";
    private final String PICKER_LABEL = "Pick a Color";
    private final String PREVIEW_LABEL = "Preview";
    private final Stage stage;
    ColorPicker picker = new ColorPicker(Color.BLACK);


    public ToolPane(double minWidth, Stage stage) {
        super();
        this.stage = stage;


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

        IOButton saveButton = new IOButton("Save", "save", stage);
        IOButton loadButton = new IOButton("Load", "load", stage);

        ClearButton clearButton = new ClearButton("New");

        buttonPane.setHgap(5);
        buttonPane.setVgap(5);
        buttonPane.add(saveButton, 0, 0);
        buttonPane.add(loadButton, 1, 0);
        buttonPane.add(clearButton, 2, 0);

        add(buttonPane, 0, 4);
    }

    private void addPicker() {
        Label pickerLabel = new Label(PICKER_LABEL);

        picker.getStyleClass().add(PICKER_STYLE);

        DrawingPane.getInstance().addPicker(picker);
        DrawingPane.getInstance().createNew();

        add(pickerLabel, 0, 2);
        add(picker, 0, 3);
    }

    private void addPreview() {
        Label previewLabel = new Label(PREVIEW_LABEL);
        PreviewPane preview = PreviewPane.getInstance();

        add(previewLabel, 0, 0);
        add(PreviewPane.getInstance(), 0, 1);
    }


}
