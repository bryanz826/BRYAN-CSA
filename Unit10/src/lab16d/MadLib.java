package lab16d;
//� A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/8
//Class - APCSA
//Lab  - 16d

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjs;
	
	public MadLib()
	{
		verbs = new ArrayList<String>();
		nouns = new ArrayList<String>();
		adjs = new ArrayList<String>();
		loadNouns();
		loadVerbs();
		loadAdjs();
	}

	public void loadNouns()
	{
		Scanner fileNouns = null;
		try{
			fileNouns = new Scanner(new File("src\\lab16d\\nouns.dat"));
			
			int i = 0;
			while(fileNouns.hasNext()) nouns.add(i++, fileNouns.next());
		}
		catch(IOException e) {
			out.println("Houston we have a problem");
		}	finally {
			if(fileNouns != null) fileNouns.close();
		}
	}
	
	public void loadVerbs()
	{
		Scanner fileVerbs = null;
		try {
			fileVerbs = new Scanner(new File("src\\lab16d\\verbs.dat"));
			
			int i = 0;
			while(fileVerbs.hasNext()) verbs.add(i++, fileVerbs.next());
		} catch(IOException e) {
			out.println("Houston we have a problem!");
		} finally {
			if(fileVerbs != null) fileVerbs.close();
		}
	}

	public void loadAdjs()
	{
		Scanner fileAdjs = null;
		try{
			fileAdjs = new Scanner(new File("src\\lab16d\\adjectives.dat"));
			
			int i = 0;
			while(fileAdjs.hasNext()) adjs.add(i++, fileAdjs.next());
		}
		catch(IOException e) {
			out.println("Houston we have a problem!");
		} finally {
			if(fileAdjs != null) fileAdjs.close();
		}
	}

	public String getRandomNoun()
	{
		int randInt = (int) (Math.random() * nouns.size());
		return nouns.get(randInt);
	}
	
	public String getRandomVerb()
	{
		int randInt = (int) (Math.random() * verbs.size());
		return verbs.get(randInt);
	}
	
	public String getRandomAdj()
	{
		int randInt = (int) (Math.random() * adjs.size());
		return adjs.get(randInt);
	}		

	public String toString()
	{
		String oldStory = "";
		String newStory = "";
		Scanner fileStory = null;
		try{
			fileStory = new Scanner(new File("src\\lab16d\\story.dat"));
			while(fileStory.hasNext()) oldStory+=fileStory.next()+" ";
		} catch(IOException e) {
			out.println("Houston we have a problem!");
		} finally {
			if(fileStory != null) fileStory.close();
		}
		
		String[] splitStory = oldStory.split(" ");
		for(int i = 0; i < splitStory.length; i++) {
			String c = splitStory[i];
			if(c.equals("#")) splitStory[i] = getRandomNoun();
			else if(c.equals("@")) splitStory[i] = getRandomVerb();
			else if(c.equals("&")) splitStory[i] = getRandomAdj();
		}
		newStory = String.join(" ", splitStory);
		return newStory+"\n\n\n";
	} 
}