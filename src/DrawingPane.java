import javafx.geometry.Orientation;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

import java.util.HashMap;
import java.util.Map;

public class DrawingPane extends FlowPane {

    private int workspaceSize;
    private int bitStyle;
    private PreviewPane preview;

    public DrawingPane(int workspaceSize, int bitStyle, PreviewPane preview) {
        super(Orientation.HORIZONTAL, 0, 0);
        this.bitStyle = bitStyle;
        this.workspaceSize = workspaceSize;
        this.preview = preview;
    }

    protected void createSpace(ColorPicker picker) {
        setVgap(0);
        setHgap(0);

        setMinSize(workspaceSize, workspaceSize);
        setMaxSize(workspaceSize, workspaceSize);

        for(int i = 1; i <= bitStyle*bitStyle; i++) {
            int dim = workspaceSize/bitStyle;
            Pixel pix = new Pixel(dim, i, picker);

            pix.paint(Color.WHITE);
            pix.strokePixel(StrokeType.INSIDE, Color.LIGHTGRAY, 0.25);
            pix.setPreview(preview);

            getChildren().add(pix);

        }
    }

}
