package persistence.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistence.MyInfo;
import persistence.RequestData;
import persistence.dto.Cooktool_dto;
import persistence.dto.Ingredient_dto;
import persistence.dto.Product_dto;
import persistence.dto.Recipe_dto;
import persistence.network.Protocol;

// requestData import 해야 됨
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class recipeControl implements Initializable {

    Socket socket = null;


    private List<String> recipe_ingredients = null;
    private List<Cooktool_dto> cooktool_Ad_list = new ArrayList<>();
    private List<Product_dto> product_Ad_list = new ArrayList<>();
    private List<Ingredient_dto> ingredient_dto = new ArrayList<>();
    private int recipe_time = 0;
    private String recipe_level = "";
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private List<Recipe_dto> list;
    private List<Product_dto> product_list;
    private List<Cooktool_dto> cooktool_list;

    @FXML
    private Button btn_search_recipe_title;
    @FXML
    private TextField recipe_search_txt;
    @FXML
    private ListView listview_recipe_list;
    @FXML
    private Button btn_next_page;
    @FXML
    private Button btn_prev_page;
    @FXML
    private Label label_page_num;
    @FXML
    private Label recipe_search_label1;
    @FXML
    private Label recipe_search_label2;
    @FXML
    private Label recipe_search_label3;
    @FXML
    private Label recipe_search_label4;
    @FXML
    private Label recipe_search_label5;
    @FXML
    private Label recipe_search_label6;
    @FXML
    private Label recipe_search_label7;
    @FXML
    private Label recipe_search_label8;

    private String prev_text;

    private List<Label> recipe_search_labels = new ArrayList<>();
    private int protocolType;
    private int protocolAction;
    private int protocolMethod;
    private HashMap<String, Object> curContents = null;

    public void initData(Object object,String text) {
        prev_text = text;
        list = (List<Recipe_dto>)object;
    }

    public void initData(int protocolType, int protocolAction, int protocolMethod, HashMap<String, Object> hashMap, Object object) {
        this.protocolType = protocolType;
        this.protocolAction = protocolAction;
        this.protocolMethod = protocolMethod;
        curContents = (HashMap<String, Object>)hashMap.clone();
        list = (List<Recipe_dto>) object;
        setRecipeNameInLabel(list);
    }

    public void showRecipeSearch(ActionEvent actionEvent)throws Exception {
        //mainyeah의 레시피 서치
        HashMap<String, Object> recipeName = new HashMap<>();
        recipeName.put("recipe_name", recipe_search_txt.getText());
        recipeName.put("offset", 0);
        RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.RECIPE, Protocol.SELECT_BY_RECIPE_NAME, recipeName);
        System.out.println("line 90");
        System.out.println(requestData.getProtocol_contents().get("recipe_name"));
        objectOutputStream.writeObject(requestData);
        objectOutputStream.flush();
        initData(objectInputStream.readObject(),recipe_search_txt.getText());
    }

    public void showRecipeView(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
       showRecipeViewCon(0);
    }
    public void showRecipeView1(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
        showRecipeViewCon(1);
    }
    public void showRecipeView2(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
        showRecipeViewCon(2);
    }
    public void showRecipeView3(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
        showRecipeViewCon(3);
    }
    public void showRecipeView4(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
        showRecipeViewCon(4);
    }
    public void showRecipeView5(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
        showRecipeViewCon(5);
    }
    public void showRecipeView6(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
        showRecipeViewCon(6);
    }
    public void showRecipeView7(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
        showRecipeViewCon(7);
    }

    public void showRecipeViewCon(int a)throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../fxml/recipeView.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        recipeViewControl revicon = (recipeViewControl)fxmlLoader.getController();
        RequestData requestCookData = new RequestData(Protocol.REQUEST, Protocol.COOK_TOOL, Protocol.SELECT_BY_RANDOM);
        objectOutputStream.writeObject(requestCookData); //서버
        cooktool_Ad_list = (List<Cooktool_dto>) objectInputStream.readObject();

        HashMap<String, Object> ingredient = new HashMap<>();
        ingredient.put("recipe_id", list.get(a).getRecipe_id());
        RequestData requestIngredientData = new RequestData(Protocol.REQUEST, Protocol.INGREDIENT, Protocol.SELECT_BY_RECIPE_ID, ingredient);
        objectOutputStream.writeObject(requestIngredientData); //서버
        ingredient_dto = (List<Ingredient_dto>) objectInputStream.readObject();
        System.out.println(ingredient_dto.get(0).getIngredient_name());

        HashMap<String, Object> productRelatedRecipe = new HashMap<>();
        productRelatedRecipe.put("recipe_ingredient", ingredient_dto.get(0).getIngredient_name());
        RequestData requestProductData = new RequestData(Protocol.REQUEST, Protocol.PRODUCT, Protocol.SELECT_BY_RELATED_RECIPE,productRelatedRecipe);
        objectOutputStream.writeObject(requestProductData); //서버
        product_Ad_list = (List<Product_dto>) objectInputStream.readObject();
        if(product_Ad_list.size() < 2 || productRelatedRecipe == null ){
            RequestData requestRandProductData = new RequestData(Protocol.REQUEST, Protocol.PRODUCT, Protocol.SELECT_BY_RANDOM_PRODUCT);
            objectOutputStream.writeObject(requestRandProductData); //서버
            product_Ad_list = (List<Product_dto>) objectInputStream.readObject();
        }
        revicon.initRecipeData(list.get(a),cooktool_Ad_list,product_Ad_list);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("레시피");
        stage.show();
    }

    public void nextLevel(ActionEvent actionEvent)throws Exception{
        int nextPageNum = Integer.parseInt(label_page_num.getText()) + 1;

        RequestData newRequestData = new RequestData(protocolType, protocolAction, protocolMethod);

        HashMap<String, Object> newContents = (HashMap<String, Object>)curContents.clone();
        newContents.put("offset", (nextPageNum-1)*8);

        newRequestData.setProtocol_contents(newContents);
        objectOutputStream.writeObject(newRequestData);
        objectInputStream.readObject();

        // here 이 부분 작성 해야 됨

        /*String pagenum =label_page_num.getText();
        int num = Integer.parseInt(pagenum)+1;
        label_page_num.setText(String.valueOf(num));
        int offset = (num)*8;
        HashMap<String, Object> recipeName = new HashMap<>();
        recipeName.put("recipe_name", prev_text);
        recipeName.put("offset",offset);
        RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.RECIPE, Protocol.SELECT_BY_RECIPE_NAME, recipeName);
        System.out.println("NullPointTesting");
        System.out.println(requestData.getProtocol_contents().get("recipe_name"));
        objectOutputStream.writeObject(requestData);
        initData(objectInputStream.readObject(),prev_text);*/
    }

    public void prevLevel(ActionEvent actionEvent)throws Exception{
        String pagenum =label_page_num.getText();
        int num = Integer.parseInt(pagenum)-1;
        if(num>0){
            label_page_num.setText(String.valueOf(num));
            int offset = (num-1)*8 +8;
            HashMap<String, Object> recipeName = new HashMap<>();
            recipeName.put("recipe_name", prev_text);
            recipeName.put("offset",offset);
            RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.RECIPE, Protocol.SELECT_BY_RECIPE_NAME, recipeName);
            objectOutputStream.writeObject(requestData);
            initData(objectInputStream.readObject(),prev_text);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(MyInfo.socketConnect);
        if(MyInfo.socketConnect){
            socket = MyInfo.getSocket();
            objectOutputStream = MyInfo.getObjectOutputStream();
            objectInputStream = MyInfo.getObjectInputStream();
        }
        recipe_search_labels.add(recipe_search_label1);
        recipe_search_labels.add(recipe_search_label2);
        recipe_search_labels.add(recipe_search_label3);
        recipe_search_labels.add(recipe_search_label4);
        recipe_search_labels.add(recipe_search_label5);
        recipe_search_labels.add(recipe_search_label6);
        recipe_search_labels.add(recipe_search_label7);
        recipe_search_labels.add(recipe_search_label8);
    }

    public void setRecipeNameInLabel(List<Recipe_dto> list){
        for(int i=0; i<list.size(); i++){
            recipe_search_labels.get(i).setVisible(true);
            recipe_search_labels.get(i).setText(list.get(i).getRecipe_name());
        }
        if(list.size()<8){
            for(int j=list.size(); j<8; j++){
                recipe_search_labels.get(j).setVisible(false);
            }
        }
    }
}
