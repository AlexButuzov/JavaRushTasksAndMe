package com.javarush.task.task20.task2027;

import java.util.*;

//Кроссворд


public class Solution {
    private  int[][] ccurrentCrossword = null;
    private  String currentWordByString = "";

    public class Pair {
        public int forX = 0;
        public int forY = 0;

        public Pair() {
        }
    }


    private  int crosX, crosY, startWordX, startWordY, wordDirectionX, wordDirectionY;
    private  List<Word> foundWordWithCoordinate = new ArrayList<Word>();
    private  static Solution sol = new Solution();


    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        sol.detectAllWords(crossword, "home", "same", "lo", "r");
/*Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)*/


    }


    public  static List<Word> detectAllWords(int[][] crossword, String... words) {

        sol.ccurrentCrossword = crossword;
        ArrayList<Word> rezult = new ArrayList<Word>();

        for (String currentWord :
                words) {
            sol.currentWordByString = currentWord;
            sol.currentWordDetecection();
        }

        if (sol.foundWordWithCoordinate != null) {
            rezult.addAll(sol.foundWordWithCoordinate);
        }
        //проверка результата
        System.out.println(rezult.size());
        for (Word curWord :
                rezult) {
            System.out.println(curWord.toString());
        }
        return rezult;
    }

    private  void currentWordDetecection() {
        char firstCharOfCurrentWord = currentWordByString.toCharArray()[0];


        crosX = ccurrentCrossword.length;

        crosY = ccurrentCrossword[1].length;

        for (int i = 0; i < crosX; i++) {
            for (int j = 0; j < crosY; j++) {
                if (ccurrentCrossword[i][j] == firstCharOfCurrentWord) {
                    startWordX = i;
                    startWordY = j;
                    if (currentWordByString.toCharArray().length > 1) {
                        findAllWordsForThisStartCoordinate();
                    } else {
                        Word nextWord = new Word(currentWordByString);
                        nextWord.setStartPoint(startWordY, startWordX);
                        nextWord.setEndPoint(startWordY, startWordX);
                      //  System.out.println(nextWord.toString());
                        foundWordWithCoordinate.add(nextWord);
                    }
                }
            }
        }
    }

    private  void findAllWordsForThisStartCoordinate() {

        try {
            char secondCharOfCurrentWord = currentWordByString.toCharArray()[1];
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (!((i == 0) & (j == 0))) {
                        if (secondCharOfCurrentWord ==
                                ccurrentCrossword[startWordX + i][startWordY + j]) { //// ?
                            wordDirectionX = i;
                            wordDirectionY = j;
                            chekDirectionAndAddWordIfPresent();
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException exp) {
        }

    }

    private  void chekDirectionAndAddWordIfPresent() {
        Word nextWord = null;
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        boolean found = false;
        int charInWordCount = currentWordByString.length();
        startX = startWordX;
        startY = startWordY;
        endX = startWordX +
                (wordDirectionX * (charInWordCount - 1));
        endY = startWordY +
                (wordDirectionY * (charInWordCount - 1));
        if ((endX <= crosX) & (endY <= crosY)) {
            found = true;
            char[] wordByChar = currentWordByString.toCharArray();
            for (int i = 0; i < wordByChar.length; i++) {
                int currentX = startWordX +
                        (wordDirectionX * i);
                int currentY = startWordY +
                        (wordDirectionY * i);

                if (wordByChar[i] != ccurrentCrossword[currentX][currentY]) {
                    found = false;
                }
            }

        }

        if (found) {
            nextWord = new Word(currentWordByString);
            nextWord.setStartPoint(startY, startX);
            nextWord.setEndPoint(endY, endX);
            //nextWord.setStartPoint(startX, startY);
            // nextWord.setEndPoint(endX, endY);
          //  System.out.println(nextWord.toString()); ////////////
            foundWordWithCoordinate.add(nextWord);
        }

    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
