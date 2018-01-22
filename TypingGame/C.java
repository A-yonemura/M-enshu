//****************************************************
//How to use "Variable class"
//
//classC is main class
//classC and classB can chage the variable of classA.
//****************************************************
//import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
//import javax.swing.*;

class A {
	private static int n=0; // <------- "static"
	A(){
		
	}
	public void setN(int i) {
		n += i;
	}
	public void set2N(int i) {
		n = i;
	}
	public  int getN() {
		return n;
	}

}

class B {
	private int n=0;
	B(){
		A a=new A();
		a.set2N(3);
		n = a.getN();
		System.out.println("n of B: "+n);
	}
}

class C {
	private int n=0;
	C(){
		A a=new A();
		a.setN(100);
		new B();
		a.setN(5);
		n = a.getN();
	}
	public static void main(String[] argc) {
		C c =new C();
		//class A  n=0 -> n=100 -> n=3 -> n=8
		System.out.println("n of C: "+c.n);
		A a =new A();
		System.out.println("n of A: "+a.getN());
	}
}
