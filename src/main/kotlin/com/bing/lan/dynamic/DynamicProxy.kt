package com.bing.lan.dynamic

import com.bing.lan.dynamicproxy.ISubject1
import com.bing.lan.dynamicproxy.ISubject2
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy


/**
 * Created by 蓝兵 on 2018/2/15.
 */

fun main(args: Array<String>) {

//    https@ //www.jianshu.com/p/a56c61da55dd

//    http@ //blog.csdn.net/u013476542/article/details/53228552?locationNum=6&fps=1
    /* 设置此系统属性,让JVM生成的Proxy类写入文件.保存路径为：com/sun/proxy(如果不存在请手工创建) */
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

    val proxyInstance1 = Proxy.newProxyInstance(
            ISubject1::class.java.classLoader,
            arrayOf(ISubject1::class.java, ISubject2::class.java),
            object : InvocationHandler {

                @Throws(Throwable::class)
                override fun invoke(proxy: Any, method: Method, args: Array<Any>): Any? {
                    println("before invoke method:" + method.name)
//                    val result = method.invoke(trueTarget, args)
//                    println("invoke finish return:" + result)

                    return null
                }
            }) as ISubject1

//    val proxyInstance2 = Proxy.newProxyInstance(
//            ISubject1::class.java.classLoader,
//            arrayOf(ISubject1::class.java)) { proxy, method, args ->
//        println("before invoke method:" + method.name)
//
//    } as ISubject2

    proxyInstance1.doSomething1("12345")
//    proxyInstance2.doSomething2(12)
}


