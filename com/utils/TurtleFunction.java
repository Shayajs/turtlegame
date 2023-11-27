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
}
