import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

import java.util.HashMap;
import java.util.Map;

public class DrawingPane extends FlowPane {

    private int workspaceSize;
    private int bitStyle;
    private Map<Pixel, Color> colorMap;
    private PreviewPane preview;
    private Color curColor;

    public DrawingPane(int workspaceSize, int bitStyle, PreviewPane preview) {
        super(Orientation.HORIZONTAL, 0, 0);
        this.bitStyle = bitStyle;
        this.workspaceSize = workspaceSize;
        colorMap = new HashMap<>();
        curColor = Color.BLACK;
        this.preview = preview;
        createSpace();
    }

    private void createSpace() {
        setVgap(0);
        setHgap(0);

        setMinSize(workspaceSize, workspaceSize);
        setMaxSize(workspaceSize, workspaceSize);

        for(int i = 1; i <= bitStyle*bitStyle; i++) {
            int dim = workspaceSize/bitStyle;
            Pixel pix = new Pixel(dim);
            pix.setPixID(i);
            colorMap.put(pix, Color.WHITE);

            pix.setFill(colorMap.get(pix));
            pix.strokePixel(StrokeType.INSIDE, Color.LIGHTGRAY, 0.25);

            pix.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    doDraw(pix);
                }
            });

            pix.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    pix.startFullDrag();
                }
            });

            pix.setOnMouseDragOver(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    doDraw(pix);
                }
            });

            getChildren().add(pix);

        }
    }

    public void setColor(Color color) {
        this.curColor = color;
    }

    private void doDraw(Pixel pix) {
        pix.setFill(curColor);
        colorMap.put(pix, curColor);
        preview.updateSpace(pix, curColor);
    }
}
