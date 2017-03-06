package com.qqdemo.administrator.bmob;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/3/6.
 */

public class Person extends BmobObject {
    private byte[] img;
    private String name;
    private int age;
    private String address;

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
