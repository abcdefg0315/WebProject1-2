package org.example;

import java.util.Scanner;

public class WordManager {
    Scanner sc = new Scanner(System.in);
    WordCRUD wordCRUD = new WordCRUD();
    public void printMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("[Menu] 1. List  2. List(level)  3. Search  4.Add  5.Modify  6.Delete  7.Save file 0.Exit >> ");
    }

    public void addData(){
        //사용자에게 새로운 데이터 입력
        int id;
        String word;
        String meaning;
        int level;
        String created_date;
        boolean memorized;
        System.out.print("Enter a word >> ");
        word = sc.nextLine();

        System.out.print("Enter a meaning >> ");
        meaning = sc.nextLine();

        System.out.print("Enter a level of word >> ");
        level = sc.nextInt();

        wordCRUD.addData(new Word(word,meaning,level));
    }
}