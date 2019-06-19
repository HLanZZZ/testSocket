package com.example.testSocket.testFactory;

public class Test {

    public static void main(String[] args) {

        Fruit fruit = TraditionalFactory.getInstance("apple");
        fruit.eat();

        Fruit fruit1 = TraditionalFactory.getInstance("orange");
        fruit1.eat();

        //吃苹果
        //吃橘子
    }
}
