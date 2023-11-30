package com.utils;

import java.io.IOException;
import java.util.ArrayList;

import com.characters.NonPlayerCharacter;

public class MiniGame {
    ArrayList<String> Q1;
    ArrayList<String> Q2;
    ArrayList<String> Q3;
    String A1; // Response to good Answer to Question 1
    String A2;
    String A3;
    String True;
    String False;
    int chance = 2;
    boolean lostGame = false;
    ArrayList<NonPlayerCharacter> mobs;

    /**
     * This is the mini Game in the Old Bank with the monkey. You have three questions
     * And you have 3 answers possible
     * 2 Chance to win the game, but if you are short of chance, it's a GAME OVER.
     * @param Q1File
     * @param Q2File
     * @param Q3File
     * @param A1File
     * @param A2File
     * @param A3File
     * @param talkTrue
     * @param talkFalse
     * @param mobs
     * @throws IOException
     */
    public MiniGame(String Q1File, String Q2File, String Q3File, String A1File, String A2File, String A3File, String talkTrue, String talkFalse, ArrayList<NonPlayerCharacter> mobs) throws IOException {
        this.Q1 = TurtleFunction.getConversationNPC(Q1File);
        this.Q2 = TurtleFunction.getConversationNPC(Q2File);
        this.Q3 = TurtleFunction.getConversationNPC(Q3File);
        this.A1 = TurtleFunction.getDescriptionFile(A1File);
        this.A2 = TurtleFunction.getDescriptionFile(A2File);
        this.A3 = TurtleFunction.getDescriptionFile(A3File);
        this.True = TurtleFunction.getDescriptionFile(talkTrue);
        this.False = TurtleFunction.getDescriptionFile(talkFalse);
        this.mobs = mobs;
    }
    
    /**
     * To play the game, you have to init before play.
     * @throws InterruptedException
     * @throws IOException
     */
    public void play() throws InterruptedException, IOException {
        String answer;
        TurtleFunction.print("Nobody yet win this game, will you? Answer with 1, 2 or 3.");
        //Q1 - 2nd Choise is good
        TurtleFunction.print(Q1, false);
        answer = Command.scanner.nextLine();
        if(answer.equalsIgnoreCase("2"))
        this.win(A1);
        else {
            this.lost();
            return;
        }
        //Q2 - 1st Choise is good
        TurtleFunction.print(Q2, false);
        answer = Command.scanner.nextLine();
        if(answer.equalsIgnoreCase("1"))
        this.win(A2);
        else {
            this.lost();
            return;
        } 
        //Q3 - 3rd Choise is good
        TurtleFunction.print(Q3, false);
        answer = Command.scanner.nextLine();
        if(answer.equalsIgnoreCase("3"))
        this.win(A3);
        else {
            this.lost();
            return;
        }

        /**
         * The mob in Forest have a new talk after winning the game
         */
        for(NonPlayerCharacter npc : mobs) {
            npc.setNewTalkPath("res\\text\\Forest\\talk3_" + npc.getName().toLowerCase() + ".txt");
        }
    }

    /**
     * This is the algorithm if you lost one question
     * @throws InterruptedException
     * @throws IOException
     */
    private void lost() throws InterruptedException, IOException {
        if(chance > 0) {
            chance--;
            TurtleFunction.print(False + " You have " + chance + " last chance before game over.");
        }
        else {
            ArrayList<String> gameOverText = TurtleFunction.getConversationNPC("res/text/OldBank/display_gameOver.txt");
            TurtleFunction.print(gameOverText);
            Command.gameOver(true);
        }
    }

    /**
     * This is the algo if you win the game
     * @param answerText
     * @throws InterruptedException
     */
    private void win(String answerText) throws InterruptedException {
        TurtleFunction.print(answerText + " ");
    }
}
