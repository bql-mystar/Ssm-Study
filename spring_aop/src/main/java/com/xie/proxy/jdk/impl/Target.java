package com.xie.proxy.jdk.impl;

import com.xie.proxy.jdk.TargetInterface;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running......");
    }
}
