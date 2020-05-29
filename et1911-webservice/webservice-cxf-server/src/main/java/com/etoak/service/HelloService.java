package com.etoak.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Administrator on 2020/5/29.
 */
@WebService(serviceName = "HelloService",
            portName = "HelloServicePort")//不写就是wepm....
public interface HelloService {

    @WebMethod
    String  sayHello(String name);
}
