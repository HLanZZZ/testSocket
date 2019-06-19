package com.example.testSocket.testReflection;

import com.example.testSocket.model.MyTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo {

    public static void main(String[] args) {

        MyTest myTest = new MyTest();
        try {
            //获取MyTest类的Class对象
            Class c = MyTest.class;
            // 第一种创建对象的方法   Class对象的newInstance()
            myTest = (MyTest) c.newInstance();
            myTest.setAge(18);
            myTest.setFirstName("laozhu");
            myTest.setLastName("huazai");
            System.out.println("myTest的所有信息:"+myTest.toString());

            // 第二种创建对象的方法

            Constructor constructor = c.getDeclaredConstructor(java.lang.String.class,java.lang.String.class,int.class);

            MyTest myTest1 = (MyTest) constructor.newInstance("a","b",12);

            System.out.println("myTest1的所有信息:"+myTest1.toString());


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //myTest的所有信息:MyTest{firstName='laozhu', lastName='huazai', age=18}
        //myTest1的所有信息:MyTest{firstName='a', lastName='b', age=12}

    }


}
