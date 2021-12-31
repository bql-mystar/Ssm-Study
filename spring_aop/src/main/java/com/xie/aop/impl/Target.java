package com.xie.aop.impl;

import com.xie.aop.TargetInterface;

public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running......");
    }
}
