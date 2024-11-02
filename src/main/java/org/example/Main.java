package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordManager manager = new WordManager();
        boolean quit = false;
        do{
            manager.printMenu();
            int menu = sc.nextInt();
            sc.nextLine();
            switch (menu){
                case 0:
                    quit = true;
                    System.out.println("Bye!");
                    break;

                case 1:
                    manager.printItem();
                    break;

                case 2:
                    manager.printItemByLevel();
                    break;

                case 3:
                    manager.printItemByMemorized();
                    break;

                case 4:
                    manager.searchData();
                    break;

                case 5:
                    manager.addData();
                    break;

                case 6:
                    manager.updateItem();
                    break;

                case 7:
                    manager.deleteItem();
                    break;

                case 8:
                    manager.saveData();
                    break;

                default:
                    System.out.println("Wrong number.\n");
                    break;
            }
        }while(!quit);
    }
}