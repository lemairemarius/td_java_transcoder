package com.company.tools;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

public class Message {

    private boolean encoded;

    private List<String> msgClear = new ArrayList<>();
    private List<String> msgEncoded = new ArrayList<>();

    private Path msgClearPath ;
    private Path msgEncodedPath ;
    private Path keyPath;
    private String key;
    private Transcoder trCode;



    public Message(boolean encoded,String msgClearPath, String msgEncodedPath,String keyPath) throws IOException {

        this.encoded = encoded;
        this.msgClearPath = Paths.get(System.getProperty("user.dir"),msgClearPath);
        this.msgEncodedPath = Paths.get(System.getProperty("user.dir"), msgEncodedPath);
        this.keyPath = Paths.get(System.getProperty("user.dir"), keyPath);

       this.key = Files.readString(Path.of(keyPath), StandardCharsets.UTF_8);
       this.trCode = new Transcoder(key);


    }






    public void readNwrite() throws IOException {

        if (encoded){
            msgEncoded = Files.readAllLines(msgEncodedPath);

            for (String line : msgEncoded){


                Files.writeString(msgClearPath,trCode.wordDecode(line) + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

        }else {msgClear = Files.readAllLines(msgClearPath);

            for (String lineC : msgClear){


                Files.writeString(msgEncodedPath,trCode.wordCode(lineC) + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        }
    }
}








