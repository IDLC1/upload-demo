package tom.spring.hellospring.domain;

import java.io.Serializable;

public class ResponseData implements Serializable {
    private static final long serialVersionUID = 1L;

    // 状态码 0 成功  -1 失败
    private int code;
    // 结果
    private Object data;
    // 消息
    private String msg;

    public ResponseData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResponseData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
