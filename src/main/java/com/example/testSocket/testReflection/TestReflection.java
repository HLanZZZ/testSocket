package com.example.testSocket.testReflection;


import com.example.testSocket.model.MyTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflection {

    public static void main(String[] args) throws ClassNotFoundException {
        //第一种方法  获取想要操作的类的Class对象
//      Class clazz = MyTest.class;
        //第二种方法
        Class clazz = Class.forName("com.example.testSocket.model.MyTest");
        //第三种方法
//      MyTest myTest =new MyTest();
//      Class clazz = myTest.getClass();

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods){
            System.out.println("这是这个类的方法:"+ method.toString());
        }

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            System.out.println("这是这个类的field:"+ field.toString());
        }

        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : constructors){
            System.out.println("这是这个类的constructor:"+ constructor.toString());
        }

    }
    //这里就是这个类的反射的结果
//这是这个类的方法:public void com.example.testSocket.model.MyTest.setFirstName(java.lang.String)
//这是这个类的方法:public java.lang.String com.example.testSocket.model.MyTest.getLastName()
//这是这个类的方法:public void com.example.testSocket.model.MyTest.setAge(int)
//这是这个类的方法:public void com.example.testSocket.model.MyTest.setLastName(java.lang.String)
//这是这个类的方法:public java.lang.String com.example.testSocket.model.MyTest.getFirstName()
//这是这个类的方法:public int com.example.testSocket.model.MyTest.getAge()
//这是这个类的field:private java.lang.String com.example.testSocket.model.MyTest.firstName
//这是这个类的field:private java.lang.String com.example.testSocket.model.MyTest.lastName
//这是这个类的field:private int com.example.testSocket.model.MyTest.age
//这是这个类的constructor:public com.example.testSocket.model.MyTest()

}
