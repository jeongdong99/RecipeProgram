package persistence.control;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import persistence.MyInfo;
import persistence.dto.Baek_dto;
import persistence.dto.Product_dto;
import persistence.network.Protocol;
import persistence.RequestData;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;



public class mainViewControl extends Thread implements Initializable{

    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private List<CheckBox> ingList = new ArrayList<>();
    private List<CheckBox> recipeTimeList = new ArrayList<>();
    private List<CheckBox> recipeLevelList = new ArrayList<>();
    private List<Product_dto> product_dtos = new ArrayList<>();

    private List<Baek_dto> baek_dtos_rand = new ArrayList<>();
    private List<Baek_dto> baek_dtos = new ArrayList<>();
    private List<WebView> productImageList = new ArrayList<>();
    private List<Label> productNameList = new ArrayList<>();
    private List<Label> productPriceList = new ArrayList<>();


    private String[] levelArray = {"아무나", "초급", "중급", "고급"};

    @FXML
    private Button btn_recipe_search;
    @FXML
    private TextArea recipe_search_txt;
    @FXML
    private TextArea baek_search_txt;
    @FXML
    private TextArea product_search_txt;
    @FXML
    private CheckBox beef;
    @FXML
    private CheckBox pork;
    @FXML
    private CheckBox chicken;
    @FXML
    private CheckBox duck;
    @FXML
    private CheckBox potato;
    @FXML
    private CheckBox onion;
    @FXML
    private CheckBox garlic;
    @FXML
    private CheckBox beanSprouts;
    @FXML
    private CheckBox shrimp;
    @FXML
    private CheckBox pepper;
    @FXML
    private CheckBox calm;
    @FXML
    private CheckBox fish;
    @FXML
    private CheckBox tuna;
    @FXML
    private CheckBox kimchi;
    @FXML
    private CheckBox tofu;
    @FXML
    private CheckBox egg;
    @FXML
    private CheckBox milk;
    @FXML
    private CheckBox cheese;
    @FXML
    private CheckBox crab;
    @FXML
    private CheckBox mushroom;
    @FXML
    private CheckBox noodle;
    @FXML
    private CheckBox squid;
    @FXML
    private CheckBox cabbage;
    @FXML
    private CheckBox vegetable;
    @FXML
    private CheckBox fruit;
    @FXML
    private CheckBox dumpling;
    @FXML
    private CheckBox can;
    @FXML
    private CheckBox peanut;
    @FXML
    private CheckBox oil;
    @FXML
    private CheckBox bread;

    @FXML
    private CheckBox recipeTime1;
    @FXML
    private CheckBox recipeTime2;
    @FXML
    private CheckBox recipeTime3;
    @FXML
    private CheckBox recipeTime4;

    @FXML
    private CheckBox level_easy;
    @FXML
    private CheckBox level_begin;
    @FXML
    private CheckBox level_middle;
    @FXML
    private CheckBox level_hard;

    @FXML
    private WebView BaekImage1;
    @FXML
    private WebView BaekImage2;
    @FXML
    private Label BaekTitle1;
    @FXML
    private Label BaekTitle2;

    @FXML
    private WebView productImage1;
    @FXML
    private WebView productImage2;
    @FXML
    private WebView productImage3;
    @FXML
    private WebView productImage4;
    @FXML
    private WebView productImage5;
    @FXML
    private WebView productImage6;
    @FXML
    private WebView productImage7;
    @FXML
    private WebView productImage8;
    @FXML
    private Label productName1;
    @FXML
    private Label productName2;
    @FXML
    private Label productName3;
    @FXML
    private Label productName4;
    @FXML
    private Label productName5;
    @FXML
    private Label productName6;
    @FXML
    private Label productName7;
    @FXML
    private Label productName8;
    @FXML
    private Label productPrice1;
    @FXML
    private Label productPrice2;
    @FXML
    private Label productPrice3;
    @FXML
    private Label productPrice4;
    @FXML
    private Label productPrice5;
    @FXML
    private Label productPrice6;
    @FXML
    private Label productPrice7;
    @FXML
    private Label productPrice8;
    @FXML
    private Label label_page_product_num;
    @FXML
    private Label label_page_baek_num;


    @FXML
    List<CheckBox> list = new ArrayList<>();

