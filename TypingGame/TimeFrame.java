import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
import javax.swing.*;

class TimeFrame extends JPanel{
	private Variable v;
	private int time;
	private JLabel timelabel;

    public TimeFrame(){
      v = new Variable();
      time = v.getTime();
			timelabel = new JLabel("");
			timelabel.setFont(new Font(null, Font.PLAIN, 30));
			timelabel.setHorizontalAlignment(JLabel.CENTER); // label内での、水平垂直方向の文字列の位置
			timelabel.setVerticalAlignment(JLabel.CENTER);
			timelabel.setText(time + "sec");
      this.add(timelabel);
      this.setOpaque(false);
    }
}
