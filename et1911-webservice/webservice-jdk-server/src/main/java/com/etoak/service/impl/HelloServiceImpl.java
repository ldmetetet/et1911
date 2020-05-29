package com.etoak.service.impl;

import com.etoak.service.HelloService;

import javax.jws.WebService;

/**
 * Created by Administrator on 2020/5/29.
 */
@WebService
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String name) {
        System.out.println("sayHello invoke!!");
        return "hi" + name;
    }
}













