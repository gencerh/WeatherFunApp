package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class WeatherApp {



    public Parent start(Stage stage) throws IOException {
        URL url = new File("src/sample/sample.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            return root;
            //stage.setScene(new Scene(root));

    }


}
