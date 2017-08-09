package com.artron.baselib.entity;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Doing on 2016/9/9.
 *
 */
public class Response<T> {

    private static final String FIELD_CODE = "status";
    private static final String FIELD_DATA = "data";
    private static final String FIELD_RESULT = "content";
    private static final String FIELD_MESSAGE = "message";
    private static final String FIELD_LIST = "result";

    @SerializedName(FIELD_CODE)
    private int status;
    @SerializedName(FIELD_RESULT)
    private T content;
    @SerializedName(FIELD_DATA)
    private T data;

    @SerializedName(FIELD_LIST)
    private T result;
    @SerializedName(FIELD_MESSAGE)
    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


}