    public mainViewControl() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(!MyInfo.socketConnect){
            System.out.println("initialize testing");
            // ******************** SET IP ********************
            final String SERVER_IP = "25.80.21.235";
            final int SERVER_PORT = 2400;
            socket = new Socket();

            try{
                socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
                System.out.println("success connection to server");
                MyInfo.setSocketConnect(true);
                System.out.println("SERVER IP : " + SERVER_IP);
                System.out.println("SERVER PORT : " + Integer.valueOf(SERVER_PORT));
                MyInfo.setSocket(socket);
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                MyInfo.setObjectOutputStream(objectOutputStream);
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                MyInfo.setObjectInputStream(objectInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(MyInfo.socketConnect){
            ingList.add(beef);
            ingList.add(pork);
            ingList.add(chicken);
            ingList.add(duck);
            ingList.add(potato);
            ingList.add(onion);
            ingList.add(garlic);
            ingList.add(beanSprouts);
            ingList.add(shrimp);
            ingList.add(pepper);
            ingList.add(calm);
            ingList.add(fish);
            ingList.add(tuna);
            ingList.add(kimchi);
            ingList.add(tofu);
            ingList.add(egg);
            ingList.add(milk);
            ingList.add(cheese);
            ingList.add(crab);
            ingList.add(mushroom);
            ingList.add(noodle);
            ingList.add(squid);
            ingList.add(cabbage);
            ingList.add(vegetable);
            ingList.add(fruit);
            ingList.add(dumpling);
            ingList.add(can);
            ingList.add(peanut);
            ingList.add(oil);
            ingList.add(bread);

            recipeTimeList.add(recipeTime1);
            recipeTimeList.add(recipeTime2);
            recipeTimeList.add(recipeTime3);
            recipeTimeList.add(recipeTime4);

            recipeLevelList.add(level_easy);
            recipeLevelList.add(level_begin);
            recipeLevelList.add(level_middle);
            recipeLevelList.add(level_hard);

            productImageList.add(productImage1);
            productImageList.add(productImage2);
            productImageList.add(productImage3);
            productImageList.add(productImage4);
            productImageList.add(productImage5);
            productImageList.add(productImage6);
            productImageList.add(productImage7);
            productImageList.add(productImage8);

            productNameList.add(productName1);
            productNameList.add(productName2);
            productNameList.add(productName3);
            productNameList.add(productName4);
            productNameList.add(productName5);
            productNameList.add(productName6);
            productNameList.add(productName7);
            productNameList.add(productName8);

            productPriceList.add(productPrice1);
            productPriceList.add(productPrice2);
            productPriceList.add(productPrice3);
            productPriceList.add(productPrice4);
            productPriceList.add(productPrice5);
            productPriceList.add(productPrice6);
            productPriceList.add(productPrice7);
            productPriceList.add(productPrice8);
        }
    }

    public void showMart(ActionEvent actionEvent)throws Exception {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        String html = getClass().getResource("../html/sample.html").toExternalForm();
        engine.load(html);
        Stage stage = new Stage();
        Scene scene = new Scene(webView, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public void showRecipeSearch(ActionEvent actionEvent)throws Exception {
        //mainyeah의 레시피 서치
        // recipeControl recon = new recipeControl();
        //recon.initData(objectInputStream.readObject());
        //Parent root = FXMLLoader.load(getClass().getResource("../fxml/recipeSearch.fxml"));

        HashMap<String, Object> recipeName = new HashMap<>();
        recipeName.put("recipe_name", recipe_search_txt.getText());
        recipeName.put("offset", 0);
        RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.RECIPE, Protocol.SELECT_BY_RECIPE_NAME, recipeName);
        objectOutputStream.writeObject(requestData); //서버
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/recipeSearch.fxml"));
        Parent root =fxmlLoader.load();
        recipeConditionControl recon = fxmlLoader.getController();
        // here
        recon.initData(requestData.getProtocol_type(), requestData.getProtocol_action(),
                requestData.getProtocol_method(), requestData.getProtocol_contents(),
                objectInputStream.readObject());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("레시피검색화면");
        stage.show();
    }
    public void searchRecipeByConditions() throws Exception{
        RequestData requestData = new RequestData();
        int ingCount = 0;
        boolean time = false;
        boolean level = false;

        HashMap<String, Object> recipeSelectHashMap = new HashMap<>();
        recipeSelectHashMap.put("offset", 0);

        requestData.setProtocol_type(Protocol.REQUEST);
        requestData.setProtocol_action(Protocol.RECIPE);

        for(CheckBox c1 : ingList){
            if(ingCount<3){
                if(c1.isSelected()){
                    recipeSelectHashMap.put("ing"+Integer.toString(ingCount+1), c1.getText());

                    ingCount++;
                }
            }
        }
        for(CheckBox c2 : recipeTimeList){
            if(!time){
                if(c2.isSelected()){
                    recipeSelectHashMap.put("recipe_time", Integer.parseInt(c2.getText().replaceAll("[^0-9]", "")));
                    time = true;
                }
            }
        }
        for(CheckBox c3 : recipeLevelList){
            if(!level){
                if(c3.isSelected()){
                    System.out.println(recipeLevelList.indexOf(c3));
                    recipeSelectHashMap.put("recipe_level", levelArray[recipeLevelList.indexOf(c3)]);
                    level = true;
                }
            }
        }
        if(ingCount>0){
            if(time&&level){
                switch(ingCount){
                    case 1:
                        requestData.setProtocol_method(Protocol.SELECT_BY_RECIPE_ALL_OPTION1);
                        break;
                    case 2:
                        requestData.setProtocol_method(Protocol.SELECT_BY_RECIPE_ALL_OPTION2);
                        break;
                    case 3:
                        requestData.setProtocol_method(Protocol.SELECT_BY_RECIPE_ALL_OPTION3);
                        break;
                    default:
                        System.out.println("error on searchRecipeByConditions() location : 0x01");
                        break;
                }
            }else if(!time&&level){
                switch(ingCount){
                    case 1:
                        requestData.setProtocol_method(Protocol.SELECT_BY_RECIPE_LEVEL_ING1);
                        break;
                    case 2:
                        requestData.setProtocol_method(Protocol.SELECT_BY_RECIPE_LEVEL_ING2);
                        break;
                    case 3:
                        requestData.setProtocol_method(Protocol.SELECT_BY_RECIPE_LEVEL_ING3);
                        break;
                    default:
                        System.out.println("error on searchRecipeByConditions() location : 0x02");
                        break;
                }
            }else if(time&&!level){
                switch(ingCount){
                    case 1:
                        requestData.setProtocol_method(Protocol.SELECT_BY_RECIPE_TIME_ING1);
                        break;
                    case 2:
                        requestData.setProtocol_method(Protocol.SELECT_BY_RECIPE_TIME_ING2);
                        break;
                    case 3:
                        requestData.setProtocol_method(Protocol.SELECT_BY_RECIPE_TIME_ING3);
                        break;
                    default:
                        System.out.println("error on searchRecipeByConditions() location : 0x03");
                        break;
                }
            }else{
                switch(ingCount){
                    case 1:
                        requestData.setProtocol_method(Protocol.SELECT_BY_ONE_INGREDIENT);
                        requestData.setProtocol_action(Protocol.INGREDIENT);
                        break;
                    case 2:
                        requestData.setProtocol_method(Protocol.SELECT_BY_TWO_INGREDIENT);
                        requestData.setProtocol_action(Protocol.INGREDIENT);
                        break;
                    case 3:
                        requestData.setProtocol_method(Protocol.SELECT_BY_THREE_INGREDIENT);
                        requestData.setProtocol_action(Protocol.INGREDIENT);
                        break;
                    default:
                        System.out.println("error on searchRecipeByConditions() location : 0x04");
                        break;
                }
            }
        }else if(time&&level){
            requestData.setProtocol_method(Protocol.SELECT_BY_RECIPE_TIME_LEVEL);
        }else if(!time&&level){
            requestData.setProtocol_method(Protocol.SELECT_BY_RECIPE_LEVEL);
        }else if(time&&!level){
            requestData.setProtocol_method(Protocol.SELECT_BY_RECIPE_TIME);
        }else{
            //nothing
        }
        requestData.setProtocol_contents(recipeSelectHashMap);
        System.out.println("================ select recipe by conditions ================\n"+requestData.getProtocol_contents());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/recipeSearchCondition.fxml"));
        Parent root = fxmlLoader.load();
        recipeConditionControl recon = fxmlLoader.getController();
        objectOutputStream.writeObject(requestData);
        recon.initData(requestData.getProtocol_type(), requestData.getProtocol_action(), requestData.getProtocol_method(), requestData.getProtocol_contents(), objectInputStream.readObject());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("레시피검색화면");
        stage.show();
    }

    public void showProduct(ActionEvent actionEvent)throws Exception {
        HashMap<String, Object> productName = new HashMap<>();
        productName.put("product_name", product_search_txt.getText());
        productName.put("offset", 0);
        RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.PRODUCT, Protocol.SELECT_BY_PRODUCT_NAME, productName);
        objectOutputStream.writeObject(requestData); //서버
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/productSearch.fxml"));
        Parent root =fxmlLoader.load();
        productSearchControl prosecon = fxmlLoader.getController();
        prosecon.initData(objectInputStream.readObject(), product_search_txt.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("식자제검색");
        stage.show();
    }
    public void product(Event event) throws IOException, ClassNotFoundException{
        HashMap<String, Object> productName = new HashMap<>();
        productName.put("product_name", "");
        productName.put("offset",0);
        RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.PRODUCT, Protocol.SELECT_BY_PRODUCT_NAME, productName);
        objectOutputStream.writeObject(requestData);
        product_dtos = (List<Product_dto>) objectInputStream.readObject();
        productSetItems();
    }
    public void productSetItems(){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        for(int i =0; i < product_dtos.size(); i++){
            productImageList.get(i).setVisible(true);
            productNameList.get(i).setVisible(true);
            productPriceList.get(i).setVisible(true);
            productImageList.get(i).getEngine().load(product_dtos.get(i).getProduct_img());
            productNameList.get(i).setText(product_dtos.get(i).getProduct_name());
            productPriceList.get(i).setText(decimalFormat.format(Integer.parseInt(product_dtos.get(i).getProduct_price()))+"원");
        }
        if(product_dtos.size()!=8){
            for(int j= product_dtos.size(); j<8; j++){
                productImageList.get(j).setVisible(false);
                productNameList.get(j).setVisible(false);
                productPriceList.get(j).setVisible(false);
            }
        }
    }
    public void showProductView(int num){
        if(product_dtos.get(num).getProduct_name() != null){
            WebView webView = new WebView();
            WebEngine engine = webView.getEngine();
            String html = product_dtos.get(num).getProduct_url();
            engine.load(html);
            Stage stage = new Stage();
            Scene scene = new Scene(webView, 1500, 1000);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void showProductView1(javafx.scene.input.MouseEvent mouseEvent)throws Exception{
        showProductView(0);
    }
    public void showProductView2(javafx.scene.input.MouseEvent mouseEvent)throws Exception{
        showProductView(1);
    }
    public void showProductView3(javafx.scene.input.MouseEvent mouseEvent)throws Exception{
        showProductView(2);
    }
    public void showProductView4(javafx.scene.input.MouseEvent mouseEvent)throws Exception{
        showProductView(3);
    }
    public void showProductView5(javafx.scene.input.MouseEvent mouseEvent)throws Exception{
        showProductView(4);
    }
    public void showProductView6(javafx.scene.input.MouseEvent mouseEvent)throws Exception{
        showProductView(5);
    }
    public void showProductView7(javafx.scene.input.MouseEvent mouseEvent)throws Exception{
        showProductView(6);
    }
    public void showProductView8(javafx.scene.input.MouseEvent mouseEvent)throws Exception{
        showProductView(7);
    }


    public void showBaekSearch(ActionEvent actionEvent)throws Exception {

        System.out.println(baek_search_txt.getText());

        HashMap<String, Object> baekName = new HashMap<>();
        baekName.put("baek_title", baek_search_txt.getText());
        baekName.put("offset", 0);
        RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.BAEK, Protocol.SELECT_BY_TITLE, baekName);
        objectOutputStream.writeObject(requestData); //서버
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/baekSearch.fxml"));
        Parent root =fxmlLoader.load();
        BaekSearchController baekcon = fxmlLoader.getController();
        baekcon.initData(objectInputStream.readObject(), baek_search_txt.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("백종원레시피검색");
        stage.show();
    }

    public void showBaek(javafx.scene.input.MouseEvent mouseEvent)throws Exception  {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/baekView.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("백종원");
        stage.show();
    }


    public void baek(Event event) throws IOException, ClassNotFoundException {
        HashMap<String, Object> baekName = new HashMap<>();
        baekName.put("baek_title", "");
        baekName.put("offset",0);
        RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.BAEK, Protocol.SELECT_BY_TITLE, baekName);
        objectOutputStream.writeObject(requestData);
        baek_dtos = (List<Baek_dto>) objectInputStream.readObject();
        
        BaekImage1.getEngine().load(baek_dtos.get(0).getImage_url());
        BaekTitle1.setText(baek_dtos.get(0).getBaek_title());
        BaekImage2.getEngine().load(baek_dtos.get(1).getImage_url());
        BaekTitle2.setText(baek_dtos.get(1).getBaek_title());
    }

    public void showBaekView(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
        showBaekViewCon(0);
    }

    public void showBaekView2(javafx.scene.input.MouseEvent mouseEvent)throws Exception {
        showBaekViewCon(1);
    }

    public void showBaekViewCon(int a)throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../fxml/baekView.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        baekViewController baekCon = (baekViewController)fxmlLoader.getController();
        RequestData requestBaekDataRandom = new RequestData(Protocol.REQUEST, Protocol.BAEK, Protocol.SELECT_BY_RAND_BAEK);
        objectOutputStream.writeObject(requestBaekDataRandom);
        baek_dtos_rand = (List<Baek_dto>) objectInputStream.readObject();
        baekCon.initBaekData(baek_dtos.get(a),baek_dtos_rand);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("백종원");
        stage.show();
    }

    public void nextBaekLevel(ActionEvent actionEvent)throws IOException,ClassNotFoundException {
        if(baek_dtos.size()==2){
            String pagenum =label_page_baek_num.getText();
            int num = Integer.parseInt(pagenum)+1;
            label_page_baek_num.setText(String.valueOf(num));
            int offset = (num-1) * 2; // 2num - 2 -> 2(num-1)
            HashMap<String, Object> baekName = new HashMap<>();
            baekName.put("baek_title", "");
            baekName.put("offset",offset);

            RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.BAEK, Protocol.SELECT_BY_TITLE, baekName);
            objectOutputStream.writeObject(requestData);
            baek_dtos = (List<Baek_dto>) objectInputStream.readObject();
            if(baek_dtos.size()==2){
                System.out.println(baek_dtos);
                BaekImage1.getEngine().load(baek_dtos.get(0).getImage_url());
                BaekTitle1.setText(baek_dtos.get(0).getBaek_title());
                BaekImage2.getEngine().load(baek_dtos.get(1).getImage_url());
                BaekTitle2.setText(baek_dtos.get(1).getBaek_title());
            }else if(baek_dtos.size()==1){
                BaekImage1.getEngine().load(baek_dtos.get(0).getImage_url());
                BaekTitle1.setText(baek_dtos.get(0).getBaek_title());
                BaekImage2.setVisible(false);
                BaekTitle2.setVisible(false);
            }else if(baek_dtos.size()==0){
                BaekImage1.setVisible(false);
                BaekTitle1.setVisible(false);
                BaekImage2.setVisible(false);
                BaekTitle2.setVisible(false);
            }else{

            }
        }
    }

    public void prevBaekLevel(ActionEvent actionEvent)throws IOException,ClassNotFoundException {
        String pagenum =label_page_baek_num.getText();
        int num = Integer.parseInt(pagenum)-1;
        if(num>0){
            label_page_baek_num.setText(String.valueOf(num));
            int offset = (num-1) * 2;
            HashMap<String, Object> baekName = new HashMap<>();
            baekName.put("baek_title", "");
            baekName.put("offset",offset);
            RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.BAEK, Protocol.SELECT_BY_TITLE, baekName);
            objectOutputStream.writeObject(requestData);
            baek_dtos = (List<Baek_dto>) objectInputStream.readObject();
            if(baek_dtos.size()==2){
                BaekImage1.setVisible(true);
                BaekTitle1.setVisible(true);
                BaekImage2.setVisible(true);
                BaekTitle2.setVisible(true);

                BaekImage1.getEngine().load(baek_dtos.get(0).getImage_url());
                BaekTitle1.setText(baek_dtos.get(0).getBaek_title());
                BaekImage2.getEngine().load(baek_dtos.get(1).getImage_url());
                BaekTitle2.setText(baek_dtos.get(1).getBaek_title());
            }
        }
    }


