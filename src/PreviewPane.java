import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

import java.util.*;

public class PreviewPane extends FlowPane {
    private Map<Integer, Pixel> pixels;
    private int workspaceSize = 128;
    private int bitStyle;

    public PreviewPane(int bitStyle) {
        this.bitStyle = bitStyle;
        pixels = new HashMap<>();
        updateSpace();
    }

    private void updateSpace() {
        setVgap(0);
        setHgap(0);

        setMinSize(workspaceSize, workspaceSize);
        setMaxSize(workspaceSize, workspaceSize);
        setPrefWrapLength(workspaceSize);

        for(int i = 1; i <= bitStyle*bitStyle; i++) {
            int dim = workspaceSize/bitStyle;
            Pixel pix = new Pixel(dim, i, Color.WHITE);
            pixels.put(pix.getPixID(), pix);

            getChildren().add(pix);
        }
    }

    public void updateSpace(Pixel pix, Color color) {
        int pixID = pix.getPixID();
        Pixel workingPix = pixels.get(pixID);

        workingPix.paint(color);
    }
}
