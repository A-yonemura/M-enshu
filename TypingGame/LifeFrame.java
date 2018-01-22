import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
import javax.swing.*;

class LifeFrame extends JPanel{
	private Variable v;
	private int life;

    public LifeFrame(){
      v = new Variable();
      life = v.getHP_player();
      this.setLayout(new GridLayout(1,10));
      for(int i=1;i<=life;i++)
        this.add(new JLabel("<html><img src='file:life_red.png' width=40 height=40></html>"));
      for(int j=1;j<=10-life;j++)
        this.add(new JLabel("<html><img src='file:life_blue.png' width=40 height=40></html>"));
      this.setOpaque(false);

    }
}
