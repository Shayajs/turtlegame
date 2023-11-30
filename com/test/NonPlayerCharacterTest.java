package com.test;

import java.io.IOException;

import com.characters.NonPlayerCharacter;
import com.items.Inventory;
import com.items.RawItemNotAllowedException;
public class NonPlayerCharacterTest {
    
    NonPlayerCharacter npc;

	public NonPlayerCharacterTest() throws IOException, InterruptedException, RawItemNotAllowedException {
		testNonPlayerCaracter();
		testGetName();
		testSetConversationPath();
		testSetNewTalkPath();
		testGetDescription();
		testGetLongDescription();
		testAttack();
		testLook();
		testInteract();
		testSetandgetBoss();
		// On a rajouté au fur et à mesure
	}

    public final void testNonPlayerCaracter() throws IOException {
        // First constructor
        npc = new NonPlayerCharacter("Test", new Inventory());
        // Second Constructor
        npc = new NonPlayerCharacter("Test");
    }

    public final void testGetName() {
        String name = npc.getName();
        System.out.println(name);
    }
	
	public final void testSetConversationPath() throws IOException{
		npc.setConversationPath(
			"com/test/test_text/test_look1",
		"com/test/test_text/test_look2",
		"com/test/test_text/test_talk1",
		"com/test/test_text/test_talk2",
		"com/test/test_text/test_attack1",
		"com/test/test_text/test_attack2"
		);
	}
	
	public final void testSetNewTalkPath() throws IOException{
		npc.setNewTalkPath("com/test/test_text/test_talk3");
	} 
	
	public final void testGetDescription(){
		System.out.println(npc.getDescription());
	}
	
	public final void testGetLongDescription(){
		System.out.println(npc.getLongDescription());
	}
	
	//deux attaques parce la première doit afficher le test_attack1 et le deuxième test_attack2
	public final void testAttack() throws InterruptedException, IOException, RawItemNotAllowedException{
		npc.attack();
		npc.attack();
	}
	
	//pareil
	public final void testLook() throws InterruptedException{
		npc.look();
		npc.look();
	}
	
	public void testInteract() throws InterruptedException{
		npc.interact();
	}
	
	public void testSetandgetBoss() throws IOException{
		NonPlayerCharacter.setBoss(new NonPlayerCharacter("testBoss"), null);
		NonPlayerCharacter.getBoss();
	}
}
