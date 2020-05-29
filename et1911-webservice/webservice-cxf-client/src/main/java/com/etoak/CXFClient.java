package com.etoak;

import com.etoak.service.HelloService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Created by Administrator on 2020/5/29.
 */
public class CXFClient {

    public static void main(String[] args) {

        //JaxWSFactoryBean
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

        //wsdl地址
        factory.setAddress("http://localhost:8000/hello?wsdl");

        //设置发布的服务端口
        factory.setServiceClass(HelloService.class);

        HelloService service =  (HelloService)factory.create();

        System.out.println(service);

        System.out.println(service.sayHello("CXF"));






















    }
}
