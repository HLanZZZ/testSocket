package com.example.testSocket.testFactory;

public class ReflectFactory {

    private ReflectFactory(){}
    public static Fruit getInstance(String className){
        Fruit fruit = null;
        try {
            fruit = (Fruit) Class.forName(className).newInstance();
        }catch (ClassNotFoundException | IllegalAccessException | InstantiationException e){
            e.printStackTrace();
        }
        return fruit;
    }

}
