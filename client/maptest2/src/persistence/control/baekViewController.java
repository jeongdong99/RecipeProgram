package persistence.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import persistence.MyInfo;
import persistence.RequestData;
import persistence.dto.Baek_dto;
import persistence.dto.Cooktool_dto;
import persistence.network.Protocol;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class baekViewController implements Initializable {
    Socket socket = null;

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private Baek_dto baek_dto;

    private List<Baek_dto> baek_dtos_rand;

    private List<Baek_dto> baek_dtos_rands;
    @FXML
    private WebView baekImage;
    @FXML
    private Label label_recipe_name;
    @FXML
    private Label label_recipe_ings;
    @FXML
    private Label recipeStep;
    @FXML
    private WebView thumbnail;
    @FXML
    private WebView thumbnail2;

    public void initBaekData(Baek_dto baek_dto) {
        this.baek_dto = baek_dto;
        baekImage.getEngine().load(this.baek_dto.getImage_url());
        label_recipe_name.setText(this.baek_dto.getBaek_title());
        label_recipe_ings.setText(this.baek_dto.getBaek_ingredient());
        recipeStep.setText(this.baek_dto.getBaek_recipe());
    }
    public void initBaekData(Baek_dto baek_dto,List<Baek_dto> baek_dtos_rand) {
        this.baek_dto = baek_dto;
        this.baek_dtos_rand = baek_dtos_rand;

        baekImage.getEngine().load(this.baek_dto.getImage_url());
        label_recipe_name.setText(this.baek_dto.getBaek_title());
        label_recipe_ings.setText(this.baek_dto.getBaek_ingredient());
        recipeStep.setText(this.baek_dto.getBaek_recipe());
        thumbnail.getEngine().load(this.baek_dtos_rand.get(0).getImage_url());
        thumbnail2.getEngine().load(this.baek_dtos_rand.get(1).getImage_url());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(MyInfo.socketConnect);
        if(MyInfo.socketConnect){
            socket = MyInfo.getSocket();

            objectOutputStream = MyInfo.getObjectOutputStream();
            objectInputStream = MyInfo.getObjectInputStream();
        }
    }

    public void goYoutube(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
        showYoutubeView(0);
    }
    public void showYoutubeView(int num){
        if(this.baek_dto.getBaek_title() != null){
            WebView webView = new WebView();
            WebEngine engine = webView.getEngine();
            String html = this.baek_dto.getVideo_url();
            engine.load(html);
            Stage stage = new Stage();
            Scene scene = new Scene(webView, 1500, 1000);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void goBaekView(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
        showBaekViewCon(0);
    }
    public void goBaekView2(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
        showBaekViewCon(1);
    }

    public void showBaekViewCon(int a)throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../fxml/baekView.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        baekViewController baekCon = (baekViewController)fxmlLoader.getController();
        RequestData requestBaekDataRandom = new RequestData(Protocol.REQUEST, Protocol.BAEK, Protocol.SELECT_BY_RAND_BAEK);
        objectOutputStream.writeObject(requestBaekDataRandom);
        baek_dtos_rands = (List<Baek_dto>) objectInputStream.readObject();
        baekCon.initBaekData(baek_dtos_rand.get(a),baek_dtos_rands);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("백종원");
        stage.show();
    }


}
