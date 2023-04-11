package persistence;

import persistence.dto.*;
import persistence.service.*;
import persistence.RequestData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServerControl {
    private final String DELIMITER_DATA = "#";
    private final String DELIMITER_PROTOCOL = "\uF0FC";
    private final String DELIMITER_STRING = "\uF042";
    private final String DELIMITER_DTO = "\uF04D";

    private Ingredient_service ingredient_service;
    private Product_service product_service;
    private Recipe_service recipe_service;
    private Post_service post_service;
    private Baek_service baek_service;
    private User_service user_service;
    private Cooktool_service cooktool_service;
    private Reply_service reply_service;

    public ServerControl(){
        ingredient_service = new Ingredient_service();
        product_service = new Product_service();
        recipe_service = new Recipe_service();
        post_service = new Post_service();
        baek_service = new Baek_service();
        user_service = new User_service();
        cooktool_service = new Cooktool_service();
        reply_service = new Reply_service();
    }

    public void run(ServerThread thread, Object input){
        // type, action, function, contents => 4
        RequestData requestData = (RequestData) input;
        if(requestData.getProtocol_type() == Protocol.REQUEST){
            switch(requestData.getProtocol_action()){
                case Protocol.LOGIN :
                    thread.send(user_service.login(
                            (String)requestData.getProtocol_contents_list().get(0).get("id"),
                            (String)requestData.getProtocol_contents_list().get(1).get("password")
                    ));
                    return;
                case Protocol.LOGOUT:
                    return;
                case Protocol.USER:
                    switch(requestData.getProtocol_method()){
                        case Protocol.SELECT_ALL:
                            thread.send(user_service.selectAll());
                            return;
                        case Protocol.INSERT:
                            thread.send(user_service.insertUser(
                                    (String)requestData.getProtocol_contents_list().get(0).get("user_id"),
                                    (String)requestData.getProtocol_contents_list().get(1).get("user_password"),
                                    (String)requestData.getProtocol_contents_list().get(2).get("user_name"),
                                    (String)requestData.getProtocol_contents_list().get(3).get("user_phone")
                            ));
                            return;
                        case Protocol.SELECT_BY_USER_NAME:
                            thread.send(user_service.selectByUserName(
                                    (String)requestData.getProtocol_contents().get("user_name")
                            ));
                            return;
                        case Protocol.SELECT_BY_USER_NUM:
                            thread.send(user_service.selectByUserNum(
                                    Integer.parseInt((String)requestData.getProtocol_contents().get("user_num"))
                            ));
                            return;
                        default:
                            break;
                    }
                    break;
                case Protocol.RECIPE:
                    switch(requestData.getProtocol_method()){
                        case Protocol.SELECT_BY_RECIPE_NAME:
                            System.out.println("testing!");
                            System.out.println(requestData.getProtocol_contents().get("recipe_name"));
                            thread.send(recipe_service.selectRecipeByName(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        case Protocol.SELECT_BY_RECIPE_LEVEL:
                            thread.send(recipe_service.selectRecipeByLevel(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        case Protocol.SELECT_BY_RECIPE_TIME:
                            thread.send(recipe_service.selectRecipeByTime(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        case Protocol.SELECT_BY_RECIPE_TIME_LEVEL:
                            thread.send(recipe_service.selectRecipeByTimeLevel(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        case Protocol.SELECT_BY_RECIPE_TIME_ING1:
                            thread.send(recipe_service.selectRecipeByTimeIng1(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        case Protocol.SELECT_BY_RECIPE_TIME_ING2:
                            thread.send(recipe_service.selectRecipeByTimeIng2(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        case Protocol.SELECT_BY_RECIPE_TIME_ING3:
                            thread.send(recipe_service.selectRecipeByTimeIng3(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        case Protocol.SELECT_BY_RECIPE_LEVEL_ING1:
                            thread.send(recipe_service.selectRecipeByLevelIng1(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        case Protocol.SELECT_BY_RECIPE_LEVEL_ING2:
                            thread.send(recipe_service.selectRecipeByLevelIng2(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        case Protocol.SELECT_BY_RECIPE_LEVEL_ING3:
                            thread.send(recipe_service.selectRecipeByLevelIng3(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        case Protocol.SELECT_BY_RECIPE_ALL_OPTION1:
                            thread.send(recipe_service.selectRecipeByAllOption1(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        case Protocol.SELECT_BY_RECIPE_ALL_OPTION2:
                            thread.send(recipe_service.selectRecipeByAllOption2(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        case Protocol.SELECT_BY_RECIPE_ALL_OPTION3:
                            thread.send(recipe_service.selectRecipeByAllOption3(
                                    requestData.getProtocol_contents()
                            ));
                            return;
                        default:
                            break;
                    }
                    break;
                case Protocol.INGREDIENT:
                        switch(requestData.getProtocol_method()){
                            case Protocol.SELECT_BY_ONE_INGREDIENT :
                                thread.send(ingredient_service.selectByIngredientName(
                                        (String)requestData.getProtocol_contents().get("ing1")
                                ));
                                return;
                            case Protocol.SELECT_BY_TWO_INGREDIENT:
                                thread.send(ingredient_service.selectByIngredientName(
                                        (String)requestData.getProtocol_contents_list().get(0).get("ing1"),
                                        (String)requestData.getProtocol_contents_list().get(1).get("ing2")
                                        ));
                                return;
                            case Protocol.SELECT_BY_THREE_INGREDIENT:
                                thread.send(ingredient_service.selectByIngredientName(
                                        (String)requestData.getProtocol_contents_list().get(0).get("ing1"),
                                        (String)requestData.getProtocol_contents_list().get(1).get("ing2"),
                                        (String)requestData.getProtocol_contents_list().get(2).get("ing3")
                                ));
                                return;
                            default:
                                break;
                        }
                    break;
                case Protocol.PRODUCT:
                    switch(requestData.getProtocol_method()){
                        case Protocol.SELECT_ALL :
                            thread.send(product_service.selectAll());
                            return;
                        case Protocol.SELECT_BY_PRODUCT_NAME:
                            thread.send(product_service.selectByProductName(
                                    (String)requestData.getProtocol_contents().get("product_name")
                            ));
                            return;
                        case Protocol.SELECT_BY_PRICE:
                            thread.send(product_service.selectByCheapProduct(
                                    (String)requestData.getProtocol_contents().get("product_name")
                            ));
                            return;
                        case Protocol.SELECT_BY_RELATED_RECIPE:
                            thread.send(product_service.selectByRelatedRecipe(
                                    (String)requestData.getProtocol_contents().get("ingredient")
                            ));
                            return;
                        default:
                            break;
                    }
                    break;
                case Protocol.BAEK:
                    switch(requestData.getProtocol_method()){
                        case Protocol.SELECT_ALL:
                            thread.send(baek_service.selectAll());
                            return;
                        case Protocol.SELECT_BY_TITLE :
                            thread.send(baek_service.selectByTitle(
                                    (HashMap<String, Object>)requestData.getProtocol_contents()
                            ));
                            return;
                        default:
                            break;
                    }
                    break;
                /*case Protocol.POST:
                    switch(Integer.parseInt(strArr[2])){
                        case Protocol.INSERT:
                            contents = strArr[3].split("#");
                            // boolean send
                            thread.send(post_service.insertPost(Integer.parseInt(contents[0]), contents[1], contents[2], contents[3], contents[4]));
                            return;
                        case Protocol.UPDATE:
                            contents = strArr[3].split("#");
                            thread.send(post_service.updatePost(Integer.parseInt(contents[0]), contents[1], contents[2]));
                            return;
                        case Protocol.DELETE:
                            contents = strArr[3].split("#");
                            thread.send(post_service.deletePost(Integer.parseInt(contents[0])));
                            return;
                        case Protocol.SELECT_ALL:
                            thread.send(post_service.selectAll());
                            return;
                        case Protocol.POST_SELECT_BY_REGION:
                            thread.send(post_service.selectByRegion(Integer.parseInt(strArr[3])));
                            return;
                        case Protocol.POST_SELECT_BY_USER:
                            thread.send(post_service.selectByUser(strArr[3]));
                            return;
                        case Protocol.POST_SELECT_BY_TITLE:
                            thread.send(post_service.selectByTitle(strArr[3]));
                            return;
                        default:
                            break;
                    }
                    break;
                    case Protocol.REPLY:
                    switch(requestData.getProtocol_method()){
                        case Protocol.INSERT:
                            contents = strArr[3].split("#");
                            thread.send(reply_service.insertFirstReply(Integer.parseInt(contents[0]), contents[1], contents[2], contents[3]));
                            return;
                        case Protocol.UPDATE:
                            contents = strArr[3].split("#");
                            thread.send(reply_service.updateReply(Integer.parseInt(contents[0]), contents[1], contents[2]));
                            return;
                        case Protocol.DELETE:
                            contents = strArr[3].split("#");
                            thread.send(reply_service.deleteReply(Integer.parseInt(contents[0])));
                            return;
                        default:
                            break;
                    }
                    break;*/
                case Protocol.COOK_TOOL:
                    switch(requestData.getProtocol_method()){
                        case Protocol.SELECT_BY_RANDOM:
                            thread.send(cooktool_service.selectByRandomCooktool());
                            return;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }
}