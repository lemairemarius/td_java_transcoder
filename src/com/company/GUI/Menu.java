package com.company.GUI;

import com.company.tools.Message;

import java.io.IOException;
import java.util.Scanner;



public class Menu {

    private int select;
    private String doc;
    private String key;
    private boolean run = false;


    public void initializeMenu() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                |-----------------------------|
                |   Systeme d'encodage et de  |
                |      décodage de message    |
                |-----------------------------|
                |     1- Décoder un message   |
                |     2- Encoder un message   |
                |     3- Quitter              |
                |-----------------------------|
                """);


        do{

            System.out.println("Veuillez selectionner une action : ");
            select = scanner.nextInt();

            switch (select) {
                case 1 -> {
                    System.out.println("Veuillez entrer le nom du document à decoder :");
                    doc = scanner.next()+".txt";

                    System.out.println("Veuillez entrer le nom de la clée :");
                    key = scanner.next()+".txt";

                    }
                case 2 -> {
                    System.out.println("Veuillez entrer le nom du document à encoder :");
                    doc = scanner.next();

                    System.out.println("Veuillez entrer le nom de la clée :");
                    key=scanner.next();
                }
                case 3 -> run = false;

                default -> {
                    System.out.println("Je suis désolée, je n'ais pas compris votre demande... Veuillez recommencer");
                    run = true;
                }
            }
        }while(run);
    }
}


