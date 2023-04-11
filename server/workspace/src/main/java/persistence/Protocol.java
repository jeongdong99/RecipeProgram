package persistence;

public class Protocol {
    public static final int LEN_HEADER_SIZE = 3;
    public static final byte LEN_INT_DATA = 2;
    public static final int LEN_MAX_LENGTH = 1000;

    public static final int UNUSED = 0;
    public static final int USED = 1;

    public static final int INDEX_MESSAGE_TYPE = 0;
    public static final int INDEX_ACTION = 1;
    public static final int INDEX_CODE = 2;
    public static final int CONTENTS = 3;

    // message type
    public static final int REQUEST = 0;
    public static final int RESPONSE = 1;

    // action
    public static final int LOGIN = 0;
    public static final int LOGOUT = 1;
    public static final int USER = 2;
    public static final int RECIPE = 3;
    public static final int INGREDIENT = 4;
    public static final int PRODUCT = 5;
    public static final int BAEK = 6;
    public static final int POST = 7;
    public static final int REPLY = 8;
    public static final int SHOPPING_MALL = 9;
    public static final int COOK_TOOL = 10;
    public static final int EXIT = 11;

    // function = code
    // INSERT, UPDATE, DELETE, READ_ALL
    public static final int LOG_IN_OUT = 0;
    public static final int INSERT = 1;
    public static final int UPDATE = 2;
    public static final int DELETE = 3;
    public static final int SELECT_ALL = 4;
    //READ를 추가하고 SELECT_ALL은 내리고

    // success, fail
    public static final int FAIL = 0;
    public static final int SUCCESS = 1;

    //user
    public static final int SELECT_BY_USER_NAME = 5;
    public static final int SELECT_BY_USER_NUM = 6;

    //recipe
    public static final int SELECT_BY_RECIPE_NAME = 5;
    public static final int SELECT_BY_RECIPE_LEVEL = 6;
    public static final int SELECT_BY_RECIPE_TIME = 7;
    public static final int SELECT_BY_RECIPE_TIME_LEVEL = 8;
    public static final int SELECT_BY_RECIPE_TIME_ING1 = 9;
    public static final int SELECT_BY_RECIPE_TIME_ING2 = 10;
    public static final int SELECT_BY_RECIPE_TIME_ING3 = 11;
    public static final int SELECT_BY_RECIPE_LEVEL_ING1 = 12;
    public static final int SELECT_BY_RECIPE_LEVEL_ING2 = 13;
    public static final int SELECT_BY_RECIPE_LEVEL_ING3 = 14;
    public static final int SELECT_BY_RECIPE_ALL_OPTION1 = 15;
    public static final int SELECT_BY_RECIPE_ALL_OPTION2 = 16;
    public static final int SELECT_BY_RECIPE_ALL_OPTION3 = 17;

    //ingredient
    public static final int SELECT_BY_ONE_INGREDIENT = 5;
    public static final int SELECT_BY_TWO_INGREDIENT = 6;
    public static final int SELECT_BY_THREE_INGREDIENT = 7;

    //product
    public static final int SELECT_BY_PRODUCT_NAME = 5;
    public static final int SELECT_BY_PRICE = 6;
    public static final int SELECT_BY_RELATED_RECIPE =7;

    //baek
    public static final int SELECT_BY_TITLE = 5;

    //post
    public static final int POST_SELECT_BY_REGION = 5;
    public static final int POST_SELECT_BY_USER = 6;
    public static final int POST_SELECT_BY_TITLE = 7;

    //reply
    public static final int REPLY_SELECT_BY_POST_NUM = 5;

    //shopping_Mall

    //cook_tool
    public static final int SELECT_BY_COOKTOOL_NAME = 5;
    public static final int SELECT_BY_RANDOM =6;
}
