package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordManager manager = new WordManager();
        boolean quit = false;
        do{
            manager.printMenu();
            int menu = sc.nextInt();
            switch (menu){
                case 0:
                    quit = true;
                    System.out.println("Bye!");
                    break;

                case 4:
                    manager.addData();
                    break;

                case 5:
                    manager.updateItem();
                    break;

                default:
                    System.out.println("Wrong number.\n");
                    break;
            }
        }while(!quit);
    }
}