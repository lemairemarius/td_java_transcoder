package com.company.GUI;

import com.company.tools.Message;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;



public class Menu {

    private int select;
    private String doc;
    private String key;
    private boolean run = false;


    public void initializeMenu() throws InterruptedException, IOException {

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


        do {

            System.out.println("Veuillez selectionner une action : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Désolée mais cela ne fait pas partie de la sélection...");
                scanner.next();
            }
            select = scanner.nextInt();

            switch (select) {
                case 1 -> {

                    System.out.println("Veuillez entrer le nom du document à decoder :");
                    doc = scanner.next() + ".txt";

                    while (!Files.exists(Path.of(doc))) {
                        System.out.println("Désolée mais le documents saisi n'est pas référencé, veuillez recommencer...");
                        doc = scanner.next() + ".txt";
                    }

                    System.out.println("Velez entrer le nom de la clée :");
                    key = scanner.next() + ".txt";
                    while(!Files.exists(Path.of(key))){
                        System.out.println("Désolée mais le documents saisi n'est pas référencé, veuillez recommencer...");
                        key = scanner.next() + ".txt";
                    }

                    messageDecode();

                }

                    case 2 -> {
                        System.out.println("Veuillez entrer le nom du document à encoder :");
                        doc = scanner.next() + ".txt";
                        while (!Files.exists(Path.of(doc))) {
                            System.out.println("Désolée mais le documents saisi n'est pas référencé, veuillez recommencer...");
                            doc = scanner.next() + ".txt";
                        }


                        System.out.println("Veuillez entrer le nom de la clée :");
                        key = scanner.next() + ".txt";
                        while(!Files.exists(Path.of(key))){
                            System.out.println("Désolée mais le documents saisi n'est pas référencé, veuillez recommencer...");
                            key = scanner.next() + ".txt";
                        }

                        messageEncode();



                    }
                    case 3 -> run = false;

                    default -> {
                        System.out.println("Je suis désolée, je n'ais pas compris votre demande... Veuillez recommencer");
                        run = true;
                    }
                }


            }
            while (run) ;
        }



    public void messageDecode() throws IOException {
            String decodePath = "decode.txt";
            Message decode = new Message(true, decodePath, doc, key);

            decode.readNwrite();

    }

    public void messageEncode() throws IOException {
        String encodePath = "code.txt.txt";
        Message encode = new Message(false,doc,encodePath,key);

        encode.readNwrite();
    }

}



