/*
  Rane Wallin
  Final Programming Assignment

  Pixel extends the javafx Rectangle class and implements the Comparable interface
  Pixel contains the data for each individual pixel, as well as the logic and
  EventHandlers
 */

import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Pixel extends Rectangle implements Comparable<Pixel> {
    private final int pixID;
    private ColorPicker picker;
    ColorMap colorMap = ColorMap.getInstance();

    public Pixel(double dim, int pixID, ColorPicker picker) {
        this(dim, pixID);
        this.picker = picker;
        setHandlers();
    }

    public Pixel(double dim, int pixID, Color color) {
        this(dim, pixID);
        paint(color);
    }

    public Pixel(double dim, int pixID) {
        super(dim, dim);
        this.pixID = pixID;
    }

    public int getPixID() { return pixID; }

    public double getPixSize() {
        return getHeight();
    }

    protected void addPicker(ColorPicker picker) {
        this.picker = picker;
        setHandlers();
    }

    public void strokePixel(StrokeType type, Color strokeColor, double strokeWidth) {
        setStrokeType(type);
        setStroke(strokeColor);
        setStrokeWidth(strokeWidth);
    }

    public void paint(Color color) {
        PreviewPane preview = PreviewPane.getInstance();

        setFill(color);
        if (preview != null) preview.updateSpace(this, color);


        colorMap.addColor(this, color);
    }

    private void setHandlers() {
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                paint(picker.getValue());
            }
        });

        setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startFullDrag();
            }
        });

        setOnMouseDragOver(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                paint(picker.getValue());
            }
        });
    }

    @Override
    public int compareTo(Pixel otherPixel) {
        int compared;

        if (otherPixel.getPixID() == this.pixID) compared = 0;
        else
        if (otherPixel.getPixID() > this.pixID) compared = -1;
        else compared = 1;

        return compared;
    }

}
