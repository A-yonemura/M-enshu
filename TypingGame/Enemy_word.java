//import java.awt.*;
//import java.awt.event.*;
import java.util.*;
//import javax.swing.*;

public class Enemy_word {
    //private int i, j, k;
    private Variable v;
    private String s="";
    private Random random;
    private int score;

    private String[] words1 = {
    		"have", "do", "be", "make", "can", "will",
    		"think", "see", "want", "get", "break", "sing", "swim", "love",
    		"what", "who", "when", "where", "why", "how", "go", "come", "know",
    		"word",
    		"Don't eat me!"
    };

    private String[] words2 = {
      "shinjuku","hatsudai","hatagaya","sasazuka","daitabashi","meidaimae",
      "simotakaido","sakurajousui","kamikitazawa","hachimanyama","rokakouen",
      "chitosekarasuyama","sengawa","tsutujigaoka","sibasaki","kokuryo","fuda",
      "chofu","nishichofu","tobitakyu","musashinodai","tamareien","higashifuchu",
      "fuchu","bubaigawara","nakagawara","seisekisakuragaoka","mogusaen",
      "takahatafudo","minamidaira","hirayamajosikouen","naganuma","kitano","keiohachiouji"
    };

    private String[] words3 = {
      "vivaldi","bach","handel","haydn","mozart","rossini","beethoven",
      "paganini","schubert","straussi","mendelsson","chopin","schumann",
      "liszt","verdi","wagnaer","bruckner","brahms","badarzewska","bizet",
      "tchaikovsky","dvorak","grieg","puccini","elger","mahler","debussy",
      "richard","sibelius","rachmaninov"
    };


    Enemy_word(int n){
		    random = new Random(System.currentTimeMillis());

        if(0<=n && n<=4000) s = words1[random.nextInt(words1.length)];
        else if(n<=14000)   s = words2[random.nextInt(words2.length)];
        else                s = words3[random.nextInt(words3.length)];
    }

    public String getWord_E(){
    	return s;
    }

}
