package com.yp.common.pojo;

import java.io.Serializable;

public class Permission implements Serializable {
    private int id;
    private String name;//Ȩ�޲�����
    private String node; //������ע��

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }
}
