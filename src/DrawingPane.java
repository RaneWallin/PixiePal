/*
 Rane Wallin
 Final Programming Project

 DrawingPane extends the FlowPane class. It represents the drawing canvas
 */
import javafx.geometry.Orientation;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

import java.util.Set;

public class DrawingPane extends FlowPane {
    private static DrawingPane single_instance = null;

    private int workspaceSize;
    private int bitStyle;
    private ColorPicker picker;

    public DrawingPane() {
        super(Orientation.HORIZONTAL, 0, 0);
    }

    protected void createNew() {
        ColorMap colorMap = ColorMap.getInstance();
        this.picker = picker;

        setVgap(0);
        setHgap(0);

        setMinSize(workspaceSize, workspaceSize);
        setMaxSize(workspaceSize, workspaceSize);

        colorMap.clearColorMap();
        getChildren().clear();

        for(int i = 1; i <= bitStyle*bitStyle; i++) {
            int dim = workspaceSize/bitStyle;
            Pixel pix = new Pixel(dim, i, picker);

            pix.paint(Color.WHITE);
            pix.strokePixel(StrokeType.INSIDE, Color.LIGHTGRAY, 0.25);
            PreviewPane.getInstance().updateSpace(pix, colorMap.getColor(pix));

            colorMap.addColor(pix, Color.WHITE);

            getChildren().add(pix);

        }
    }

    protected void addPicker(ColorPicker picker) {
        this.picker = picker;
    }

    protected void setBitStyle(int bitStyle) {
        this.bitStyle = bitStyle;
    }

    protected void setWorkspaceSize(int workspaceSize) {
        this.workspaceSize = workspaceSize;
    }

    protected void loadCanvas() {
        ColorMap colorMap = ColorMap.getInstance();

        Set<Pixel> pixels = colorMap.getPixels();
        getChildren().clear();

        for(Pixel pixel: pixels) {
            pixel.strokePixel(StrokeType.INSIDE, Color.LIGHTGRAY, 0.25);
            pixel.addPicker(picker);
            getChildren().add(pixel);

        }

    }

    public static DrawingPane getInstance() {
        if (single_instance == null)
            single_instance = new DrawingPane();

        return single_instance;
    }

}
