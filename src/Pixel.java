import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Pixel extends Rectangle {
    private int pixID;
    private static int totalIDs;

    public Pixel(double dim) {
        super(dim, dim);
        totalIDs++;
    }

    //public void setFill(Color color) { setFill(color); }

    public int getPixID() { return pixID; }

    public void setPixID(int id) { this.pixID = id; }

    public void strokePixel(StrokeType type, Color strokeColor, double strokeWidth) {
        setStrokeType(type);
        setStroke(strokeColor);
        setStrokeWidth(strokeWidth);
    }
}
