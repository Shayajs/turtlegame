package com.utils;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TurtleFunction {
    public static ArrayList<String> getConversationNPC(String filename) throws IOException {
        // Get the return variable
        ArrayList<String> conversation = new ArrayList<>();

        try {
        // Open the file
            File conversationFile = new File("./res/" + filename);
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

    // Is a String by String function, insert one and unique String at once
    public static void printConversation(String str) throws InterruptedException {
        String[] charList = str.split("");
        for(String chars: charList) {
            Thread.sleep(5);
            System.out.print(chars);
        }
        System.out.print("\n");
    }

    public static void printConversation(ArrayList<String> strs, int waitSecondesBeforeDisplay) throws InterruptedException {
        
        Scanner sc = new Scanner(System.in);
        
        for(String str: strs) {
            TurtleFunction.printConversation(str);
            Thread.sleep(waitSecondesBeforeDisplay);
            System.out.print("\n");
            System.out.print("Enter to continue.\r");
            sc.nextLine();
        }
        sc.close();
    }

    public static void printConversation(ArrayList<String> strs) throws InterruptedException {
        int waitSecondesBeforeDisplay = 2000;
        TurtleFunction.printConversation(strs, waitSecondesBeforeDisplay);
    }
}
