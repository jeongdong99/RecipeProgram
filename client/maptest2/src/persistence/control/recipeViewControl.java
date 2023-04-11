package persistence.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import persistence.MyInfo;
import persistence.RequestData;
import persistence.dto.*;
import persistence.network.Protocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class recipeViewControl implements Initializable{

    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private Recipe_dto recipe_dto;

    @FXML
    private Label recipe_name;
    @FXML
    private Label recipe_time;
    @FXML
    private Label recipe_level;
    @FXML
    private Label recipe_ingredients;
    @FXML
    private Label recipe_step;
    @FXML
    private WebView product_webView1;
    @FXML
    private Label product_name1;
    @FXML
    private Label product_price1;
    @FXML
    private WebView product_webView2;
    @FXML
    private Label product_name2;
    @FXML
    private Label product_price2;
    @FXML
    private WebView cooktool_webView1;
    @FXML
    private Label cooktool_name1;
    @FXML
    private Label cooktool_price1;
    @FXML
    private WebView cooktool_webView2;
    @FXML
    private Label cooktool_name2;
    @FXML
    private Label cooktool_price2;

    private List<Cooktool_dto> cooktool_list = new ArrayList<>();
    private List<Product_dto> product_list = new ArrayList<>();

    public void initRecipeData(Recipe_dto _recipe_dto){
        setInitRecipeData(_recipe_dto);
    }

    public void initRecipeData(Recipe_dto _recipe_dto, List<Cooktool_dto> cooktool_Ad_list, List<Product_dto> product_Ad_list) {
        setInitRecipeData(_recipe_dto);
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        cooktool_list = cooktool_Ad_list;
        cooktool_webView1.getEngine().load(cooktool_list.get(0).getCooktool_img());
        cooktool_name1.setText(cooktool_list.get(0).getCooktool_name());
        cooktool_price1.setText(cooktool_list.get(0).getCooktool_price()+"원");
        cooktool_webView2.getEngine().load(cooktool_list.get(1).getCooktool_img());
        cooktool_name2.setText(cooktool_list.get(1).getCooktool_name());
        cooktool_price2.setText(cooktool_list.get(1).getCooktool_price()+"원");


        product_list = product_Ad_list;
        product_webView1.getEngine().load(product_list.get(0).getProduct_img());
        product_name1.setText(product_list.get(0).getProduct_name());
        product_price1.setText(decimalFormat.format(Integer.parseInt(product_list.get(0).getProduct_price()))+"원");
        product_webView2.getEngine().load(product_list.get(1).getProduct_img());
        product_name2.setText(product_list.get(1).getProduct_name());
        product_price2.setText(decimalFormat.format(Integer.parseInt(product_list.get(1).getProduct_price()))+"원");
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

    public void showProductURL1(MouseEvent mouseEvent) {
        setShowProductURL(0);
    }

    public void showProductURL2(MouseEvent mouseEvent) {
        setShowProductURL(1);
    }


    public void showCooktoolURL1(MouseEvent mouseEvent) {
        setShowCooktoolURL(0);
    }

    public void showCooktoolURL2(MouseEvent mouseEvent) {
        setShowCooktoolURL(1);
    }

    public void setInitRecipeData(Recipe_dto _recipe_dto){
        this.recipe_dto = _recipe_dto;
        recipe_name.setText(recipe_dto.getRecipe_name());
        recipe_time.setText(recipe_dto.getRecipe_time()+"분");
        recipe_level.setText(recipe_dto.getRecipe_level());
        recipe_ingredients.setText(recipe_dto.getRecipe_ingredient().replace("#"," "));
        recipe_step.setText(recipe_dto.getRecipe_step().replace("#","\n\n"));
    }

    public void setShowProductURL(int num){
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        String html = product_list.get(num).getProduct_url();
        engine.load(html);
        Stage stage = new Stage();
        Scene scene = new Scene(webView, 1500, 1000);
        stage.setScene(scene);
        stage.show();
    }

    public void setShowCooktoolURL(int num){
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        String html = cooktool_list.get(num).getCooktool_url();
        engine.load(html);
        Stage stage = new Stage();
        Scene scene = new Scene(webView, 1500, 1000);
        stage.setScene(scene);
        stage.show();
    }

}
