package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("c:\\log.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

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

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
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

        /**
         * @date 20.04.2018
         * @author Butuzov A.N.
         * @param outputStream поток вывода
         * @throws Exception что-то с выводом
         */
        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            if (name != null & !name.equals("")) {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
                printWriter.println(name);
                if (assets !=null) {
                    printWriter.println("startAssetsList");
                    for (Asset currentAsset : assets) {

                        printWriter.println(currentAsset.getName() + " " + currentAsset.getPrice());
                    }
                    printWriter.println("endAssetsList");
                }
                printWriter.close();
            }

        }

        /**
         *  @date 20.04.2018
         *  @author Butuzov A.N.
         * @param inputStream потокк воода
         * @throws Exception что-то с потокм ввода
         */
        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream) );

            if (reader.ready()) name = reader.readLine();
            String currentLine = "";
            while (reader.ready() & !(currentLine = reader.readLine()).equals("startAssetsList")){}
            while (reader.ready() & !(currentLine = reader.readLine()).equals("endAssetsList")) {

                assets.add(new Asset(currentLine.trim().split(" ")[0] ,
                        Double.parseDouble(currentLine.trim().split(" ")[1])));
            }
            reader.close();

        }
    }
}
