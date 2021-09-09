package com.company.tools;


import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Transcoder {


    private HashMap<String, Character> decodeMap = new HashMap<String, Character>();
    private HashMap<Character, String> encodeMap = new HashMap<Character,String>();
    private String key;

    public Transcoder(String key) {
        this.key = key;
        generateMaps();
    }


    public HashMap<String, Character> getDecodeMap() {
        return decodeMap;
    }
    public HashMap<Character, String> getEncodeMap() {
        return encodeMap;
    }





    public ArrayList<String> keyLoop() {
        char firstLetter = 'A';
        char secondLetter = 'A';
        ArrayList<String> array = new ArrayList<String>();

        for (int i = 0; i <= key.length(); i++) {
            String letter = firstLetter + "" + secondLetter;
            array.add(letter);

            if (secondLetter == 'Z') {
                firstLetter++;
                secondLetter = 'A';
            } else {
                secondLetter++;
            }
        }
        return array;
    }




    public void generateMaps() {

        char[] keyArray = key.toCharArray();


        int i = 0;
        while (i < key.length()) {

            decodeMap.put(keyLoop().get(i), keyArray[i]);
            encodeMap.put(keyArray[i], keyLoop().get(i));
            i++;

        }
    }



    public String wordCode(String x) {

        String ligneCode = "";

        for(char a : x.toCharArray()){

            for(char b : getEncodeMap().keySet()){

                if(a==b){
                     ligneCode += getEncodeMap().get(b);

                }
            }
        }
return ligneCode;
    }



    public String wordDecode(String y){
        String yDecode = "";
        StringBuilder result = new StringBuilder();


        for(int i=0; i<y.length(); i+=2){

            yDecode = y.toCharArray()[i]+""+y.toCharArray()[i+1];

            for (String a : getDecodeMap().keySet()){

                if (Objects.equals(a, yDecode)){

                    result.append(getDecodeMap().get(yDecode));

                }
            }
        }
        return result.toString();
    }

}












