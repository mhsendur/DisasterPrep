package com.example.disasterprepfrontend;

import java.io.Serializable;

public class ModelDisaster implements Serializable {

    private String name;
    private String desc;
    private int image;
    private String plan;

    public ModelDisaster(String name, String desc, String plan) {
        this.name = name;
        this.desc = desc;
        this.plan = plan;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
