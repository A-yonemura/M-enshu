//import java.awt.*;
//import java.awt.event.*;
import java.util.*;
//import javax.swing.*;

public class Variable extends Observable{
	public static int Scene=-1;
	public static int HP_player=10;
	public static int HP_enemy=100;
	public static int HP_enemy_MAX=100;
	public static int Score=0;
	public static int Limit=10;
	public static int remaining=0; // 残り時間

	Variable() { }

	public void plusScore(int n) {
		Score += n;
		setChanged();
	  notifyObservers();
	}

	public int getScore() {
		return Score;
	}

	public void ResetScore() {
		Score = 0;
	}

	public void setScene(int n) {
		Scene += 1;
		if(Scene>1) Scene=0;
		if(n<0) Scene=0;
	}
	public int getScene() {
		return Scene;
	}

	public void setHP_player(int n) {
		if(n==10) HP_player = 10;
		else HP_player -= 1;
		if(HP_player<0) HP_player = 0;
		setChanged();
	    notifyObservers();
	}
	public int getHP_player() {
		return HP_player;
	}

	public void RecoverHP_Player(int n) {
		// n:現在のプレイヤーのHP
		if(n<10) {
			HP_player += 1;
			setChanged();
				notifyObservers();
		}
	}

	public void setHP_enemy(int n) {
		HP_enemy = -n*5;
		if(HP_enemy<0) HP_enemy=0;
	}
	public int getHP_enemy() {
		return HP_enemy;
	}
	public int getHP_enemy_MAX() {
	    return HP_enemy_MAX;
	 }

	 public void Update_time(int sec) {
		remaining = Limit - sec;
 		setChanged();
 	  notifyObservers();
 	}

	public int getTime() {
		return remaining;
	}

	public int getLimit() {
		return Limit;
	}

	public void setLimit() {
		if(0<=Score && Score<=5000) Limit = 10;
		else if(Score<=10000) Limit = 9;
		else if(Score<=15000) Limit = 8;
		else if(Score<=20000) Limit = 7;
	  else if(Score<=25000) Limit = 6;
		else if(Score<=30000) Limit = 5;
		else Limit = 4;
	}

}
