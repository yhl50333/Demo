package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class JsonResult implements Serializable {
    private int state=1;//1 表示ok,0表示error
    /**状态码对应的消息*/
    private String message="ok";
    private Object data;
    public JsonResult(String message) {
        this.message=message;
    }
    public JsonResult() {
        this.data=data;
    }
    public JsonResult(Throwable e) {
        this.state=0;
        this.message=e.getMessage();
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }


}
