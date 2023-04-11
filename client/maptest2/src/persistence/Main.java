package persistence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import netscape.javascript.JSException;

/**
 * JavaFx with Google map simple sample.
 *
 * @author tomo
 */
public class Main extends Application{
    @Override
    public void start(Stage stage) throws Exception, JSException {

        Parent root = FXMLLoader.load(getClass().getResource("fxml/MainYeah.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("메인화면");
        stage.show();

        /*VBox root = new VBox(10);
        HBox hbox2 = new HBox(10);
        hbox2.setPadding(new Insets(15,12,15,12));
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        String html = getClass().getResource("sample.html").toExternalForm();
        engine.load(html);
        hbox2.getChildren().addAll(webView);
        // JavaScript can call Java method using the name app
        root.getChildren().addAll(hbox2);
        Scene scene = new Scene(root, 500, 470);
        stage.setScene(scene);
        stage.show();*/
        /*Parent root = FXMLLoader.load(getClass().getResource("fxml/mainView.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("레시피 검색");
        stage.show();*/
    }

    public static void main(String[] args) {
        launch();
    }

}
