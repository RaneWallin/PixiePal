import javafx.scene.control.Button;

public class IOButton extends Button {
    String ioType;

    public IOButton(String buttonText, String ioType) {
        super(buttonText);
        this.ioType = ioType;
    }
}
