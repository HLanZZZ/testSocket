package com.example.testSocket.testFactory;

public class TraditionalFactory {

    private TraditionalFactory(){}

    public static Fruit getInstance(String className){

        if ("apple".equals(className)){
            //这里为啥返回的是Appel  Apple 是 实现了Fruit 的方法
            return new Apple();
        }else if ("orange".equals(className)){
            return new Orange();
        }
        return null;
    }

}
