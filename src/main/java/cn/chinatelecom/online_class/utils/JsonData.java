package cn.chinatelecom.online_class.utils;

public class JsonData {
    private Object data;
    private Integer code;
    private String msg;

    public JsonData(Object data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public JsonData() {
    }

    public static JsonData buildSuccess(Object data){
        return new JsonData(data,0,null);
    }
    public static JsonData buildSuccess(Object data,String msg){
        return new JsonData(data,0,msg);
    }
    public static JsonData buildError(Object data,Integer code,String msg){
        return new JsonData(data,code,msg);
    }
    public static JsonData buildError(Integer code,String msg){
        return new JsonData(null,code,msg);
    }
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
