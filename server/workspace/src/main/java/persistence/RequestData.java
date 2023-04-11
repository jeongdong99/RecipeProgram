package persistence;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class RequestData implements Serializable {
    private static final long serialVersionUID = 9176873029745254542L;

    private int protocol_type;
    private int protocol_action;
    private int protocol_method;
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
