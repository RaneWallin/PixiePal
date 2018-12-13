/*
 Rane Wallin
 Final Programming Assignment

 ColorMap holds the color data for the active drawing
 */

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ColorMap {
    private static ColorMap single_instance = null;
    private Map<Pixel, Color> colorMap = new HashMap<>();
    private Set<Pixel> allPixels = new TreeSet<>();
    private double pixelSize = 0;

    public void addColor(Pixel pix, Color color) {
        if(pixelSize == 0) pixelSize = pix.getPixSize();
        colorMap.put(pix, color);
        allPixels.add(pix);
    }

    public Map getColorMap() {
        return colorMap;
    }

    public Color getColor(Pixel pix) {
        return colorMap.get(pix);
    }

    public void replaceColorMap(List<String> colorData) {
        double pixelSize = Double.parseDouble(colorData.get(0));
        colorMap = new HashMap<>();
        allPixels = new TreeSet<>();

        colorData.remove(0);
        PreviewPane.getInstance().clearPreview();

        for(String input: colorData) {
            String[] data = input.split(":");
            Pixel pix = new Pixel(pixelSize, Integer.parseInt(data[0]), Color.web(data[1]));
            colorMap.put(pix, Color.web(data[1]));
            allPixels.add(pix);
        }
        DrawingPane.getInstance().loadCanvas();
    }

    protected Set<Pixel> getPixels() {
        return allPixels;
    }

    protected double getPixelSize() { return pixelSize; }

    protected void clearColorMap() {
        pixelSize = 0;
        allPixels.clear();
        colorMap.clear();
    }

    public static ColorMap getInstance() {
        if (single_instance == null)
            single_instance = new ColorMap();

        return single_instance;
    }
}
