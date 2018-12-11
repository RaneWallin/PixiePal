import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import java.util.Map;

public class PreviewPane extends FlowPane {
    private Map<Pixel, Color> pixelMap;
    private int workspaceSize = 32;
    private int bitStyle;

    public PreviewPane(int bitStyle) {
        this.bitStyle = bitStyle;
        updateSpace();
    }

    public void updateColors(Map<Pixel, Color> pixelMap) {
        this.pixelMap = pixelMap;

    }

    private void updateSpace() {
        for(int i = 1; i <= bitStyle*bitStyle; i++) {
            int dim = workspaceSize/bitStyle;
            Pixel pix = new Pixel(dim);
            pixelMap.put(pix, Color.WHITE);

            pix.setFill(pixelMap.get(pix.getPixID()));

            getChildren().add(pix);
        }
    }

    private void updateSpace(Map<Pixel, Color> pixelMap) {

    }
}
