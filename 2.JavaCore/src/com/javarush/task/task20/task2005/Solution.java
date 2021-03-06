package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            /*Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);*/
            Human ivanov = new Human("Ivanov", null);
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return false;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;


            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            if (name != null & !name.equals("")) {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
                printWriter.println(name);
                printWriter.println("startAssetsList");
                if (assets != null) {
                    for (Asset currentAsset : assets) {
                        printWriter.println(currentAsset.getName() + " : " + currentAsset.getPrice());
                    }
                }
                printWriter.println("endAssetsList");
                printWriter.close();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.ready()) name = reader.readLine();
            String currentLine = "";
            Asset currentAsset = null;
            while (reader.ready() & !(reader.readLine()).equals("startAssetsList")) {
            }
            while (reader.ready() & !(currentLine = reader.readLine()).equals("endAssetsList")) {
                String[] assetNameAndPrice = currentLine.trim().split(" : ");
                currentAsset = new Asset(assetNameAndPrice[0]);
                currentAsset.setPrice(Double.parseDouble(assetNameAndPrice[1]));
                this.assets.add(currentAsset);
            }
            reader.close();

        }
    }
}
