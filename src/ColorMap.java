import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColorMap {
    private static ColorMap single_instance = null;
    private Map<Pixel, Color> colorMap = new HashMap<>();
    private List<Pixel> allPixels = new ArrayList<>();

    public void addColor(Pixel pix, Color color) {
        colorMap.put(pix, color);
        allPixels.add(pix);
    }

    public Map getColorMap() {
        return colorMap;
    }

    public Color getColor(Pixel pix) {
        return colorMap.get(pix);
    }

    protected List<Pixel> getPixels() {
        return allPixels;
    }

    public static ColorMap getInstance() {
        if (single_instance == null)
            single_instance = new ColorMap();

        return single_instance;
    }
}
