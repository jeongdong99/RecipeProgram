package persistence;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


public class RequestData implements Serializable {
    private static final long serialVersionUID = 9176873029745254542L;

    private int protocol_type;
    private int protocol_action;
    private int protocol_method;

    public int getProtocol_type() {
        return protocol_type;
    }

    public void setProtocol_type(int protocol_type) {
        this.protocol_type = protocol_type;
    }

    public int getProtocol_action() {
        return protocol_action;
    }

    public void setProtocol_action(int protocol_action) {
        this.protocol_action = protocol_action;
    }

    public int getProtocol_method() {
        return protocol_method;
    }

    public void setProtocol_method(int protocol_method) {
        this.protocol_method = protocol_method;
    }

    public HashMap<String, Object> getProtocol_contents() {
        return protocol_contents;
    }

    public void setProtocol_contents(HashMap<String, Object> protocol_contents) {
        this.protocol_contents = protocol_contents;
    }

    public List<HashMap<String, Object>> getProtocol_contents_list() {
        return protocol_contents_list;
    }

    public void setProtocol_contents_list(List<HashMap<String, Object>> protocol_contents_list) {
        this.protocol_contents_list = protocol_contents_list;
    }

    private HashMap<String, Object> protocol_contents;
    private List<HashMap<String, Object>> protocol_contents_list;

    public RequestData(){}
    public RequestData(int protocol_type, int protocol_action, int protocol_method){
        this.protocol_type = protocol_type;
        this.protocol_action = protocol_action;
        this.protocol_method = protocol_method;
    }
    public RequestData(int protocol_type, int protocol_action, int protocol_method, HashMap<String, Object> protocol_contents){
        this.protocol_type = protocol_type;
        this.protocol_action = protocol_action;
        this.protocol_method = protocol_method;
        this.protocol_contents = protocol_contents;
    }

    public RequestData(int protocol_type, int protocol_action, int protocol_method, List<HashMap<String, Object>> protocol_contents_list){
        this.protocol_type = protocol_type;
        this.protocol_action = protocol_action;
        this.protocol_method = protocol_method;
        this.protocol_contents_list = protocol_contents_list;
    }
}
