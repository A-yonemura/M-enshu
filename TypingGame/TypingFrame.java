import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class TypingFrame extends JFrame{
    public static void main(String args[]) {
      JFrame f = new JFrame();
		  f.setSize(1025,670);  //1000x600
	    f.setLayout(new GridLayout(1,1));
		  f.add(new MainPanel());

		  f.setVisible(true);
		  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MainPanel extends JPanel implements ActionListener, Observer{
	  private Bar bar;
	  private Variable v;
    private ScoreFrame scoreframe;
	  private LifeFrame lifeframe;
    private TimeFrame timeframe;
    private int i, n, scene=0;
    private PictureName pic;
    private String[] name;
    private Image img;
    private javax.swing.Timer timer;
    private JLabel l1;
    private Typing frame;
    private Font font = new Font(null, Font.PLAIN, 28);

    MainPanel(){
      v = new Variable();
      pic = new PictureName(scene);
      name = pic.getName();

		  this.setLayout(null);
		  this.setBackground(Color.black);
		  frame = new Typing(v);

      l1 = new JLabel("");
      l1.setFont(font);
      frame.setBounds(180, 360, 640, 480);

      l1.setBounds(0, 135, 350, 50);
      l1.setHorizontalAlignment(JLabel.CENTER);
      l1.setVerticalAlignment(JLabel.CENTER);

      this.add(l1);
      this.add(frame);

      bar = new Bar();
      bar.setBounds(10, 20, 800, 200);
      this.add(bar);

      // HPの表示
      lifeframe = new LifeFrame();
      lifeframe .setBounds(30, 540, 440, 40); //
      this.add(lifeframe);

      // Scoreの表示
      scoreframe = new ScoreFrame();
      scoreframe.setBounds(550,10,300,300);
      this.add(scoreframe);

      // TimeLimitの表示
      timeframe = new TimeFrame();
      timeframe.setBounds(550,310,300,300);
      this.add(timeframe);


      //MusicWav wav= new MusicWav("merrygo1.wav");
      MusicWav wav= new MusicWav("konekonoosanpo.wav");
      wav.setBounds(920, 15, 60, 60);
      this.add(wav);

      timer = new javax.swing.Timer(100, this);
	    timer.start();
	    v.addObserver(this);
    }

    public void actionPerformed(ActionEvent e){
    	scene = v.getScene();
    	pic = new PictureName(scene);
    	name = pic.getName();
		  n= frame.getn();

      if(n==1) {
		    l1.setText("");
		    repaint();
		  } else {
		     l1.setText(frame.getWord());
		    repaint();
		  }
    }

    protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for(i=0;i<5;i++) {
			img = getToolkit().getImage(name[i]);
			if(i==4&&n==0) img = null;
			g.drawImage(img,0,0,this);
		}
    }

    public void update(Observable o,Object arg) {
    	this.remove(lifeframe);
		//lifeframe.removeAll();
		  lifeframe = new LifeFrame();
		  lifeframe .setBounds(30, 540, 440, 40);
		  this.add(lifeframe);
		  lifeframe.revalidate();

      this.remove(scoreframe);
      scoreframe = new ScoreFrame();
      scoreframe.setBounds(550,10,300,300);
      this.add(scoreframe);
      scoreframe.revalidate();

      this.remove(timeframe);
      timeframe = new TimeFrame();
      timeframe.setBounds(550,310,300,300);
      this.add(timeframe);
      scoreframe.revalidate();
    }

}
