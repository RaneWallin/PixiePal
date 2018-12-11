import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PixiePal extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        initializeApp(stage);
    }

    private void initializeApp(Stage stage) {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane);
    }
}
