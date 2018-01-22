import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
import javax.swing.*;

class ScoreFrame extends JPanel{
	private Variable v;
	private int score;
	private JLabel scorelabel;

    public ScoreFrame(){
      v = new Variable();
      score = v.getScore();
			scorelabel = new JLabel("");
			scorelabel.setFont(new Font(null, Font.PLAIN, 30));
			scorelabel.setHorizontalAlignment(JLabel.CENTER); // label内での、水平垂直方向の文字列の位置
			scorelabel.setVerticalAlignment(JLabel.CENTER);
			scorelabel.setText(score + "Point");
      this.add(scorelabel);
      this.setOpaque(false);
    }
}
