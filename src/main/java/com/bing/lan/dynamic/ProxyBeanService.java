package com.bing.lan.dynamic;

import java.util.List;

public interface ProxyBeanService {

    void save(ProxyBean e);

    void delete(Long id);

    void update(ProxyBean e);

    ProxyBean get(Long id);

    List<ProxyBean> list();
}
