package com.bing.lan.dynamic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 蓝兵 on 2018/4/24.
 */

public class ProxyTest {

    @Test
    public void test() {

        ProxyBeanService proxyBeanServiceImpl1 = new ProxyBeanServiceImpl1();
        ProxyBeanService proxyBeanServiceImpl2 = new ProxyBeanServiceImpl2();

        ProxyBeanService instance = (ProxyBeanService) Proxy.newProxyInstance(
                ProxyBeanService.class.getClassLoader(),
                new Class[]{ProxyBeanService.class},
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("invoke(): " + method);
                        System.out.println("invoke(): " + method.hashCode());
                        System.out.println("invoke(): " + method.getName());

                        // 通过父类拿到 的method
                        method.invoke(proxyBeanServiceImpl2, args);
                        method.invoke(proxyBeanServiceImpl1, args);

                        return null;
                    }
                });

        // 通过父类拿到 的method
        Method[] declaredMethods0 = ProxyBeanService.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods0) {
            System.out.println("test(): " + declaredMethod.hashCode());
            System.out.println("test(): " + declaredMethod.getName());

            if (declaredMethod.getName().equals("delete")) {
                try {
                    declaredMethod.invoke(proxyBeanServiceImpl2, 5l);
                    declaredMethod.invoke(proxyBeanServiceImpl1, 6l);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("**************************************");
        System.out.println("**************************************");

        // 通过 proxyBeanServiceImpl1 拿到 的method
        Method[] declaredMethods1 = proxyBeanServiceImpl1.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods1) {
            System.out.println("test(): " + declaredMethod.hashCode());
            System.out.println("test(): " + declaredMethod.getName());

            if (declaredMethod.getName().equals("delete")) {
                try {
                    declaredMethod.invoke(proxyBeanServiceImpl1, 6l);
                    // 不能调用
                    //declaredMethod.invoke(proxyBeanServiceImpl2, 5l);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("**************************************");
        System.out.println("**************************************");

        // 通过 proxyBeanServiceImpl2 拿到 的method
        Method[] declaredMethods2 = proxyBeanServiceImpl2.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods2) {
            System.out.println("test(): " + declaredMethod.hashCode());
            System.out.println("test(): " + declaredMethod.getName());

            if (declaredMethod.getName().equals("delete")) {
                try {
                    // 不能调用
                    //declaredMethod.invoke(proxyBeanServiceImpl1, 6l);
                    declaredMethod.invoke(proxyBeanServiceImpl2, 5l);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("**************************************");
        System.out.println("**************************************");

        instance.delete(5l);
    }
}
