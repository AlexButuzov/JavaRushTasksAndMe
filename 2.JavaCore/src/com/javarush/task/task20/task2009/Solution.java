package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable, Externalizable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(ClassWithStatic.staticString);
            out.writeObject(i);
            out.writeObject(j);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            ClassWithStatic.staticString = (String) in.readObject();
            i = (int) in.readObject();
            j = (int) in.readObject();
        }
    }

    public static void main(String[] args) {

    }
}
