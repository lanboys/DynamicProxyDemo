package com.bing.lan.dynamic;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class ProxyBean {

    private String name;
    private Long id1;
    private Long id;
    private String phone;

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ProxyBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", phone='" + phone + '\'' +
                '}';
    }
}
