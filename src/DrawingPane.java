import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

import java.util.HashMap;
import java.util.Map;

public class DrawingPane extends FlowPane {

    private int workspaceSize;
    private int bitStyle;
    private Map<Integer, Color> colorMap = new HashMap<>();
    Color curColor;

    public DrawingPane(int workspaceSize, int bitStyle) {
        super(Orientation.HORIZONTAL, 0, 0);
        this.bitStyle = bitStyle;
        this.workspaceSize = workspaceSize;
        curColor = Color.BLACK;
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
            colorMap.put(pix.getPixID(), Color.WHITE);

            pix.setFill(colorMap.get(pix.getPixID()));
            pix.strokePixel(StrokeType.INSIDE, Color.LIGHTGRAY, 0.25);

            pix.setOnMousePressed(new EventHandler<MouseEvent>() {
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
        colorMap.put(pix.getPixID(), curColor);
    }
}
