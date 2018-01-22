//import java.awt.*;
//import java.awt.event.*;
import java.util.*;
//import javax.swing.*;

public class Randomword {
    private int i, j, k;
    private String s="";
    private Random random;

    /*private String[] words = {
    		"have", "do", "be", "make", "can", "will",
    		"think", "see", "want", "get", "break", "sing", "swim", "love",
    		"what", "who", "when", "where", "why", "how", "go", "come", "know",
    		"word",
    		"Don't eat me!"
    };*/


    Randomword(int n){
		random = new Random(System.currentTimeMillis());
		for(i=0;i<n;i++){
		    //j = random.nextInt(26);
		    j = random.nextInt(27);
		    if(j==26) {
			s = "I am Mr.Bear.";
			break;
		    }
		    k = 'a' + j;
		    s+=  "" + (char)k;
		}
		// s = words[random.nextInt(words.length)];
    }

    public String getWord(){
    	return s;
    }

}
