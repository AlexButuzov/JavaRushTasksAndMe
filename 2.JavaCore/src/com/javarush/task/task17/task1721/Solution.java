package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            String fileAddress1 = null;
            String fileAddress2 = null;
            fileAddress1 = readFileAddress();
            fileAddress2 = readFileAddress();
            Solution.allLines = scanFromFileToList(fileAddress1);
            Solution.forRemoveLines = scanFromFileToList(fileAddress2);

            new Solution().joinData();

        } catch (CorruptedDataException exp1) {
            exp1.printStackTrace();
        } catch (FileNotFoundException exp2) {
            exp2.printStackTrace();
        } catch (IOException exp3) {
            exp3.printStackTrace();
        }

    }

    public static String readFileAddress() throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(in));
        String fileAddress = null;

            while (fileAddress == null) {
            fileAddress = reader.readLine();
            }

            reader.close();
            in.close();

        return fileAddress;
    }

    public static List<String> scanFromFileToList(String fileAddress) throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        File fileTemp = new File(fileAddress);

        Scanner scan = new Scanner( new FileInputStream(fileTemp));
            if (scan.hasNext()) {
                while (scan.hasNext()) {
                    String caurrentString = scan.nextLine();
                    lines.add(caurrentString);
                }
            }
            scan.close();
        return lines;

    }




    public  void joinData () throws CorruptedDataException, FileNotFoundException, IOException {


        if( Solution.allLines.containsAll(Solution.forRemoveLines)) {
            Solution.allLines.removeAll(Solution.forRemoveLines);
        } else {
            Solution.allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
