package com.threecat.springboot.commons.dto;

public class BaseReq<T> {
    private Head head;

    private T data;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
