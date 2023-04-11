package persistence.control;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import persistence.MyInfo;
import persistence.RequestData;
import persistence.dto.Baek_dto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import persistence.network.Protocol;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;


public class BaekSearchController implements Initializable {

        Socket socket = null;

        RequestData curRequestData = null;

        private ObjectInputStream objectInputStream;
        private ObjectOutputStream objectOutputStream;

        private List<WebView> webViewList = new ArrayList<>();
        private List<Label> nameLabelList = new ArrayList<>();

         private List<Baek_dto> baek_dtos_rand;
        @FXML
        private TextField inputFoodTitle;
        @FXML
        private Label recipeTitle1;
        @FXML
        private Label recipeTitle2;
        @FXML
        private WebView recipeImage1;
        @FXML
        private WebView recipeImage2;
        @FXML
        private Label label_page_baek_num;
        private String prev_text;

        int pageNum ;
        List<Baek_dto> Baeklist = new ArrayList<>();

        public void initData(Object data, String text) throws Exception {
            prev_text = text;
            Baeklist = (List<Baek_dto>) data;
            if(Baeklist.size()==2){
                setItemsVisibility(true, true);
                recipeTitle1.setText(Baeklist.get(0).getBaek_title());
                recipeImage1.getEngine().load(Baeklist.get(0).getImage_url());
                recipeTitle2.setText(Baeklist.get(1).getBaek_title());
                recipeImage2.getEngine().load(Baeklist.get(1).getImage_url());
            }else if(Baeklist.size()==1){
                setItemsVisibility(true, false);
                recipeTitle1.setText(Baeklist.get(0).getBaek_title());
                recipeImage1.getEngine().load(Baeklist.get(0).getImage_url());
            }else if(Baeklist.size()==0){
                setItemsVisibility(false, false);
            }else{

            }
        }

        @FXML
        protected void searchBaekByTitle(ActionEvent event)throws Exception {
            HashMap<String, Object> baekName = new HashMap<>();
            baekName.put("baek_title", inputFoodTitle.getText());
            baekName.put("offset", 0);
            label_page_baek_num.setText("1");
            RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.BAEK, Protocol.SELECT_BY_TITLE, baekName);
            objectOutputStream.writeObject(requestData); //서버
            initData(objectInputStream.readObject(),inputFoodTitle.getText() );


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
        baekCon.initBaekData(Baeklist.get(a),baek_dtos_rand);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("백종원");
        stage.show();
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

    public void nextBaekLevel(ActionEvent actionEvent)throws Exception {
        if(Baeklist.size()==2){
            String pagenum =label_page_baek_num.getText();
            int num = Integer.parseInt(pagenum)+1;

            int offset = (num)*2;
            HashMap<String, Object> baekName = new HashMap<>();
            baekName.put("baek_title", prev_text);
            baekName.put("offset",offset);
            RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.BAEK, Protocol.SELECT_BY_TITLE, baekName);
            objectOutputStream.writeObject(requestData);
            Baeklist = (List<Baek_dto>) objectInputStream.readObject();
            if(Baeklist.size() != 0){
                initData(Baeklist,prev_text);
                label_page_baek_num.setText(String.valueOf(num));
            }
        }
    }

    public void prevBaekLevel(ActionEvent actionEvent)throws Exception {
        if(Integer.parseInt(label_page_baek_num.getText()) > 1){
            String pagenum =label_page_baek_num.getText();
            int num = Integer.parseInt(pagenum)-1;
            label_page_baek_num.setText(String.valueOf(num));
            int offset = (num-1)*2;
            HashMap<String, Object> baekName = new HashMap<>();
            baekName.put("baek_title", prev_text);
            baekName.put("offset",offset);
            RequestData requestData = new RequestData(Protocol.REQUEST, Protocol.BAEK, Protocol.SELECT_BY_TITLE, baekName);
            objectOutputStream.writeObject(requestData);
            initData(objectInputStream.readObject(),prev_text);
        }
    }

    public void setItemsVisibility(boolean firstVisibility, boolean secondVisibility){
        recipeTitle1.setVisible(firstVisibility);
        recipeImage1.setVisible(firstVisibility);
        recipeTitle2.setVisible(secondVisibility);
        recipeImage2.setVisible(secondVisibility);
    }
}