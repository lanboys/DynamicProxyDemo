package com.bing.lan.dynamic;

import java.util.List;

public class ProxyBeanServiceImpl1 implements ProxyBeanService {

    @Override
    public void save(ProxyBean e) {
        System.out.println("save1(): ");
    }

    @Override
    public void delete(Long id) {
        System.out.println("delete1(): ");
    }

    @Override
    public void update(ProxyBean e) {
        System.out.println("update1(): ");
    }

    @Override
    public ProxyBean get(Long id) {
        System.out.println("get()1: ");
        return null;
    }

    @Override
    public List<ProxyBean> list() {
        System.out.println("list()1: ");
        return null;
    }
}
