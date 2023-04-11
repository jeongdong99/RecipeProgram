
package persistence.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

public class productSearchControl extends Thread implements Initializable {

    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private List<WebView> webViewList = new ArrayList<>();
    private List<Label> nameLabelList = new ArrayList<>();
    private List<Label> priceLabelList = new ArrayList<>();

    @FXML
    private TextArea txt_product_title;

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
    private WebView product_webView3;
    @FXML
    private Label product_name3;
    @FXML
    private Label product_price3;
    @FXML
    private WebView product_webView4;
    @FXML
    private Label product_name4;
    @FXML
    private Label product_price4;
    @FXML
    private WebView product_webView5;
    @FXML
    private Label product_name5;
    @FXML
    private Label product_price5;
    @FXML
    private WebView product_webView6;
    @FXML
    private Label product_name6;
    @FXML
    private Label product_price6;
    @FXML
    private WebView product_webView7;
    @FXML
    private Label product_name7;
    @FXML
    private Label product_price7;
    @FXML
    private WebView product_webView8;
    @FXML
    private Label product_name8;
    @FXML
    private Label product_price8;
    @FXML
    private Label label_page_product_num;
    RequestData curRequestData = null;

    private List<Product_dto> list = new ArrayList<>();
    private String prev_text;

    public void initData(Object data, String text)throws Exception {
        list = (List<Product_dto>) data;
        prev_text = text;

        setLabelText();
    }

    public void showProduct(ActionEvent actionEvent)throws Exception {
        HashMap<String, Object> productName = new HashMap<>();
        productName.put("product_name", txt_product_title.getText());
        productName.put("offset", 0);
        label_page_product_num.setText("1");
        RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.PRODUCT, Protocol.SELECT_BY_PRODUCT_NAME, productName);
        objectOutputStream.writeObject(requestData);
        initData(objectInputStream.readObject(),txt_product_title.getText());
    }

    public void showProductView(int num){
        if(list.get(num).getProduct_name() != null){
            WebView webView = new WebView();
            WebEngine engine = webView.getEngine();
            String html = list.get(num).getProduct_url();
            engine.load(html);
            Stage stage = new Stage();
            Scene scene = new Scene(webView, 1500, 1000);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void productSetItems(){
        setLabelText();
    }

    public void nextProductLevel(ActionEvent actionEvent)throws IOException,ClassNotFoundException {
        if(list.size()==8){
            String pagenum =label_page_product_num.getText();
            int num = Integer.parseInt(pagenum)+1;
            int offset = (num-1)*8 +8;
            HashMap<String, Object> productName = new HashMap<>();
            productName.put("product_name", prev_text);
            productName.put("offset",offset);
            RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.PRODUCT, Protocol.SELECT_BY_PRODUCT_NAME, productName);
            objectOutputStream.writeObject(requestData);
            list = (List<Product_dto>) objectInputStream.readObject();
            if(list.size()!=0){
                productSetItems();
                label_page_product_num.setText(String.valueOf(num));
            }
        }
    }

    public void prevProductLevel(ActionEvent actionEvent)throws IOException,ClassNotFoundException {
        String pagenum =label_page_product_num.getText();
        int num = Integer.parseInt(pagenum)-1;
        if(num>0){
            label_page_product_num.setText(String.valueOf(num));
            int offset = (num-1)*8;
            HashMap<String, Object> productName = new HashMap<>();
            productName.put("product_name", prev_text);
            productName.put("offset",offset);
            RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.PRODUCT, Protocol.SELECT_BY_PRODUCT_NAME, productName);
            objectOutputStream.writeObject(requestData);
            list = (List<Product_dto>) objectInputStream.readObject();
            productSetItems();
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
        webViewList.add(product_webView1);
        webViewList.add(product_webView2);
        webViewList.add(product_webView3);
        webViewList.add(product_webView4);
        webViewList.add(product_webView5);
        webViewList.add(product_webView6);
        webViewList.add(product_webView7);
        webViewList.add(product_webView8);

        nameLabelList.add(product_name1);
        nameLabelList.add(product_name2);
        nameLabelList.add(product_name3);
        nameLabelList.add(product_name4);
        nameLabelList.add(product_name5);
        nameLabelList.add(product_name6);
        nameLabelList.add(product_name7);
        nameLabelList.add(product_name8);

        priceLabelList.add(product_price1);
        priceLabelList.add(product_price2);
        priceLabelList.add(product_price3);
        priceLabelList.add(product_price4);
        priceLabelList.add(product_price5);
        priceLabelList.add(product_price6);
        priceLabelList.add(product_price7);
        priceLabelList.add(product_price8);
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

    public void setItemsVisibility(int index, boolean isItemVisible){
        webViewList.get(index).setVisible(isItemVisible);
        nameLabelList.get(index).setVisible(isItemVisible);
        priceLabelList.get(index).setVisible(isItemVisible);
    }

    public void setLabelText(){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        for(int i =0; i < list.size(); i++){
            setItemsVisibility(i, true);
            webViewList.get(i).getEngine().load(list.get(i).getProduct_img());
            nameLabelList.get(i).setText(list.get(i).getProduct_name());
            priceLabelList.get(i).setText(decimalFormat.format(Integer.parseInt(list.get(i).getProduct_price()))+"원");
        }
        if(list.size()!=8){
            for(int j= list.size(); j<8; j++){
                setItemsVisibility(j, false);
            }
        }
    }
}

