package com.dip.dipay.recycleview;
public class Model {
    int img;
    String name,ph;

    public Model(int img, String name, String ph) {
        this.img = img;
        this.name = name;
        this.ph = ph;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {

        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }
}
