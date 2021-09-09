package com.company;

import com.company.GUI.Menu;
import com.company.tools.Message;
import com.company.tools.Transcoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {



        Message testMess = new Message(false,"decode.txt","code.txt","key.txt");

        testMess.readNwrite();

        Menu testMenu = new Menu();
        testMenu.initializeMenu();


    }

}
