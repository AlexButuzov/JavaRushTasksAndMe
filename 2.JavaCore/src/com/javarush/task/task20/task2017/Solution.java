package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {

        A resultObject = null;
        try {
            Object loadedObject = objectStream.readObject();
            if ( loadedObject instanceof A) {
                resultObject = (A) loadedObject;
            } else {
                System.out.println("Something wrong with clas object in objectStream");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultObject;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
