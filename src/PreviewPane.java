/*
  Rane Wallin
  Final programming assignment

  PreviewPane extends the FlowPane class. It shows an actual-size preview of the
  PixiePal drawing
 */

import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.*;

public class PreviewPane extends FlowPane {
    private static PreviewPane single_instance = null;

    private Map<Integer, Rectangle> pixelMap;
    private int workspaceSize = 128;
    private int bitStyle;

    public PreviewPane() {
        pixelMap = new HashMap<>();
        setMaxSize(workspaceSize, workspaceSize);
        setMinSize(workspaceSize, workspaceSize);
    }

    public void updateSpace(Pixel pix, Color color) {
        Rectangle workingPix;

        int pixID = pix.getPixID();

        if (pixelMap.get(pixID) != null) {
            workingPix = pixelMap.get(pixID);
            workingPix.setFill(color);
        } else {
            double dim = workspaceSize/bitStyle;
            workingPix = new Rectangle(dim, dim);
            workingPix.setFill(color);
            pixelMap.put(pixID, workingPix);
            getChildren().add(workingPix);
        }

    }

    protected void setBitStyle(int bitStyle) {
        this.bitStyle = bitStyle;
    }

    protected void clearPreview() {
        getChildren().clear();
        pixelMap.clear();
    }

    public static PreviewPane getInstance() {
        if (single_instance == null)
            single_instance = new PreviewPane();

        return single_instance;
    }
}
