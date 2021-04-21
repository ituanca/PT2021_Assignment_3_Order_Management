package presentationLayer;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;

public class FxmlLoader {

    private Pane view;
    public Pane getPage(String filename) {
        try{
            URL url = new File("src\\main\\java\\presentationLayer\\fxmlFiles\\" + filename + ".fxml").toURI().toURL();
            view = new FXMLLoader().load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }
}
