package com.example.testSocket.testFactory;

public class Test1 {
    public static void main(String[] args) {

        Fruit fruit = ReflectFactory.getInstance("com.example.testSocket.testFactory.Apple");
        fruit.eat();
    }

    //吃苹果
}
