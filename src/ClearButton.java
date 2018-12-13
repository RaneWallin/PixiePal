/*
 Rane Wallin
 Final Programming Project

 ClearButton extends the javafx Button class. It clears the canvas when clicked
 */
import javafx.scene.control.Button;

public class ClearButton  extends Button {

    public ClearButton(String text) {
        super(text);
    }

    public void fire() {
        DrawingPane.getInstance().createNew();
    }
}
