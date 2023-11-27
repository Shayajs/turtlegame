package com.utils;
import java.util.ArrayList;
import java.io.*;

public class TurtleFunction {
    public static ArrayList<String> getConversationNPC(String filename) throws IOException {
        // Get the return variable
        ArrayList<String> conversation = new ArrayList<>();

        try {
        // Open the file
            File conversationFile = new File(filename);
            // Get a reader for the file
            FileReader fr = new FileReader(conversationFile);
            // Get a Buffer Reader
            BufferedReader br = new BufferedReader(fr);
            String paragraph;
            while((paragraph = br.readLine()) != null) {
                conversation.add(paragraph);
            }
            br.close();
            fr.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return conversation;
    }

    public static String getDescriptionFile(String filename) throws IOException {
        ArrayList<String> text = TurtleFunction.getConversationNPC(filename);
        if(text.size() == 0)
        return "Fichier Vide";
        else
        return text.get(0);
    }

    // Is a String by String function, insert one and unique String at once
    public static void print(String str) throws InterruptedException {
        String[] charList = str.split("");
        for(String chars: charList) {
            Thread.sleep(5);
            System.out.print(chars);
        }
        //System.out.print("\n");
    }

    public static void print(ArrayList<String> strs, int waitSecondesBeforeDisplay) throws InterruptedException {
        
        
        for(String str: strs) {
            TurtleFunction.print(str);
            Thread.sleep(waitSecondesBeforeDisplay);
            System.out.print("\n");
            System.out.print("Enter to continue.\r");
            Command.scanner.nextLine();
        }
    }

    public static void print(ArrayList<String> strs) throws InterruptedException {
        int waitSecondesBeforeDisplay = 2000;
        TurtleFunction.print(strs, waitSecondesBeforeDisplay);
    }
}
