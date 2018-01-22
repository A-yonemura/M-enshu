import java.applet.Applet;
//import java.awt.*;
import java.awt.event.*;
//import java.util.*;
import javax.swing.*;

import java.applet.AudioClip;

public class MusicWav extends JPanel {
	AudioClip audioClip;
	private static boolean On;
	private ImageIcon icon;
	private JButton b;
	private JLabel l;


	MusicWav(String s){
		 On = true;
		 l = new JLabel();
		 icon = new ImageIcon("on.png");
		 l.setIcon(icon);
		 audioClip = Applet.newAudioClip(MusicWav.class.getResource(s));
	     audioClip.loop();

	     l.addMouseListener(
	    	      new MouseAdapter(){
	    	        public void mouseClicked(MouseEvent  event){
	    	          b.doClick(200);
	    	        }
	    	      }
	     );
	     b = new JButton();
	     b.addActionListener(
	    	      new ActionListener(){
	    	        public void actionPerformed(ActionEvent event){
	    	        	if(On){
	    	    			On = false;
	    	    			icon = new ImageIcon("off.png");
	    	    			l.setIcon(icon);
	    	    			audioClip.stop();
	    	    		}
	    	    		else {
	    	    			On = true;
	    	    			icon = new ImageIcon("on.png");
	    	    			l.setIcon(icon);
	    	    			audioClip.loop();
	    	    		}
	    	        }
	    	      }
	    	    );
	     this.add(l);
	     this.setOpaque(false);

	}
	/*
    public static void main(String args[]) {
    	new MusicWav("merrygo1.wav");
    }
    */
}
