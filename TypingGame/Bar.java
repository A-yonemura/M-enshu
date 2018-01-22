import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Bar extends JPanel implements Observer{
	private static final int w = 600;
	private static final int h = 20;
	private double y=0;
	private Variable v;
	
	Bar(){
		v = new Variable();
		this.setOpaque(false);
		v.addObserver(this);
	}
	
    public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(Color.BLACK);
	    g.fillRect(0,0,w,h);
	    g.setColor(Color.RED);
	    y = (double)(v.getHP_enemy()/(double)v.getHP_enemy_MAX());
	    //double y = 0.7;
	    if(y <= 0.25)    g.setColor(Color.red);
	    else if(y < 0.5) g.setColor(Color.yellow);
	    else             g.setColor(Color.green);
	    g.fillRect(0,0, (int)(y * w),h);
    }
    public void update(Observable o,Object arg) {
    	y = (double)(v.getHP_enemy()/(double)v.getHP_enemy_MAX());
    	repaint();
    }
    
}
