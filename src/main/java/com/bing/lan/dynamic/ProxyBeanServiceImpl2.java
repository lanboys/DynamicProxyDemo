package com.bing.lan.dynamic;

import java.util.List;

public class ProxyBeanServiceImpl2 implements ProxyBeanService {

    @Override
    public void save(ProxyBean e) {
        System.out.println("save(): ");
    }

    @Override
    public void delete(Long id) {
        System.out.println("delete(): ");
    }

    @Override
    public void update(ProxyBean e) {
        System.out.println("update(): ");
    }

    @Override
    public ProxyBean get(Long id) {
        System.out.println("get(): ");
        return null;
    }

    @Override
    public List<ProxyBean> list() {
        System.out.println("list(): ");
        return null;
    }
}
