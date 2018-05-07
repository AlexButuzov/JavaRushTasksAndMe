package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("c:\\log.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User current = new User();
            current.setMale(true);
            current.setBirthDate(new Date(12, 4, 23));
            current.setCountry(User.Country.RUSSIA);
            current.setFirstName("GF");
            current.setLastName("rrr");
            javaRush.users.add(current);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        /**
         * @param outputStream поток вывода
         * @throws Exception что-то с записью файла
         * @date 20.04.2018
         * @author Butuzov A.N.
         */
        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

            for (User currentUser :
                    users) {
                printWriter.println("startSaveNewUser");
                printWriter.println("firstName " + currentUser.getFirstName());
                printWriter.println("lastName " + currentUser.getLastName());
                printWriter.println("birthDate " + currentUser.getBirthDate().toString());
                printWriter.println("isMale " + currentUser.isMale());
                printWriter.println("country " + currentUser.getCountry().getDisplayedName());
                printWriter.println("endSaveNewUser");

            }
            printWriter.flush();
            printWriter.close();

        }

        /**
         * @param inputStream поток ввода
         * @throws Exception что-то с чтением файла
         * @date 20.04.2018
         * @author Butuzov A.N.
         */
        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {

                String currentLine = "";
                while (reader.ready() & !(currentLine = reader.readLine()).equals("startSaveNewUser")) {
                }
                String firstName = null;
                String lastName = null;
                Date birthDate = null;
                boolean isMale = false;
                String strCountry = null;
                while (reader.ready()
                        & (!(currentLine = reader.readLine()).equals("endSaveNewUser"))) {
                    String currentParamenter = currentLine.trim().split(" ")[0];
                    switch (currentParamenter) {
                        case "firstName":
                            firstName = currentLine.substring("firstName ".length());
                            break;
                        case "lastName":
                            lastName = currentLine.substring("lastName ".length());
                            break;
                        case "birthDate":
                            SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                            birthDate = sdf.parse(currentLine.substring("birthDate ".length()));
                            break;
                        case "isMale":
                            isMale = currentLine.substring("isMale ".length()).equals("true") ? true : false;
                            break;
                        case "country":
                            strCountry = currentLine.substring("country ".length()).trim();
                            break;
                    }

                }
                User.Country country = null;
                if (strCountry != null) {
                    switch (strCountry) {
                        case "Ukraine":
                            country = User.Country.UKRAINE;
                            break;
                        case "Russia":
                            country = User.Country.RUSSIA;
                            break;
                        case "Other":
                            country = User.Country.OTHER;
                            break;
                    }
                }
                User currentUser = new User();
                currentUser.setFirstName(firstName);
                currentUser.setLastName(lastName);
                currentUser.setBirthDate(birthDate);
                currentUser.setMale(isMale);
                currentUser.setCountry(country);
                users.add(currentUser);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