    public void nextProductLevel(ActionEvent actionEvent)throws IOException,ClassNotFoundException {
        String pagenum =label_page_product_num.getText();
        int num = Integer.parseInt(pagenum)+1;
        label_page_product_num.setText(String.valueOf(num));
        int offset = (num-1)*8;
        HashMap<String, Object> productName = new HashMap<>();
        productName.put("product_name", "");
        productName.put("offset",offset);
        RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.PRODUCT, Protocol.SELECT_BY_PRODUCT_NAME, productName);
        objectOutputStream.writeObject(requestData);
        product_dtos = (List<Product_dto>) objectInputStream.readObject();
        productSetItems();
    }

    public void prevProductLevel(ActionEvent actionEvent)throws IOException,ClassNotFoundException {
        String pagenum =label_page_product_num.getText();
        int num = Integer.parseInt(pagenum)-1;
        if(num>0){
            label_page_product_num.setText(String.valueOf(num));
            int offset = (num-1)*8;
            HashMap<String, Object> productName = new HashMap<>();
            productName.put("product_name", "");
            productName.put("offset",offset);
            RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.PRODUCT, Protocol.SELECT_BY_PRODUCT_NAME, productName);
            objectOutputStream.writeObject(requestData);
            product_dtos = (List<Product_dto>) objectInputStream.readObject();
            productSetItems();
        }
    }
}
