import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class Typing extends JLabel implements KeyListener, ActionListener {
	private Variable v;
  private Randomword rw;
	private Enemy_word enemy_word;
  private int n=0;
  private String word="Let's hang out!";
  private JLabel label;
  // private JLabel scoreLabel;

  private static final int Time_Limit = 10000; // 10000ms
  //private static final int SPEED = 10;
  //private static final int NUM_RANKING = 5;

  private boolean isPlaying;
  //private int delay;
  //private int score;
  //private ArrayList<Integer> ranking;
  //private long prevTime;
  private javax.swing.Timer timer;

	private int bonus = 0;
	public  int sec = 0;

  public Typing(Variable vo) {
		//super(title);
		this.setLayout(new GridLayout(3,1));
		v = vo;
		label = new JLabel(" ");
		label.setFont(new Font(null, Font.PLAIN, 30)); // フォント設定
		label.setHorizontalAlignment(JLabel.CENTER); // label内での、水平垂直方向の文字列の位置
		label.setVerticalAlignment(JLabel.CENTER);

		this.add(label);

		addKeyListener(this);
		setFocusable(true);

		/*ranking = new ArrayList<Integer>(NUM_RANKING);
		for (int i = 0; i < NUM_RANKING; i++) {
		    ranking.add(0);
		}*/

		isPlaying = false; // isPlayingの初期化
		//timer = new javax.swing.Timer(0, this); // 0なので起動と同時にイベントをトリガー
		//timer.setRepeats(false); // 最初のアクション・イベントの送信後、タイマーを停止する場合はfalseを指定
		timer = new javax.swing.Timer(1000,this);

		showTitle();
		//timer.start();
  }

  public void keyPressed(KeyEvent e) {
  }

  public void keyReleased(KeyEvent e) {
  }

  public void keyTyped(KeyEvent e) {

		if (!isPlaying&&e.getKeyChar()==KeyEvent.VK_SPACE) {
				v.ResetScore();
				v.setLimit();
			 	sec = 0;
				v.Update_time(sec);
 
		    n = 0;
		    v.setScene(1);
		    if(v.getHP_player()==0) { // PlayerのHPが0の時のゲームオーバー処理
		    	v.setScene(-1);
		    	v.setHP_player(10);  // HP回復
		    }
				isPlaying = true;
				newWord();

		} else { // isPlaying == true
		    String text = label.getText();
		    if (text.charAt(0) == e.getKeyChar()) { // 正しく打てた時
					bonus++;
					v.plusScore(100);
					if(bonus == 10) {
						v.RecoverHP_Player(v.getHP_player());
						bonus = 0;
					}
					if (text.length() > 1) {
				    label.setText(text.substring(1));
						// もしtextの1文字目を正しく打てれば、1文字目を削除した文字列をlabelにsetする
					} else {
						sec = 0;
						timer.setInitialDelay(0); // actionPerformedまでの初期遅延を10秒にする
						timer.restart();
						v.setLimit();
				    newWord(); // text.length == 1 最後の1文字を正解できればsuccess()を呼ぶ
					}
		    } else { // 間違えた時
				//System.out.println("miss");
					bonus = 0;
		    	v.setHP_player(1); // HPを1マイナスする
		    	if(v.getHP_player()==0) { // もしHPが0ならばgameOver()を呼び出す
		    		gameOver();
		    	}
	    	}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(sec>v.getLimit()){
			sec = 0;
			if (!isPlaying) {
		    return;
			}
			if (label.getText().length() > 0) {
		    gameOver();
			}
		}
		else v.Update_time(sec);

		sec++;
	}

  protected String getLabelText() {
    return label.getText();
  }

  private void gameOver() {
		n=1;
		isPlaying = false;
		timer.stop();
		label.setForeground(Color.white);
		showTitle();
  }

  private void newWord() {
		timer.setInitialDelay(0);
		timer.start();
		label.setForeground(Color.black);
		// ramdomword
		/*rw = new Randomword(v.getScene()*2+5);
		label.setText(rw.getWord());
		setWord(rw.getWord());*/

		//enemy_word 敵のwordが非ランダムの時
		enemy_word = new Enemy_word(v.getScore());
		label.setText(enemy_word.getWord_E());
		setWord(enemy_word.getWord_E());
  }

  private void showTitle() {
    	label.setText("Press Space Button.");
  }

	private void setWord(String s) {
  	word = s;
  }

	public String getWord() {
  	return word;
  }

	public int getn() {
  	return n;
  }

} // Typingクラスの終点
