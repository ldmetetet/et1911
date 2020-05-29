package com.etoak;

import com.etoak.service.impl.HelloServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by Administrator on 2020/5/29.
 */
public class JdkWebService {
    public static void main(String[] args) {
        //两个参数
        //发布地址   暴露服务
        Endpoint.publish("http://localhost:8080/hello",
                new HelloServiceImpl());
        System.out.println("Srevice start");

    }
}
