package org.example;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WordManager implements iCRUD{
    Scanner sc = new Scanner(System.in);
    WordCRUD wordCRUD = new WordCRUD();
    public void printMenu(){
        System.out.print("[Menu] 1. List  2. List(level) 3.List(memorized)  4. Search  5.Add  6.Modify  7.Delete  8.Save file 0.Exit >> ");
    }

    @Override
    public void addData(){
        String word;
        String meaning;
        int level;
        String created_date;
        boolean memorized = false;
        System.out.print("Enter a word >> ");
        word = sc.nextLine();

        System.out.print("Enter a meaning >> ");
        meaning = sc.nextLine();

        System.out.print("Enter a level of word >> ");
        level = sc.nextInt();
        sc.nextLine();

        created_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        wordCRUD.addData(new Word(word,meaning,level,created_date,memorized));
    }


    @Override
    public void updateItem() {
        System.out.print("Enter a word to update >> ");
        String word = sc.nextLine();
        wordCRUD.updateData(word);
    }

    @Override
    public void deleteItem() {
        System.out.print("Enter the word to delete >> ");
        String word = sc.nextLine();
        sc.nextLine(); // 입력 버퍼 비우기
        wordCRUD.deleteData(word);
    }

    @Override
    public void printItem() {
        wordCRUD.printData();
    }

    public void searchData(){
        System.out.print("Enter a word to search >> ");
        String searchWord = sc.nextLine();
        wordCRUD.searchData(searchWord);
    }

    public void printItemByLevel(){
        wordCRUD.printItemByLevel();
    }
}